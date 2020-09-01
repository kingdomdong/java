package com.king.java8;

import com.king.classes.Subject;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * Multiple List to Map
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-06-14
 */
public class MultiListToMap {

    public static void main(String[] args) {
        MultiListToMap classMap = new MultiListToMap();
        classMap.listReduceToMap1();
        classMap.listReduceToMap2();
        classMap.listReduceToMap3();
    }

    public void listReduceToMap1() {
        Subject subject1 = new Subject(45, 57, 0, 0, 52, 41);
        Subject subject2 = new Subject(54, 57, 90, 72, 0, 31);
        List<Subject> subjects = Arrays.asList(subject1, subject2);
        // output: List<Map>
        // [{math=45}, {physics=57}, {chemistry=0}, {history=0}, {economics=52}, {biology=41}, {math=54}, {physics=57}, {chemistry=90}, {history=72}, {economics=0}, {biology=31}]
        Stream<Map<String, Integer>> collect = subjects.stream().flatMap(subject -> Arrays.stream(Subject.class.getFields()).map(field -> {
            try {
                field.setAccessible(true);
                return new HashMap<String, Integer>() {{
                    put(field.getName(), (Integer) field.get(subject));
                }};
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                field.setAccessible(false);
            }
        }));

        /*
           flatMap(...stream()) is a stream of "ONE k-v List", while map(...stream()) is a stream of "MULTIPLE k-v Group List"
         */
//        Stream<Object> x = collect.map(m -> new ArrayList<>(m.entrySet())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum)); // error
//        List<ArrayList<Map.Entry<String, Integer>>> x = collect.map(m -> new ArrayList<>(m.entrySet())).collect(toList()); // array list with 12 elements

//        List<Stream<Map.Entry<String, Integer>>> streamList = collect.map(m -> m.entrySet().stream()).collect(toList());

        // output: Map
        // {chemistry=90, economics=52, biology=72, physics=114, history=72, math=99}
        Stream<Map.Entry<String, Integer>> entryStream = collect.flatMap(m -> m.entrySet().stream());
        System.out.println(entryStream.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum)));
    }

    public void listReduceToMap2() {
        Map<String, Long> map = new HashMap<>();
        map.put("Apple", 2L);
        map.put("Banana", 2L);

        Map<String, Long> map1 = new HashMap<>();
        map1.put("Apple", 2L);
        map1.put("Orange", 2L);

        Map<String, Long> map2 = new HashMap<>();
        map1.put("Banana", 2L);
        map1.put("Guava", 2L);

        List<Map<String, Long>> mapList = new ArrayList<>();
        mapList.add(map);
        mapList.add(map1);
        mapList.add(map2);

        // output:
        // {Guava=2, Apple=4, Orange=2, Banana=4}
        Map<String, Long> reduce = mapList.stream()
                .reduce((firstMap, secondMap) -> Stream.concat(firstMap.entrySet().stream(), secondMap.entrySet().stream())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum)))
                .orElse(new HashMap<>());
        System.out.println(reduce);

        Map<String, Long> longMap = mapList.stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum));
        System.out.println(longMap);
    }

    public void listReduceToMap3() {
        //Map-1
        HashMap<String, Integer> subjectToStudentCountMap1 = new HashMap<>();
        subjectToStudentCountMap1.put("Maths", 45);
        subjectToStudentCountMap1.put("Physics", 57);
        subjectToStudentCountMap1.put("Chemistry", 52);
        subjectToStudentCountMap1.put("History", 41);
        //Map-2

        HashMap<String, Integer> subjectToStudentCountMap2 = new HashMap<>();
        subjectToStudentCountMap2.put("Economics", 49);
        subjectToStudentCountMap2.put("Maths", 42);
        subjectToStudentCountMap2.put("Biology", 41);
        subjectToStudentCountMap2.put("History", 55);

        //Merging Map-1 and Map-2 into Map-3
        //If any two keys are found same, their values are added

        HashMap<String, Integer> subjectToStudentCountMap3 = new HashMap<>(subjectToStudentCountMap1);
        subjectToStudentCountMap2.forEach((key, value) -> subjectToStudentCountMap3.merge(key, value, Integer::sum));

        System.out.println("Map 1 : " + subjectToStudentCountMap1);
        System.out.println("Map 2 : " + subjectToStudentCountMap2);
        System.out.println("Map 3 : " + subjectToStudentCountMap3);
    }

}
