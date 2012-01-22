public class studentElement
{
    /**
     * Volgend studentElement
     */
    private studentElement volgend = null;
    
    /**
     * student in dit element
     **/
    private student s;

    /**
     * Constructor
     * @param data student voor dit Element
     **/
    public studentElement(student data)
    {
	setStudent(data);
    }

    /**
     * Sla student op voor dit element
     * @param data Student om op te slaan
     **/
    public void setStudent(student data)
    {
	s = data;
    }

    /**
     * Haal de student op uit dit element
     * @return student de student
     **/
    public student getStudent()
    {
	return s;
    }

    /**
     * Controleer of er nog een volgend student is in dit element
     * @return boolean
     **/
    public boolean volgend()
    {
	if (volgend == null)
	    {
		return false;
	    }
	else
	    {
		return true;
	    }
    }

    /**
     * Vraag de volgende studentElement op
     * @return studentElement volgend studentElement
     **/
    public studentElement getVolgend()
    {
	if (volgend())
	    {
		return volgend;
	    }
	else
	    {
		return null;
	    }
    }
    /**
     * Geef een nieuw element op in de lijst
     * @param v Volgend studentElement
     * @throws studentStackExistsException
     **/
    public void setVolgend(studentElement v) throws studentStackExistsException
    {
	if (!volgend() || v == null) // Wanneer v null is willen we volgend verwijderen
	    {
		volgend = v;
	    }
	else
	    {
		throw new studentStackExistsException();
	    }
    }
}
