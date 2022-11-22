package util;

import data.Student;
import data.Teacher;
import data.User;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterToTxt {
    public static void write(User user) {
        try (PrintWriter printWriter = new PrintWriter("user.txt")) {
            String className = user.getClass().getSimpleName();
            printWriter.write(className + "\n");
            printWriter.write(user.getName() +"\n");
            printWriter.write(user.getBirthday() +"\n");
            if (className.equals("Student")){
                Student temp = (Student) user;
                printWriter.write(temp.getStudentId()+"\n");
            }
            if (className.equals("Teacher")){
                Teacher temp = (Teacher) user;
                printWriter.write(temp.getDisciplesTaught() +"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
