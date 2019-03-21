package dao;

import domain.User;
import org.apache.ibatis.annotations.Select;

public interface Anotation {
    @Select("  SELECT pid,pname,page,sex FROM USER WHERE pid=#{pid};")
    public User getUser(int pid);
}
