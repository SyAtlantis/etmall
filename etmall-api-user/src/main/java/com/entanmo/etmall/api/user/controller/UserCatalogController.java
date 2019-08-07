package com.entanmo.etmall.api.user.controller;

import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.db.domain.EtmallCategory;
import com.entanmo.etmall.db.service.EtmallCategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类目服务
 */
@RestController
@RequestMapping("/user/catalog")
@Validated
public class UserCatalogController {

    private EtmallCategoryService categoryService;

    // 分类详情
    @GetMapping("index")
    public Object index(Integer id) {

        // 所有一级分类目录
        List<EtmallCategory> l1CatList = categoryService.queryL1();

        // 当前一级分类目录
        EtmallCategory currentCategory = null;
        if (id != null) {
            currentCategory = categoryService.findById(id);
        } else {
            currentCategory = l1CatList.get(0);
        }

        // 当前一级分类目录对应的二级分类目录
        List<EtmallCategory> currentSubCategory = null;
        if (null != currentCategory) {
            currentSubCategory = categoryService.queryByPid(currentCategory.getId());
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("categoryList", l1CatList);
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);
        return ResponseUtil.ok(data);
    }

    // 所有分类数据
    @GetMapping("all")
    public Object queryAll() {
        //优先从缓存中读取
//        if (HomeCacheManager.hasData(HomeCacheManager.CATALOG)) {
//            return ResponseUtil.ok(HomeCacheManager.getCacheData(HomeCacheManager.CATALOG));
//        }


        // 所有一级分类目录
        List<EtmallCategory> l1CatList = categoryService.queryL1();

        //所有子分类列表
        Map<Integer, List<EtmallCategory>> allList = new HashMap<>();
        List<EtmallCategory> sub;
        for (EtmallCategory category : l1CatList) {
            sub = categoryService.queryByPid(category.getId());
            allList.put(category.getId(), sub);
        }

        // 当前一级分类目录
        EtmallCategory currentCategory = l1CatList.get(0);

        // 当前一级分类目录对应的二级分类目录
        List<EtmallCategory> currentSubCategory = null;
        if (null != currentCategory) {
            currentSubCategory = categoryService.queryByPid(currentCategory.getId());
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("categoryList", l1CatList);
        data.put("allList", allList);
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);

        //缓存数据
//        HomeCacheManager.loadData(HomeCacheManager.CATALOG, data);
        return ResponseUtil.ok(data);
    }

    // 当前分类栏目
    @GetMapping("current")
    public Object current(@NotNull Integer id) {
        // 当前分类
        EtmallCategory currentCategory = categoryService.findById(id);
        if(currentCategory == null){
            return ResponseUtil.badArgumentValue();
        }
        List<EtmallCategory> currentSubCategory = categoryService.queryByPid(currentCategory.getId());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("currentCategory", currentCategory);
        data.put("currentSubCategory", currentSubCategory);
        return ResponseUtil.ok(data);
    }
}
