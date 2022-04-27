
public class Admin extends Thread
{
	private Eventi e;
	private static int id = 0;

	public Admin(Eventi e) {
		this.e = e;
		id++;
	}
	
	public void run(String nome, int posti)
	{
		System.out.println("Admin: creazione...");
		e.crea(nome, posti);
		e.listaEventi();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Admin: aggiungi...");
		e.aggiungi(nome, posti);
		e.listaEventi();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		e.chiudi(nome);
		System.out.println("Admin: chiudi...");
		e.listaEventi();
	}
}
