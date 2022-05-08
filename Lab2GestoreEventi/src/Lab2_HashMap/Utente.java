package Lab2_HashMap;
public class Utente implements Runnable
{
	private Eventi e;
	private int n = 2;

	public Utente(Eventi e) {this.e = e;}

	@Override
	public void run() {
		try {Thread.sleep(1000);}
		catch (InterruptedException e) {e.printStackTrace();}
		for(int i = 0; i<2; ++i)
		{
			System.out.println("Utente["+i+"]: prenota "+n+" posti");
			e.prenota("Evento_"+i,n);
			try {Thread.sleep(2000);}
			catch (InterruptedException e) {e.printStackTrace();}
			System.out.println("Utente["+i+"]: prenota "+(n-1)+" posto");
			e.prenota("Evento_"+i,n-1);
		}
	}
}