/**
 * @author Paul Sohier
 **/
public class app
{
	public static void main(String[] arg)
	{
		administratie a = new administratie();
		
		for (int i = 0; i < 20; i++)
		{
			// Data
			int leeftijd = 18 + (i / 2);
			String geslacht = ((i % 4) == 0) ? "f" : "m";
			String naam = "student " + i;
			String student = leeftijd * i + "";
			
			String studierichting = ((i % 2) == 0) ? "ti" : "inf";
			String klas = ((i % 4) + 1) + "a";

			a.addStudent(student, naam, geslacht, klas, studierichting);
		}	
		
		a.addVak("ti", "tirdat01", 2);	
		a.addVak("ti", "tirdat02", 2);	
		a.addVak("ti", "tirprg01", 1);	
		a.addVak("ti", "tirprg02", 1);	
		a.addVak("ti", "tirprg03", 3);	
		
		a.addVak("inf", "tirprg00", 1);	
		a.addVak("inf", "tirprg01", 1);	
		a.addVak("inf", "tirprg02", 2);	
		
		a.addCijfer("486", "tirdat01", 7);	
		a.addCijfer("0", "tirdat01", 4);
		
		a.printBepaaldVakBehaald("tirtest01");
		a.printBepaaldVakBehaald("tirprog01");	
		a.printBepaaldVakBehaald("tirdat01");
		
		a.printGemiddeldVoorVak("tirdat01");
		a.printGemiddeldVoorVak("tirtest01");
		
		a.printGehaaldeVakken("0", true);
		a.printGehaaldeVakken("486", true);
		a.printGehaaldeVakken("80", true);
		
		a.printGehaaldeVakken("0", false);
		a.printGehaaldeVakken("486", false);
		a.printGehaaldeVakken("80", false);		
	}
} 
