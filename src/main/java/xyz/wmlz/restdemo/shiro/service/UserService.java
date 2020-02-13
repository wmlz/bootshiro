package xyz.wmlz.restdemo.shiro.service;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wmlz.restdemo.shiro.entity.User;
import xyz.wmlz.restdemo.shiro.mapper.UserMapper;

/**
 * created by wmlz at 2018/4/18 16:08<br>
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserByName(String uname) {
        return userMapper.selectByName(uname);
    }

    public boolean createUser(User user) {
        //使用MD5(uname).toBase64作为密码的加密盐
        user.setSalt(new Md5Hash(user.getUname()).toBase64());
        String encryptedPwd = new Sha256Hash(user.getPwd(), user.getSalt(), 1024).toBase64();
        user.setPwd(encryptedPwd);
        return userMapper.insert(user) == 1;
    }
}
