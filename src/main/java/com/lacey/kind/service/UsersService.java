package com.lacey.kind.service;

import com.lacey.kind.entity.Users;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface UsersService {
    Users login(String username,String password);
}
