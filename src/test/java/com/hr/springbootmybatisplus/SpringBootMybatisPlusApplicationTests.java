package com.hr.springbootmybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hr.springbootmybatisplus.mapper.UserMapper;
import com.hr.springbootmybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
        user.setName("东方不败");
        user.setAge(1200);
        user.setEmail("dongfang@qq.com");
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

    //测试乐观锁
    @Test
    void testOptimisticLocker() {
        //根据id查询数据
        User user = userMapper.selectById(1343458716774600705L);
        user.setAge(100000);
        int i = userMapper.updateById(user);
        System.out.println(i);
        //版本号加1 ,乐观锁生效
    }

    //多个id批量查询
    @Test
    void selectBatchsIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    @Test
    void testPage() {
        //创建page对象, 传入两个参数,当前页和每页显示记录数
        Page<User> page = new Page<>(1,3);
        //把分页的所有数据封装到page对象里面
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
    }

}
