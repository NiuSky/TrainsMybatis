package com.hk.mapper;

import com.hk.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest extends BaseTest {

    private SqlSession sqlSession;
    private Logger logger = LogManager.getLogger();

    private UserMapper userMapper;
    @Before
    public void getSession() {
        if (sqlSession == null) {
            sqlSession = getSqlSessionFactory().openSession();
        }
        if(userMapper == null){
            userMapper = sqlSession.getMapper(UserMapper.class);
        }
    }

    @After
    public void closeSession() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }


    @Test
    public void testSelectAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Assert.assertTrue(mapper.selectAll().size() > 0);
    }

    @Test
    public void testSelectByID() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Assert.assertTrue(userMapper.selectByID(1L) != null);
    }

    @Test
    public void testSelectRolesByUserID() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Assert.assertTrue(userMapper.selectRolesByUserID(1L).size() > 0);
    }

    @Test
    public void testSelectCount(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectUserCount());
        Assert.assertTrue(userMapper.selectUserCount() > 0);
    }


    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUserName("DO");
        user.setUserPassword("123");
        user.setCreateTime(new Date());
        System.out.println(sqlSession.getMapper(UserMapper.class).insertUser(user));
        System.out.println(user.getID());
        sqlSession.commit();
    }

    @Test
    public void updateByUserIDTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setID(12L);
        user.setUserName("Do");
        System.out.println(userMapper.updateBYID(user));
        sqlSession.commit();
    }


    @Test
    public void updateByIDAndPwd(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.updateBYIDAndPwd(12L,"Do","123"));
        sqlSession.commit();

    }


    @Test
    public void selectByNameAndPwd(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectByNameAndPwd("Do","123").size());
    }


    @Test
    public void selectDyncTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        Assert.assertTrue(userMapper.selectDync(user).size() == 4);
        user.setUserName("Do");

        Assert.assertTrue(userMapper.selectDync(user).size() == 2);
        user.setUserPassword("123");
        Assert.assertTrue(userMapper.selectDync(user).size() == 1);
    }



    @Test
    public void updateDyncTest(){

        User user = new User();
        user.setID(3L);
        user.setUserEmail("dujiang@hkjtgc.com");
        user.setUserInfo("测试");

        Assert.assertEquals(userMapper.updateDync(user),1);
    }


    @Test
    public void selectByIDArrayTest(){
        List<User> users = userMapper.selectByIDList(new Long[]{1L,12L,14L});
        Assert.assertEquals(users.size(),3);
    }

    @Test
    public void selectByIDArrayAndUserNameTest(){
        List<User> users = userMapper.selectByIDListAndName(new Long[]{1L,12L,14L},"admin");
        Assert.assertEquals(1,users.size());
    }

    @Test
    public void selectByMapTest(){
        Map<String,Object> params = new HashMap<>();
        params.put("ID",12L);
        params.put("User_Name","Do");
        Assert.assertEquals(1,userMapper.selectByMap(params).size());
    }
}
