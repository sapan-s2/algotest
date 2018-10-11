import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortIntegerArray {

    public static void main(String[] args) {

        int arr[] = {1, 1, 2, 4, 4, 4, 3, 3, 3, 3};
        SortIntegerArray sortIntegerArray = new SortIntegerArray();
        final HashMap<Integer, Integer> integerIntegerHashMap = sortIntegerArray.countFreq(arr);
        ValueComparator valueComparatorMap = new ValueComparator(integerIntegerHashMap);
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(valueComparatorMap);
        treeMap.putAll(integerIntegerHashMap);

        System.out.println("sorted map :");
        treeMap.entrySet().stream()
                .forEach(System.out::println);

        System.out.println("java 8 way");
        final HashMap<Integer, Integer> collect = integerIntegerHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        HashMap::new
                ));

        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int j = 0; j < value; j++) {
                System.out.println(key);
            }
        }

    }

    private HashMap<Integer, Integer> countFreq(int[] inputArray) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : inputArray) {
            if (map.containsKey(i)) {

                map.put(i, map.get(i) + 1);

            } else {
                map.put(i, 1);
            }

        }

        return map;
    }


}


class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

    HashMap<K, V> map = new HashMap<K, V>();

    public ValueComparator(HashMap<K, V> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(K s1, K s2) {
        return map.get(s1).compareTo(map.get(s2));//descending order
    }
}