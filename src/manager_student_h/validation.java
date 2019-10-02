/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager_student_h;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tien_do
 */
public class validation {

    private final static Scanner in = new Scanner(System.in);

    public static String check_input_string(String MSG) {
        //loop until user input correct
        String input = " ";
        do {
            System.out.println(MSG);
            input = in.nextLine().trim();
            if (!input.matches("[\\w\\s]+")) {
                System.out.println("Not right.Please enter again !!!");
            } else {
                return input;
            }

        } while (true);
    }

    public static int check_input_int(String MSG, int min, int max) {
        int num;
        String input;
        do {
            System.out.println(MSG);
            input = in.nextLine().trim();
            if (input.matches("\\d")) {
                num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.err.println("type mismatch");
                    continue;
                }
            }

        } while (true);
        return num;
    }

    public static double check_input_double(String MSG, double min, double max) {
        double num;
        String input;
        do {
            System.out.println(MSG);
            input = in.nextLine().trim();
            try {
                num = Double.parseDouble(input);
                break;
            } catch (Exception e) {
                System.err.println("type mismatch");
                continue;
            }
        } while (true);

        return num;
    }

    public static boolean check_input_YN(String MSG) {
        do {
            String input = check_input_string(MSG);
            if (input.matches("[yY]")) {
                return true;
            }
            if (input.matches("[nN]")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        } while (true);
    }

    public static boolean check_input_UD() {
        do {
            String input = check_input_string("Please enter U to update, D to delete: ");
            if (input.matches("[uD]")) {
                return true;
            }
            if (input.matches("[Dd]")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        } while (true);
    }

    public static String check_course(String MSG) {

        do {
            System.out.println(MSG);
            String course = in.nextLine().trim();
            if (course.equalsIgnoreCase("java")
                    || course.equalsIgnoreCase(".net")
                    || course.equalsIgnoreCase("C/C++")) {
                return course;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
        } while (true);

    }

    public static int student_exist(ArrayList<Student> arrayList, String id, String studentName, String semester, String courseName) {
        int count = -1;
        
        for (Student st : arrayList) {
            
            count++;
            if (st.getId().equalsIgnoreCase(id)
                    && st.getStudentName().equalsIgnoreCase(studentName)
                    && st.getSemester().equalsIgnoreCase(semester)
                    && st.getCourseName().equalsIgnoreCase(courseName)) {
                return count;
            }
        }
        return -1;
    }

    public static int student_position_by_id(ArrayList<Student> arrayList, String id) {
        int count = -1;
        for (Student st : arrayList) {
            count++;
            if (st.getId().equalsIgnoreCase(id)) {
                return count;
            }
        }
        return -1;
    }

}
