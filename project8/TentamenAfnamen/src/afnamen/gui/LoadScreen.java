package afnamen.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.net.ssl.SSLEngineResult.Status;
import org.omg.CORBA.INITIALIZE;

/**
 *
 * @author sebastiaan
 */
public class LoadScreen extends javax.swing.JFrame {
    private static javax.swing.JLabel lblTitle;
    private static javax.swing.JProgressBar pbStatus;
    private static LoadScreen screen;

    public LoadScreen() {

    }

    private static void initComponents() {
        int x, y; // Voor scherm positie

        // Componenten uit defualt inladen
        screen.setSize(500, 50);

        // Scherm grotes opvragen en centreer punten benaderen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        x = (dim.width-screen.getSize().width)/2;
        y = (dim.height-screen.getSize().height)/2;

        screen.setLocation(x, y);

        lblTitle = new javax.swing.JLabel();
        pbStatus = new javax.swing.JProgressBar();

        screen.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        screen.setAlwaysOnTop(true);
        screen.setResizable(false);
        screen.setUndecorated(true);
        screen.getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        lblTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblTitle.setText("{%TITLE}");
        screen.getContentPane().add(lblTitle);

        pbStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pbStatus.setString("load...");
        pbStatus.setStringPainted(true);
        screen.getContentPane().add(pbStatus);
    }

    public static void Update(int Value)
    {
        LoadScreen.Update(pbStatus.getString(), Value);
    }

    public static void Update(String Message, int Value)
    {
        if(screen == null)
        {
            screen = new LoadScreen();
            initComponents();
            screen.setVisible(true);
        }

        pbStatus.setString(Message);

        Value += pbStatus.getValue();

        if(Value > pbStatus.getMaximum()) Value = pbStatus.getMaximum();
        if(Value < pbStatus.getMinimum()) Value = pbStatus.getMinimum();

        pbStatus.setValue(Value);
    }

    public static void Close()
    {
        screen.dispose();
        screen = null;
    }
}
