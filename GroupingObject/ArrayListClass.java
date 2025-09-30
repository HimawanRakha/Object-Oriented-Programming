import java.util.*;

public class ArrayListClass {
    public static void main(String[] args) {
        //Data
        Mahasiswa mhs1 = new Mahasiswa("K121","Adam Kamil",67,69,91);
        Mahasiswa mhs2 = new Mahasiswa("K122","Budi Ridho",57,89,93);
        Mahasiswa mhs3 = new Mahasiswa("K123","Cecep Mansyur",77,79,80);
        Mahasiswa mhs4 = new Mahasiswa("K124","Dadang Habibie",67,79,60);
        Mahasiswa mhs5 = new Mahasiswa("K125","Evi Julita",89,79,95);

        //membuat arraylist
        ArrayList<Mahasiswa> al=new ArrayList<Mahasiswa>();
        //menambahkan objek ke arraylist
        al.add(mhs1);
        al.add(mhs2);
        al.add(mhs3);
        al.add(mhs4);
        al.add(mhs5);

        //menampilkan isi arrayList
        Iterator itr=al.iterator();
        while(itr.hasNext()){
            Mahasiswa tampungMhs = (Mahasiswa)itr.next();
            System.out.print(tampungMhs.getNim()+" ");
            System.out.print(tampungMhs.getNama()+" ");
            System.out.print(tampungMhs.getTugas()+" ");
            System.out.print(tampungMhs.getUts()+" ");
            System.out.println(tampungMhs.getUas()+" ");
        }
    }
}