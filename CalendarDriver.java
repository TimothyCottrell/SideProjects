/**
 *
 * @author Timothy Cottrell
 * @version v1
 */
public class CalendarDriver
{
    public static void main(String[] args)
    {
        Calendar date = new Calendar(12,10,2019);
        for(int i=0;i<125;i++)
        {
            date.AddDays(1);
            System.out.println((118-i)+" days till the rest of my life.. ("+date.toString()+")");
        }
    }
}
