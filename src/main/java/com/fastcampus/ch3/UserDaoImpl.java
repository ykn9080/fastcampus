package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource ds;
    final int FAIL=0;


    @Override
    public User selectUser(String id) {

        User user = null;
        String sql = "select * from user_info where id= ? ";

        try (
                Connection conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()

        ){

            //pstmt.setString(1, id);
             //  select

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setBirth(new Date(rs.getDate(5).getTime()));
                user.setSns(rs.getString(6));
                user.setReg_date(new Date(rs.getTimestamp(7).getTime()));
            }
        } catch (SQLException e) {
            return null;
        }

        return user;
    }

    @Override
    public int updateUser(User user){
        int rowCnt = FAIL;

        String sql = "update user_info set pwd=?, name=?, email=?, birth=?, reg_date=?,sns=? where id=?";

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, user.getPwd());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
            pstmt.setString(5, user.getSns());
            pstmt.setTimestamp(6, new java.sql.Timestamp(user.getReg_date().getTime()));
            pstmt.setString(7, user.getId());

            rowCnt = pstmt.executeUpdate(); //  insert, delete, update
        } catch (SQLException e) {
            return FAIL;
        }

        return rowCnt;
    }
    @Override
    public int insertUser(User user){

        int rowCnt = FAIL;

        String sql = "insert into user_info(id, pwd, name, email, birth, sns, reg_date) values(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

             pstmt.setString(1, user.getId());
             pstmt.setString(2, user.getPwd());
             pstmt.setString(3, user.getName());
             pstmt.setString(4, user.getEmail());
             pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
             pstmt.setString(6, user.getSns());
             pstmt.setTimestamp(7, new java.sql.Timestamp(user.getReg_date().getTime()));

             rowCnt = pstmt.executeUpdate(); //  insert, update, delete
    } catch (SQLException e) {
        return FAIL;
    }
        return rowCnt;
}
//    private void close(AutoCloseable... acs) {
//        for(AutoCloseable ac :acs)
//            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
//    }
}
