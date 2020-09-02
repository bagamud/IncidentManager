//package main.java.servlets;
//
////import main.java.ru.kpp.inm_client.clients.AuthClient;
//
//import main.java.jb.SelectedUser;
//import main.java.jb.Session;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "auth", urlPatterns = "/auth")
//public class AuthorizationServlet extends HttpServlet {
//    /*
//     TODO:
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
////        String login = request.getParameter("login");
////        String password = request.getParameter("password");
//        Session session = new Session();
//
//        session.setUser(new SelectedUser(request.getParameter("user")));
////        AuthClient authClient = new AuthClient();
////        if (authClient.isLogin(login, password)) {
////            RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager.jsp");
////            requestDispatcher.forward(request, response);
////        } else {
////            request.setAttribute("msg", "Incorrect login or password");
////            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
////            requestDispatcher.forward(request, response);
////        }
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager.jsp");
//        requestDispatcher.forward(request, response);
//    }
//}
