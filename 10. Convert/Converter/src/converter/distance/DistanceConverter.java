// Distance Package
//converter.distance.DistanceConverter
package converter.distance;

public class DistanceConverter {
    public static double convertMeterToKM(double distance) {
        return distance / 1000.0;
    }

    public static double convertKMToMeter(double distance) {
        return distance * 1000.0;
    }

    public static double convertMilesToKM(double distance) {
        return distance * 1.60934;
    }

    public static double convertKMToMiles(double distance) {
        return distance / 1.60934;
    }

}
