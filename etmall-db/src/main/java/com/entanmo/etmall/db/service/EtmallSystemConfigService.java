package com.entanmo.etmall.db.service;


import com.entanmo.etmall.db.dao.EtmallSystemMapper;
import com.entanmo.etmall.db.domain.EtmallSystem;
import com.entanmo.etmall.db.domain.EtmallSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EtmallSystemConfigService {

    @Resource
    private EtmallSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        EtmallSystemExample example = new EtmallSystemExample();
        example.or().andDeletedEqualTo(false);

        List<EtmallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (EtmallSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        EtmallSystemExample example = new EtmallSystemExample();
        example.or().andKeyNameLike("Etmall_mall_%").andDeletedEqualTo(false);
        List<EtmallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(EtmallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        EtmallSystemExample example = new EtmallSystemExample();
        example.or().andKeyNameLike("Etmall_wx_%").andDeletedEqualTo(false);
        List<EtmallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(EtmallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        EtmallSystemExample example = new EtmallSystemExample();
        example.or().andKeyNameLike("Etmall_order_%").andDeletedEqualTo(false);
        List<EtmallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(EtmallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        EtmallSystemExample example = new EtmallSystemExample();
        example.or().andKeyNameLike("Etmall_express_%").andDeletedEqualTo(false);
        List<EtmallSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(EtmallSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            EtmallSystemExample example = new EtmallSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            EtmallSystem system = new EtmallSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        EtmallSystem system = new EtmallSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
