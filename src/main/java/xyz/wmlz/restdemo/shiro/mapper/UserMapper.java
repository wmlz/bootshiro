package xyz.wmlz.restdemo.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.wmlz.restdemo.shiro.entity.User;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    User selectByPrimaryKey(Integer uid);

    User selectByName(String uname);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}