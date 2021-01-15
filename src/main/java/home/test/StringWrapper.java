package home.test;

public class StringWrapper {
    public String string;

    StringWrapper(String in) {
        string = in;
    }

    public void swap(StringWrapper other) {
        String tempString;
        tempString = string;
        string = other.string;
        other.string = tempString;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (!(other instanceof StringWrapper)) return false;
        StringWrapper testOther = (StringWrapper) other;
        return this.string != null
                && this.string.equals(testOther.string);
    }

    @Override
    public String toString() {
        return string;
    }

    public static void test() {
        StringWrapper a = new StringWrapper("aaa");
        System.out.println("source a : " + a.string);
        StringWrapper b = new StringWrapper("bbb");
        System.out.println("source b : " + b.string);
        StringWrapper c = new StringWrapper("bbb");

        a.swap(b);
        System.out.println("swap a <-> b");
        System.out.println("result a : " + a.string);
        System.out.println("result b : " + b.string);

        if (a.equals(c)) {
            System.out.println("a equals c");
        } else {
            System.out.println("a not equals c");
        }
        System.out.println("a.toString() : " + a.toString());
        System.out.println("a.hashCode() : " + a.hashCode());
        System.out.println("a.getClass() : " + a.getClass());
    }
}


