package controller;

import dao.StudentDaoImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateStudent")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String choice = req.getParameter("choice");
        String newValue = req.getParameter("newValue");

        if (choice.equals("name")) {
            new StudentDaoImplementation().updateNameRecord(id,newValue);
        } else {
            new StudentDaoImplementation().updateCityRecord(id,newValue);
        }

        out.println("<h1>Student Updated Successfully</h1>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req,resp);
    }
}
