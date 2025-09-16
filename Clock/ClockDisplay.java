/**
 * The ClockDisplay class implements a digital clock display.
 * It now also handles date and temperature data.
 *
 * @author Michael Kölling and David J. Barnes (modified)
 * @version 2025.09.16
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayString;
    
    // DITAMBAHKAN: Variabel untuk tanggal dan suhu
    private NumberDisplay day;
    private NumberDisplay month;
    private NumberDisplay year;
    private double temperature;

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at 00:00:00 and a default date/temp.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        
        // DITAMBAHKAN: Inisialisasi tanggal dan suhu
        day = new NumberDisplay(32);     // Batas 32 (untuk nilai 1-31)
        month = new NumberDisplay(13);   // Batas 13 (untuk nilai 1-12)
        year = new NumberDisplay(10000); // Batas 10000 (untuk tahun 0-9999)
        
        // Atur nilai default
        setDate(1, 1, 2025);
        this.temperature = 25.0;
        
        updateDisplay();
    }

    /**
     * This method should get called once every second - it
     * makes the clock display go one second forward.
     */
    public void timeTick()
    {
        seconds.increment();
        if(seconds.getValue() == 0) {
            minutes.increment();
            if(minutes.getValue() == 0) {
                hours.increment();
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display.
     */
    public void setTime(int hour, int minute, int second)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }
    
    /**
     * DITAMBAHKAN: Set the date of the display.
     */
    public void setDate(int day, int month, int year)
    {
        this.day.setValue(day);
        this.month.setValue(month);
        this.year.setValue(year);
    }
    
    /**
     * DITAMBAHKAN: Set the temperature.
     */
    public void setTemperature(double temp)
    {
        this.temperature = temp;
    }

    /**
     * Return the current time of this display in the format HH:MM:SS.
     */
    public String getTimeString()
    {
        return displayString;
    }
    
    /**
     * DITAMBAHKAN: Return the current date in the format DD/MM/YYYY.
     */
    public String getDateString()
    {
        String yearValue = String.format("%04d", year.getValue());
        return day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + yearValue;
    }
    
    /**
     * DITAMBAHKAN: Return the current temperature in the format XX.X°C.
     */
    public String getTempString()
    {
        // Format suhu menjadi satu angka di belakang koma dan tambahkan simbol °C
        return String.format("%.1f°C", temperature);
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue() + ":" +
                        seconds.getDisplayValue();
    }
}