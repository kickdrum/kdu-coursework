package org.handson;

public class StudentRepo {
    static Student[] studentObjects;
    static int n = 0;

    public void addStudent(Student student) {
      try
      {
        Student newarr[] = new Student[n + 1];
        for (int i = 0; i < n; i++) {
            newarr[i] = studentObjects[i];
        }
        newarr[n] = student;
        studentObjects = newarr;
        CustomLogging.getLoggerCustom().debug("Student added!");
        n++;

    }
      catch (Exception e) {
          CustomLogging.getLoggerCustom().error("Unable to add student!");

      }
      }

    public Student getStudent(int id) {
        for (var student : studentObjects) {
            if ((student.getID()) == (id)) {
                CustomLogging.getLoggerCustom().debug("Student info retrieved for provided ID");
                return student;
            }
        }
        CustomLogging.getLoggerCustom().error("Unable to get student info retrieved for provided ID");

        return null;
    }

    public Student getStudent(String name) {
        for (var student : studentObjects) {
            if ((student.getName()).equals((name))) {
                CustomLogging.getLoggerCustom().debug("Student info retrieved for provided name");

                return student;
            }
        }
        CustomLogging.getLoggerCustom().error("Unable to get student info retrieved for provided name");

        return null;
    }

    public void updateStudentAge(int age, Student stud) {
        int flag = 0;
        for (var student : studentObjects) {
           if(student.getID() == stud.getID())
           {
               CustomLogging.getLoggerCustom().debug("Student age updated to "+age);
flag = 1;
               student.setAge(age);
               break;
           }
        }
        if(flag==0)
        {
            CustomLogging.getLoggerCustom().error("Unable to update student age to "+ age);
        }
    }

    public void updateStudentGrade(char grade, Student Student) {
        int flag = 0;

        for (var student : studentObjects) {
            if(student.getGrade() == Student.getGrade())
            {
                CustomLogging.getLoggerCustom().debug("Student age updated to "+grade);

                student.setGrade(grade);break;
            }
        }
        if(flag==0)
        {
            CustomLogging.getLoggerCustom().error("Unable to update student age to "+ grade);
        }
    }
}
