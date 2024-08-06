package org.bytetech.dao;

import org.bytetech.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public Student getStudent(int id) {
        Student s = new Student();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "new_password");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from students where id = " + id);
            if (rs.next()) {
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.set_class(rs.getString(3));
                s.setMarks(rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }
    public Student addStudent(Student s) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "new_password");

            PreparedStatement ps = con.prepareStatement("INSERT INTO students (name, class, marks) VALUES (?, ?, ?);");
            ps.setString(1, s.getName());
            ps.setString(2, s.get_class());
            ps.setInt(3, s.getMarks());

            if (ps.executeUpdate() == 1) {
                return s;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "new_password");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from students");

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.set_class(rs.getString("class"));
                s.setMarks(rs.getInt("marks"));
                students.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public boolean removeStudent(int id) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "new_password");

            PreparedStatement ps = con.prepareStatement("Delete From students Where id = ?");
            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return false;
    }

    public boolean updateStudent(Student s) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "new_password");

            PreparedStatement ps = con.prepareStatement("UPDATE students SET name = ?, class = ?, marks = ? WHERE id = ?;");
            ps.setString(1, s.getName());
            ps.setString(2, s.get_class());
            ps.setInt(3, s.getMarks());
            ps.setInt(4, s.getId());

            int result = ps.executeUpdate();

            if (result == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return false;
    }

}
