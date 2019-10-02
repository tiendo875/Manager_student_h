/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager_student_h;

/**
 *
 * @author tien_do
 */
public class Student {
     private String id;
    private String studentName;
    private String semester;
    private String courseName;
    private int p;

    public Student() {
    }

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
    
    
    
    public void print() {
        System.out.printf("%-22|s%-22s|%-22s\n", studentName, semester, courseName);
    }
}
