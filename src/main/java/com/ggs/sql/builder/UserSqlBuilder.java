package com.ggs.sql.builder;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlBuilder {

    public static String buildGetAllUsers() {
        return new SQL() {{
            SELECT("user.id, user.name, role.id role_id, role.name role_name");
            FROM("USER user");
            LEFT_OUTER_JOIN("USER_ROLE user_role on user.id = user_role.user_id");
            LEFT_OUTER_JOIN("ROLE role on role.id = user_role.role_id");
        }}.toString();
    }
}
