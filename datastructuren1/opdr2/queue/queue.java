/**
 * @author Paul Sohier
 **/
public class queue
{
	private studentElement start;
	private int size;

	/**
	*
	**/
	public queue()
	{

	}

	/**
	* Voeg een student toe aan de stack
	* @param s Student
	**/
	public void push(student s)
	{
		studentElement last = new studentElement(s);
		studentElement prev;

		if (size != 0)
		{
			prev = getLast();
		}
		else
		{
			start = last;
			size++;
			return;
		}      
		try
		{
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
	public student pop()
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
