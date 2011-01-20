import java.awt.Color;
import java.io.*;
import java.util.*;

public class LayoutFile {
    public static List<NameValue<String, String>> Data;
    
    public static void Init(String file)
    {
        Data = new ArrayList<NameValue<String, String>>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] t = line.split("=", 2);
                if(t.length < 2) continue;
                
                Data.add(new NameValue<String, String>(t[0], t[1]));
            }
            br.close();
        } catch (IOException ex) {
            // TST
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Neger line
        } finally {
            // TST
        }
    }

    public static String getData(String name, String Defualt)
    {
        for(int i=0;i<Data.size();i++) {
            if(Data.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                return Data.get(i).getValue();
            }
        }

        return Defualt;
    }

    public static Integer getData(String name, Integer Defualt)
    {
        for(int i=0;i<Data.size();i++) {
            if(Data.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                try
                {
                    return Integer.parseInt(Data.get(i).getValue());
                }
                catch(Exception ex)
                {
                    return Defualt;
                }
            }
        }
        return Defualt;
    }

    public static Color getData(String name, Color Defualt)
    {
        for(int i=0;i<Data.size();i++) {
            if(Data.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                try
                {
                    String[] t = Data.get(i).getValue().split(",", 4);
                    if(t[0].isEmpty()) t[0] = "" + Defualt.getRed();
                    if(t[1].isEmpty()) t[1] = "" + Defualt.getGreen();
                    if(t[2].isEmpty()) t[2] = "" + Defualt.getBlue();
                    if(t[3].isEmpty()) t[3] = "" + Defualt.getAlpha();

                    return new Color(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]), Integer.parseInt(t[3]));
                }
                catch(Exception ex)
                {
                    return Defualt;
                }
            }
        }

        return Defualt;
    }
}
