package kdu.backend;

import java.util.ArrayList;

public class StudentRepository {

    private ArrayList<Student> students = new ArrayList<>();

    public void add(Student st) {
        students.add(st);
        Logging.add(st);
    }

    public Student retrieve(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                Logging.retrieve(id, s);
                return s;
            }
        }
        Logging.retrieve(id, null);
        return null;
    }


    public Student updateStudentName(int id, String Name) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(Name);
                Logging.updateName(id, Name, s);
                return s;
            }
        }
        Logging.updateName(id, Name, null);
        return null;
    }

    public Student updateStudentAge(int id, int Age) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setAge(Age);
                Logging.updateAge(id, Age, s);
                return s;
            }
        }
        Logging.updateAge(id, Age, null);
        return null;
    }
}
