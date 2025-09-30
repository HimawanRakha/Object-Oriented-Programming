import java.util.*;

public class ArrauListContoh {
    public static void main (String[] args) {
    ArrayList<String> al = new ArrayList<String> ();
    
    al.add("Ahmad");
    al.add("Budi");
    al.add("Ahmad");
    al.add("Dora");
    
    Iterator itr=al.iterator();
    
    while(itr.hasNext()){
        System.out.println(itr.next());
    }
    
}
}