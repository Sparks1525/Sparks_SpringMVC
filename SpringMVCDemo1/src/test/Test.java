package test;

import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by kerwin on 2017/9/13.
 */
public class Test {
    public static void main(String[] args) throws Exception{

        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mapper/mybatis-config.xml"));
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);


        User user =  new User(2,"ccc","ddd");
        //userMapper.delete(4);
        userMapper.update(user);
        //System.out.println(user);



        session.commit();
        session.close();
    }
}
