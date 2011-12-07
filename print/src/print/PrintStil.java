/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

/**
 *
 * @author Sebastiaan
 */
public class PrintStil extends Thread {

    private PageFormat mPageFormat;
    private Date date = new Date();
    static boolean voorbeeld = !true;
    private Image qrImage;
    private String Regel1;
    private String[] Regel2;

    /*public static void main(String[] args) {
        PrintStil ps = new PrintStil("123456789","002","VEEL");
        if (voorbeeld) {
            ps.preview();
        }
    }*/

    public void preview() {
        JFrame frame = new JFrame();
        frame.add(new OpScherm());
        frame.setTitle("Preview van label 99014");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    

    public PrintStil(Image _qrCode, String _Regel1, String _Regel2) {
        qrImage = _qrCode;
        Regel1 = _Regel1;
        Regel2 = _Regel2.split("\n");

        if (!voorbeeld) {
            PrinterJob pj = PrinterJob.getPrinterJob();
            mPageFormat = new PageFormat();
            Paper paper = new Paper();
            //mPageFormat.setOrientation(mPageFormat.LANDSCAPE);
            paper.setImageableArea(0, 0, 160, 290);
            paper.setSize(160, 290);
            mPageFormat.setPaper(paper);

            pj.setPrintable(new OutPrintable(), mPageFormat);
            //if (pj.printDialog())
            //{
                try {
                    pj.print();
                } catch (PrinterException e) {
                    System.out.println(e);
                }
            //}
        }
    }

    public void makeGraphics(Graphics2D g3) {
        int yoffset = 15;

        g3.setColor(Color.white);
        g3.fillRect(0, 0, 160, 85);

        // Imag
        g3.drawImage(qrImage, 10, 10, 70, 70, null);

        // Start lijn
        g3.setColor(Color.black);
        g3.drawLine(0, 5, 160, 5);

        // Regel1
        g3.setFont(new Font("Monospaced", Font.BOLD, 10));
        g3.drawString(Regel1, 75, yoffset);

        // Regel2
        for(int i=0;i<Regel2.length;i++)
        {
            g3.setFont(new Font("Monospaced", Font.PLAIN, 10));
            g3.drawString(Regel2[i], 75, yoffset + 12 + (i*12));
        }

        // Eind lijn
        g3.setColor(Color.black);
        g3.drawLine(0, 80, 160, 80);//*/
    }

    class OutPrintable
            implements Printable {

        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex != 0) {
                return NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) g;
            makeGraphics(g2);
            return PAGE_EXISTS;
        }
    }

    class OpScherm extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            makeGraphics(g2);
        }
    }
}
