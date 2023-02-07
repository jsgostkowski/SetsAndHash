import java.lang.reflect.Array;
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

        Set<String> set3 = Set.of("Hello", "World", "100", "||", "Cos");
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
        Map<String, String> stringMap = new TreeMap<>();
        stringMap.put("1", "Jeden");
        stringMap.put("2", "Dwa");
        stringMap.put("3", "Trzy");
        stringMap.put("4", "Cztery");
        stringMap.put("5", "Pięć");

        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        // Dodaj do mapy 4 slowa jako klucze, niech wartoscia bedzie dlugosc kazdego ze slow
        HashMap<String, Integer> valueIsLength = new HashMap<>();
        valueIsLength.put("a", "a".length());
        valueIsLength.put("abc", "abc".length());
        valueIsLength.put("abcd", "abcd".length());
        valueIsLength.put("bsasda", "bsasda".length());

        for (String key : valueIsLength.keySet()) {
            System.out.println("slowo: " + key + " ,dlugosc: " + valueIsLength.get(key));
        }
        //test
        // Napisz metode ktora pozwala dodawac do mapy kolejne wyrazy. Na koncu ma
        // wyswietlic ile razy jaki element byl dodany

        HashMap<Integer, String> mapFromMethod = new HashMap<>();
        String[] words = {"jeden", "dwa", "Trzy", "Cztery"};

        addWordsToMap(words, mapFromMethod);
        for (int key : mapFromMethod.keySet()) {
            System.out.println("Klucz: " + key + " ,wartość: " + mapFromMethod.get(key));
        }

        // Napisz program, ktory losuje liczby w duzym lotku bez powtorzen, zakres liczb 1-45
        HashSet<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            int number = random.nextInt(45) + 1;
            numbers.add(number);
        }

        System.out.println("Random numbers: " + numbers);
        // napisz metode ktora przyjmuje Mape<Integer, String>, zamien wartosci ktorych
        // klucze sa parzystych wartosci
        // na słowo "parzyste"
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "aaa");
        testMap.put(2, "aaa");
        testMap.put(4, "aaa");
        testMap.put(5, "aaa");
        isDivineByTwo(testMap);
        System.out.println(testMap);

        // W systemie przechowujemy nazwe klasy (szkolnej, np 1a, 2b) oraz listę osób
        // (same nazwiska jako Stringi) które uczeszczaja do klasy.
        // 1) Napisz metode ktora zwraca liste osob o najdluzszych nazwiskach z kazdej klasy
        // 2) Napisz metode która zwraca osobe o najdluzszym nazwisku ze wzystkich klas
        Map<String, List<String>> classes = new HashMap<>();
        classes.put("1a", Arrays.asList("Kowalski", "Nowak", "Wiśniewski"));
        classes.put("2b", Arrays.asList("Kowalczyk", "Mazurasdasdasdasdasda", "Wójcik"));

        List<String> longestLastNamesPerClass = getLongestLastNameInClass(classes);
        System.out.println("Najdłuższe nazwiska z każdej klasy: " + longestLastNamesPerClass);
        String longestLastName = getLongestLastNamePersoninClass(classes);
        System.out.println("Najdłuższe nazwisko ze wszystkich klas: " + longestLastName);


        // Napisz program, ktory symuluje dzialanie slownika
        // polsko-angielskiego. Przykładowy program: Podaj slowko po Polsku: mama Slowko
        // po Angielsku to mother. Program dziala dopoki uzytkownik nie zrezygnuje
        // (cancel)
        Map<String, String> dictionary = new TreeMap<>();
        dictionary.put("mama", "mother");
        dictionary.put("syn", "son");
        dictionary.put("pies", "dog");
        dictionary.put("kot", "cat");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Aby zakonczyc dzialanie programu nalezy wpisac slowo 'koniec' ");
        System.out.println("Podaj słowo do przetłumaczenia: ");
        while (true) {
            String wordInPolish = scanner.nextLine();
            if (wordInPolish.equals("koniec")) {
                break;
            }
            if (dictionary.containsKey(wordInPolish)) {
                System.out.println("Tłumaczenie słowa: " + wordInPolish + " = " + dictionary.get(wordInPolish));
            } else {
                System.out.println("Nie znaleziono tlumaczenia");
            }
            System.out.println("Podaj kolejne slowo po polsku");

        }
        System.out.println("koniec programu");
        scanner.close();

    }


    public static String getLongestLastNamePersoninClass(Map<String, List<String>> schoolClass) {
        String personWithLongestLastName = null;
        int maxLength = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : schoolClass.entrySet()) {
            List<String> lastName = entry.getValue();
            for (String s : lastName) {
                if (s.length() > maxLength) {
                    maxLength = s.length();
                    personWithLongestLastName = s;
                }
            }
        }
        return personWithLongestLastName;
    }

    public static List<String> getLongestLastNameInClass(Map<String, List<String>> classes) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : classes.entrySet()) {
            List<String> lastNames = entry.getValue();
            String longestLastName = null;
            int maxLength = Integer.MIN_VALUE;
            for (String lastName : lastNames) {
                if (lastName.length() > maxLength) {
                    maxLength = lastName.length();
                    longestLastName = lastName;
                }

            }
            result.add(longestLastName);
        }
        return result;
    }

    public static void isDivineByTwo(Map<Integer, String> map) {
        for (int i : map.keySet()) {
            if (i % 2 == 0) {
                map.replace(i, "parzysta");
            }
        }
    }

    public static void addWordsToMap(String[] words, HashMap<Integer, String> map) {
        for (int i = 0; i < words.length; i++) {
            map.put(i, words[i]);
        }


    }
}