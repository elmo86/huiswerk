/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package print;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sun.font.CreatedFontTracker;

/**
 *
 * @author sebastiaan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for(int i=1;i<=2;i++)
            {
                BufferedImage img = createQrCode(null, "i.tilab.nl/LOD020", 80, "png");

                for (int s = 1; s <= 1; s++)
                {
                    PrintStil t = new PrintStil(img, "LOD020","Legodoos\nLEGO\nKast: I.2.12 1");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Call this method to create a QR-code image. You must provide the OutputStream where the image data can be written.
     *
     * @param outputStream The OutputStream where the QR-code image data is written.
     * @param content The string that should be encoded with the QR-code.
     * @param qrCodeSize The QR-code must be quadratic. So this is the number of pixel in width and height.
     * @param imageFormat The image format in which the image should be rendered. As Example 'png' or 'jpg'. See @javax.imageio.ImageIO for
     *        more information which image formats are supported.
     * @throws Exception If an Exception occur during the create of the QR-code or while writing the data into the OutputStream.
     */
    public static BufferedImage createQrCode(OutputStream outputStream, String content, int qrCodeSize, String imageFormat) throws Exception
    {
        // Create the ByteMatrix for the QR-Code that encodes the given String.

        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);

        // Make the BufferedImage that are to hold the QRCode

        int matrixWidth = byteMatrix.getWidth();

        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);

        // Paint and save the image using the ByteMatrix

        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrixWidth; i++)
        {
            for (int j = 0; j < matrixWidth; j++)
            {
                if (byteMatrix.get(i, j) == true)
                {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        //ImageIO.write(image, imageFormat, outputStream);
        return image;
    }
}
