package util;

import data.Student;
import data.StudentsGroup;
import data.Teacher;
import data.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderFromTxt {
    public static User readUser(String fileName){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                arrayList.add(line);
            }
            if(arrayList.get(0).contains("Teacher")){
               User user = new Teacher(arrayList.get(3),arrayList.get(1),arrayList.get(2));
                return user;
            }
            if (arrayList.get(0).contains("Student")){
                User user = new Student(arrayList.get(3),arrayList.get(1),arrayList.get(2));
                return user;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static StudentsGroup readGroup(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                arrayList.add(line);
            }
            StudentsGroup group = new StudentsGroup();
            for(int i = 0; i < arrayList.size(); i++) {
                String kind = "";
                String name = "";
                String birthday = "";
                String property = "";
                switch (i % 4) {
                    case 0 -> kind = arrayList.get(i);
                    case 1 -> name = arrayList.get(i);
                    case 2 -> birthday = arrayList.get(i);
                    case 3 -> property = arrayList.get(i);
                }
                if ((i % 4) == 0 && i>0) {
                    if (kind.equals("Teacher")) {
                        group.SetTeacher(new Teacher(property, name, birthday));
                    }
                    else {
                        group.AddStudent(new Student(property, name, birthday));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
