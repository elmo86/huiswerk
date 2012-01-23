import java.util.*;

class administratie
{
	private HashMap<String, student> studenten;
	
	private int aantal = 0;
	
	/**
	 *
	 **/
	public administratie()
	{
		studenten = new HashMap<String, student>();
	}

	/**
	 * Voeg een student toe aan de lijst met studenten.
	 * @param student Studentnummer
	 * @param naam Studentnaam
	 * @param geslacht Geslacht
	 * @param klas Klas waarin de student zit
	 * @param studierichting Studie welke de student volgt.
	 **/
	public void addStudent(String student, String naam, String geslacht, String klas, String studierichting)
	{
		student st = new student(student, naam, geslacht, klas, studierichting);
		
		studenten.put(student, st);
		aantal++;
		
		System.out.println("Added student " + student + " (Naam: " + naam +")");
	}
	
	/**
	 * Voeg een vak toe aan een bepaalde studierichting
	 * @param studierichting Opleiding waarbij het vak hoort.
	 * @param module Vakcode
	 * @param jaar Jaar waarin het vak gegeven wordt.
	 **/
	public void addVak(String studierichting, String module, int jaar)
	{
		
		System.out.println("Created vak: " + module);
		
		Iterator itr = studenten.entrySet().iterator();
		
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			student st = (student)mp.getValue();
			
			if (st.getStudie().equals(studierichting))
			{
				vak v = new vak(module, jaar);
				
				st.addVak(v);
				
				System.out.println("Added to student: " + st.getStudent()); 
			}
		}
	}

	/**
	 * Voeg een cijfer toe aan een specifieke student met specifieke vakcode.
	 * @param student studentnummer
	 * @param code Vakcode
	 * @param cijfer Cijfer
	 **/
	public void addCijfer(String student, String code, int cijfer)
	{
		System.out.println("Adding result for " + student);
		Iterator itr = studenten.entrySet().iterator();
		
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			student str = (student)mp.getValue();
						
			if (str.getStudent().equals(student))
			{
				itr.remove();
				System.out.println("Adding to " + str.getStudent());
							
				str.setCijfer(code, cijfer);
				studenten.put(student, str);
				str = null;
				return;
			}
			str = null;
		}
		
	}
	
	/**
	 * Print een lijst van studenten welke een bepaald vak gehaald hebben
	 * @param vakcode Te printen vak.
	 **/
	public void printBepaaldVakBehaald(String vakcode)
	{
		int ant = 0;
		
		Iterator itr = studenten.entrySet().iterator();
		
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			student st = (student)mp.getValue();
						
			LinkedList<vak> vk = st.getVakken();
			
			ListIterator it = vk.listIterator();
			
			while (it.hasNext())
			{
				vak v = (vak)it.next();
				
				if (!v.getModule().equals(vakcode))
					continue;
							
				if (v.getCijfer() > 5)
				{
					System.out.println(st.getNaam() + " heeft " + vakcode + " behaald met een " + v.getCijfer());
					ant++;
				}
			}
			it = null;
			st = null;
			mp = null;
		}
		
		if (ant == 0)
		{
			System.out.println("Niemand heeft " + vakcode + " gehaald tot nu toe.");  
		}
	}
	
	/**
	 * Print het gemiddelde voor een specifiek vak die studenten gevolgd hebben.
	 * @param vakcode Vakcode om te volgen
	 **/
	public void printGemiddeldVoorVak(String vakcode)
	{	
		Iterator itr = studenten.entrySet().iterator();
		
		int totaal = 0;
		int aantal = 0;
		int max = 0;
		
		while (itr.hasNext())
		{
			Map.Entry mp = (Map.Entry)itr.next();
			student st = (student)mp.getValue();
						
			LinkedList<vak> vk = st.getVakken();
			
			ListIterator it = vk.listIterator();
			
			while (it.hasNext())
			{
				vak v = (vak)it.next();
				
				if (!v.getModule().equals(vakcode))
					continue;
							
				if (v.getCijfer() != -1)
				{
					aantal++;
					totaal += v.getCijfer();
					
					if (v.getCijfer() > max)
					{
						max = v.getCijfer();
					}
				}
			}
		}
		
		if (aantal == 0)
		{
			System.out.println("Niemand heeft " + vakcode + " gevolgd tot nu toe.");  
		}
		else
		{
			double gem = totaal / aantal;
			
			if (aantal == 1)
				System.out.println(aantal + " studenten heeft het vak gevolgd, met gemiddelde van " + gem + " en een maximum cijfer van " + max);
			else
				System.out.println(aantal + " studenten hebben het vak gevolgd, met gemiddelde van " + gem + " en een maximum cijfer van " + max);
		}
	}
	
	/**
	 * Print de behaalde vakken met het cijfer, of de vakken welke nog gevolgd moeten worden voor een 
	 * specifieke student.
	 * @param student Studentnummer om te printen
	 * @param gehaald Of de gehaalde vakken of nog niet behaalde vakken geprint moeten worden.
	 **/
	public void printGehaaldeVakken(String student, boolean gehaald)
	{
		student st = (student)studenten.get(student);
		
		if (st == null)
			return;
		
		LinkedList<vak> vk = st.getVakken();
		
		ListIterator it = vk.listIterator();
		
		int aantal = 0;
		
		while (it.hasNext())
		{
			vak v = (vak)it.next();
							
			if (gehaald)
			{
				if (v.getCijfer() > 5)
				{
					System.out.println("Student " + student + " heeft " + v.getModule() + " gehaald met cijfer " + v.getCijfer());
					aantal++;
				}
			}
			else
			{
				if (v.getCijfer() <= 5)
				{
					System.out.println("Student " + student + " moet " + v.getModule() + " nog halen ");
					aantal++;
				}				
			}
		}
		
		if (aantal == 0 && gehaald)
		{
			System.out.println("Student " + student + " heeft nog geen vakken gehaald.");
		}
		else if (aantal == 0 && !gehaald)
		{
			System.out.println("Student " + student + " heeft alle vakken al gehaald!");
		}
	}
} 
