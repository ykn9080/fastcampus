package com.fastcampus.ch3;

public interface UserDao {
    User selectUser(String id);

    int updateUser(User user);

    int insertUser(User user);
}
