package dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*使用mapper代理的方式开发*/
public interface User {
    domain.User getUser(int pid);

    int insertReturnPrimaryKey(domain.User user);

    domain.User getUsers(int pid);

    domain.User getUserByNameAndAge(String name,int age);

    void insertUseGeneratedKeys(domain.User user);

    domain.User getUserByNamedParameter(@Param("pname")String name, @Param("page")int page);
    /*mybatis会完成数据类型的自动转换，数据库中的数据为int型，有时候也可以传入String，特别是在参数类型为集合类型
    * 需要指定泛型时*/

    domain.User getUserByMap(Map<String,String> map);

    domain.User getUserByList(List<String> list);

    domain.User getUserByArray(String[]arr);

    List<domain.User> getUsersPottingInList(Character sex);

    Map<Integer,Object> getUserPottingInMap(Integer pid);

    @MapKey("pid")
    Map<Integer, domain.User> getUsersPottingInMap(Character sex);

    domain.User getUserByResultMap(Integer pid);

    domain.User getUserByStep(Integer pid);


}
