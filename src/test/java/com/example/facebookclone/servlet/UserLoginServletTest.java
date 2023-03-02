package com.example.facebookclone.servlet;

import com.example.facebookclone.dao.DashboardDAO;
import com.example.facebookclone.dao.UserDAO;
import com.example.facebookclone.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    private UserDAO userDAO;
    private DashboardDAO dashboardDAO;

    @BeforeEach
    void setUp(){
        request= Mockito.mock(HttpServletRequest.class);
        response=Mockito.mock(HttpServletResponse.class);
        userDAO=new UserDAO();
    }


    @Test
    void doPost() {
     Mockito.when(request.getParameter("userName")).thenReturn("richiie");
     Mockito.when(request.getParameter("password")).thenReturn("1234");
//     User user = new User();
//     user.setUserName("richiie");
//     user.setPassWord("1234");
        try {
            User user1= this.userDAO.getUser("richiie","1234");
            Assertions.assertEquals(user1.getUserName(),"richiie");
            Assertions.assertEquals(user1.getPassWord(),"1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}