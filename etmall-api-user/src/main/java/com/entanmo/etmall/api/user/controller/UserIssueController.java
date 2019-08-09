package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.core.validator.Order;
import com.entanmo.etmall.core.validator.Sort;
import com.entanmo.etmall.db.domain.EtmallIssue;
import com.entanmo.etmall.db.service.EtmallIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 帮助中心
 */
@RestController
@RequestMapping("/user/issue")
@Validated
public class UserIssueController {

    @Autowired
    private EtmallIssueService issueService;

    @GetMapping("/list")
    public Object list(String question,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<EtmallIssue> issueList = issueService.querySelective(question, page, limit, sort, order);
        return ResponseUtil.okList(issueList);
    }
}
