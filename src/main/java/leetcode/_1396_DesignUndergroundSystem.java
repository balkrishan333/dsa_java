package leetcode;

import java.util.*;

public class _1396_DesignUndergroundSystem {

    private final Map<Integer, Map<String, Integer>> checkIns;
    private final Map<String, AvgObject> avgObjects;

    static class AvgObject {
        int count;
        long total;

        void update(int time) {
            count++;
            total += time;
        }
    }

    /*
        Approach: Do some calculation on checkout and final calculation when average function is called

        Create a map - key -> person id, value -> another map with key -> station name, value -> time
        Check in - Add entry to checkins map

        Check out - Take out check in entry from checkins map for this person id, create a key of source station and destination station
        and put it in another map. For new map key -> start_station+#+end_station, value -> avg object, which contains total visits
        between these stations and total time taken for those visits.

        getAverage - Getnthe avgobject from map for the pair of stations. Key to get value from map -> start_station+#+end_station and
        return the average.
     */
    public static void main(String[] args) {
        _1396_DesignUndergroundSystem obj = new _1396_DesignUndergroundSystem();
        obj.checkIn(45,"Leyton",3);
        obj.checkIn(32,"Paradise",8);
        obj.checkIn(27,"Leyton",10);
        obj.checkOut(45,"Waterloo",15);
        obj.checkOut(27,"Waterloo",20);
        obj.checkOut(32,"Cambridge",22);
        System.out.println(obj.getAverageTime("Paradise","Cambridge"));
        System.out.println(obj.getAverageTime("Leyton","Waterloo"));
        obj.checkIn(10,"Leyton",24);
        System.out.println(obj.getAverageTime("Leyton","Waterloo"));
        obj.checkOut(10,"Waterloo",38);
        System.out.println(obj.getAverageTime("Leyton","Waterloo"));
    }

    public void checkIn(int id, String stationName, int t) {
       Map<String, Integer> travel = new HashMap<>();
       travel.put(stationName, t);
       checkIns.put(id, travel);
    }

    public void checkOut(int id, String stationName, int t) {
        Map<String, Integer> start = checkIns.get(id);
        String startStation = start.entrySet().iterator().next().getKey();
        int startTime = start.entrySet().iterator().next().getValue();

        String stationPair =  startStation + "#" + stationName;
        avgObjects.putIfAbsent(stationPair, new AvgObject());
        AvgObject obj = avgObjects.get(stationPair);
        obj.update(t - startTime);

        //remove from check ins to make things simpler. Since we have already considered this entry with corresponding checkout entry, we
        // can remove this.
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String pair = startStation + "#" + endStation;
        AvgObject avg = avgObjects.get(pair);
        return (double) avg.total / avg.count;
    }

    public _1396_DesignUndergroundSystem() {
        checkIns = new HashMap<>();
        avgObjects = new HashMap<>();
    }

}
