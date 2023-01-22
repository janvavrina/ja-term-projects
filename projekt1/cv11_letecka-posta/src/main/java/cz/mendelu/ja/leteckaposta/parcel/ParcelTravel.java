package cz.mendelu.ja.leteckaposta.parcel;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParcelTravel {
    public List<String> traveler(String start, String end, Map<String, List<String>> graph) {
        // Create a queue to store the list of countries to visit
        Queue<String> queue = new LinkedList<>();
        // Create a Set to store the visited countries
        Set<String> visited = new HashSet<>();
        // Add the starting country (location) to the queue
        queue.add(start);
        // Create a list to store the path
        List<String> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                return path;
            }
            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    path.add(neighbor);
                }
            }
        }
        return null;
    }
}
