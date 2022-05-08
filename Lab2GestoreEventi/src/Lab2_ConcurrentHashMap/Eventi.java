package Lab2_ConcurrentHashMap;

import java.util.concurrent.*;

import static javax.swing.UIManager.get;

public class Eventi
{
	private ConcurrentHashMap<String, Integer> eventi;
	public Eventi() { eventi = new ConcurrentHashMap<>();	}

	//Crea un nuovo evento e i relativi posti solo se non esiste già
	public void crea(String nome, Integer posti)
	{
		eventi.putIfAbsent(nome,posti);
	}

	//per aggiungere nuovi posti ad un determinato evento
	public void aggiungi(String nome, int posti)
	{
		//se non esite
		synchronized (this) {
			if (eventi.get(nome) == null)
				return;
		}
		eventi.replace(nome, eventi.get(nome) +posti);
	}

	//per prenotare posti per un dato evento,
	//il metodo deve essere bloccante se non ci sono abbastanza posti
	public void prenota(String nome, int posti)
	{
		synchronized(this) {
			if (eventi.isEmpty()) return;

			if (eventi.get(nome) == null) return;

			if (eventi.get(nome) - posti < 0) return;
		}
		eventi.replace(nome, eventi.get(nome)-posti);
	}

	//cancella l'evento e sblocca tutti i clienti in attesa di post
	public void chiudi(String nome)
	{
		synchronized(this) {
			//se non esite
			if (eventi.get(nome) == null)
				return;
		}
		eventi.remove(nome);
		synchronized(this) { this.notifyAll();}
	}

	//per visualizzare su console eventi e posti ancora disponibili
	public synchronized void listaEventi()
	{
		for (String i : eventi.keySet()) {
			System.out.println("nome: [" + i + "] posti: [" + eventi.get(i) + "]");
		}
	}
}