package com.ggs.mapper;

import com.ggs.model.User;
import com.ggs.sql.builder.UserSqlBuilder;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;

import java.util.List;

@Mapper
@MapperDataSource("app")
public interface UserMapper {

    @Select("SELECT user.id, user.name, role.id role_id, role.name role_name\n" +
        "        from USER user left outer join USER_ROLE user_role\n" +
        "        on user.id = user_role.user_id left outer join ROLE role on role.id = user_role.role_id")
    @ResultMap("UserResultMap")
    List<User> findAllUsers();

    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetAllUsers")
    @ResultMap("UserResultMap")
    List<User> findAllUsersUsingBuilder();
}
