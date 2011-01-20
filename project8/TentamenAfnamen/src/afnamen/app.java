/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package afnamen;

import afnamen.gui.LoadScreen;
import afnamen.gui.Vragen;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastiaan
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            // Args controleren met tags

            // Loading screen starten
            LoadScreen.Update("Start aplication", 0);
            Thread.sleep(500);

            // Form aanmaken
            // Tempory sleep
            /*for (int i = 0; i < 10; i++)
            {
                LoadScreen.Update("Message " + i,i * 10);
                Thread.sleep(500);
                
                LoadScreen.Update(i * 10 + 5);
                Thread.sleep(500);
            }*/

            String[] andwoorde = new String[4];
            String[] buttons = new String[4];
            Color[] colors = new Color[4];

            for(int i=0;i<andwoorde.length;i++) colors[i] = new Color(128, 128, 0, 70);
            andwoorde[0] = "Kok";
            buttons[0] = "A";
            andwoorde[1] = "Kees";
            buttons[1] = "B";
            andwoorde[2] = "...";
            buttons[2] = "?";
            andwoorde[3] = "...";
            buttons[3] = "?";

            Vragen.ShowVraag("Kippie is een kip maar kokkie is een ?", andwoorde, buttons, 1000, colors);

            LoadScreen.Close();
            
            Thread.sleep(10000);
            System.exit(0);

        } catch (InterruptedException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
