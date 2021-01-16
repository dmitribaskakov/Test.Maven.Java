package home.test;

interface Printable {
    void Print(java.io.PrintStream stream);
}
abstract class Account implements Printable {
    private static int count = 0;
    int id;
    String name;

    Account(String name) {
        id = count++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account> "+ id +": "+name;
    }

    public void Print(java.io.PrintStream stream) {
        stream.println("Account / " + toString());
    }
}

class User extends Account {
    User(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "User> "+ id +": "+name;
    }

    @Override
    public void Print(java.io.PrintStream stream) {
        stream.println("User / " + toString());
    }

}
class Admin extends User {
    Admin(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Admin> "+ id +": "+name;
    }

    @Override
    public void Print(java.io.PrintStream stream) {
        stream.println("Admin / " + toString());
    }

}

public class Polymorph {

    public static void test() {
        User userIvanov = new User("Ivanov");
        User userPetrov = new Admin("Petrov");
        Admin adminSidorov = new Admin("Sidorov");
        Printable printable;

        System.out.println("Polymorph test:");

        System.out.println("userIvanov:" + userIvanov.toString());
        userIvanov.Print(System.out);
        printable = userIvanov;
        printable.Print(System.out);

        System.out.println("userPetrov:" + userPetrov.toString());
        userPetrov.Print(System.out);
        printable = userPetrov;
        printable.Print(System.out);

        System.out.println("adminSidorov:" + adminSidorov.toString());
        adminSidorov.Print(System.out);
        printable = adminSidorov;
        printable.Print(System.out);
    }
}

