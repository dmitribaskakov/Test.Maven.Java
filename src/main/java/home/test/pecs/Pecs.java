package home.test.pecs;

import java.util.ArrayList;

class A {
    @Override
    public String toString() {
        return "Class A";
    }
}

class B extends A {
    @Override
    public String toString() {
        return "Class B";
    }
}

class C extends B {
    @Override
        public String toString() {
        return "Class C";
    }
}

class D extends C {
    @Override
    public String toString() {
        return "Class D";
    }
}

public class Pecs {

    public static void test () {
        System.out.println("Ковариантность:");
        Stack<A> stackA = new Stack<>();
        ArrayList<B> arrayB = new ArrayList<>();
        arrayB.add(new B());
        stackA.pushAll(arrayB);
        for (B stB: arrayB) {
            System.out.println("stB " + stB.toString());
        }

        System.out.println("Контравариантность:");
        Stack<C> stackC = new Stack<>();
        ArrayList<A> arrayA = new ArrayList<>();
        stackC.push(new C());
        stackC.popAll(arrayA);
        for (A stA: arrayA) {
            System.out.println("stA " + stA.toString());
        }

    }
}
