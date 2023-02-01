import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Set interface represents an unordered collection of unique elements.
        //SET VS LIST
        //Set unordered List ordered, Set unique List non unique

        //implementation
        Set set = new HashSet();

        //TreeSet -
        Set set2 = new TreeSet();

        //Good practice is always specify a generic type of set like:
        Set<String> setString = new HashSet<>();

        //to add element to set we need to use method ".add"
        set.add("Hello");

        Set<String> set3 = Set.of("Hello","World","100","||","Cos");
//        for (String s : set3) {
//            System.out.println(s);
//        }

//        //To sort element we need to use TreeSet like:
//        Set<String> sortedSet = new TreeSet<>();
//        sortedSet.add("7");
//        sortedSet.add("1");
//        sortedSet.add("112");
//        sortedSet.add("aga");
//        sortedSet.add("2");
//        sortedSet.add("Aga");
//        sortedSet.add("||");
//        for (String s : sortedSet) {
//            System.out.println(s);
//        }
//        //Remove element
//        sortedSet.remove("1");
//        for (String s : sortedSet) {
//            System.out.println(s + " -Deleted1");
//        }

        // Stwórz set Stringów, dodaj jakies elementy, zrob tak zeby wyswietlic je w
        // kolejnosci rosnacej
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("Jeden");
        stringSet.add("a");
        stringSet.add("c");
        stringSet.add("bcd");
        for (String s : stringSet) {
            System.out.println(s);
        }
        // Stworz mape gdzie kluczem jest String i wartoscia tez String, wyswietl cala mape za pomoca Entry
        Map<String,String> stringMap = new TreeMap<>();
        stringMap.put("1","Jeden");
        stringMap.put("2","Dwa");
        stringMap.put("3","Trzy");
        stringMap.put("4","Cztery");
        stringMap.put("5","Pięć");

        for(Map.Entry<String,String> entry:stringMap.entrySet()){
            System.out.println(entry.getKey()+ " : " + entry.getValue());
        }
        // Dodaj do mapy 4 slowa jako klucze, niech wartoscia bedzie dlugosc kazdego ze slow
        HashMap<String,Integer> valueIsLength = new HashMap<>();
        valueIsLength.put("a", "a".length());
        valueIsLength.put("abc","abc".length());
        valueIsLength.put("abcd","abcd".length());
        valueIsLength.put("bsasda","bsasda".length());

        for(String key : valueIsLength.keySet()){
            System.out.println("slowo: " + key + " ,dlugosc: " +valueIsLength.get(key));
        }
        //test

        HashMap<Integer, String> mapFromMethod = new HashMap<>();
        String[] words = {"jeden", "dwa", "Trzy", "Cztery"};

        addWordsToMap(words,mapFromMethod);
        for(int key : mapFromMethod.keySet()){
            System.out.println("Klucz: " +key + " ,wartość: " +mapFromMethod.get(key));
        }

    }
    public static void addWordsToMap(String[] words,HashMap<Integer,String> map){
        for(int i = 0; i<words.length;i++){
            map.put(i,words[i]);
        }


    }
}