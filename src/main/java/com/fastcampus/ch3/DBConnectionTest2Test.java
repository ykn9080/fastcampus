package com.fastcampus.ch3;




import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import javax.sql.*;
import java.sql.*;

import static org.junit.Assert.*;




//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:/src/main/webapp/WEB-INF/**/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class DBConnectionTest2Test {
    @Autowired
    DataSource ds;
    @Test
    public void main() throws Exception{
//        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
//        DataSource ds = ac.getBean(DataSource.class);

        Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

        System.out.println("conn = " + conn);
        assertTrue(conn!=null);
    }
}