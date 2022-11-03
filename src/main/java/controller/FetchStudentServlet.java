package controller;

import bean.Student;
import dao.StudentDaoImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FetchStudentPage")
public class FetchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Student> studentsList = new StudentDaoImplementation().fetch();

        out.print("<table border=2px>");
        out.print("<th>ROLL NO</th><th> NAME</th><th> CITY </th>");

        for (Student s:studentsList) {
            out.println("<tr><td>"+s.getStudentId()+"</td><td>"+s.getStudentName()+"</td><td>"+s.getCity()+"</td></tr>");
        }

        out.print("</table>");

    }
}
