package br.com.FreeLancer.servlet;

import br.com.FreeLancer.controller.PeopleController;
import br.com.FreeLancer.model.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        People people = (People) session.getAttribute("pessoa");
        req.setAttribute("pessoa", people);
        req.getRequestDispatcher("homeCad.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        People people = (People) session.getAttribute("pessoa");
        req.setAttribute("pessoa", people);
        req.getRequestDispatcher("homeCad.jsp").forward(req, resp);
    }
}

