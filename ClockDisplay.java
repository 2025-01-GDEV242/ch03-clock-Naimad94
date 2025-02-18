
/**
 * 
 * 12 HOUR INTERNAL
 * 
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 AM (midnight) to 11:59 PM (one minute before 
 * midnight).
 * 
 * This version requires program to maintain an internal variable to indicate if
 * it is an ante-meridian or post meridian (AM-PM).
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
    private String displayString; // simulates the actual display
    private int changes; // changes between AM/PM.
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12); //Since it's a 12 hour internal i changed the limit to 13 hours.
        minutes = new NumberDisplay(60);
        changes = 1; //will always display AM at first.
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    
    //added boolean isAM to the parameter of the constructor.
    public ClockDisplay(int hour, int minute, boolean isAM)
    {
        hours = new NumberDisplay(12); //Just like in the first constructor i changed the limit to 13 hours.
        minutes = new NumberDisplay(60);
        changes = 1; //will display AM unless you put 12.
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {      
        minutes.increment();
        if(minutes.getValue() == 0) 
        {  // it just rolled over!
            hours.increment();
        }
        
        if(hours.getValue() == 0)
        {
            changes++; //incrementing changes to 2 then 3...
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
        if (changes % 2 == 0)
        {
           displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " PM"; 
        }
        else if (changes % 2 != 0)
        {
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "AM";
        }
    }
}
