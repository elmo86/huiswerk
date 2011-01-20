package afnamen.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author sebastiaan
 */
public class Vragen extends javax.swing.JFrame {
    private javax.swing.JPanel Antwoorde;
    private javax.swing.JPanel Vraag;
    private javax.swing.JLabel lblTitle;
    protected javax.swing.JLabel lblVraag;
    protected javax.swing.JProgressBar pbTime;

    /** Creates new form Vragen */
    public Vragen() {
        initComponents();
    }

    private void initComponents() {
        LoadScreen.Update("Locaties instellen", 10);

        lblTitle = new javax.swing.JLabel();
        Vraag = new javax.swing.JPanel();
        lblVraag = new javax.swing.JLabel();
        pbTime = new javax.swing.JProgressBar();
        Antwoorde = new javax.swing.JPanel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setText("{%TITLE}");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Vraag.setBackground(new Color(0, 0, 128));

        lblVraag.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lblVraag.setForeground(new Color(255, 255, 0));
        lblVraag.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVraag.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblVraag.setText("{%VRAAG}");
        lblVraag.setBorder(null);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        getContentPane().add(Vraag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, dim.width, 200));

        lblVraag.setLocation(0, 0);
        lblVraag.setSize(Vraag.getSize());
        lblVraag.setVisible(true);
        Vraag.setAlignmentX(javax.swing.SwingConstants.LEFT);
        Vraag.add(lblVraag);

        Antwoorde.setBackground(new java.awt.Color(200, 200, 100));
        Antwoorde.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        getContentPane().add(Antwoorde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, dim.height - 300, dim.width, 300));

        //pack();
        
        //Vraag.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        this.setLocation(0, 0);
        this.setSize(dim);
    }

    protected void AddAndword(String Letter, String Andwoord, Color Kleur)
    {
        javax.swing.JLabel lbl;
        javax.swing.JPanel pnl;
        javax.swing.JToggleButton tcmd;

        pnl = new javax.swing.JPanel();
        tcmd = new javax.swing.JToggleButton();
        lbl = new javax.swing.JLabel();

        pnl.setBackground(Kleur);
        pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tcmd.setFont(new java.awt.Font("DejaVu Sans", 1, 36));
        lbl.setFont(new java.awt.Font("DejaVu Sans", 1, 12));

        tcmd.setText(Letter);
        tcmd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tcmd.setMaximumSize(new java.awt.Dimension(30, 30));
        tcmd.setMinimumSize(new java.awt.Dimension(30, 30));
        tcmd.setPreferredSize(new java.awt.Dimension(30, 30));

        lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl.setText(Andwoord);
        lbl.setBorder(null);

        javax.swing.GroupLayout pnlALayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlALayout);

        pnlALayout.setHorizontalGroup(
            pnlALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlALayout.createSequentialGroup()
                .addComponent(tcmd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
        );

        pnlALayout.setVerticalGroup(
            pnlALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlALayout.createSequentialGroup()
                .addComponent(tcmd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        Antwoorde.add(pnl);
    }

    public static void ShowVraag(String Vraag, String Andwoorden[], String Buttons[], int Tijd, Color Colors[])
    {
        // Vraag scherm aanmaken
        Vragen vraag = new Vragen();

        // Vraag installen
        vraag.lblVraag.setText(Vraag);

        // Andwoorden weergeven
        for(int i=0;i<Andwoorden.length;i++)
        {
            vraag.AddAndword(Buttons[i], Andwoorden[i], Colors[i]);
        }

        // Scherm weergeven
        vraag.setVisible(true);

        // Wachten en PB showen
    }
}
