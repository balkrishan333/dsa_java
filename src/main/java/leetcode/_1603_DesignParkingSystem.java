package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1603_DesignParkingSystem {

    private final Map<Integer, Integer> parkingSlotCount;
    public static void main(String[] args) {
        _1603_DesignParkingSystem obj = new _1603_DesignParkingSystem(1,1,0);

        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }
    public _1603_DesignParkingSystem(int big, int medium, int small) {
        parkingSlotCount = new HashMap<>();
        parkingSlotCount.put(1, big);
        parkingSlotCount.put(2, medium);
        parkingSlotCount.put(3, small);
    }

    public boolean addCar(int carType) {
        boolean canPark = parkingSlotCount.get(carType) > 0;
        parkingSlotCount.merge(carType, -1, Integer::sum);
        return canPark;
    }
}
