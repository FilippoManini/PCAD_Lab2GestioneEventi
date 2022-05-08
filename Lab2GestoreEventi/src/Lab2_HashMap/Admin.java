package Lab2_HashMap;

import Lab2_HashMap.Eventi;

public class Admin implements Runnable
{
	private Eventi e;
	private int n = 5;

	public Admin(Eventi e) {this.e = e;	}

	@Override
	public void run() {

		//Prima di tutto creiamo tutti gli eventi
		//per evitare che gli utenti facciano prenotazioni "a vuoto"
		for(int i = 0; i<2; ++i)
		{
			System.out.println("Admin ["+i+"]: crea...");
			e.crea("Evento_"+i, 10);
		}

		e.listaEventi();
		System.out.println("-------------------------------");

		for(int i = 0; i<2; ++i)
		{

			try {Thread.sleep(1500);}
			catch (InterruptedException e) {e.printStackTrace();}

			System.out.println("Admin ["+i+"]: aggiunge "+n+" posti");
			e.aggiungi("Evento_"+i, n);

			try {Thread.sleep(2000);}
			catch (InterruptedException e) {e.printStackTrace();}

			e.listaEventi();

			e.chiudi("Evento_"+i);
			System.out.println("Admin ["+i+"]: chiude...");
			//e.listaEventi();
		}
	}
}