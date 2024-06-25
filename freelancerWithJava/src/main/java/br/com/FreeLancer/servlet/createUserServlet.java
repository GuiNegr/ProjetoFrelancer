package br.com.FreeLancer.servlet;

import br.com.FreeLancer.controller.PeopleController;
import br.com.FreeLancer.model.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-user")
public class createUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome").toLowerCase();
        String sobrenome = req.getParameter("sobrenome").toLowerCase();
        String pass = req.getParameter("pass");
        String userName = req.getParameter("userName").toLowerCase();
        String email = req.getParameter("email").toLowerCase();

        People people = new People(userName,pass,nome,sobrenome,email);
        PeopleController pc = new PeopleController();
        pc.createCad(people);
        System.out.println(people);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
