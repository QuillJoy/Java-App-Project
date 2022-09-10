import java.util.*;

public class App {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu: \n 1. Add new workout \n 2. Add progress \n 3. View workouts \n 4. Close");

        int usrInput = scanner.nextInt();


        while (usrInput != 4){
            switch(usrInput){
                case 1:
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
        w1.setName(name);
    }


}
