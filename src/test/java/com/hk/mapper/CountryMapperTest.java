package com.hk.mapper;

import com.hk.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

public class CountryMapperTest extends BaseTest{

    @Test
    public void testSelectAll() throws IOException {

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sessionFactory.openSession();
        List<Country> countryList = sqlSession.selectList("com.hk.mapper.CountryMapper.selectAll");
        countryList.stream().forEach((e)-> System.out.println(e));
        sqlSession.close();

    }


}
