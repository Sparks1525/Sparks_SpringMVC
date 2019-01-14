package entity;

/**
 * Created by kerwin on 2017/9/12.
 */
public class User {
    private int id;
    private String userName;
    private String password;

    public User(){}

    public User(int id, String userName, String password) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
