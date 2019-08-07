package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.core.validator.Order;
import com.entanmo.etmall.core.validator.Sort;
import com.entanmo.etmall.db.domain.EtmallBrand;
import com.entanmo.etmall.db.service.EtmallBrandService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 专题服务
 */
@RestController
@RequestMapping("/user/brand")
@Validated
public class UserBrandController {

    private EtmallBrandService brandService;

    // 品牌列表
    @GetMapping("list")
    public Object list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<EtmallBrand> brandList = brandService.query(page, limit, sort, order);
        return ResponseUtil.okList(brandList);
    }

    // 品牌详情
    @GetMapping("detail")
    public Object detail(@NotNull Integer id) {
        EtmallBrand entity = brandService.findById(id);
        if (entity == null) {
            return ResponseUtil.badArgumentValue();
        }

        return ResponseUtil.ok(entity);
    }
}
