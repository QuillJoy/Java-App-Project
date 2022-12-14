import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static workout[] storage = new workout[5];
    public static void main (String args[]){
        int usrInput = 9999;

        while (usrInput != 4){
            System.out.println("Menu: \n 1. Add/Delete workout \n 2. Add/Delete progress \n 3. View workouts \n 4. Close");
            System.out.print("Input: ");
            usrInput = scanner.nextInt();
            switch(usrInput){
                case 1:
                    addDeleteWorkout();
                    break;
                case 2:
                    addDeleteProgress();
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


    public static void addDeleteWorkout(){
        int addDeleteChoice = 999;

        System.out.println("(1) Add or (2) Delete a workout?");
        System.out.print("Input: ");
        addDeleteChoice = scanner.nextInt();

        switch(addDeleteChoice){
            case 1: //Add
                String inputAdd = "zlx";
                System.out.println("Enter name of workout, or enter 0 to return to menu.");
                System.out.print("Input: ");
                inputAdd = scanner.nextLine(); //token ate
                inputAdd = scanner.nextLine();
                while(!inputAdd.equals("0")){
                    for(int i = 0; i < storage.length; i++){
                        if(storage[i] == null){
                            storage[i] = new workout();
                            storage[i].setName(inputAdd);
                            System.out.println("The workout name is " + storage[i].getName());
                            System.out.println("Press enter to continue: ");
                            scanner.nextLine();
                            return;
                        }
                    }
                    System.out.println("Enter name of workout, or enter 0 to return to menu.");
                    inputAdd = scanner.nextLine();
                }
                break;
            case 2: //Delete
                displayWorkout();
                System.out.println("Enter number of workout you want to delete.");
                int input = getInput();
                if(input == 0){
                    return;
                }
                if(storage[input] == null){
                    System.out.println("Oops! This spots already empty.");
                    return;
                }
                else{
                    System.out.println("Deleting " + storage[input].getName());
                    storage[input] = null;
                }
                break;       
        }
    }

    public static void addDeleteProgress(){
        int addDeleteChoice = 999;

        System.out.println("(1) Add or (2) Delete progress?");
        System.out.print("Input: ");
        addDeleteChoice = scanner.nextInt();
        switch(addDeleteChoice){
            case 1:
                displayWorkout();
                System.out.println("Select workout to add progress to, or enter 111 to cancel. ");
                int input = getInput();
                if(input == 111){
                    return;
                }
                System.out.println("Enter date.");
                System.out.print("Input: ");
                scanner.nextLine(); 
                String date = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate dt1 = LocalDate.parse(date, formatter); // string to localdate 
    
                System.out.println("Enter weight.");
                System.out.print("Input: ");
                Integer weight = scanner.nextInt();
                System.out.println("You entered: " + dt1 + " and " + weight);
                scanner.nextLine();
                scanner.nextLine();
                System.out.println("Enter 1 to confirm, or 0 to cancel");
                System.out.print("Input: ");
                int input2 = scanner.nextInt();
                if(input2 == 0){
                    return;
                }
                (storage[input]).setProgress(dt1, weight);
                System.out.println(storage[input].progress);
                break;
            case 2:
                displayWorkout();
                System.out.println("Select workout to delete progress, or enter 111 to cancel. ");
                int inputDel = getInput();
                if(inputDel == 111){
                    return;
                }
                for (LocalDate key : storage[inputDel].getProgress().keySet()){
                    String formattedDate = key.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
                    Integer weight2 = storage[inputDel].getProgressValuefromKey(key);
                    System.out.println(formattedDate + "          " + weight2 + "lbs");
                }
                System.out.println("Enter date of entry you want to delete.");
                System.out.print("Input: ");
                scanner.nextLine(); 
                String date2 = scanner.nextLine();
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate dt2 = LocalDate.parse(date2, formatter2); // string to localdate 
                System.out.println("Confirm deletion of " + date2 + " " + storage[inputDel].getProgressValuefromKey(dt2));
                System.out.println("Enter 1 to confirm, or 0 to cancel");
                System.out.print("Input: ");
                int input3 = scanner.nextInt();
                if(input3 == 0){
                    return;
                }
                storage[inputDel].deleteProgress(dt2);
                System.out.println("Entry deleted");

                break;
        }
        

    }


    public static void viewWorkout(){
        displayWorkout();
        System.out.println("Type number of workout for further info, or enter 0 to go back to menu ");
        System.out.print("Input: ");
        int input = scanner.nextInt();
        if(input == 0){
            return;
        }
        System.out.println("Date                 Weight");
        for (LocalDate key : storage[input-1].getProgress().keySet()){
            String formattedDate = key.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            Integer weight = storage[input-1].getProgressValuefromKey(key);
            System.out.println(formattedDate + "          " + weight + "lbs");
        }
        System.out.println(storage[input-1].getName() + storage[input-1].getProgress());
        System.out.print("Enter to continue: ");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void displayWorkout(){
        System.out.println("-------------------------------");
        for(int i = 0; i < storage.length; i++){
            if(storage[i] == null){
                System.out.println(i+1);
            }
            else{
                System.out.println((i+1) + ". " + storage[i].getName());
            }
        }
    }

    public static int getInput(){
        System.out.print("Input: ");
        int input = scanner.nextInt();
        if(input == 111){
            return 111;
        }
        input -= 1;
        return input;
    }

}
