import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Timothy Cottrell
 * @version v1
 */
public class Calendar
{
    //DONT FORGET TO IMPLEMENT LEAP YEARS
    private int temp;
    private int day;
    private int month;
    private int year;
    private final int[] DAYSOFTHEMONTH = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public Calendar()
    {
        Date todaysDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
        temp = 10*Character.getNumericValue(dateForm.format(todaysDate).charAt(0));
        temp += Character.getNumericValue(dateForm.format(todaysDate).charAt(1));
        month = temp;
        temp = 10*Character.getNumericValue(dateForm.format(todaysDate).charAt(3));
        temp += Character.getNumericValue(dateForm.format(todaysDate).charAt(4));
        day = temp;
        temp = 1000*Character.getNumericValue(dateForm.format(todaysDate).charAt(6));
        temp += 100*Character.getNumericValue(dateForm.format(todaysDate).charAt(7));
        temp += 10*Character.getNumericValue(dateForm.format(todaysDate).charAt(8));
        temp += Character.getNumericValue(dateForm.format(todaysDate).charAt(9));
        year = temp;
    }
    public Calendar(int defMonth, int defDay, int defYear)
    {
        month = defMonth;
        day = defDay;
        year = defYear;
    }
    public void AddDays(int numOfDays)
    {
        for(int i=0;i<numOfDays;i++)
        {
            if(year%4 == 0 && month == 2 && day == 28)
            {
                month = 2;
                day = 29;
            }
            else
            {
                day++;
                if(day > DAYSOFTHEMONTH[month-1])
                {
                    month++;
                    day = 1;
                    if(month > 12)
                    {
                        year++;
                        month = 1;
                    }
                }
            }
        }
    }
    public void SubtractDays(int numOfDays)
    {
        for(int i=0;i<numOfDays;i++)
        {
            if(year%4 == 0 && month == 3 && day == 1)
            {
                month = 2;
                day = 29;
            }
            else
            {
                day--;
                if(day == 0)
                {
                    month--;
                    if(month == 0)
                    {
                        year--;
                        month = 12;
                    }
                    day = DAYSOFTHEMONTH[month-1];
                }
            }
        }
    }
    public int daysBetween(Calendar anotherDate)
    {
        int count = 0;
        if(this.compareTo(anotherDate)==-1)
        {
            while(!this.equals(anotherDate))
            {
                this.AddDays(1);
                count++;
            }
        }
        else if(this.compareTo(anotherDate)==1)
        {
            while(!this.equals(anotherDate))
            {
                this.SubtractDays(1);
                count++;
            }
        }
        return count;
    }
    public String toString()
    {
        return month+"/"+day+"/"+year;
    }
    public int getYear()
    {
        return year;
    }
    public int getMonth()
    {
        return month;
    }
    public int getDay()
    {
        return day;
    }
    public boolean equals(Calendar anotherDate)
    {
        return this.compareTo(anotherDate)==0;
    }
    public int compareTo(Calendar anotherDate)
    {
        if(this.getYear()<anotherDate.getYear())
        {
            return -1;
        }
        if(this.getYear()>anotherDate.getYear())
        {
            return 1;
        }
        if(this.getMonth()<anotherDate.getMonth())
        {
            return -1;
        }
        if(this.getMonth()>anotherDate.getMonth())
        {
            return 1;
        }
        if(this.getDay()<anotherDate.getDay())
        {
            return -1;
        }
        if(this.getDay()>anotherDate.getDay())
        {
            return 1;
        }
        return 0;
    }
    public void setDate(int defMonth, int defDay, int defYear)
    {
        day = defDay;
        month = defMonth;
        year = defYear;
    }
    //Different types of format:
    //    *English(d/m/y) E
    //    *American(m/d/y) A
    public String getDate(char format)
    {
        String monthName = "null";
        String dayThing = "null";
        switch(day)
        {
            case 1:
            dayThing = "st ";
            break;
            case 2:
            dayThing = "nd ";
            break;
            case 3:
            dayThing = "rd ";
            break;
            default:
            dayThing = "th ";
            break;
        }
        switch(this.getMonth())
        {
            case 1:
            monthName = "January ";
            break;
            case 2:
            monthName = "February ";
            break;
            case 3:
            monthName = "March ";
            break;
            case 4:
            monthName = "April ";
            break;
            case 5:
            monthName = "May ";
            break;
            case 6:
            monthName = "June ";
            break;
            case 7:
            monthName = "July ";
            break;
            case 8:
            monthName = "August ";
            break;
            case 9:
            monthName = "September ";
            break;
            case 10:
            monthName = "October ";
            break;
            case 11:
            monthName = "November ";
            break;
            case 12:
            monthName = "December ";
            break;
        }
        switch(format)
        {
            case 'E':
            return day+dayThing+monthName+year;
            case 'A':
            return monthName+day+dayThing+", "+year;
            default:
            return "Incorrect Type name";
        }
    }
}
