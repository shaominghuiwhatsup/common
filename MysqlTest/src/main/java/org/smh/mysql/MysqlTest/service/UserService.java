package org.smh.mysql.MysqlTest.service;

import org.smh.mysql.MysqlTest.dao.UserDao;
import org.smh.mysql.MysqlTest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int addUser(User user) {
        int result = 0;
        if (user != null) {
            result = userDao.insert(user);
        }
        return result;
    }

}
