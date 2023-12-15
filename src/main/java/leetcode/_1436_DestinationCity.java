package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1436_DestinationCity {

    public static void main(String[] args) {
        _1436_DestinationCity obj = new _1436_DestinationCity();

        List<List<String>> paths = List.of(
                List.of("London","New York"),
                List.of("New York","Lima"),
                List.of("Lima","Sao Paulo")

        );
        System.out.println(obj.destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        Set<String> nodesWithOutgoingEdge = new HashSet<>();
        for (List<String> path : paths) {
            nodesWithOutgoingEdge.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!nodesWithOutgoingEdge.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
