package main.java.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.clients.ManagerClient;
import main.java.entity.Incident;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;

@WebServlet(name = "ManagerServlet", urlPatterns = "/manager")
public class ManagerServlet extends HttpServlet {
    /**
     * TODO:
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Incident incident = new Incident();

        incident.setDate(Timestamp.valueOf(request.getParameter("date")));
        incident.setCategory(Integer.parseInt(request.getParameter("category")));
        incident.setOperator(Integer.parseInt(request.getParameter("operator")));


        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter s = new StringWriter();
        objectMapper.writeValue(s, incident);

        ManagerClient managerClient = new ManagerClient();
        int id = managerClient.addIncident(s.toString());

        request.setAttribute("id", id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
