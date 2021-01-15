package home.test;

import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    public static void main(String... args) throws Exception {
        System.out.println("Hello world !");

        StringWraper a = new StringWraper("aaa");
        System.out.println("source a : " + a.string);
        StringWraper b = new StringWraper("bbb");
        System.out.println("source b : " + b.string);
        StringWraper c = new StringWraper("bbb");

        Swap(a, b);
        System.out.println("swap a <-> b");
        System.out.println("result a : " + a.string);
        System.out.println("result b : " + b.string);

        if (a.equals(c)) {
            System.out.println("a equals c");
        } else {
            System.out.println("a not equals c");
        }
    }

    public static class StringWraper {
        public String string;
        StringWraper (String in) {
            string = in;
        }

        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (!(other instanceof StringWraper)) return false;
            StringWraper testOther = (StringWraper) other;
            return this.string != null
                    && this.string.equals(testOther.string);
        }
    }

    public static void Swap (StringWraper a, StringWraper b) {
        String c;
        c = a.string;
        a.string = b.string;
        b.string = c;
    }
}


