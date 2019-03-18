package basic;

import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.mybatisUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Demo {
    @Test
    public void test1(){
        String sta="resources.userMapper.selectOneUser";
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        String pname = session.selectOne(sta, 5);
        System.out.println(pname);
        session.close();

    }

    @Test
    public void test2(){/*若要将数据库中的记录映射到对象中，那么对象所对应的类应当提供无参构造*/
       String sta="resources.userMapper.getInUser";
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        User user = session.selectOne(sta, 1);
        System.out.println(user);
        session.close();

    }
    @Test
    public void test3(){
        String sta="resources.userMapper.insertUser";
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        User user=new User("飞飞",21,'男');
        session.insert(sta,user);
        session.close();
    }

    @Test
    public void test4(){
        String sta="resources.userMapper.updateUser";
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        User user=new User(16,"汤汤",21,'男');
        session.update(sta,user);
        session.close();
    }

    @Test
    public void test5(){
        String sta="resources.userMapper.deleteUser";
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        User user=new User();
        user.setPid(1);
        session.delete(sta,user);
        session.close();
    }
}
