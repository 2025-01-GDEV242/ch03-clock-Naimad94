
/**
 * 24 HOUR INTERNAL BRANCH
 * 
 * The ClockDisplay class implements a digital clock display for a
 * US-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 AM (midnight) to 11:59 pm (one minute before 
 * midnight).
 * 
 * The clock represents hhours in the range from 0..23 and converts to range 12
 * ....11 as shown in US clocks.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Damian Davila
 * @version 2025.02.10
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment(); //minutes + 1
        if(minutes.getValue() == 0) //If minutes Value is equal to "00" add hour.
        {
            hours.increment(); // it just rolled over!
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        int hour = hours.getValue(); //local variable of hour.
        String meridian; //local variable of meridian.
        
        if(hour >= 12) //if hour is greater then or equal to 12
        {
            meridian = "PM"; //set meridian to "PM"
        }
        else
        {
           meridian = "AM"; //else set meridian to "AM"
        }
        
        if(hour >= 12) //if hour is greater then or equal to 12
        {
            hour -= 12; //subtract 12 to number.
        }
        
        if(hour == 0) //if hour is equal to 0.
        {
            hour = 12; //hour is erqual to 12.
        }
        
        //had to change hours.getValue to hour becuase we are using that local variable.
        //ended up adding meridian becuase it will give us our string AM or PM.
        displayString = hour + ":" + minutes.getDisplayValue() + meridian; 
    }
}
