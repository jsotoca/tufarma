package helpers;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ComboItem {
    private final int key;
    private final String value;

    public ComboItem(int key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return this.value;
    }

    public int getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
