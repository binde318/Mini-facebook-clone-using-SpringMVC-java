package com.example.facebookclone.dao;

import com.example.facebookclone.models.Posts;
import com.example.facebookclone.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/facebook";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234567890";

    private static final String SELECT_ALL_POST_EXCEPT_USER= "select * from Posts where userId<> ?";

    private Connection getConnection(){
        Connection dataConnection= null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dataConnection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return dataConnection;
    };


    public  List<Posts> displayAllOtherUsersPosts(User user){
        List<Posts>listOfPosts = new ArrayList<>();
        try (Connection connection= getConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_POST_EXCEPT_USER)){
            preparedStatement.setInt(1,user.getUserId());
            ResultSet result= preparedStatement.executeQuery();
            while(result.next()){
                String content= result.getString("content");
                int userId= result.getInt("userId");
                int postId= result.getInt("postId");
                Posts post = new Posts();
                post.setContent(content);
                post.setPostId(postId);
                post.setUserId(userId);
                listOfPosts.add(post);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listOfPosts;
    }
}
