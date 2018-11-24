
package com.kotall.rms.core.aspect;


import com.kotall.rms.common.entity.sys.SysUserEntity;
import com.kotall.rms.core.RmsException;
import com.kotall.rms.core.annotation.DataFilter;
import com.kotall.rms.core.constants.Constant;
import com.kotall.rms.core.service.sys.SysOrgService;
import com.kotall.rms.core.service.sys.SysRoleOrgService;
import com.kotall.rms.core.service.sys.SysUserRoleService;
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
 * 数据过滤，切面处理类
 *
 * @author aracwong
 * @since 2017年8月28日 上午11:07:35
 */
@Aspect
@Order(value = -1)
@Component
public class DataFilterAspect {

    @Autowired
    private SysOrgService sysOrgService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleOrgService sysRoleOrgService;

    @Pointcut("@annotation(com.kotall.rms.core.annotation.DataFilter)")
    public void dataFilterCut() {
    }

    @Before("dataFilterCut()")
    public void dataFilter(JoinPoint point) throws Throwable {
        Object params = point.getArgs()[0];
        if(params != null && params instanceof Map){
            SysUserEntity user = ShiroUtils.getUserEntity();
            // 如果不是超级管理员，则进行数据过滤
            if(user.getUserId() != Constant.SUPER_ADMIN){
                Map map = (Map)params;
                map.put(Constant.SQL_FILTER, getSQLFilter(user, point));
            }
            return ;
        }
        throw new RmsException("数据权限接口，只能是Map类型参数，且不能为NULL");
    }

    /**
     * 获取数据过滤的SQL
     */
    private String getSQLFilter(SysUserEntity user, JoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);
        // 获取表的别名
        String tableAlias = dataFilter.tableAlias();
        if(StringUtils.isNotBlank(tableAlias)){
            tableAlias +=  ".";
        }

        // 部门ID列表
        Set<Integer> deptIdList = new HashSet<>();

        // 用户角色对应的部门ID列表
        List<Integer> roleIdList = sysUserRoleService.queryRoleIdList(user.getUserId());
        if(roleIdList.size() > 0){
            List<Integer> userOrgIdList = sysRoleOrgService.queryOrgIdListByRoleIds(roleIdList.toArray(new Integer[roleIdList.size()]));
            deptIdList.addAll(userOrgIdList);
        }

        // 用户子部门ID列表
        if(dataFilter.subDept()){
            List<Integer> subOrgIdList = sysOrgService.getSubOrgIdList(user.getOrgId());
            deptIdList.addAll(subOrgIdList);
        }

        StringBuilder sqlFilter = new StringBuilder();
        sqlFilter.append(" (");

        if(deptIdList.size() > 0){
            sqlFilter.append(tableAlias).append(dataFilter.deptId()).append(" in(").append(StringUtils.join(deptIdList, ",")).append(")");
        }

        // 没有本部门数据权限，也能查询本人数据
        if(dataFilter.user()){
            if(deptIdList.size() > 0){
                sqlFilter.append(" or ");
            }
            sqlFilter.append(tableAlias).append(dataFilter.userId()).append("=").append(user.getUserId());
        }

        sqlFilter.append(")");
        return sqlFilter.toString();
    }
}
