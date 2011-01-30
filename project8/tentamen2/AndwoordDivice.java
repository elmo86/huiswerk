
import java.awt.Color;
import java.util.*;

public class AndwoordDivice {
    private String DiviceID;
    private List<NameValue<Integer, String>> Andwoorde;

    public AndwoordDivice(String ID)
    {
        DiviceID = ID;
    }

    public void BusEvent(String Event) // Tijdelijk even string
    {
        // Event data analiceren
        switch(Event.charAt(0)) {
            case 'A': // Anser
                Andwoorde.add(new NameValue<Integer, String>(0, "A"));
                break;
        }

    }

    /**
     * De kleur van de lets instellen (Het value woord opgevraagt per onderdeel
     * dus een tint blauw zal zwart opleveren)
     * @param ledA Kleur led A
     * @param ledB Kleur led B
     * @param ledC Kleur led C
     * @param ledD Kleur led D
     * @param ledE Kleur led E
     */
    public void SetLeds(Color ledA, Color ledB, Color ledC, Color ledD, Color ledE)
    {
        // Code voor leds aansturen
    }
}
