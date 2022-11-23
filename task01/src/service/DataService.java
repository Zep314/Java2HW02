package service;
import data.User;

import java.util.List;

public interface DataService {
    void create(User user);
    User read(String fileName);
}
