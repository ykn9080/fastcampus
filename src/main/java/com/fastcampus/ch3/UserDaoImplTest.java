package com.fastcampus.ch3;


import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;


import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest {
    @Autowired
    UserDao userDao;
    @Test
    public void selectUser() {
    }

    @Test
    public void updateUser() {
        User user=new User("asdf21", "1234", "abc", "ykn@g.com", new Date(), "fb", new Date());
        int rowCnt=userDao.insertUser(user);
        assertEquals(rowCnt, 1);
    }

    @Test
    public void insertUser() {
    }
}