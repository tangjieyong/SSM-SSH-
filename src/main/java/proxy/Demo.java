package proxy;

import dao.Anotation;
import dao.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.mybatisUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*原生的方式开发session直接操作的是mapper.xml 方法中参数传入 namespace+id
* mapper代理方式将接口和mapper.xml动态绑定，用户可以完全面向接口编程
* */
public class Demo {
    private User getUser() {
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        return session.getMapper(User.class);
    }
    @Test
    public void test1(){
        User user = getUser();
        domain.User u = user.getUser(19);
        System.out.println(u);
        System.out.println(u.getEmail());
    }

    /*非自增主键的返回*/
       @Test
    public void test2(){
           User user = getUser();
           domain.User u=new domain.User("天天",23,'女');
        user.insertReturnPrimaryKey(u);
        System.out.println(u.getPid());
    } 


    /*基于注解开发*/
    @Test
    public void tset3(){
        SqlSession session = mybatisUtil.getSession(true, "src/main/resources/mybatisConfig.xml");
        Anotation mapper = session.getMapper(Anotation.class);
        domain.User user = mapper.getUser(19);
        System.out.println(user);
    }

    @Test
    public void test4(){
        User user = getUser();
        domain.User u = user.getUserByNameAndAge("飞飞", 21);
        System.out.println(u);
    }
    @Test
    public void test5(){
        User user = getUser();
        domain.User u=new domain.User("gold",34,'男');
        user.insertUseGeneratedKeys(u);
        System.out.println(u.getPid());
    }
    @Test
     public void test6(){
        User user = getUser();
        domain.User u = user.getUserByNamedParameter("飞飞", 21);
         System.out.println(u);
     }
    @Test
    public void test7(){
        User user = getUser();
        Map<String,String> map=new HashMap<>();
        map.put("pname","飞飞");
        map.put("page","21");
        domain.User u = user.getUserByMap(map);
        System.out.println(u);
    }
    @Test
    public void test8(){
        User user = getUser();
        List<String> list =new ArrayList();
        list.add("飞飞");
        list.add("21");
        domain.User u = user.getUserByList(list);
        System.out.println(u);
    }
    @Test
    public void test9(){
        User user = getUser();
        String[]arr={"飞飞","21"};
        domain.User u = user.getUserByArray(arr);
        System.out.println(u);
    }
    @Test
    public void test10(){
        User user = getUser();
        List<domain.User> list = user.getUsersPottingInList('男');
        for(domain.User u:list){
            System.out.println(u);
        }
    }

    @Test
    public void test11(){
        User user = getUser();
        Map<Integer, Object> map = user.getUserPottingInMap(19);
       for(int i:map.keySet()){
           System.out.print(i+"="+map.get(i));
       }
    }


    @Test
    public void test12(){
        User user = getUser();
        Map<Integer, domain.User> map = user.getUsersPottingInMap('男');
        System.out.println(map);
    }
    @Test
    public void test13(){
        User user = getUser();
        domain.User u = user.getUserByResultMap(19);
        System.out.println(u);
    }

    @Test
    public void test14(){
        User user = getUser();
        domain.User u = user.getUserByStep(19);
        System.out.println(u);
    }
}
