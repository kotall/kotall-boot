package com.kotall.rms.api.controller;

import com.kotall.rms.api.annotation.AppConfig;
import com.kotall.rms.api.annotation.LoginUser;
import com.kotall.rms.common.entity.litemall.LiteMallAppEntity;
import com.kotall.rms.common.entity.litemall.LiteMallKeywordEntity;
import com.kotall.rms.common.entity.litemall.LiteMallSearchHistoryEntity;
import com.kotall.rms.common.utils.Result;
import com.kotall.rms.core.service.litemall.LiteMallKeywordService;
import com.kotall.rms.core.service.litemall.LiteMallSearchHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/search")
@Validated
@Slf4j
public class WxSearchController {

    @Autowired
    private LiteMallKeywordService keywordsService;
    @Autowired
    private LiteMallSearchHistoryService searchHistoryService;

    /**
     * 搜索页面信息
     * <p>
     * 如果用户已登录，则给出用户历史搜索记录。
     *
     * @param userId 用户ID
     * @return 搜索页面信息
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data:
     * {
     * defaultKeyword: xxx,
     * historyKeywordList: xxx,
     * hotKeywordList: xxx
     * }
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("index")
    public Object index(@LoginUser Integer userId, @AppConfig LiteMallAppEntity appConfig) {
        // 取出输入框默认的关键词
        LiteMallKeywordEntity defaultKeyword = keywordsService.queryDefault(appConfig.getStoreId());
        // 取出热闹关键词
        List<LiteMallKeywordEntity> hotKeywordList = keywordsService.queryHots(appConfig.getStoreId());

        List<LiteMallSearchHistoryEntity> historyList;
        if (userId != null) {
            //取出用户历史关键字
            historyList = searchHistoryService.queryByUserId(userId);
        } else {
            historyList = new ArrayList<>(0);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("defaultKeyword", defaultKeyword);
        data.put("historyKeywordList", historyList);
        data.put("hotKeywordList", hotKeywordList);
        return Result.ok().put("data", data);
    }

    /**
     * 关键字提醒
     * <p>
     * 当用户输入关键字一部分时，可以推荐系统中合适的关键字。
     *
     * @param keyword 关键字
     * @return 合适的关键字
     * 成功则
     * {
     * code: 0,
     * msg: '成功',
     * data: xxx
     * }
     * 失败则 { code: XXX, msg: XXX }
     */
    @GetMapping("helper")
    public Object helper(@NotEmpty String keyword,
                         @RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer size) {
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        params.put("pageNumber", page);
        params.put("pageSize", size);
        List<LiteMallKeywordEntity> keywordsList = keywordsService.queryByList(params);
        String[] keys = new String[keywordsList.size()];
        int index = 0;
        for (LiteMallKeywordEntity key : keywordsList) {
            keys[index++] = key.getKeyword();
        }
        return Result.ok().put("data", keys);
    }

    /**
     * 关键字清理
     * <p>
     * 当用户输入关键字一部分时，可以推荐系统中合适的关键字。
     *
     * @param userId 用户ID
     * @return 清理是否成功
     * 成功则 { code: 0, msg: '成功' }
     * 失败则 { code: XXX, msg: XXX }
     */
    @PostMapping("clearhistory")
    public Object clearhistory(@LoginUser Integer userId) {
        if (userId == null) {
            return Result.unLogin();
        }
        searchHistoryService.deleteByUserId(userId);
        return Result.ok();
    }
}
