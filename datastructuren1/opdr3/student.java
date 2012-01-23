import java.util.*;
/**
 * @author Paul Sohier
 **/
class student
{
	private String student;
	private String naam;
	private String geslacht;
	private String klas;
	private String studierichting;
	private HashMap<String, vak> behaald;
	private HashMap<String, vak> onbehaald;
	
	/**
	 * 
	 **/
	public student()
	{
		behaald = new HashMap<String, vak>();
		onbehaald = new HashMap<String, vak>();	
	}
	
	/**
	 * Voeg student data toe aan het object.
	 * @param student Studentnummer
	 * @param naam Naam
	 * @param geslacht Geslacht
	 * @param klas Klas
	 * @param studierichting Studierichting van de student
	 **/
	public student (String student, String naam, String geslacht, String klas, String studierichting)
	{
		behaald = new HashMap<String, vak>();
		onbehaald = new HashMap<String, vak>();
		setStudent(student);
		setNaam(naam);
		setGeslacht(geslacht);
		setKlas(klas);
		setStudie(studierichting);
	}
	
	/**
	 * Sla een studentnummer op
	 * @param data Nummer
	 **/
	public void setStudent(String data)
	{
		student = data;
	}
	
	/**
	 * Vraag het studentnumer op
	 * @return Nummer
	 **/
	public String getStudent()
	{
		return student;
	}
	
	/**
	 * Sla een naam op
	 * @param data Naam
	 **/	
	public void setNaam(String data)
	{
		naam = data;
	}
	
	/**
	 * Vraag de naam op
	 * @return Naam
	 **/	
	public String getNaam()
	{
		return naam;
	}
	
	/**
	 * Sla een geslacht op
	 * @param data Geslacht
	 **/	
	public void setGeslacht(String data)
	{
		geslacht = data;
	}
	
	/**
	 * Vraag het geslacht op
	 * @return Geslacht
	 **/		
	public String getGeslacht ()
	{
		return geslacht;
	}
	
	/**
	 * Sla een klas op
	 * @param data klas
	 **/	
	public void setKlas(String data)
	{
		klas = data;
	}
	
	/**
	 * Vraag de klas op
	 * @return Klas
	 **/		
	public String getKlas()
	{
		return klas;
	}
	
	/**
	 * Sla een studierichting op
	 * @param data studierichting
	 **/	
	public void setStudie(String data)
	{
		studierichting = data;
	}
	
	/**
	 * Vraag de Studierichting op
	 * @return Studierichting
	 **/		
	public String getStudie()
	{
		return studierichting;	
	}
	
	/**
	 * Geef alle vakken terug welke zijn opgeslagen voor deze student
	 * @return Lijst met vakken
	 **/
	public LinkedList<vak> getVakken()
	{
		LinkedList<vak> tmp = new LinkedList<vak>();
		
		Iterator itr = behaald.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			vak str = (vak)mp.getValue();
			tmp.add(str);
		}
		
		itr = onbehaald.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			vak str = (vak)mp.getValue();
			tmp.add(str);
		}
		
		return tmp;
	}
	
	/**
	 * Vraag een hashmap op van alle vakken 
	 * @retur Hashmap met de vakken
	 **/
	public HashMap<String, vak> getHashVakken()
	{
		HashMap<String, vak> tmp = new HashMap<String, vak>();

		Iterator itr = behaald.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			vak str = (vak)mp.getValue();
			tmp.put(str.getModule(), str);
		}
		
		itr = onbehaald.entrySet().iterator();
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			vak str = (vak)mp.getValue();
			tmp.put(str.getModule(), str);
		}

		return tmp;
	}
	
	/**
	 * Vraag alle vakken op van een specifiek jaartal.
	 * @param jaar Jaar
	 * @return Lijst met vakken
	 **/
	public LinkedList<vak> getVakken(int jaar)
	{
		if (jaar == 0)
		{
			return getVakken();
		}
		
		
		HashMap<String, vak> data = getHashVakken();
		Iterator itr = data.entrySet().iterator();
		LinkedList<vak> result = new LinkedList<vak>();
		
		int totaal = 0;
		int aantal = 0;
		
		while (itr.hasNext())
		{
			vak v = (vak)itr.next();
			
			if (v.getJaar() == jaar)
			{
				result.add(v);
			}
		}
		return result;
	}	
	
	
	/**
	 * Voeg een lijst toe met vakken voor deze student
	 * @param v Vak om toe te voegen.
	 **/
	public void addVak(vak v)
	{	
		if (v.getCijfer() < 6)
		{
			onbehaald.put(v.getModule(), v);
		}
		else
		{
			behaald.put(v.getModule(), v);
		}
	}
	
	/**
	 * Update een cijfer van een al toegevoegd vak.
	 * @param code Module code om cijfer op te slaan.
	 * @param cijfer Cijfer om toe te voegen.
	 **/
	public void setCijfer(String code, int cijfer)
	{
		Iterator itr = onbehaald.entrySet().iterator();
		
		System.out.println("Adding result for " + getStudent() + " Vak: " + code);
		
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			vak v = (vak)mp.getValue();
			
			if (v.getModule().equals(code))
			{
				itr.remove();
				
				v.setCijfer(cijfer);
				
				if (cijfer >= 6)
				{
					behaald.put(v.getModule(), v);
				}
				else
				{
					onbehaald.put(v.getModule(), v);
				}

				return;
			}
		}
		
		itr = behaald.entrySet().iterator();
		
		while (itr.hasNext())
		{
			vak v = (vak)itr.next();
			
			if (v.getModule().equals(code))
			{
				itr.remove();
				
				v.setCijfer(cijfer);
				
				if (cijfer >= 6)
				{
					behaald.put(v.getModule(), v);
				}
				else
				{
					onbehaald.put(v.getModule(), v);
				}

				return;
			}
		}
	}
		
	/**
	 * Bereken het gemiddelde van alle (gevolgde) vakken
	 * @return Gemiddelde cijfer.
	 **/
	public double gemiddelde()
	{
		LinkedList<vak> data = getVakken();
		ListIterator itr = data.listIterator();
		
		int totaal = 0;
		int aantal = 0;
		
		while (itr.hasNext())
		{
			vak v = (vak)itr.next();
			if (v.getCijfer() != -1)
			{
				aantal++;
				totaal += v.getCijfer();
			}
		}
		
		double result = totaal / aantal;
		return result;
	}
}
