import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class DZ05_task1 {
    public static void main(String[] args) {
        Map <String, ArrayList<String>> phoneBook = new HashMap<>();
        System.out.println("Добро пожаловатьв телефонную книгу");
        String choice = "";
        Scanner sc = new Scanner(System.in);

        while(!choice.equals("3")) {
            System.out.println("----------------------");
            System.out.println("Выберете:\n1. Добавить номер\n2. Вывести все\n3. Стоп");
            System.out.println("----------------------");

            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addPhone(phoneBook);
                    break;
                case "2":
                for (var kv: phoneBook.entrySet()) 
                        System.out.println(kv.getKey() + " " + (kv.getValue()));
               
                    break;
                case "3":
                    System.out.println("До свидания!");

            }
        }
        sc.close();
    }
    static void addPhone(Map <String, ArrayList<String>> phoneBook) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите фамилию:");
        String secondName = sc.nextLine();

        System.out.println("Введите номер:");
        String phoneNumber = sc.nextLine();
        ArrayList<String> s = new ArrayList<>();

        if (!phoneBook.containsKey(secondName)) {
                s.add(phoneNumber);
                phoneBook.put(secondName, s);
        }  
        else {
                s.addAll(phoneBook.get(secondName));
                s.add(phoneNumber);
                phoneBook.put(secondName, s);
        }
        sc.close();
    } 

}
