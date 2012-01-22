/**
 * Niet geimplementeerd zoals in de opdracht:
 * public void push(student s, int index), retourneert student
 * s in de list op positie index en verwijdert deze uit de list
 * Reden: Methode naam is zelfde als om student toe te voegen + parameter is niet logische
 * Vervanging: delete(int index); verwijderd een element op locatie index en geeft hem terug.
 **/

public class list
{
    private studentElement start;
    private int size;

    /**
     *
     **/
    public list()
    {

    }
    
    /**
     * Voeg een student toe het einde van de list
     * @param s Student
     **/
    public void push(student s)
    {
    	push(s, getSize());
    }

    /**
     * Voeg een student toe aan de list
     * @param s Student
     * @param index Locatie om toe te voegen
     **/
    public void push(student s, int index)
    {
	studentElement last = new studentElement(s);
	studentElement prev;
	
	if (getSize() == 0)
	{
		// Er staat nog niks in de list.
		// We voegen hem toe als start.
		start = last;
		size++;
		return;
	}

	if (index >= getSize())
	{
	    /**
	     * We kunnen hem aan het eind toevoegen.
	     * We hoeven niet te controleren of 
	     * size gelijk is aan 0, aangezien we dat
	     * hierboven al hebben afgevangen.
	     */ 
	    prev = getLast();
	    
	    try
	    {
	    	prev.setVolgend(last);
	    }
	    catch (studentStackExistsException e)
	    {
	    	System.out.println(e);
	    }
	    size++;
	    return;
	}
	
	prev = start;
	
	for (int i = 0; i < index - 1; i++)
	{
		prev = prev.getVolgend();
	}
	
	try
	{
		last.setVolgend(prev.getVolgend());
		prev.setVolgend(null);
		prev.setVolgend(last);
	}
	catch(studentStackExistsException e)
	{
		System.out.println(e);
		return;
	}
	size++;
    }

    /**
     * Geef de grote terug van de stack
     * @return int grote
     **/
    public int getSize()
    {
	return size;
    }

    /**
     * Geeft de eerste student terug
     * @return student Eerste student
     **/
    public student head()
    {
    	studentElement returned = start;
    	
    	if (start.volgend())
    	{
    		start = start.getVolgend();
    	}
    	else
    	{
    		start = null;
    	}
    	size--;
		return returned.getStudent();
    }
    
    /**
     * Geeft de laatste student terug
     * @return student Laatste student
     **/
    public student tail()
    {
	studentElement last = getLast();
	studentElement tmp = start;

	for (int i = 0; i < size -2; i++) // size - 1 om het laatste element te krijgen.
	{
		tmp = tmp.getVolgend();
	}
	try
	{
		if (tmp != null)
			tmp.setVolgend(null);  // verwijder laatste element!
		size--;
	}
	catch (studentStackExistsException e)
	{
		System.out.println(e);
		return null;
	}

	if (last != null)
		return last.getStudent();
	else
		return null;
    }
    
    /**
     * Verwijderd een element uit de list op de opgegeven locatie
     * en geeft de student op die plek terug.
     *
     * @param index Locatie om terug te krijgen
     * @return student De specifieke student.
     **/
    public student delete(int index)
    {
    	studentElement find = start;
    	studentElement temp = null;
    	
    	for (int i = 0; i < index - 1; i++)
    	{
    		find = find.getVolgend();
    	}
    	
    	if (find == null)
    	{
    		return null;
    	}
    	temp = find.getVolgend();
    	
    	try
    	{
    	
		find.setVolgend(null);
		find.setVolgend(temp.getVolgend());
 	}
 	catch (studentStackExistsException e)
 	{
 		System.out.println(e);
 		return null;
 	}
    	
    	size--;
    	
    	return temp.getStudent();
    }

    /**
     * Controleer of een bepaalde student met dat studentnummer al aanwezig is
     * @param s student om te controleren.
     * @return boolean True indien aanwezig, anders false.
     **/
    public boolean peek(student s)
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		student t = tmp.getStudent();

		if (s.getStudent() == t.getStudent())
		    {
			return true;
		    }
		tmp = tmp.getVolgend();	     
	    }

	return false;
    }

    /**
     * Print alle studenten
     **/
    public void printStack()
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		tmp.getStudent().printStudent();
		tmp = tmp.getVolgend();
	    }
    }

    /**
     * Print alle mannen
     **/
    public void printmen()
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		if (tmp.getStudent().getGeslacht() == "m")
		    {
			tmp.getStudent().printStudent();
		    }
		tmp = tmp.getVolgend();
	    }
    }
    /** 
     * Print alle vrouwen
     **/
    public void printwomen()
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		if (tmp.getStudent().getGeslacht() == "f")
		    {
			tmp.getStudent().printStudent();
		    }
		tmp = tmp.getVolgend();
	    }
    }
    /**
     * Haal het laatste studentElement op uit de stack
     * @return studentElement
     * @access private
     **/
    private studentElement getLast()
    {
	studentElement vorig = start;
	for (int i = 0; i < size; i++)
	    {
		if (vorig.volgend())
		    {
			vorig = vorig.getVolgend();
		    }
		else
		    {
			return vorig;
		    }
	    }
	System.out.println("ERROR!");
	return null;
    }
}
