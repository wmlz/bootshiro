package xyz.wmlz.restdemo.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wmlz.restdemo.shiro.entity.Perm;
import xyz.wmlz.restdemo.shiro.mapper.PermMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by wmlz at 2018/4/18 16:08<br>
 */
@Service
public class PermService {

    @Autowired
    PermMapper permMapper;

    public Set<String> getPermValuesByUserId(Integer uid) {
        System.out.println("DB查询权限");
        List<Perm> permList = permMapper.selectByUid(uid);
        Set<String> perms = new HashSet<>();
        permList.forEach(item -> perms.add(item.getPval()));
        return perms;
    }
}
