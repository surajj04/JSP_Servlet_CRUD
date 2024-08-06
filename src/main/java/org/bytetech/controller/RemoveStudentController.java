package org.bytetech.controller;

import org.bytetech.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveStudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        StudentDao dao = new StudentDao();
        boolean result = dao.removeStudent(id);

        if (result) {
            req.setAttribute("message", "Student record successfully deleted.");
            RequestDispatcher rd = req.getRequestDispatcher("message.jsp");
            rd.forward(req, resp);
        }else{
            req.setAttribute("message", "Error deleting student record. Please try again later.");
            RequestDispatcher rd = req.getRequestDispatcher("message.jsp");
            rd.forward(req, resp);
        }
    }
}
