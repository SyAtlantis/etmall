package com.entanmo.etmall.db.service;


import com.entanmo.etmall.db.dao.EtmallPermissionMapper;
import com.entanmo.etmall.db.domain.EtmallPermission;
import com.entanmo.etmall.db.domain.EtmallPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EtmallPermissionService {

    @Resource
    private EtmallPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        EtmallPermissionExample example = new EtmallPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<EtmallPermission> permissionList = permissionMapper.selectByExample(example);

        for(EtmallPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        EtmallPermissionExample example = new EtmallPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<EtmallPermission> permissionList = permissionMapper.selectByExample(example);

        for(EtmallPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        EtmallPermissionExample example = new EtmallPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        EtmallPermissionExample example = new EtmallPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(EtmallPermission EtmallPermission) {
        EtmallPermission.setAddTime(LocalDateTime.now());
        EtmallPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(EtmallPermission);
    }
}
