package org.bytetech.controller;

import org.bytetech.dao.StudentDao;
import org.bytetech.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateStudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String _class = req.getParameter("class");
        int marks = Integer.parseInt(req.getParameter("marks"));

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.set_class(_class);
        s.setMarks(marks);

        StudentDao dao = new StudentDao();

        boolean result = dao.updateStudent(s);

        if (result) {
            req.setAttribute("message", "Student record successfully Update.");
            RequestDispatcher rd = req.getRequestDispatcher("message.jsp");
            rd.forward(req, resp);
        }else{
            req.setAttribute("message", "Error updating student record. Please try again later.");
            RequestDispatcher rd = req.getRequestDispatcher("message.jsp");
            rd.forward(req, resp);
        }

    }
}
