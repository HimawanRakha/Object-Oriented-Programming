import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListRemoveAll {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //membuat arraylist
        ArrayList<String> al=new ArrayList<String>();
        //menambahkan objek ke arraylist
        al.add("Ahmad");
        al.add("Budi");
        al.add("Cecep");
        al.add("Dora");

        ArrayList<String> al2 = new ArrayList<String>();
        al2.add("Endo");
        al2.add("Dora");

        al.removeAll(al2);

        //menampilkan isi arrayList
        Iterator itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}