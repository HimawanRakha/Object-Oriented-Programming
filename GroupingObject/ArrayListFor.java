import java.util.ArrayList;

public class ArrayListFor {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //membuat arraylist
        ArrayList<String> al=new ArrayList<String>();
        //menambahkan objek ke arraylist
        al.add("Ahmad");
        al.add("Budi");
        al.add("Cecep");
        al.add("Dora");
        //menampilkan isi arrayList
        for(String obj:al){
            System.out.println(obj);
        }
    }
}