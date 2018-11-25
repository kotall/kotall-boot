package com.kotall.rms.core.annotation.support;

import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.annotation.StoreFilter;
import com.kotall.rms.core.constants.Constant;
import com.kotall.rms.core.service.litemall.LiteMallStoreService;
import com.kotall.rms.web.util.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 店铺数据过滤 切面处理
 * @author zpwang
 * @version 1.0.0
 */
@Aspect
@Order(value = -1)
@Component
public class StoreFilterAspect {

    @Autowired
    private LiteMallStoreService liteMallStoreService;

    @Pointcut("@annotation(com.kotall.rms.core.annotation.StoreFilter)")
    public void dataFilterCut() {
    }

    /**
     * 根据当前登录用户查出所属店铺 ID
     * @param point
     * @throws Throwable
     */
    @Before("dataFilterCut()")
    public void dataFilter(JoinPoint point) throws Throwable {
        Object  param = point.getArgs()[0];
        if (null != param && param instanceof Map) {
            SysUserEntity user = ShiroUtils.getUserEntity();
            // 如果不是超级管理员，则进行数据过滤
            if(user.getUserId() != Constant.SUPER_ADMIN){
                Map map = (Map)param;
                map.put(Constant.SQL_FILTER, getStoreSQLFilter(user, point));
            }
            return ;
        }

        throw new RmsException("数据权限接口，只能是Map类型参数，且不能为NULL");
    }

    private String getStoreSQLFilter(SysUserEntity user, JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        StoreFilter storeFilter = signature.getMethod().getAnnotation(StoreFilter.class);
        // 获取表的别名
        String tableAlias = storeFilter.tableAlias();
        if(StringUtils.isNotBlank(tableAlias)){
            tableAlias +=  ".";
        }

        Set<Integer> storeIdList = new HashSet<>();

        // 店铺ID列表
        List<Integer> currentUserStoreIdList = this.liteMallStoreService.queryStoreIdListByUserId(user.getUserId());
        if (null != currentUserStoreIdList && currentUserStoreIdList.size() > 0) {
            storeIdList.addAll(currentUserStoreIdList);
        }

        StringBuilder sqlFilter = new StringBuilder();
        sqlFilter.append(" (");


        if(storeIdList.size() > 0){
            sqlFilter.append(tableAlias).append(storeFilter.storeId()).append(" in(").append(StringUtils.join(storeIdList, ",")).append(")");
        }

        sqlFilter.append(")");
        return sqlFilter.toString();
    }


}
