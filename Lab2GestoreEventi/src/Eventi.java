import java.util.HashMap;

public class Eventi extends Thread
{
	
	//costruttore
	
	//aggiungere un nuovo evento e i relativi posti
	//disponibili solo se non esiste già un evento con lo stesso nome.
	public synchronized boolean crea(String nome, int posti, HashMap<String, Integer> eventi)
	{
		//se esiste
		if(eventi.get(nome) != null)
			return false;
		
		eventi.put(nome, posti);
		return true;
	}
	
	//per aggiungere nuovi posti ad un determinato evento
	public synchronized boolean aggiungi(String nome, int posti, HashMap<String, Integer> eventi)
	{
		//se non esite 
		if(eventi.get(nome) == null)
			return false;
		
		//eventi.put(nome, posti);
		eventi.replace(nome, eventi.get(nome)+posti);
		return true;
	}

	//per prenotare posti per un dato evento,
	//il metodo deve essere bloccante se non ci sono abbastanza posti
	public synchronized boolean prenota(String nome, int posti, HashMap<String, Integer> eventi)
	{
		if(eventi.get(nome)-posti < 0)
			return false;
		
		eventi.replace(nome, eventi.get(nome)-posti);
		return true;
	}
	
	//cancella l’evento e sblocca tutti i clienti in attesa di post
	public synchronized boolean chiudi(String nome, HashMap<String, Integer> eventi)
	{
		//se non esite 
		if(eventi.get(nome) == null)
			return false;
		
		eventi.remove(nome);
		return true;
	}
	
	
	//per visualizzare su console eventi e posti ancora disponibili
	public synchronized void listaEventi(HashMap<String, Integer> eventi)
	{
		for (String i : eventi.keySet()) {
			System.out.println("nome: [" + i + "] posti: [" + eventi.get(i) + "]");
		}
	}
}
