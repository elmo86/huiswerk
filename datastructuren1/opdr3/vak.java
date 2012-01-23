import java.util.LinkedList;
/**
 * @author Paul Sohier
 **/
class vak
{
	String modulecode;
	int cijfer;
	int jaar;
	
	/**
	 * Maak het vak aan
	 * @param code Vakcode
	 * @param jaar Jaartal waar het vak in wordt gegeven
	 **/
	public vak(String code, int jaar)
	{
		setModule(code);
		setJaar(jaar);
		setCijfer(-1);
	}
	
	/**
	 * Geef de modulecode op voor het vak
	 * @param data Modulecode
	 **/
	public void setModule(String data)
	{
		modulecode = data;
	}
	
	/**
	 * Vraag de modulecode op
	 * @return code
	 **/
	public String getModule()
	{
		return modulecode;
	}
	
	/**
	 * Sla het cijfer op voor het vak
	 * @param data cijfer
	 **/
	public void setCijfer(int data)
	{
		if (data == -1 || (data >= 1 && data <= 10))
			cijfer = data;
		else
			System.out.println("ERROR: " + data);
	}
	
	/**
	 * Vraag het cijfer op voor het vak
	 * @return cijfer
	 **/
	public int getCijfer()
	{
		return cijfer;
	}
	
	/**
	 * Sla het jaar op voor het vak
	 * @param data jaar
	 **/
	public void setJaar(int data)
	{
		jaar = data;
	}
	
	/**
	 * Vraag het jaar op voor het vak
	 * @return jaar
	 **/
	public int getJaar()
	{
		return jaar;
	}
	
	/**
	 * Print alle data over dit vak
	 **/
	public void printVak()
	{
		System.out.println(String.format("Modulecode: %s\nJaar: %d\nCijfer: %d\n", modulecode, jaar, cijfer));
	}
}
