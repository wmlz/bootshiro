package xyz.wmlz.restdemo.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.wmlz.restdemo.shiro.entity.Result;
import xyz.wmlz.restdemo.shiro.entity.User;
import xyz.wmlz.restdemo.shiro.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login(new UsernamePasswordToken(username, password));
            //从session取出用户信息
            User user = (User) currentUser.getPrincipal();
            if (user == null) {
                throw new AuthenticationException();
            }
            //返回登录用户的信息给前台，含用户的所有角色和权限
            return Result.suc()
                    .putData("uid", user.getUid())
                    .putData("nick", user.getNick())
                    .putData("roles", user.getRoles())
                    .putData("perms", user.getPerms())
                    .putData("sessionId", currentUser.getSession());
        } catch (UnknownAccountException uae) {
            log.warn("用户帐号不存在,账号：{}", username);
            return Result.err(3, "用户帐号或密码不正确");
        } catch (IncorrectCredentialsException ice) {
            log.warn("用户密码不正确,账号：{}", username);
            return Result.err(3, "用户帐号或密码不正确");
        } catch (LockedAccountException lae) {
            log.warn("用户帐号被锁定,账号：{}", username);
            return Result.err(5, "用户账号被锁定");
        } catch (AuthenticationException ae) {
            log.warn("登录出错,账号：{}, exception:{}", username, ae.getMessage());
            return Result.err(6, "登录失败");
        }
    }

    @GetMapping("/logout")
    Result logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return Result.suc("登出成功");
    }

    @PostMapping("/create")
    Result createUser(User user) {
        if (userService.createUser(user)) {
            return Result.suc("新增用户成功");
        } else {
            return Result.err(444, "新增用户失败");
        }
    }

    @GetMapping("/unauthc")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result unauthc() {
        throw new UnauthenticatedException();
    }
}
