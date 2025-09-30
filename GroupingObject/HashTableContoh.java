import java.util.*;

class HashTableContoh {
    public static void main(String args[]) {
        Hashtable<Integer,String> hm=new Hashtable<Integer,String>();
        hm.put(100, "Andri");
        hm.put(102, "Roni");
        hm.put(101, "Fahrul");
        hm.put(103, "Badu");

        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}