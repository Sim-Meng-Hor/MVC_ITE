package OOP.Class.Phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Phone phone = new Phone();
        System.out.println("===========| Insert Phone Info |===============");
        System.out.print("[+] Insert Phone Brand :");
        String brand = sc.next();
        System.out.print("[+] Insert Phone Model :");
        String model = sc.next();
        sc.nextLine();
        System.out.print("[+] Insert Phone Price :");
        double price = sc.nextDouble();
        System.out.print("[+] Insert Phone Storage :");
        int storage = sc.nextInt();
        sc.nextLine();
        System.out.print("[+] Insert Phone Battery :");
        int battery = sc.nextInt();

        System.out.println("===================| Phone Info | ======================");
        System.out.println("Phone Brand : " + brand);
        System.out.println("Phone Model : " + model);
        System.out.println("Phone Price : " + price + "$");
        System.out.println("Phone Storage : " + storage + "GB");
        System.out.println("Phone Battery : " + battery + "%");
    }
}
