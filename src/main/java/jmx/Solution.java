package jmx;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static final String SOURCE_STATION_NAME = "Montgomery St.";

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        FindUpComingTrainTask trainTask = new FindUpComingTrainTask(SOURCE_STATION_NAME);
        trainTask.findNPrintUpComingTrains();
    }

    class FindUpComingTrainTask {

        private final String _sourceStation;
        private static final int COUNT = 10;
        private static final String KEY = "MW9S-E7SL-26DU-VV8V";

        FindUpComingTrainTask(String sourceStation) {
            Objects.requireNonNull(sourceStation);
            _sourceStation = sourceStation;
        }

        void findNPrintUpComingTrains() {
            String stationCode = fetchStationCodeForName();
            fetchNPrintRealTimeEstimates(stationCode);
        }

        private void fetchNPrintRealTimeEstimates(String stationCode) {
            String realTimeEstimateURL = "http://api.bart.gov/api/etd.aspx?cmd=etd&orig="+ stationCode +"&key="+ KEY +"&json=y";
            String realTimeInfo = readFromURL(realTimeEstimateURL);

            if (realTimeInfo == null || realTimeInfo.trim().length() == 0) {
                throw new RuntimeException("Empty response from service call.");
            }

            JSONDeserializer deserializer = new JSONDeserializer(realTimeInfo);
            JSONObject realTimeInfoObject = deserializer.parseJSON();

            JSONArray stationArray = (JSONArray) ((JSONObject)realTimeInfoObject.get("root")).get("station");

            for (Object station : stationArray) {
                JSONArray etdArray = (JSONArray) ((JSONObject) station).get("etd");

                List<DestinationTimeMap> destinationList = new ArrayList<>();
                for (Object etd : etdArray) {
                    String destination = (String)((JSONObject) etd).get("destination");
                    JSONArray estimateArray = (JSONArray)((JSONObject) etd).get("estimate");

                    for (Object estimate : estimateArray) {
                        String minutes = (String)((JSONObject) estimate).get("minutes");
                        destinationList.add(new DestinationTimeMap(destination, Integer.parseInt(minutes)));
                    }
                }

                Collections.sort(destinationList);

                System.out.println("------------------------------------------------");
                System.out.println(SOURCE_STATION_NAME);
                System.out.println("------------------------------------------------");

                int recordCount = COUNT;
                if (destinationList.size() < COUNT) {
                    recordCount = destinationList.size();
                }

                destinationList.subList(0, recordCount).forEach(d -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(d._time).append(" min ").append(d._destination).append(System.lineSeparator());
                    System.out.print(builder);
                });
            }
        }

        private String fetchStationCodeForName() {
            String stationInfoURL = "http://api.bart.gov/api/stn.aspx?cmd=stns&key="+ KEY +"&json=y";
            String stationInfo = readFromURL(stationInfoURL);

            if (stationInfo == null || stationInfo.trim().length() == 0) {
                throw new RuntimeException("Empty response from service call.");
            }

            JSONDeserializer deserializer = new JSONDeserializer(stationInfo);
            JSONObject stnInfoObject = deserializer.parseJSON();

            JSONObject stationsObject = (JSONObject) ((JSONObject)stnInfoObject.get("root")).get("stations");
            JSONArray stationArray =  (JSONArray) stationsObject.get("station");

            for (Object station : stationArray) {
                JSONObject stationJSONObj = (JSONObject)station;
                if (((String)stationJSONObj.get("name")).equalsIgnoreCase(_sourceStation)) {
                    return (String)stationJSONObj.get("abbr");
                }
            }
            throw new RuntimeException("No code found for station name: " + _sourceStation);
        }

        private String readFromURL(final String destinationURL) {
            URL url;
            try {
                url = new URL(destinationURL);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid URL.", e);
            }

            URLConnection urlConnection;
            try {
                urlConnection = url.openConnection();
                urlConnection.connect();
            } catch (IOException e) {
                throw new RuntimeException("Error opening connection.", e);
            }

            try(BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                return br.lines().collect(Collectors.joining());
            } catch (IOException e) {
                throw new RuntimeException("Error reading response", e);
            }
        }
    }

    class JSONDeserializer {

        private String _contentToParse;

        JSONDeserializer(String contentToParse) {
            Objects.requireNonNull(contentToParse);
            _contentToParse = contentToParse;
        }

        private JSONObject parseJSON() {
            JSONParser parser = new JSONParser();
            try {
                return  (JSONObject) parser.parse(_contentToParse);
            } catch (ParseException e) {
                throw new RuntimeException("Error parsing JSON response", e);
            }
        }
    }

    class DestinationTimeMap implements Comparable<DestinationTimeMap> {
        private final String _destination;
        private final int _time;

        DestinationTimeMap(String destination, int time) {
            _destination = destination;
            _time = time;
        }

        @Override
        public int compareTo(DestinationTimeMap o) {
            return Integer.compare(this._time, o._time);
        }
    }
}
