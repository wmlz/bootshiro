package xyz.wmlz.restdemo.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wmlz.restdemo.shiro.entity.Role;
import xyz.wmlz.restdemo.shiro.mapper.RoleMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by wmlz at 2018/4/18 16:08<br>
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public Set<String> getRoleValuesByUserId(Integer uid) {
        System.out.println("DB查询角色");
        List<Role> roleList = roleMapper.selectByUid(uid);
        Set<String> roles = new HashSet<>();
        roleList.forEach(item -> roles.add(item.getRval()));
        return roles;
    }

}
