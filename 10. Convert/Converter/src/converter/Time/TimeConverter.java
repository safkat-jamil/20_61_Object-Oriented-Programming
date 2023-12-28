// Time Package
// converter.time.TimeConverter
package converter.Time;

public class TimeConverter {
    public static double convertHoursToMinutes(double hours) {
        return hours * 60.0;
    }

    public static double convertHoursToSeconds(double hours) {
        return hours * 3600.0;
    }

    public static double convertMinutesToHours(double minutes) {
        return minutes / 60.0;
    }

    public static double convertSecondsToHours(double seconds) {
        return seconds / 3600.0;
    }

}