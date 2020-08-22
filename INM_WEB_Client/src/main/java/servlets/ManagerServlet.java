package main.java.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.clients.EntityClient;
import main.java.entity.Incident;

import javax.servlet.RequestDispatcher;
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
    /*
     * TODO:
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Incident incident = new Incident();

//        if (request.getParameter("date") != null) incident.setDate(Timestamp.valueOf(request.getParameter("date")));
//        else incident.setDate(Timestamp.valueOf("1594759370000"));
        if (request.getParameter("category") != null)
            incident.setCategory(Integer.parseInt(request.getParameter("category")));
        if (request.getParameter("priority") != null)
            incident.setPriority(Integer.parseInt(request.getParameter("priority")));
        if (request.getParameter("department") != null)
            incident.setRequesterDepartment(Integer.parseInt(request.getParameter("department")));
        if (request.getParameter("requester") != null) incident.setRequester(request.getParameter("requester"));
        if (request.getParameter("requesterContacts") != null)
            incident.setRequesterContacts(request.getParameter("requesterContacts"));
        if (request.getParameter("ip") != null) incident.setIpAddress(request.getParameter("ip"));
        if (request.getParameter("duration") != null)
            incident.setDuration(Integer.parseInt(request.getParameter("duration")));
        if (request.getParameter("description") != null) incident.setDescription(request.getParameter("description"));
        if (request.getParameter("engineer") != null)
            incident.setEngineer(Integer.parseInt(request.getParameter("engineer")));
        if (request.getParameter("operator") != null)
            incident.setOperator(Integer.parseInt(request.getParameter("operator")));
        if (request.getParameter("status") != null)
            incident.setStatus(Integer.parseInt(request.getParameter("status")));
//        if (request.getParameter("close_date") != null)
//            incident.setCloseDate(Timestamp.valueOf(request.getParameter("close_date")));
        else incident.setCloseDate(Timestamp.valueOf("1594759370000"));


        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter s = new StringWriter();
        objectMapper.writeValue(s, incident);

        EntityClient entityClient = new EntityClient();
//        entityClient.addIncident(s.toString());
        int id = entityClient.addIncident(s.toString());

        request.setAttribute("id", id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntityClient entityClient = new EntityClient();
        int id = Integer.parseInt(request.getParameter("id"));

        Incident incident = entityClient.getIncident(id);

        request.setAttribute("id", incident.getId());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
