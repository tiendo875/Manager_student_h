/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager_student_h;

import java.util.ArrayList;

/**
 *
 * @author tien_do
 */
public class Manager_student_h {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student St = new Student();
        Manager Mg = new Manager();
        ArrayList<Student> arr = new ArrayList();
        arr.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        arr.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        arr.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));
        arr.add(new Student("3", "Nguyen Xuan Cuong", "Spring", ".net"));
        arr.add(new Student("3", "Nguyen Xuan Cuong", "winter", "c/c++"));
        arr.add(new Student("2", "Do Quang Hiep", "Summer", "c/c++"));
        arr.add(new Student("4", "Le Tuan Anh", "Summer", ".net"));
        arr.add(new Student("4", "Le Tuan Anh", "winter", ".net"));
        arr.add(new Student("1", "Pham Ngoc Hoa", "Summer", "java"));
        int choice;
        do {
            Mg.menu();
            choice = validation.check_input_int("Please choose from 1 to 5. ", 1, 5);
            switch (choice) {
                case 1:
                    Mg.create(arr);
                    break;
                case 2:
                    Mg.Find_Sort(arr);
                    break;
                case 3:
                    Mg.Update_Delete(arr);
                    break;
                case 4:
                    Mg.report(arr);
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

}
