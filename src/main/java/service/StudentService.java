/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import static jdk.nashorn.internal.codegen.Compiler.LOG;

/**
 *
 * @author Likitha
 */
@Stateless
public class StudentService {

    @Resource(lookup = "jdbc/llokeshMp2DS")
    private DataSource dataSource;

    public StudentService() {
    }
//Student s;

    public Collection<Student> findAll() {
        LOG.info("find all");
        List<Student> students = new ArrayList<>();

        try (Connection c = dataSource.getConnection()) {

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from student_table");

            while (rs.next()) {
                students.add(new Student(rs.getString("studentID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        // rs.getString("email"),
                        rs.getString("address")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (students.isEmpty()) {
            return null;
        } else {
            return students;
        }

    }

    public Student find(String studentID) {
        LOG.info("find");
        Student s = null;

        try (Connection conn = dataSource.getConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from student_table where studentID = ?");
            ps.setString(1, studentID);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                s = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        //LOG.info(country.toString());
        return s;
    }

    public boolean create(Student c) {

        //Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null,);
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into student_table (studentID,firstName,lastName,address) values (?,?,?,?)");
            ps.setString(1, c.getStudentID());
            ps.setString(2, c.getfirstName());
            ps.setString(3, c.getlastName());
            ps.setString(4, c.getAddress());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean update(Student c) {
        LOG.info(c.toString());

        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement("update student_table set studentID = ?, address = ?, firstName = ?, lastName= ? where studentID= ?");
            ps.setString(1, c.getStudentID());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getfirstName());
            ps.setString(4, c.getlastName());
            ps.setString(5, c.getStudentID());

            int temp = ps.executeUpdate();
            LOG.info(temp);
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex.toString());
        }

        return false;
    }

    /**
     *
     * @param studentID
     * @param id
     *
     * @return
     */
    public boolean delete(String studentID) {

        try (Connection conn = dataSource.getConnection()) {
            LOG.info("delete");
            PreparedStatement ps = conn.prepareStatement("delete from student_table where studentID=?");
            ps.setString(1, studentID);
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean save(Student c) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("update student_table set field = ?, field2 = ? where studentID = ?");
            ps.setString(1, c.getStudentID());
            // and so forth
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
