
public class Utente extends Thread
{
	private Eventi e;
	private static int id = 0;

	public Utente(Eventi e) {
		this.e = e;
		id++;
	}
	
	public void run(String nome, int posti)
	{
		System.out.println("Utente: prenota...");
		e.prenota(nome, posti);
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//e.prenota(nome, posti);
		
		System.out.println("Utente: fine");
		e.listaEventi();
		return;
	}
	
}
