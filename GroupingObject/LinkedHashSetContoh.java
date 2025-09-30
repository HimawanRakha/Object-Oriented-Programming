import java.util.LinkedHashSet;
import java.util.Iterator;

class LinkedHashSetContoh {
    public static void main(String args[]) {
        LinkedHashSet<String> al=new LinkedHashSet<String>();
        al.add("Anto");
        al.add("Budi");
        al.add("Cecep");
        al.add("Dudi");
        al.add("Eka");

        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}