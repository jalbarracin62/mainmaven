/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Series;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Video;
import Servicios.DbUtil;

public class SeriesDao
{
    private Connection connection;

    public SeriesDao()
    {
        connection = DbUtil.getConnection();
    }

    public void addSeries(Series series)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into series(nocapitulo,temporadas) values (?, ? )");
            // Parameters start with 1
            preparedStatement.setInt(1, series.getNocapitulo());
            preparedStatement.setInt(2, series.getTemporadas());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

   

    public List<Series> getAllSeries()
    {
        List<Series> seriess = new ArrayList<Series>();
        try
        {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from series");
            while (rs.next())
            {
                Series serie = new Series();
               serie.setIdseries(rs.getInt("idseries"));
                serie.setNocapitulo(rs.getInt("nocapitulo"));
                   serie.setTemporadas(rs.getInt("temporadas"));
                seriess.add(serie);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return seriess;
    }

    public Series getSerieById(int serieid)
    {
        Series series = new Series();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from series where idseries=?");
            preparedStatement.setInt(1, serieid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                series.setIdseries(rs.getInt("idseries"));
                series.setNocapitulo(rs.getInt("nocapitulo"));
                series.setTemporadas(rs.getInt("temporadas"));
                
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return series;
    }
}
