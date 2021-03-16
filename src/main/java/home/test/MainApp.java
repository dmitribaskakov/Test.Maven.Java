package home.test;

import home.test.functionality.Functionaled;
import home.test.pecs.Pecs;
import org.apache.camel.main.Main;
import home.test.jdbc.JdbcExample;
import home.test.store.StoreSample;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.stream.Stream;

import java.util.function.Predicate;


/**
 * A Camel Application
 */
public class MainApp {


    public static void main(String... args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello world !");

        // StringWrapper.test();
        // Polymorph.test();
        // Pecs.test();
        // new OverridingTest.Child();
        // Functionaled.test();

        StoreSample.test();

//        JdbcExample j = new JdbcExample();
//        j.someMethod();
//        JdbcExample.test();

//        ArrayList<String> states = new ArrayList<String>();
//        states.add("Germany");
//        states.add("France");
//        states.add("Italy");
//        states.add("Spain");
//
//        ListIterator<String> listIter = states.listIterator();
//
//        while(listIter.hasNext()){
//
//            System.out.println(listIter.next());
//        }
//        // сейчас текущий элемент - Испания
//        // изменим значение этого элемента
//        listIter.set("Португалия");
//        System.out.println("пройдемся по элементам в обратном порядке");
//        while(listIter.hasPrevious()){
//
//            System.out.println(listIter.previous());
//        }

//        Predicate<Integer> isPositive = x -> x > 0;
//
//        System.out.println(isPositive.test(5)); // true
//        System.out.println(isPositive.test(-7)); // false
    }

}


