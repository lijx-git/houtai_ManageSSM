package com.lacey.kind.dao;

import com.lacey.kind.entity.Users;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface UserDao {
    Users selectUserByUsernameAndPwd(@Param("username") String username, @Param("password") String passeord);
}