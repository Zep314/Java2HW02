package service;

import data.Student;
import data.User;
import util.ReaderFromTxt;
import util.WriterToTxt;

public class StudentServis implements DataService {

    @Override
    public void create(User user) {
        if (user instanceof Student){
            WriterToTxt.write(user);
        }
        else System.out.println("Ошибка!");
    }

    @Override
    public User read(String fileName) {
        return ReaderFromTxt.read(fileName);
    }
}
