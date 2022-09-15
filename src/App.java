import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static workout[] storage = new workout[5];
    public static void main (String args[]){
        int usrInput = 9999;

        while (usrInput != 4){
            System.out.println("Menu: \n 1. Add new workout \n 2. Add progress \n 3. View workouts \n 4. Close");
            System.out.print("Input: ");
            usrInput = scanner.nextInt();
            switch(usrInput){
                case 1:
                    addWorkout();
                    break;
                case 2:
                    addProgress();
                    break;
                case 3: 
                    viewWorkout();
                    break;
                case 4:
                    return;
            }
        }
        System.out.println("Program closing...");
    }


    public static void addWorkout(){
        String input = "zlx";

        System.out.println("Enter name of workout, or enter 0 to return to menu.");
        System.out.print("Input: ");
        input = scanner.nextLine(); //token ate
        input = scanner.nextLine();
        while(!input.equals("0")){
            for(int i = 0; i < storage.length; i++){
                if(storage[i] == null){
                    storage[i] = new workout();
                    storage[i].setName(input);
                    System.out.println("The workout name is " + storage[i].getName());
                    System.out.println("Press enter to continue: ");
                    scanner.nextLine();
                    return;
                }
            }
            System.out.println("Enter name of workout, or enter 0 to return to menu.");
            input = scanner.nextLine();
        }
        return;
    }

    public static void addProgress(){
        System.out.println("-------------------------------");
        for(int i = 0; i < storage.length; i++){
            if(storage[i] == null){
                System.out.println(i+1);
            }
            else{
                System.out.println((i+1) + ". " + storage[i].getName());
            }
        }
        System.out.println("Select workout to add progress to, or enter 0 to cancel. ");
        System.out.print("Input: ");
        int input = scanner.nextInt();
        if(input == 0){
            return;
        }
        input -= 1;
        System.out.println("Enter date.");
        System.out.print("Input: ");
        scanner.nextLine(); 
        String date = scanner.nextLine();
        System.out.println("Enter weight.");
        System.out.print("Input: ");
        Integer weight = scanner.nextInt();
        System.out.println("You entered: " + date + " and " + weight);
        scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter 1 to confirm, or 0 to cancel");
        System.out.print("Input: ");
        int input2 = scanner.nextInt();
        if(input2 == 0){
            return;
        }
        (storage[input]).setProgress(date, weight);
        System.out.println(storage[input].progress);

    }


    public static void viewWorkout(){
        System.out.println("-------------------------------");
        for(int i = 0; i < storage.length; i++){
            if(storage[i] == null){
                System.out.println(i+1);
            }
            else{
                System.out.println((i+1) + ". " + storage[i].getName());
            }
        }
        System.out.println("Type number of workout for further info, or enter 0 to go back to menu ");
        System.out.print("Input: ");
        int input = scanner.nextInt();
        if(input == 0){
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

        for (String key : storage[input-1].getProgress().keySet()){
            String test = key;
            LocalDate date = LocalDate.parse(test, formatter);
            System.out.println(date);
        }
        System.out.println(storage[input-1].getName() + storage[input-1].getProgress());
        System.out.print("Enter to continue: ");
        scanner.nextLine();
        scanner.nextLine();
    }
}
