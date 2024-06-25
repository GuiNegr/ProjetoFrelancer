package br.com.FreeLancer.servlet;

import br.com.FreeLancer.controller.PeopleController;
import br.com.FreeLancer.model.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String pass = req.getParameter("password");

        People people = new People(userName,pass);
        PeopleController pc = new PeopleController();
        Boolean verify = pc.verify(people);

        if (verify) {
            req.getSession().setAttribute("loggedUSer", userName);
            resp.sendRedirect("index.jsp");
        } else {
            req.setAttribute("message", "Erro de credencial");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
