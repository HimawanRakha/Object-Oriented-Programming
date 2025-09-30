import java.util.*;

class HashSetContoh {
    public static void main(String args[]) {
        HashSet<String> al=new HashSet<String>();
        al.add("Anto");
        al.add("Budi");
        al.add("Cecep");
        al.add("Dani");
        al.add("Eka");

        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}