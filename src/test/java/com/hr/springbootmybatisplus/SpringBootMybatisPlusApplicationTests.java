package com.hr.springbootmybatisplus;

import com.hr.springbootmybatisplus.mapper.UserMapper;
import com.hr.springbootmybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findAll() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }


    @Test
    void insert() {
        User user = new User();
        user.setName("Lucy");
        user.setAge(28);
        user.setEmail("lucy@qq.com");
        //使用mybatis-plus的自动填充功能
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
        int i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    void update() {
        //修改id为3的人 年龄为120
        User user = new User();
        user.setId(3L);
        user.setAge(120);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

}
