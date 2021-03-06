package com.goat.doit.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.doit.system.mapper.PermissionMapper;
import com.goat.doit.system.mapper.RoleMapper;
import com.goat.doit.system.mapper.RolePermissionMapper;
import com.goat.doit.system.mapper.UserMapper;
import com.goat.doit.system.model.Permission;
import com.goat.doit.system.model.Role;
import com.goat.doit.system.model.RolePermission;
import com.goat.doit.system.model.User;
import com.goat.doit.system.service.RoleService;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.system.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public Set<String> findRoleByUserId(Integer userId) {
        return roleMapper.findRoleByUserId(userId);
    }

    @Override
    public List<Role> selectRoles(Role role) {
        return roleMapper.selectRoles(role);
    }


    @Override
    public int insert(Role role) {
        return 0;
    }


    @Override
    public int updateStatusBatch(List<String> roleIds, Integer status) {
        Map<String,Object> params = new HashMap<>(2);
        params.put("roleIds",roleIds);
        params.put("status",status);
        return roleMapper.updateStatusBatch(params);
    }

    @Override
    public List<Permission> findPermissionsByRoleId(String roleId) {
        return permissionMapper.findByRoleId(roleId);
    }

    /**
     * 根据角色id保存分配权限
     * @param roleId 当前选中角色id
     * @param permissionIds
     */
    @Override
    public ResponseVo addAssignPermission(String roleId, List<String> permissionIds) {
        try{
            List<RolePermission> list = new ArrayList<>();
            rolePermissionMapper.deletes(Integer.valueOf(roleId)); //1.删除 中间表中 所有与该角色关联的菜单
            if(permissionIds!=null && permissionIds.size()>0){
                permissionIds.forEach(x->list.add(new RolePermission(roleId,x)));
                rolePermissionMapper.batchRolePermission(list); // 2.全部删除后  根据打钩项 再重新插入
            }
            return ResultUtil.success("分配权限成功");
        }catch(Exception e){
            return ResultUtil.error("分配权限失败");
        }
    }

    @Override
    public List<User> findByRoleIds(List<String> roleIds) {
        return userMapper.findByRoleIds(roleIds);
    }

}
