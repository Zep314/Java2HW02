package service;
import data.StudentsGroup;
import data.User;

import java.util.List;

public interface DataGroupService {
    void create(StudentsGroup studentsGroup);
    StudentsGroup read(String fileName);
}
