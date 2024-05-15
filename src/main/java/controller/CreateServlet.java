package controller;

import dao.ChildDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Child;
import utils.DBConnection;

import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String group = req.getParameter("group");

        Child child = new Child(name, age, gender, group);

        ChildDao dao = new ChildDao(DBConnection.getConnection());
        HttpSession session = req.getSession();
        boolean f = dao.addChild(child);

        if (f) {
            session.setAttribute("succMsg", "Submit!");
            resp.sendRedirect("addChild.jsp");
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
    }
}
