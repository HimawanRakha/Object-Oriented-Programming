import java.util.HashSet;

public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    
    /**
     * Membuat sistem bantuan teknis FRS.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Memulai interaksi dengan pengguna.
     */
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            HashSet<String> words = reader.getInput();
            String fullInput = reader.getLastInputLine();

            if(words.contains("selesai") || fullInput.equals("selesai")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(words, fullInput);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print pesan selamat datang
     */
    private void printWelcome()
    {
        System.out.println("Selamat datang di Bantuan FRS");
        System.out.println();
        System.out.println("Ceritakan masalah Anda kepada kami.");
        System.out.println("Kami akan mencoba membantu menyelesaikan permasalahan Anda.");
        System.out.println("Ketik 'selesai' untuk keluar.");
    }

    /**
     * Print pesan selamat tinggal
     */
    private void printGoodbye()
    {
        System.out.println("Senang mengobrol dengan Anda, sampai jumpa kembali.");
    }
}
