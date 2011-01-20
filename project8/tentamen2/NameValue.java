
public class NameValue<NAME, VALUE> {
    private NAME l_Name;
    private VALUE l_Value;

    public NameValue(NAME Name, VALUE Value)
    {
        l_Name = Name;
        l_Value = Value;
    }

    public NAME getName() {return l_Name;}
    public VALUE getValue() {return l_Value;}
}