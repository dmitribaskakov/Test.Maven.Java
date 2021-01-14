package home.test;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    public static void main(String... args) throws Exception {
        System.out.println("Hello world !");

        StringWraper a = new StringWraper("aaa");
        System.out.print("source a : ");
        System.out.println(a.string);
        StringWraper b = new StringWraper("bbb");
        System.out.print("source b : ");
        System.out.println(b.string);

        Swap(a, b);
        System.out.println("swap a <-> b");
        System.out.print("result a : ");
        System.out.println(a.string);
        System.out.print("result b : ");
        System.out.println(b.string);
    }


    public static class StringWraper {
        public String string;
        StringWraper (String in) {
            string = in;
        }
    }

    public static void Swap (StringWraper a, StringWraper b) {
        String c;
        c = a.string;
        a.string = b.string;
        b.string = c;
    }
}


