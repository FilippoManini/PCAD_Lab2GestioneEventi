
public class Admin implements Runnable
{
	private Eventi e;

	public Admin(Eventi e) {this.e = e;	}

	@Override
	public void run() {
		
		for(int i = 0; i<3; ++i)
		{
			System.out.println("Admin ["+i+"]: crea...");
			e.crea("Evento_"+i, 10);
			
			e.listaEventi();
			try {Thread.sleep(1000);}
			catch (InterruptedException e) {e.printStackTrace();}
			
			System.out.println("Admin ["+i+"]: aggiunge...");
			e.aggiungi("Evento_"+i, 5);
			
			e.listaEventi();
			try {Thread.sleep(1000);}
			catch (InterruptedException e) {e.printStackTrace();}
			
			e.chiudi("Evento_"+i);
			System.out.println("Admin ["+i+"]: chiude...");
			e.listaEventi();
		}
	}
}
