package org.bytetech.controller;

import org.bytetech.dao.StudentDao;
import org.bytetech.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String _class = req.getParameter("class");
        String marksStr = req.getParameter("marks");
        String message;

        if (marksStr != null && !marksStr.isEmpty()) {
            try {
                int marks = Integer.parseInt(marksStr);
                Student s = new Student();
                s.setName(name);
                s.set_class(_class);
                s.setMarks(marks);

                StudentDao dao = new StudentDao();
                if (dao.addStudent(s) != null) {
                    message = "The student has been successfully added to the database.";
                } else {
                    message = "Unexpected error. Please contact the system administrator.";
                }
            } catch (NumberFormatException e) {
                message = "Invalid marks. Please enter a valid number.";
            }
        } else {
            message = "Marks field is required.";
        }

        req.setAttribute("message", message);
        RequestDispatcher rd = req.getRequestDispatcher("message.jsp");
        rd.forward(req, resp);
    }
}
