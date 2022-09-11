import java.util.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static workout[] storage = new workout[5];
    public static void main (String args[]){
        int usrInput = 9999;

        while (usrInput != 4){
            System.out.println("Menu: \n 1. Add new workout \n 2. Add progress \n 3. View workouts \n 4. Close");
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
        for(int i = 0; i < 5; i++){
            if(storage[i] == null){
                storage[i] = new workout();
                System.out.println("What is the name");
                scanner.nextLine(); //token ate
                String name = scanner.nextLine();
                storage[0].setName(name);
                System.out.println("The workout name is " + storage[0].getName());
                return;
            }
        }
        return;
    }

    public static void viewWorkout(){
        for(int i = 0; i < 4; i++){

        }
        System.out.println(storage[0].getName());
    }



}
