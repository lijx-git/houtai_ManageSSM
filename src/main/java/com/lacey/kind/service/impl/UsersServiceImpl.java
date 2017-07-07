package com.lacey.kind.service.impl;

import com.lacey.kind.dao.UserDao;
import com.lacey.kind.entity.Users;
import com.lacey.kind.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserDao userDao;

    public Users login(String username, String password) {
      return userDao.selectUserByUsernameAndPwd(username,password);
    }


}
