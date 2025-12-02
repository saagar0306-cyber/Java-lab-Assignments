package lab2.service;

import lab2.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentManager implements RecordActions {

    private Map<Integer, Student> map = new HashMap<>();

    @Override
    public void addStudent(Student s){
        if (map.containsKey(s.getRollNo())) {
            System.out.println("Duplicate roll number not allowed: " + s.getRollNo());
        } else {
            map.put(s.getRollNo(), s);
        }
    }

    @Override
    public void deleteStudent(int rollNo){
        if (map.remove(rollNo) == null) {
            System.out.println("Student not found with rollNo: " + rollNo);
        } else {
            System.out.println("Student deleted with rollNo: " + rollNo);
        }
    }

    @Override
    public void updateStudent(int rollNo, Student updated){
        if (!map.containsKey(rollNo)) {
            System.out.println("Student not found with rollNo: " + rollNo);
        } else {
            map.put(rollNo, updated);
            System.out.println("Student updated with rollNo: " + rollNo);
        }
    }

    @Override
    public Student searchStudent(int rollNo){
        return map.get(rollNo);
    }

    @Override
    public void viewAllStudents(){
        if (map.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : map.values()) {
                s.displayInfo();
            }
        }
    }
}
