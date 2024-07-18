package br.com.FreeLancer.servlet;

import br.com.FreeLancer.controller.userController;
import br.com.FreeLancer.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String telefone = req.getParameter("telefone");
        String aboutMe = req.getParameter("aboutMe");

        User user = (User) req.getSession().getAttribute("user");

        user.setNome(nome);
        user.setSobrenome(sobrenome);
        user.setTelefone(telefone);
        user.setAboutMe(aboutMe);

        userController usc = new userController();

        usc.updateCad(user);
        req.getSession().setAttribute("user", user);

        resp.sendRedirect("homeCad.jsp");
    }
}