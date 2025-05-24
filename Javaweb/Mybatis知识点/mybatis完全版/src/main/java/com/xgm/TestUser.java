package com.xgm;

import com.xgm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser {
    public static void main(String[] args) {

    //1.加载mybatis配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //2.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

    //3.执行SQL语句
       List<User> users = session.selectList("test.selectAll");

       System.out.println(users);
    //4.释放资源
        session.close();
    }
}
