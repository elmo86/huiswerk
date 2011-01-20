import java.io.*;
import java.util.*;

public class app
{
    public static void main(String args[])
    {
	String vragen_f = "./tirlin01.vraag";
	String layout_f = "./tirlin01.styl";

	boolean rand_andwoorde = false;
	boolean rand_vragen = false;

	// Info over vraagen lijst
	String Naam = "";
	String Info  = "";

	// Lijst met alle vragen
	List<Vraag> vragen = new ArrayList<Vraag>();

	System.out.println("Programma starten");

	// Slectie van de vragen vint plaats in andere app

	// Vragen laden
        System.out.println("---START LOADING---");
	try {
            LayoutFile.Init(layout_f);
            
	    BufferedReader br = new BufferedReader(new FileReader(vragen_f));
	    String line = "";
	    while((line = br.readLine()) != null) {
		if(line.length() < 1) continue;
		
		String command = line.substring(1).trim();
		
		switch(line.charAt(0)) {
		case '!': // Speciaal command
		    // Comandows verder opdelen hier (extra switch)
		    if(command.toLowerCase().equals("rand_andwoorde")) rand_andwoorde = true;
                    else if(command.toLowerCase().equals("static_andwoorde")) rand_andwoorde = false;
                    else if(command.toLowerCase().equals("rand_vragen")) rand_vragen = true;
                    else if(command.toLowerCase().equals("static_vragen")) rand_vragen = false;
                    else if(command.toLowerCase().equals("next"))
                    {
                        if (rand_andwoorde == true) {
                            vragen.get(vragen.size()-1).Shuffel();
                        }

                        System.out.println("---NEXT QUESTION");
                        vragen.add(new Vraag());
                    }
                    //else System.out.println(command); // Onbekent comandow
		    break;
		case 'n': // Naam van de toets
		    Naam  = command;
		    break;
		case 'i': // Info over toets
		    Info = command;
		    break;
// --------------------------------------------------- 	    
		case '?': // De vraag die gestelt woord (moet een !NEXT aan vooraf zijn gegaan)
		    vragen.get(vragen.size()-1).setVraag(command);
		    break;
		case 't': // De tijd die voor de vraag staat
		    vragen.get(vragen.size()-1).setTijd(command);
		    break;
		case 'p': // Aantal punten dat de vraag oplevert
		    vragen.get(vragen.size()-1).setPunten(command);
		    break;
		case '>': // Opschrift op de buttons (Comma geschijden)
		    vragen.get(vragen.size()-1).setButtons(command);
                    break;
		case '<': // Achtergrond afbeelding van de vraag
		    vragen.get(vragen.size()-1).setAchtergrond(command);
		    break;
		case '+': // Een juist andwoord (bij meerdere + telt de laaste + als juiste andwoord)
		    vragen.get(vragen.size()-1).addAndwoord(command, true);
		    break;
		case '-': // Verkeert andwoord
		    vragen.get(vragen.size()-1).addAndwoord(command, false);
		    break;
                default:
                    //System.out.println("u:" + line.charAt(0));
		}
	    }
	}
	catch(IOException ex) {
	    ex.printStackTrace(System.out);
	}
	finally {
	    //br.Close();
	}
        System.out.println("---EIND LOADING---");

	// Vragen gereet maken
        System.out.println("---START VRAGENCOPPEL---");
        List<Vraag> show = new ArrayList<Vraag>();

        while(vragen.size() > 0)
        {
            int i = vragen.size();

            if(rand_vragen == true && vragen.size() > 1) i -= new Random().nextInt(i);

            System.out.println("Vraag: "  + i);

            Vraag t = vragen.get(i-1);
            vragen.remove(t);
            
            show.add(t);
        }
        System.out.println("---EIND VRAGENCOPPEL---");

        System.out.println("---START WELKOMS SCHERM---");
	WelkomScreen welkom = new WelkomScreen(Naam, Info);
        welkom.setVisible(true);
        System.out.println("---EIND WELKOMS SCHERM---");

	System.out.println("---START EXAMEN---");

	// Vragen tonen
	for(int i=0;i<show.size();i++) {
	    show.get(i).Show(i+1);
        }

	System.out.println("---EIND EXAMEN---");
	
	System.out.println("Afnamen software beindigt");
	System.exit(0); // Force exit
    }
}