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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String group = req.getParameter("group");

        Child child = new Child(id, name, age, gender, group);

        ChildDao dao = new ChildDao(DBConnection.getConnection());
        boolean f = dao.updateChild(child);

        if (f) {
            System.out.println("Success");
            resp.sendRedirect("index.jsp");
        } else {
            System.out.println("Error");
        }
    }
}
