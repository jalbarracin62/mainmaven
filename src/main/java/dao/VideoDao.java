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

import modelo.Video;
import Servicios.DbUtil;

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

   
    public List<Video> getAllVideos()
    {
        List<Video> videos = new ArrayList<Video>();
        try
        {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from video order by director DESC");
            while (rs.next())
            {
                Video video = new Video();
                video.setIdvideo(rs.getInt("idvideo"));
                video.setFkseries(rs.getInt("fkseries"));

                video.setTitulo(rs.getString("titulo"));
                video.setDirector(rs.getString("director"));
                video.setCreacion(rs.getDate("dob"));
                video.setGenero(rs.getString("genero"));
               
                videos.add(video);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return videos;
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
