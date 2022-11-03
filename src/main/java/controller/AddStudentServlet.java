package controller;

import bean.Student;
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import dao.StudentDaoImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        Student student = new Student(id,name,city);

        StudentDaoImplementation studentDaoImplementation = new StudentDaoImplementation();
        studentDaoImplementation.addRecord(student);

        out.println("<h1>Student Added Successfully</h1>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req,resp);



    }
}
