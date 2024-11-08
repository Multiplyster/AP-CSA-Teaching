package BatteryCharager;

public class BatteryCharger {
    static int[] rateTable = {50, 60, 160, 60, 80, 100, 100, 120, 150, 150, 150, 200, 40, 240, 220, 220, 200, 200, 180, 180, 140, 100, 80, 60};

    public static void main(String[] args) {
        // System.out.println(getChargingCost(20, 4));
        System.out.println(getChargeStartTime(30));
    }

    /**
     * Determines the total cost to charge the battery starting at the beginning of startHour
     * @param startHour
     * @param chargeTime
     * @return
     */
    public static int getChargingCost(int startHour, int chargeTime) {
        int cost = 0;
        for(int i = 0; i < chargeTime; i++) {
            cost += rateTable[(i + startHour) % rateTable.length];
        }

        return cost;
    }

















    public static int getChargeStartTime(int chargeTime) {
        int minIndex = 0;
        int minChargingCost = getChargingCost(0, chargeTime);
        for(int i = 1; i < rateTable.length; i++) {
            int cost = getChargingCost(i, chargeTime);
            if(cost < minChargingCost) {
                minIndex = i;
                minChargingCost = cost;
            }
        }
        return minIndex;
    }
}
