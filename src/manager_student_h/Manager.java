/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager_student_h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author tien_do
 */
public class Manager {

    public void menu() {
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    public void create(ArrayList<Student> arrayList) {
        // check so hoc sinh > 10 thi hoi xem co tiep tuc hay ko
        if (arrayList.size() > 10) {
            if (!validation.check_input_YN("Do you want to continue (Y/N): ")) {
                return;
            }
        }
        while (true) {
            // nhap ID
            String id = validation.check_input_string("Enter ID: ");
            String studentName;
            
            // check id xem có trùng hay ko, trùng thì lấy ra vị trí của ID trùng và lấy tên thông qua vị trí đó 
            int pos = validation.student_position_by_id(arrayList, id);
            if (pos != -1) {
                System.out.println("ID is exist with name:  "+ arrayList.get(pos).getStudentName());
                studentName = arrayList.get(pos).getStudentName();
            } else {
                studentName = validation.check_input_string("Enter name: ");
            }

            String semester = validation.check_input_string("Enter semester: ");
            String courseName = validation.check_course("Enter course name: ");
            
            // check xem data vừa nhập có bị trùng hay ko
            if (validation.student_exist(arrayList, id, studentName, semester, courseName) != -1) {
                System.out.println("Duplicate.");
                continue;
            }
            Student A = new Student(id, studentName, semester, courseName);
            arrayList.add(A);
            System.out.println("add sucessful");
            return;
        }
    }

    public void Find_Sort(ArrayList<Student> arrayList) {
        
        // check arraylist truyền vào có rỗng hay ko
        if (arrayList.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        
        // khởi tạo list tìm theo tên
        ArrayList<Student> list_order_name = list_order_name(arrayList);
        if (list_order_name.isEmpty()) {
            System.out.println("Not exist.");
        } else {
            Collections.sort(list_order_name, (Student o1, Student o2) -> o1.getStudentName().compareToIgnoreCase(o2.getStudentName()));
            System.out.printf("%-22s|%-22s|%-22s\n", "Student name", "semester", "Course Name");
            // loop from first to last element of list student
            for (Student student : list_order_name) {
                student.print();
            }
        }
    }

    
    // function để tạo list tìm theo tên
    public ArrayList<Student> list_order_name(ArrayList<Student> arr) {

        ArrayList<Student> list_name = new ArrayList<>();
        String name = validation.check_input_string("Enter name to find: ");

        for (Student st : arr) {
            if (st.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                list_name.add(st);
            }
        }
        return list_name;
    }

    public void Update_Delete(ArrayList<Student> arr) {
        
        // nhập ID để update
        String id = validation.check_input_string("enter Id to update:");
        
        // khởi tạo list theo ID
        ArrayList<Student> list_find_ID = list_find_by_ID(arr, id);
        if (list_find_ID.isEmpty()) {
            System.out.println("ID is not exist!!");
            return;
        }
        
        // khởi tạo object được user chọn
        Student st = Get_student_by_ID(list_find_ID);
        do {
            Boolean choice = validation.check_input_UD();
            if (choice) {
                
                // nếu muốn đổi tên thì phải thay đổi toàn bộ vì 1 ID chỉ có duy nhất 1 tên
                if (validation.check_input_YN("Do you want to change name: ")) {
                    String change_name = validation.check_input_string("Enter name: ");
                    for (Student stu : list_find_ID) {
                        arr.get(stu.getP()).setStudentName(change_name);
                    }
                } else;
                String semeter = validation.check_input_string("Enter Semeter: ");
                String course_name = validation.check_course("Enter course name: ");

                // check lại xem dữ liệu vừa nhập có bị trùng với dữ liệu có trước ko
                if (validation.student_exist(arr, id, st.getStudentName(), semeter, course_name) == -1) {
                    
                    // ở đây mới set lại dữ liệu bởi vì nếu set ngay sau khi nhập thì sẽ update dữ liệu trước khi check
                    arr.get(st.getP()).setSemester(semeter);
                    arr.get(st.getP()).setCourseName(course_name);
                    System.out.println("Update successful.");
                    break;
                } else {
                    System.out.println("Duplicate.");
                }
            } else {
                arr.remove(st.getP());
                System.out.println("Delete successful.");
                break;
            }

        } while (true);

    }

    
    // function để return list theo ID
    public ArrayList<Student> list_find_by_ID(ArrayList<Student> arr, String id) {
        ArrayList<Student> list_find_by_ID = new ArrayList<Student>();
        int count = -1;
        for (Student st : arr) {
            count++;
            if (st.getId().equalsIgnoreCase(id)) {
                st.setP(count);
                list_find_by_ID.add(st);
            }
        }
        return list_find_by_ID;
    }

    // function để in list theo ID và return object được user chọn
    public Student Get_student_by_ID(ArrayList<Student> list_find_by_ID) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-22s%-22s%-22s%-22s\n", "Number", "Student name",
                "semester", "Course Name");
        
        // display list student found
        for (Student student : list_find_by_ID) {
            System.out.printf("%-22d%-22s%-22s%-22s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        int choice = validation.check_input_int("Enter number of student: ", 1, list_find_by_ID.size());
        return list_find_by_ID.get(choice - 1);
    }

    public void report(ArrayList<Student> arr) {
        
        // sort lại để cho đẹp arraylist thôi 
        Collections.sort(arr, (Student o1, Student o2) -> o1.getStudentName().compareToIgnoreCase(o2.getStudentName()) //To change body of generated lambdas, choose Tools | Templates.
        );
        
        // khởi tạo 1 arraylist khác copy từ arraylist truyền vào
        ArrayList<Student> arrfake = new ArrayList<>(arr);
        System.out.printf("%-22s|%-22s|%-22s\n","Name","Course Name","total course");
        int total = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arrfake.size(); j++) {
                
                // nếu trùng ID và trùng tên khóa học thì cho total++ và xóa bớt phần tử đang xét của arraylist arrfake
                if (arrfake.get(j).getId().equalsIgnoreCase(arr.get(i).getId())
                        && arrfake.get(j).getCourseName().equalsIgnoreCase(arr.get(i).getCourseName())) {
                    total++;
                    arrfake.remove(arrfake.get(j));
                    // phải j-- để tránh bỏ qua phần tử khi xóa
                    j--;
                }
            }
            
            // nếu mà total = 0 tức là phần tử đã đc cộng rồi nên ko cần in ra nữa
            if (total != 0) {
                System.out.printf("%-22s|%-22s|%-22d\n", arr.get(i).getStudentName(), arr.get(i).getCourseName(), total);
            }
            
            total = 0;
        }
        return;
    }
}
