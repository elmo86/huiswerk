public class student
{
    /**
     * Student number
     * @access private
     **/
    private int student;

    /**
     * Name
     * @access private
     **/
    private String naam;

    /**
     * Age
     * @access private
     **/
    private int leeftijd;

    /**
     * geslacht
     * @access private
     **/
    private String geslacht;

    public student()
    {

    }

    /**
     * Constructor met assignment voor basis data.
     * @param student Studentnummer
     * @param naam Studentnaam
     * @param geslacht Geslacht
     * @param leeftijd Leeftijd
     **/ 
    public student(int student, String naam, String geslacht, int leeftijd)
    {
	setStudent(student);
	setNaam(naam);
	setGeslacht(geslacht);
	setLeeftijd(leeftijd);
    }

    /**
     * set student number
     * @param data studentnumber
     */
    public void setStudent(int data)
    {
	student = data;
    }

    /**
     * set name
     * @param data Name
     **/
    public void setNaam(String data)
    {
	naam = data;
    }

    /**
     * set age
     * @param data age
     **/
    public void setLeeftijd(int data)
    {
	leeftijd = data;
    }
    
    /**
     * set geslacht
     * @param data geslacht
     * @return boolean
     **/
    public boolean setGeslacht(String data)
    {
	if (data != "f" && data != "m")
	    {
		return false;
	    }
	geslacht = data;

	return true;
    }

    /**
     * Get student
     * @return student number
     **/
    public int getStudent()
    {
	return student;
    }

    /**
     * Get name
     * @return String student name
     **/
    public String getNaam()
    {
	return naam;
    }

    /**
     * Get age
     * @return int age
     **/
    public int getLeeftijd()
    {
	return leeftijd;
    }

    /** 
     * Get geslacht
     * @return string geslacht
     **/
    public String getGeslacht()
    {
	return geslacht;
    }

    /**
     * Print student
     *
     **/
    public void printStudent()
    {
	String data = "";
	data += "Naam: ";
	data += getNaam();
	data += "\n";
	data += "Geslacht: ";
	data += (getGeslacht() == "m") ? "Man" : "Vrouw";
	data += "\n";
	data += "Leeftijd: ";
	data += getLeeftijd();
	data += "\n";
	data += "Studentnummer: ";
	data += getStudent();
	
	System.out.println(data);
    }
}