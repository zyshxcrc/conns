package mapper;


import domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */
public interface UserMapper {


    @Select("SELECT * FROM tbl_user")
    List<User> getUserList();

    @Select("SELECT * FROM tbl_user WHERE userId = #{userId}")
    domain.User getUserById(@Param("userId") String userId);

    @Update("UPDATE tbl_user SET sex = #{sex} WHERE userId = #{userId}")
    void updateUserEmailById(@Param("userId") String userId, @Param("sex") String sex);

    @Delete("DELETE FROM tbl_user WHERE userId = #{userId}")
    void deleteUserById(@Param("userId") String userId);

    void insertUser(User user);
}
