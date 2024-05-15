package controller;

import dao.ChildDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBConnection;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ChildDao dao = new ChildDao(DBConnection.getConnection());

        boolean f = dao.deleteChild(id);

        if (f) {
            System.out.println("Success");
            resp.sendRedirect("index.jsp");
        } else {
            System.out.println("Error");
        }
    }
}
