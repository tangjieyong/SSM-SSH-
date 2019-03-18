package domain;

public class User {
    private Integer pid;
    private String pname;
    private Integer page;
    private Character sex;

    public User(Integer pid, String pname, Integer page, Character sex) {
        this.pid = pid;
        this.pname = pname;
        this.page = page;
        this.sex = sex;
    }

    public User(String pname, Integer page, Character sex) {
        this.pname = pname;
        this.page = page;
        this.sex = sex;
    }

    public User() {
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Integer getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public Integer getPage() {
        return page;
    }

    public Character getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", page=" + page +
                ", sex=" + sex +
                '}';
    }
}
