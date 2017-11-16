package controlador;

import dao.SeriesDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Series;

/**
 * Adaptado de https://danielniko.wordpress.com/2012/04/17/simple-crud-using-jsp-servlet-and-mysql/
 * @author Fabian Giraldo
 */
public class Controlador1 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/series.jsp";
    private static String LIST_SERIES = "/listseries.jsp";
    private SeriesDao dao;

    public Controlador1()
    {
        super();
        dao = new SeriesDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String forward = "";
        String action = request.getParameter("action");
         if (action.equalsIgnoreCase("edit"))
        {
            forward = INSERT_OR_EDIT;
            int seriesid = Integer.parseInt(request.getParameter("idseries"));
            Series series = dao.getSerieById(seriesid);
            request.setAttribute("idseries", series);
        }
        else if (action.equalsIgnoreCase("listUser"))
        {
            forward = LIST_SERIES;
            request.setAttribute("idseries", dao.getAllSeries());
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
        Series series = new Series();
        series.setNocapitulo(Integer.parseInt(request.getParameter("nocapitulo")));
        series.setTemporadas(Integer.parseInt(request.getParameter("temporadas")));
        
 
        String idseries = request.getParameter("idseries");
        if (idseries == null || idseries.isEmpty())
        {
            dao.addSeries(series);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_SERIES);
        request.setAttribute("series", dao.getAllSeries());
        view.forward(request, response);
    }
}