import java.util.*;
import javax.swing.*;

public class Vraag {
    public String l_Vraag = "";
    public String l_Info = "";
    public int l_Tijd = 0;
    public String l_Punten = "";
    public String l_Buttons = "";
    public ImageIcon l_Afbeelding = null;
    public List<Andwoord> l_Andwoorden = new ArrayList<Andwoord>();

    public Vraag() { }
    
    public void setVraag(String value) {l_Vraag = value; }
    public void setInfo(String info) {l_Info = info;}
    public void setPunten(String punten) {l_Punten = punten;} // parse
    public void setButtons(String buttons) {l_Buttons = buttons;}

    public void setTijd(String tijd) {
        try {
            l_Tijd = Integer.parseInt(tijd);
        }
        catch(Exception ex) {
            l_Tijd = 0;
        }
    }
    public int getTime() {return  l_Tijd; }

    public void setAchtergrond(String value) {l_Afbeelding = new ImageIcon(value); System.out.println(value + " loaded"); }
    public ImageIcon getAchtergrond() { return l_Afbeelding;  }

    public void Shuffel()
    {
        System.out.println("Lets shuffel");
        List<Andwoord> temp = new ArrayList<Andwoord>();

        while(l_Andwoorden.size() > 0)
        {
            int i = l_Andwoorden.size();
            i -= new Random().nextInt(i);
            Andwoord t = l_Andwoorden.get(i-1);
            l_Andwoorden.remove(t);
            temp.add(t);
        }

        l_Andwoorden = temp;
    }

    public void addAndwoord(String andwoord, boolean juist)
    {
	// Gegevens van Andwoord;
	//System.out.println(andwoord);
        l_Andwoorden.add(new Andwoord(andwoord, juist));
    }
    
    public void Show(int VraagNummer)
    {
        System.out.println(l_Vraag);
	// Vraag laten zien met deze gegevens

        VraagGui.Show(this, VraagNummer);
    }
}