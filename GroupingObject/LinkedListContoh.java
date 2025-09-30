import java.util.*;

public class LinkedListContoh {
    public static void main(String args[]) {
        LinkedList<String> al=new LinkedList<String>();
        al.add("Zaza");
        al.add("Yadi");
        al.add("Mutiare");
        al.add("Santoso");

        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}