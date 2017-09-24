package calculator_soter;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter {
    public static String getSortLettersWithAppearTimes(String letters) {
        List<String> listLetters = Arrays.asList(letters.split(""));
        Map<String, Integer> mapLetters = getMapLetters(listLetters);
        return format(mapLetters);

    }

    public static Map<String, Integer> getMapLetters(List<String> list) {
        Map<String, Integer> mapLetters = new LinkedHashMap<>();
        list.stream().
                forEach(item -> mapLetters.put(item, mapLetters.containsKey(item) ? mapLetters.get(item) + 1 : 1));
        return mapLetters;
    }

    public static String format(Map<String, Integer> mapLetters) {
        return mapLetters.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(item -> item.getValue() + "(" + item.getKey() + ")")
                .collect(Collectors.joining("<"));

    }
}
