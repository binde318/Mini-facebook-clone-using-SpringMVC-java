package com.example.facebookclone.servlet;

import com.example.facebookclone.dao.DashboardDAO;
import com.example.facebookclone.dao.UserDAO;
import com.example.facebookclone.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationServletTest {
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
//        Mockito.when(request.getParameter("userName")).thenReturn("richiie");
//        Mockito.when(request.getParameter("firstName")).thenReturn("");



        User user= new User();
        user.setUserName("naoth");
        user.setFirstName("naomi");
        user.setLastName("mac");
        user.setCountry("nigeria");
        user.setPassWord("123456");
        user.setEmail("bmac@gmail.com");
        try {
            int status= userDAO.createUser(user);
            Assertions.assertEquals(1,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}