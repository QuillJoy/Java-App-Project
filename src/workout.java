import java.util.*;
import java.time.*;
public class workout {
    String name;
    TreeMap<LocalDate, Integer> progress = new TreeMap<LocalDate, Integer>();


    workout(){
 

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setProgress (LocalDate date, Integer integer){
        progress.put(date,integer);
    }

    public TreeMap<LocalDate,Integer> getProgress(){
        return progress;
    }

    public Integer getProgressValuefromKey(LocalDate key){
        return progress.get(key);
    }

    public void deleteProgress(LocalDate key){
        progress.remove(key);
    }
    
    
}
