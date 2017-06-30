import domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface UserDAO {
    @Insert("insert into User(id,name) values (#{nameId},#{name})")
    @SelectKey(statement = "call next value for TestSequence",keyProperty="nameId",before = true,resultType = int.class)
    int insertUser();

    @Results(id="selectByName",value={
         @Result(property = "id",column = "id",id = true),
         @Result(property = "name",column = "name"),
         @Result(property = "password",column = "password")
    })
    @Select("select * from User where name = #{name}")
    User selectByName(String name);


    int updateUser(String name);
}
