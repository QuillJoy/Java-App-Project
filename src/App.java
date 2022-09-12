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
        for(int i = 0; i < storage.length; i++){
            if(storage[i] == null){
                storage[i] = new workout();
                System.out.println("Enter new workout name");
                System.out.print("Input: ");
                scanner.nextLine(); //token ate
                String name = scanner.nextLine();
                storage[i].setName(name);
                System.out.println("The workout name is " + storage[i].getName());
                return;
            }
        }
        return;
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
        while(input != 0){


            scanner.nextLine();
            System.out.print("Press enter to continue: ");
            scanner.nextLine();
            
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
            input = scanner.nextInt();
        }
    }
}
