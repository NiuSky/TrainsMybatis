package com.hk.mapper;

import com.hk.model.Role;
import com.hk.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    User selectByID(Long ID);

    List<User> selectAll();

    List<Role> selectRolesByUserID(Long ID);

    int selectUserCount();


    int insertUser(User user);


    int updateBYID(User user);


    int updateBYIDAndPwd(@Param("ID") Long ID, @Param("userName") String userName, @Param("userPassword") String pwd);



    @ResultMap("userMapper")
    @Select("SELECT user_name FROM Sys_User WHERE User_Name = #{userName} AND User_Password = #{userPassword}")
    List<String> selectByNameAndPwd(@Param("userName") String name,@Param("userPassword") String pwd);

    List<User> selectDync(User user);


    int updateDync(User user);

}
