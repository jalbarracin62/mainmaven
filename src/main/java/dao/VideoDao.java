/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.daniel.model.User;
import modelo.Video;
import com.daniel.util.DbUtil;

public class VideoDao
{
    private Connection connection;

    public VideoDao()
    {
        connection = DbUtil.getConnection();
    }

    public void addVideo(Video video)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into video(idvideo,fkseries,titulo,director,dob,genero) values (?, ?, ?, ?,?,? )");
            // Parameters start with 1
            preparedStatement.setInt(1, video.getIdvideo());
            preparedStatement.setInt(2, video.getFkseries());
            preparedStatement.setString (3, video.getTitulo());
            preparedStatement.setString(4, video.getDirector());
           preparedStatement.setDate(5, new java.sql.Date(video.getCreacion().getTime()));
            preparedStatement.setString(6, video.getGenero());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

   
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<User>();
        try
        {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next())
            {
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }

    public Video getvideoById(int videoId)
    {
        Video video=new Video();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from video where idvideo=?");
            preparedStatement.setInt(1, videoId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                video.setIdvideo(rs.getInt("idvideo"));
                video.setFkseries(rs.getInt("fkseries"));
                video.setTitulo(rs.getString("titulo"));
                video.setDirector(rs.getString("director"));
                video.setCreacion(rs.getDate("dob"));
                video.setGenero(rs.getString("genero"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return video;
    }
}
