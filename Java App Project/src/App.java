import java.util.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String args[]){

        System.out.println("Menu: \n 1. Add new workout \n 2. Add progress \n 3. View workouts \n 4. Close");

        int usrInput = scanner.nextInt();


        while (usrInput != 4){
            switch(usrInput){
                case 1:
                    addWorkout();
                    break;
                case 2:
                    break;
                case 3: 
                    break;
                case 4:
                    return;
            }
            usrInput = scanner.nextInt();
        }
        System.out.println("Program closing...");
    }


    public static void addWorkout(){
        workout w1 = new workout();
        System.out.println("What is the name");
        scanner.nextLine(); //token ate
        String name = scanner.nextLine();
        w1.setName(name);

        System.out.println("The workout name is " + w1.getName());
        return;
    }



}
