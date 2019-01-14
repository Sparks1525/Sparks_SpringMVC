package mapper;
import entity.User;
/**
 * Created by kerwin on 2017/9/13.
 */
public interface UserMapper {
    User get(int id);
    void insert(User user);
    void delete(int id);
    void update(User user);
}
