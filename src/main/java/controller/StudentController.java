/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Student;
import service.StudentService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author Likitha
 */
@WebServlet(name = "StudentController",
        urlPatterns = {
            "/student",
            "/student/",
            "/student/new",
            "/student/delete",
            "/student/edit"})
public class StudentController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(StudentController.class.getName());

    @EJB
    private StudentService ssv;
    Student s = new Student();

    @Resource
    Validator validator;

    private boolean isEmpty(String param) {
        if ((param == null) || (param.trim().equals(""))) {
            return true;
        } else {
            return false;
        }
    }

    private String purge(String param) {
        if (isEmpty(param)) {
            return null;
        } else {
            return param.trim();
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HashMap<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        switch (request.getServletPath()) {
            case "/student":
                if (isEmpty(request.getParameter("studentID"))) {
                    LOG.warning("ID value is null, new student is created");
//                    messages.put("countryCode", "Please enter a countryCode");
//                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad Reqest!  Bad User!");
                    request.setAttribute("action", "new");
                    request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                    break;
                }
                request.setAttribute("action", "edit");
                request.setAttribute("stud", ssv.find(request.getParameter("studentID")));
                request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                break;
            case "/student/":
                request.setAttribute("stud", ssv.findAll());
                request.getRequestDispatcher("/WEB-INF/student/show.jsp").forward(request, response);
                break;

            case "/student/delete":
                request.setAttribute("stud", ssv.delete(request.getParameter("studentID")));
                LOG.info("stud id you indise the");
                request.getRequestDispatcher("/WEB-INF/student/delete.jsp").forward(request, response);
                break;
            case "/student/new":
                LOG.info("new  student");
                request.setAttribute("action", "new");
                request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                break;
            case "/student/edit":
                request.setAttribute("stud", ssv.find(request.getParameter("studentID")));

                request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                LOG.info("Process edit here!");
                /*
                 s.setStudentID(purge(request.getParameter("studentID"))); 
                 s.setAddress(purge(request.getParameter("address")));
                 //  s.setEmail(purge(request.getParameter("email")));
                 s.setfirstName(purge(request.getParameter("firstName")));
                 s.setlastName(purge(request.getParameter("lastName")));;

                
                 Set<ConstraintViolation<Student>> violations   = validator.validate(s);
                 LOG.log(Level.INFO, "Violations: {0}", violations.size());
                
                
                 if (violations.isEmpty()) { //What are you trying to do here?
                 LOG.info("oye");
                 if (ssv.update(s)) {
                 request.getRequestDispatcher("/WEB-INF/student/show.jsp").forward(request, response);
                 }
                 } else {
                 request.setAttribute("violations", violations);
                 request.setAttribute("stud", s);
                 request.setAttribute("action", "new");
                 LOG.info("edit");
                 request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                 LOG.info("hello");
                 }
                 */
                break;
            default:
                break;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HashMap<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        switch (request.getServletPath()) {

            case "/student/new":

                s.setStudentID(purge(request.getParameter("studentID")));
                s.setAddress(purge(request.getParameter("address")));
                // s.setEmail(purge(request.getParameter("email")));
                s.setfirstName(purge(request.getParameter("firstName")));
                s.setlastName(purge(request.getParameter("lastName")));

                LOG.info(s.getfirstName());
                Set<ConstraintViolation<Student>> violations
                        = validator.validate(s);
                LOG.log(Level.INFO, "Violations: {0}", violations.size());

                if (violations.isEmpty()) {

                    if (ssv.create(s)) {
                        request.setAttribute("stud", ssv.findAll());
                        request.getRequestDispatcher("/WEB-INF/student/show.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("violations", violations);
                    request.setAttribute("stud", s);
                    request.setAttribute("action", "new");
                    request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                }

                break;
            case "/student/delete":
                LOG.info("delete");
                request.setAttribute("stud", ssv.delete(request.getParameter("studentID")));
                LOG.info("studd");
                request.getRequestDispatcher("/WEB-INF/student/show.jsp").forward(request, response);
                break;
            case "/student/edit":
                LOG.info("Process student edit here!");

                s.setStudentID(purge(request.getParameter("studentID")));
                s.setAddress(purge(request.getParameter("address")));
                // s.setEmail(purge(request.getParameter("email")));
                s.setfirstName(purge(request.getParameter("firstName")));
                s.setlastName(purge(request.getParameter("lastName")));

                violations = validator.validate(s);
                LOG.log(Level.INFO, "Violations: {0}", violations.size());

                if (violations.isEmpty()) {
                    LOG.info("update");
                    boolean testBool = ssv.update(s);
                    if (testBool) {
                        LOG.info("update1");
                        request.setAttribute("stud", ssv.findAll());
                        request.getRequestDispatcher("/WEB-INF/student/show.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("violations", violations);
                    request.setAttribute("stud", s);
                    request.setAttribute("action", "new");
                    request.getRequestDispatcher("/WEB-INF/student/form.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
