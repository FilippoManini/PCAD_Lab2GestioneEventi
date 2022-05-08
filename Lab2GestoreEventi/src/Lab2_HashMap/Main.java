package Lab2_HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Lab2_HashMap");
        Eventi e = new Eventi();
        Utente u1 = new Utente(e);
        Admin a1 = new Admin(e);

        var th1 = new Thread(a1);
        var th2 = new Thread(u1);

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }

}