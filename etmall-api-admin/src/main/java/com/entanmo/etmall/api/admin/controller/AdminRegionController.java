package com.entanmo.etmall.api.admin.controller;

import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.core.vo.RegionVo;
import com.entanmo.etmall.db.domain.EtmallRegion;
import com.entanmo.etmall.db.service.EtmallRegionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
//    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private EtmallRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<EtmallRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<EtmallRegion> provinceList = regionService.queryByPid(0);
        for (EtmallRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<EtmallRegion> cityList = regionService.queryByPid(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (EtmallRegion city : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(city.getId());
                cityVO.setName(city.getName());
                cityVO.setCode(city.getCode());
                cityVO.setType(city.getType());

                List<EtmallRegion> areaList = regionService.queryByPid(city.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (EtmallRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
