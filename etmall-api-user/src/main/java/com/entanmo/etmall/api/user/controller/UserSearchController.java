package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.api.user.annotation.LoginUser;
import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.db.domain.EtmallKeyword;
import com.entanmo.etmall.db.domain.EtmallSearchHistory;
import com.entanmo.etmall.db.service.EtmallKeywordService;
import com.entanmo.etmall.db.service.EtmallSearchHistoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品搜索服务
 * <p>
 * 注意：目前搜索功能非常简单，只是基于关键字匹配。
 */
@RestController
@RequestMapping("/user/search")
@Validated
public class UserSearchController {
//    private final Log logger = LogFactory.getLog(UserSearchController.class);

    @Autowired
    private EtmallKeywordService keywordsService;
    @Autowired
    private EtmallSearchHistoryService searchHistoryService;

    /**
     * 搜索页面信息
     * <p>
     * 如果用户已登录，则给出用户历史搜索记录；
     * 如果没有登录，则给出空历史搜索记录。
     */
    @GetMapping("index")
    public Object index(@LoginUser Integer userId) {
        //取出输入框默认的关键词
        EtmallKeyword defaultKeyword = keywordsService.queryDefault();
        //取出热闹关键词
        List<EtmallKeyword> hotKeywordList = keywordsService.queryHots();

        List<EtmallSearchHistory> historyList = null;
        if (userId != null) {
            //取出用户历史关键字
            historyList = searchHistoryService.queryByUid(userId);
        } else {
            historyList = new ArrayList<>(0);
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("defaultKeyword", defaultKeyword);
        data.put("historyKeywordList", historyList);
        data.put("hotKeywordList", hotKeywordList);
        return ResponseUtil.ok(data);
    }

    /**
     * 关键字提醒
     * <p>
     * 当用户输入关键字一部分时，可以推荐系统中合适的关键字。
     */
    @GetMapping("helper")
    public Object helper(@NotEmpty String keyword,
                         @RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10") Integer limit) {
        List<EtmallKeyword> keywordsList = keywordsService.queryByKeyword(keyword, page, limit);
        String[] keys = new String[keywordsList.size()];
        int index = 0;
        for (EtmallKeyword key : keywordsList) {
            keys[index++] = key.getKeyword();
        }
        return ResponseUtil.ok(keys);
    }

    /**
     * 清除用户搜索历史
     */
    @PostMapping("clearhistory")
    public Object clearhistory(@LoginUser Integer userId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        searchHistoryService.deleteByUid(userId);
        return ResponseUtil.ok();
    }
}
