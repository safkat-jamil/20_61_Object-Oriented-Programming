//Currency Package
//converter.currency.CurrencyConverter
package converter.currency;

public class CurrencyConverter {
    private static double dollarToBDTRate = 110.50;
    private static double euroToBDTRate = 122.51;
    private static double yenToBDTRate = 0.78;

    public static void setConversionRates(double dollarRate, double euroRate, double yenRate) {
        dollarToBDTRate = dollarRate;
        euroToBDTRate = euroRate;
        yenToBDTRate = yenRate;
    }

    public static double convertDollarToBDT(double amount) {
        return amount * dollarToBDTRate;
    }

    public static double convertEuroToBDT(double amount) {
        return amount * euroToBDTRate;
    }

    public static double convertYenToBDT(double amount) {
        return amount * yenToBDTRate;
    }

    public static double convertBDTToDollar(double amount) {
        return amount / dollarToBDTRate;
    }

    public static double convertBDTToEuro(double amount) {
        return amount / euroToBDTRate;
    }

    public static double convertBDTToYen(double amount) {
        return amount / yenToBDTRate;
    }

}