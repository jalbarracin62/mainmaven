/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SeriesDao;
import dao.VideoDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Video;


/**
 * Adaptado de https://danielniko.wordpress.com/2012/04/17/simple-crud-using-jsp-servlet-and-mysql/
 * @author Fabian Giraldo
 */
public class Controller3 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/videos.jsp";
    private static String LIST_VIDEOS = "/listvideos.jsp";
    private VideoDao dao;

    public Controller3()
    {
        super();
        dao = new VideoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String forward = "";
        String action = request.getParameter("action");
         if (action.equalsIgnoreCase("listVideo"))
        {
            forward = LIST_VIDEOS;
            request.setAttribute("idvideo", dao.getAllVideos());
        }
        else
        {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Video video = new Video();
        video.setFkseries(Integer.parseInt(request.getParameter("fkseries")));
        video.setTitulo(request.getParameter("titulo"));
         video.setDirector(request.getParameter("director"));
        try
        {
            Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
            video.setCreacion(dob);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
  video.setGenero(request.getParameter("genero"));
        String idvideo = request.getParameter("idvideo");
        if (idvideo == null || idvideo.isEmpty())
        {
            dao.addVideo(video);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_VIDEOS);
        request.setAttribute("videos", dao.getAllVideos());
        view.forward(request, response);
    }
}