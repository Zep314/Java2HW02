package data;

public class Main {

    public abstract class User {
        private String name;
        private String birthday;

        public String getBirthday() {
            return this.birthday;
        }

    }

    public class Student extends User {
        private String studentId;

    }

    public class Teacher extends User {

    }
}
