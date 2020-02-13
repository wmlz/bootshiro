package xyz.wmlz.restdemo.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.wmlz.restdemo.shiro.entity.Role;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    Role selectByPrimaryKey(Integer rid);

    List<Role> selectAll();

    List<Role> selectByUid(Integer uid);

    int updateByPrimaryKey(Role record);
}