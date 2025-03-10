import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReisePlaner reisePlaner = new ReisePlaner();
        reisePlaner.addDestination("Berlin");
        reisePlaner.addDestination("Paris");
        reisePlaner.addDestination("Rom");
        reisePlaner.updateDestination(1, "London");
        System.out.println("Reiseplan: " + reisePlaner.getRoute());

        WortBewertung wortBewertung = new WortBewertung();
        wortBewertung.addWord("Haus");
        wortBewertung.addWord("Auto");
        wortBewertung.addWord("Baum");
        System.out.println("Bewertete Wörter: " + wortBewertung.getSortedWords());

        Autorennen autorennen = new Autorennen();
        autorennen.addLapTime("Auto1", 10);
        autorennen.addLapTime("Auto1", 12);
        autorennen.addLapTime("Auto2", 9);
        autorennen.addLapTime("Auto2", 11);
        System.out.println("Durchschnittszeiten: " + autorennen.getAverageTimes());
    }
}

class ReisePlaner {
    private List<String> route = new ArrayList<>();

    public void addDestination(String destination) {
        route.add(destination);
    }

    public void updateDestination(int index, String newDestination) {
        if (index >= 0 && index < route.size()) {
            route.set(index, newDestination);
        }
    }

    public List<String> getRoute() {
        return route;
    }
}

class WortBewertung {
    private Map<String, Integer> wordScores = new HashMap<>();

    public void addWord(String word) {
        int score = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if (c != 'a') {
                score++;
            }
        }
        wordScores.put(word, score);
    }

    public List<String> getSortedWords() {
        return wordScores.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }
}

class Autorennen {
    private Map<String, List<Integer>> raceTimes = new HashMap<>();

    public void addLapTime(String car, int time) {
        raceTimes.putIfAbsent(car, new ArrayList<>());
        raceTimes.get(car).add(time);
    }

    public Map<String, Double> getAverageTimes() {
        Map<String, Double> avgTimes = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : raceTimes.entrySet()) {
            List<Integer> times = entry.getValue();
            if (times.size() > 1) {
                double avg = times.subList(1, times.size())
                        .stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0);
                avgTimes.put(entry.getKey(), avg);
            }
        }
        return avgTimes;
    }
}
