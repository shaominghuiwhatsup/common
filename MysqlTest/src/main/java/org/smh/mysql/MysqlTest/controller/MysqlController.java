package org.smh.mysql.MysqlTest.controller;

import org.smh.mysql.MysqlTest.pojo.User;
import org.smh.mysql.MysqlTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/mysql")
public class MysqlController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public String testMysql(@RequestBody User user) {
        userService.addUser(user);
        return "ok";
    }
}
