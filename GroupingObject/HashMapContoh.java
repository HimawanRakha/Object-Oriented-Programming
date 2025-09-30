import java.util.*;

class HashMapContoh {
    public static void main(String args[]) {
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(100, "Kano");
        hm.put(101, "Laila");
        hm.put(102, "Badu");
        hm.put(null, "Johan");

        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}