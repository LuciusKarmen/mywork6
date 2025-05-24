package com.xgm;

import com.xgm.mapper.UserMapper;
import com.xgm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMapperUser {
    public static void main(String[] args) {
        //1.加载mybatis配置文件,获取SqlSessionFactory

        String resource = "mybatis-config.xml";

        InputStream inputStream;

        {
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //3.执行SQL语句
//        List<User> user = session.selectList("test.selectAll");
        //3.1
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> user = userMapper.selectAll();
        System.out.println(user);

        session.close();


    }
}
