import java.awt.Dimension;
import java.awt.Toolkit;

public class LoadScreen extends javax.swing.JFrame {
    private static LoadScreen screen; // Screen die voor calls woord gebruikt
    
    protected javax.swing.JLabel lblTitle;
    protected javax.swing.JProgressBar pbStatus;

    // Static screen empty constructor
    public LoadScreen() {}
    
    public static void initScreen()
    {
	if(screen == null) {
	    // Screen aanmaken
	    screen = new LoadScreen();
	    
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Scherm grote opvragen
	    
	    screen.setSize(500, 50); // Maten instellen
	    screen.setLocation((dim.width-screen.getSize().width)/2, (dim.height-screen.getSize().height)/2); // Centreren

	    // Componenten aanmaken
	    screen.lblTitle = new javax.swing.JLabel();
	    screen.pbStatus = new javax.swing.JProgressBar();
	
	    // Scherm instellingen aanpassen
	    screen.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	    screen.setAlwaysOnTop(true);
	    screen.setResizable(false);
	    screen.setUndecorated(true);

	    // Componenten in een grit zetten
	    screen.getContentPane().setLayout(new java.awt.GridLayout(2, 1));
	
	    // Title van programma invullen
	    screen.lblTitle.setFont(new java.awt.Font("DeJaVu Sans", 1, 14));
	    screen.lblTitle.setText("{%TITLE}");
	    
	    // Status bar instellen
	    screen.pbStatus.setString("Loading...");
	    screen.pbStatus.setStringPainted(true);
	    
	    // Items toevoegen
	    screen.add(screen.lblTitle);
	    screen.add(screen.pbStatus);

	    // Screen weergeven
	    screen.setVisible(true);
	}
	else {
	    screen.setVisible(true);
	}
    }
    

    /**
     * Processbar verhogen
     **/
    public static void Update(int value)
    {
	initScreen();
	
	String message = screen.pbStatus.getString();
	
	LoadScreen.Update(message, value);
    }

    /**
     * Prosessbar verhogen en opschrift aanpassen
     **/
    public static void Update(String message, int value)
    {
	initScreen();

	// PB update
        screen.pbStatus.setString(message);

        value += screen.pbStatus.getValue();

        if(value > screen.pbStatus.getMaximum()) value = screen.pbStatus.getMaximum();
        if(value < screen.pbStatus.getMinimum()) value = screen.pbStatus.getMinimum();

        screen.pbStatus.setValue(value);
    }

    /**
     * Venster sluiten
     **/
    public static void Close()
    {
	screen.dispose();
	screen = null;
    }
}