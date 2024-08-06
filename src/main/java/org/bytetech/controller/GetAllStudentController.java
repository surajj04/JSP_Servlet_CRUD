package org.bytetech.controller;

import org.bytetech.dao.StudentDao;
import org.bytetech.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao dao = new StudentDao();

        List<Student> students = dao.getAllStudent();
        req.setAttribute("students", students);

        RequestDispatcher rd = req.getRequestDispatcher("showlist.jsp");
        rd.forward(req, resp);
    }
}
