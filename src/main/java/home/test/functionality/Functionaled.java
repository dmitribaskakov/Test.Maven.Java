package home.test.functionality;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

public class Functionaled {

    public static void test () {
        System.out.println("Functionaled test:");

        List<String> names = Arrays.asList("petr", "anna", "mike", "xenia", "ivan");

        System.out.println("1: ");
        for (String item: names) {
            System.out.print(item + " ");
        }
        System.out.println("");

//        System.out.println("2: ");
//        names.sort(new Comparator<String>(){
//            @Override
//            public int compare(String a, String b){
//                return a.compareTo(b);
//            }
//        });
//        for (String item: names) {
//            System.out.print(item + " ");
//        }
//        System.out.println("");
//        System.out.println("3: ");
//        names.sort((String a, String b) -> {
//            return a.compareTo(b);
//        });
//        for (String item: names) {
//            System.out.print(item + " ");
//        }
//        System.out.println("");

        System.out.println("4: ");
        names.sort((String a, String b) -> a.compareTo(b));
        for (String item: names) {
            System.out.print(item + " ");
        }
        System.out.println("");

        System.out.println("Functionalinterface: ");

//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer converted = converter.convert("123");

        Something something = new Something();
        Converter<String,String> converter = something::startsWith;
        String converted = converter.convert("Java");

        System.out.println("converted="+converted);

//        Predicate<String> predicate = s -> s.length() > 0;
//        System.out.println("predicate="+ predicated);

        Stream.iterate(2, x -> x * 2)
                .limit(10)
                .forEach(System.out::println);


    }
}
