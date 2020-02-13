package xyz.wmlz.restdemo.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xyz.wmlz.restdemo.shiro.entity.RolePerm;

import java.util.List;

@Repository
@Mapper
public interface RolePermMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("permId") Integer permId);

    int insert(RolePerm record);

    List<RolePerm> selectAll();
}