/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Likitha
 */
public class Student {
//@NotNull

    private String studentID;
    @Size(max = 40)
    @NotNull
    private String firstName;
    @Size(max = 40)
    @NotNull
    private String lastName;

    @Size(max = 70)
    private String address;

    public Student() {
    }

    public Student(String studentID, String firstName, String lastName, String address) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        //

        this.address = address;
    }

    /**
     * Get the value of Courses
     *
     * @return the value of Courses
     */
    /**
     * Get the value of Last_name
     *
     * @return the value of Last_name
     */
    public String getlastName() {
        return lastName;
    }

    /**
     * Set the value of Last_name
     *
     * @param lastName
     */
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of First_name
     *
     * @return the value of First_name
     */
    public String getfirstName() {
        return firstName;
    }

    /**
     * Set the value of First_name
     *
     * @param firstName
     */
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the value of studentID
     *
     * @return the value of studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Set the value of studentID
     *
     * @param studentID new value of studentID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ",address=" + address + '}';
    }

}
