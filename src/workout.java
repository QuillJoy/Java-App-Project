import java.util.*;
public class workout {
    String name;
    LinkedHashMap<String, Integer> progress = new LinkedHashMap<String, Integer>();


    workout(){
        name = this.name;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setProgress (String string, Integer integer){
        progress.put(string,integer);
    }

    public HashMap<String,Integer> getProgress(){
        return progress;
    }
    
    
}
