package xyz.wmlz.restdemo.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.wmlz.restdemo.shiro.entity.Perm;

import java.util.List;

@Repository
@Mapper
public interface PermMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Perm record);

    Perm selectByPrimaryKey(Integer pid);

    List<Perm> selectAll();

    List<Perm> selectByUid(Integer uid);

    int updateByPrimaryKey(Perm record);
}