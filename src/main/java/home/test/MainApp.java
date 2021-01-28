package home.test;

import home.test.functionality.Functionaled;
import home.test.pecs.Pecs;
import org.apache.camel.main.Main;
import home.test.jdbc.JdbcExample;

import java.sql.SQLException;

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
        JdbcExample.test();
    }

}


