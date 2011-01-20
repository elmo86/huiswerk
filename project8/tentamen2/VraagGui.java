import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class VraagGui extends javax.swing.JFrame {
    protected javax.swing.JPanel pnlAndwoorden;
    protected javax.swing.JPanel pnlVraag;
    protected javax.swing.JLabel lblVraag;
    protected javax.swing.JProgressBar pbTime;
    protected javax.swing.JLabel BackImg;
    
    public VraagGui()
    {
        BackImg = new  javax.swing.JLabel();
	lblVraag = new javax.swing.JLabel();
        pnlVraag = new javax.swing.JPanel();
	pnlAndwoorden = new javax.swing.JPanel();
        pbTime = new javax.swing.JProgressBar();
	
	// Scherm instellen
	//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setLayout(null);
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Scherm grote opvragen
	
        this.setLocation(0, 0);
        this.setSize(dim);

        // Back image instellen
        BackImg.setSize(dim);
	BackImg.setLocation(0, 0);
        BackImg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BackImg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        // de Vraag
        lblVraag.setFont(new java.awt.Font(LayoutFile.getData("font", "DejaVu Sans"), 1,LayoutFile.getData("vraag_size", 25)));
        lblVraag.setForeground(LayoutFile.getData("vraag_fcolor", Color.black));
	lblVraag.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVraag.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	lblVraag.setSize(dim.getSize().width-20, 280);
	lblVraag.setLocation(10, 10);

        // Panel Vraag
	pnlVraag.setSize(dim.getSize().width, 300);
	pnlVraag.setLocation(0, 0);
        pnlVraag.setBackground(LayoutFile.getData("vraag_bcolor", new Color(255, 255, 255, 70)));
        pnlVraag.setLayout(null);
        pnlVraag.add(lblVraag);

        // Time toevoegen
        pbTime.setSize(dim.getSize().width, 30);
        pbTime.setLocation(0, dim.getSize().height - 330); // boven ander pennel platsen
        pbTime.setForeground(LayoutFile.getData("tijd_fcolor", Color.red)); // Color uit file
        pbTime.setBackground(LayoutFile.getData("tijd_bcolor", new Color(255,255,255,70)));
        
	// Pannel toevoegen
	pnlAndwoorden.setSize(dim.getSize().width, 300);
	pnlAndwoorden.setLocation(0, dim.getSize().height - 300);
	pnlAndwoorden.setBackground(LayoutFile.getData("andwoorden_bcolor", new Color(0, 128, 70, 70)));
	
	// Add gedoe
        this.add(pbTime);
	this.add(pnlAndwoorden);
        this.add(pnlVraag);
        this.add(BackImg);
    }

    private void addAndwoord(String button, String Andwoord)
    {
	// Debug
	System.out.println("AA: " + button + " = " + Andwoord);
	
	// Elementen aanmaken
	javax.swing.JPanel pnl = new javax.swing.JPanel();
	javax.swing.JLabel lbl = new javax.swing.JLabel();
	javax.swing.JButton cmd = new javax.swing.JButton();
	
	// pnl gereet maken
	pnl.setBackground(LayoutFile.getData("andwoord_bcolor", new Color(200, 200, 100, 70)));
	pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
	
	// Button gereet maken
	cmd.setFont(new java.awt.Font(LayoutFile.getData("font", "DejaVu Sans"), 1, LayoutFile.getData("button_size", 36)));
        cmd.setForeground(LayoutFile.getData("andwoord_acolor", Color.black));
	cmd.setText(button);
        cmd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	cmd.setSize(30, 30);
	cmd.setLocation(5, 5);
	
	// Label gereet maken
        lbl.setFont(new java.awt.Font(LayoutFile.getData("font", "DejaVu Sans"), 1, LayoutFile.getData("andwoord_size", 20)));
        lbl.setForeground(LayoutFile.getData("andwoord_fcolor", Color.black));
	lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl.setText("<HTML>"+Andwoord+"</HTML>");
        lbl.setBorder(null);
	lbl.setLocation(40, 5);
	lbl.setSize(100, 100);
	
	// Locaties permanent maken
	javax.swing.GroupLayout Layout = new javax.swing.GroupLayout(pnl);
	pnl.setLayout(Layout);
	
	Layout.setHorizontalGroup(
	       Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	       .addGroup(Layout.createSequentialGroup()
		 .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
		 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		 .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
	);

	Layout.setVerticalGroup(
	       Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	       .addGroup(Layout.createSequentialGroup()
		  .addComponent(cmd,javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
		  .addContainerGap(10, Short.MAX_VALUE))
	       .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
	
	// Gedoe met add
	pnl.add(cmd);
	pnl.add(lbl);
	pnlAndwoorden.add(pnl);
    }

    public static void Show(Vraag data,int VraagNumemr)
    {
        // Vraag voorberijden
        String value = "<HTML>Vraag " + VraagNumemr + ":<br>" + data.l_Vraag + "</div></HTML>";

        // Time lezen
        int Time = data.getTime();

	// Vraag scherm aanmaken
	VraagGui vraag = new VraagGui();

        // Achtergrond laden
        vraag.BackImg.setIcon(data.getAchtergrond());

	// Vraag invullen
	vraag.lblVraag.setText(value);
	
        String[] Buttons = data.l_Buttons.split(",");

	for(int i=0;i<data.l_Andwoorden.size();i++) {
            if(Buttons.length <= i){
                vraag.addAndwoord(getLetter(i), data.l_Andwoorden.get(i).getValue());
            }
            else {
                if(Buttons[i].trim().equals("")) Buttons[i] = getLetter(i);
                vraag.addAndwoord(Buttons[i], data.l_Andwoorden.get(i).getValue());
            }
	}
	
	// Grote bepalen
	switch(data.l_Andwoorden.size()) {
	case 1:
	case 2:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
	    break;
	case 3:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(3, 1, 5, 5));
	    break;
	case 4:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(2, 2, 5, 5));
	    break;
	case 5:
	case 6:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(3, 2, 5, 5));
	    break;
	}

	// Vraag scherm tonen
	vraag.setVisible(true);

        vraag.pbTime.setMaximum(Time);
        
        for(int t=0;t<Time;t+=10)
        {
            vraag.pbTime.setValue(t);

            try
            {
                Thread.sleep(10);
            }  catch (InterruptedException ex) { }
        }

        vraag.dispose();
    }

    private static String getLetter(int i) {
        switch(i) {
            case 0: return "A";
            case 1: return "B";
            case 2: return "C";
            case 3: return "D";
            case 4: return "E";
            case 5: return "F";
        }

        return "?";
    }
}