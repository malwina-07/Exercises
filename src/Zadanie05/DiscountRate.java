package Zadanie05;

public class DiscountRate {
    private static double serviceDiscountPremium = 0.2;
    private static double serviceDiscountGold = 0.15;
    private static double serviceDiscountSilver = 0.1;

    private static double productDiscountPremium = 0.1;
    private static double productDiscountGold = 0.1;
    private static double productDiscountSilver = 0.1;


    public static double getServiceDiscountRate(MemberType type) {
        switch (type) {
            case PREMIUM:
                return serviceDiscountPremium;
            case GOLD:
                return serviceDiscountGold;
            case SILVER:
                return serviceDiscountSilver;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate(MemberType type) {
        switch (type) {
            case PREMIUM:
                return productDiscountPremium;
            case GOLD:
                return productDiscountGold;
            case SILVER:
                return productDiscountSilver;
            default:
                return 0.0;
        }
    }
}
