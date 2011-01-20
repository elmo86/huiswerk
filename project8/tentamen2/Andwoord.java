public class Andwoord
{
    boolean l_Juist = false;
    String l_Value = "";

    public Andwoord(String value, boolean juist)
    {
        l_Value = value;
        l_Juist = juist;
    }

    public boolean getJuist() { return l_Juist; }
    public void setJuist(boolean value) { l_Juist = value; }

    public String getValue() { return l_Value; }
    public void setValua(String value) { l_Value = value; }
}
