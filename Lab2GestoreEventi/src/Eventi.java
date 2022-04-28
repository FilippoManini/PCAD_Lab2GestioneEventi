import java.util.HashMap;

public class Eventi
{
	private HashMap<String, Integer> eventi = new HashMap<String, Integer>();
	
	//costruttore
	
	
	//aggiungere un nuovo evento e i relativi posti
	//disponibili solo se non esiste gi� un evento con lo stesso nome.
	public synchronized boolean crea(String nome, int posti)
	{
		//se esiste
		if(eventi.get(nome) != null)
			return false;
		
		eventi.put(nome, posti);
		return true;
	}
	
	//per aggiungere nuovi posti ad un determinato evento
	public synchronized boolean aggiungi(String nome, int posti)
	{
		//se non esite 
		if(eventi.get(nome) == null)
			return false;
		
		eventi.replace(nome, eventi.get(nome)+posti);
		return true;
	}

	//per prenotare posti per un dato evento,
	//il metodo deve essere bloccante se non ci sono abbastanza posti
	public synchronized boolean prenota(String nome, int posti)
	{
		if(eventi.isEmpty()) return false;
		
		if(eventi.get(nome) == null) return false;
		
		if(eventi.get(nome)-posti < 0) return false;
		
		eventi.replace(nome, eventi.get(nome)-posti);
		return true;
	}
	
	//cancella l�evento e sblocca tutti i clienti in attesa di post
	public synchronized  boolean chiudi(String nome)
	{
		//se non esite 
		if(eventi.get(nome) == null)
			return false;
		
		eventi.remove(nome);
		this.notifyAll();
		return true;
	}
	
	
	//per visualizzare su console eventi e posti ancora disponibili
	public synchronized void listaEventi()
	{
		for (String i : eventi.keySet()) {
			System.out.println("nome: [" + i + "] posti: [" + eventi.get(i) + "]");
		}
	}
	
	public HashMap<String, Integer> getEventi()
	{
		//ritona il puntatore all'oggetto 
		return this.eventi;
	}
}