package com.test.mybatis;

import com.mzhu.mapper.UserMapper;
import com.mzhu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test4 {

    @Test
    public void addUser() throws IOException {
        User user = new User();
        user.setUsername("大猪猪");
        user.setAddress("深圳");
        user.setAge(1);
        user.setPassword("123456789");
        user.setGender("male");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        try {
            int i = mapper.addUser(user);
            System.out.println(i);
            //手动提交事务
            sqlSession.commit();
        }catch (Exception e){
            System.out.println("用户名已存在，添加失败");
        }

        sqlSession.close();

    }
    @Test
    public void updatePassword() throws IOException {
            String username = "小猪猪";
            String password = "123456789";
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updatePassword(password,username);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void checkByUsername() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        boolean checkResult = checkUsernameExistence("zzy", users);
        if(checkResult){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名不存在");
        }
        sqlSession.commit();
        sqlSession.close();

    }
    //输入查询的用户名和从数据库中获得的集合
    public boolean checkUsernameExistence(String inputUsername,List<User> users){
        for (User user : users) {
            if(user.getUsername().equals(inputUsername)){
                return true;
            }
        }
        return false;
    }
}
