package OOP.Class.Student;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner  = new Scanner(System.in);
        Student [] students = new Student[3];
        Student student1 = new Student(
                1,
                "Meng",
                "Male",
                "Meng@mgmail.com",
                Date.from(Instant.now())
        );
        Student student2 = new Student(
                2,
                "Hor",
                "Male",
                "Hor@gmail.com",
                Date.from(Instant.now())
        );
        Student student3 = new Student(
                3,
                "Mey",
                "Female",
                "Mey@gmail.com",
                Date.from(Instant.now())
        );
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        System.out.println("========== | Find Student | ===========");
        System.out.print("[+] Enter Student ID : ");
        Integer id = new Scanner(System.in).nextInt();
        Thread.sleep(500);
        for (Student s : students){
           if (s.id == id){
               s.getStudentInfo();
           }
        }
    }
}
