
public class Utente implements Runnable
{
	private Eventi e;

	public Utente(Eventi e) {this.e = e;}
	
	@Override
	public void run() {
		for(int i = 0; i<2; ++i)
		{
			System.out.println("Utente["+i+"]: prenota Evento_"+i);
			e.prenota("Evento_"+i,2);
			try {Thread.sleep(1000);}
			catch (InterruptedException e) {e.printStackTrace();}
			e.prenota("Evento_"+i,1);
		}
	}
}