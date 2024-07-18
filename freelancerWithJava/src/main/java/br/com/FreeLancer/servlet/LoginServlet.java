package br.com.FreeLancer.servlet;

import br.com.FreeLancer.controller.userController;
import br.com.FreeLancer.model.User;

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

        User user = new User(userName,pass);
        userController pc = new userController();
        boolean verify = pc.verify(user);

        if (verify) {
            user = pc.returnLogin(user);
            req.getSession().setAttribute("user", user);
            System.out.println(user);
            resp.sendRedirect("homeCad.jsp");
        } else {
            req.setAttribute("message", "Erro de credencial");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
