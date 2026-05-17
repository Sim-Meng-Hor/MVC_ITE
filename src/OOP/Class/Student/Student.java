package OOP.Class.Student;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    Integer id;
    String name;
    String gender;
    String email;
    Date birthDate;
    Student(){}

    Student(Integer id, String name,
            String gender, String email,
            Date birthDate){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthDate = birthDate;
    }

    void getStudentInfo(){
        System.out.println("============ | Student Info | ===========");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name );
        System.out.println("Gender : " + gender);
        System.out.println("Email : " + email);
        System.out.println("Birth Date : " + birthDate);
    }
}
