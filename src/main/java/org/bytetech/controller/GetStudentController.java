package org.bytetech.controller;


import org.bytetech.dao.StudentDao;
import org.bytetech.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        StudentDao dao = new StudentDao();
        Student s = dao.getStudent(id);

        req.setAttribute("student", s);

        RequestDispatcher rd = req.getRequestDispatcher("showStudent.jsp");
        rd.forward(req, resp);
    }
}
