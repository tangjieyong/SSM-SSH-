
package utils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class mybatisUtil {

    public static SqlSessionFactory getFactory(String filepath){
        InputStream stream=null;
        try {
            stream=new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(stream);
    }


    public static SqlSession getSession(boolean flag,String filepath){
        SqlSessionFactory factory = getFactory(filepath);
        return factory.openSession(flag);
    }
}
