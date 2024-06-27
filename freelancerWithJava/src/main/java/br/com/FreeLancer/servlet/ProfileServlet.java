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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        People people = (People) session.getAttribute("pessoa");

        if (people != null) {
            People psp = new PeopleController().returnLogin(people);
            req.setAttribute("userProfile", psp);
            req.getRequestDispatcher("/homeCad.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");







            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        People people = (People) session.getAttribute("pessoa");

        if (people != null) {

            resp.sendRedirect(req.getContextPath() + "/ProfileServlet");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp"); // Redireciona se não houver usuário na sessão
        }
    }
    }

