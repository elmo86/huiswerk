
import java.awt.Dimension;
import java.awt.Toolkit;

public class WelkomScreen extends javax.swing.JFrame {
    private javax.swing.JLabel lblNaam;
    private javax.swing.JLabel lblInfo;
    
    public WelkomScreen(String Naam, String Info)
    {
        lblNaam = new javax.swing.JLabel(Naam);
        lblInfo = new javax.swing.JLabel(Info);

        this.setLayout(null);

        //this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setLayout(null);

	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Scherm grote opvragen

        this.setLocation(0, 0);
        this.setSize(dim);
    }
}
