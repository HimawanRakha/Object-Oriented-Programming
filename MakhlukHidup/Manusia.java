
public class Manusia extends MakhlukHidup {

    @Override
    public void bernapas() {
        System.out.println("Manusia = Bernapas menggunakan paru-paru.");
    }
    
    @Override
    public void makan() {
        System.out.println("Manusia = Makan nasi, sayur, dan daging.");
    }

    public void bekerja() {
        System.out.println("Manusia sedang bekerja.");
    }
}