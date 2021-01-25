package home.test.functionality;

import java.util.*;


@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
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

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        converted = converter.convert("333");
        System.out.println("converted="+converted);

    }
}
