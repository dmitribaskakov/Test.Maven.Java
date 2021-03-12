package home.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import home.test.core.User;
import home.test.jdbc.QueryExecutor;
import home.test.jdbc.ResultHandler;

public class JdbcExample {

    public void someMethod(){
        // В примере ниже и a и b - effectively final, тк значения устанавливаютcя однажды:
        final int a = 1;
        final int b;
        if (a == 2) b = 3;
        else b = 4;
        // с НЕ является effectively final, т.к. значение изменяется
        int c = 10;
        c++;

        Stream.of(1, 2).forEach(s-> System.out.println(s + a)); //Ок
        //Stream.of(1, 2).forEach(s-> System.out.println(s + c)); //Ошибка компиляции
    }

    public static void test () throws SQLException, ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://0.0.0.0:5432/demo_db1","trackuser", "trackuser");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

//        if (true) {
//            System.out.println("It's ok");
//            return;
//        }

        Statement stmt;
        String sql;
        ResultSet rs;

        stmt = connection.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS company" +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " AGE            INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " SALARY         REAL)";
        stmt.executeUpdate(sql);
        stmt.close();

        connection.setAutoCommit(false);
        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        if (!rs.next()) {
            rs.close();
            stmt.close();

            stmt = connection.createStatement();
            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
        }

        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();

        stmt = connection.createStatement();
        sql = "UPDATE COMPANY SET SALARY = 25000.00 WHERE ID=1;";
        stmt.executeUpdate(sql);
        stmt.close();
        connection.commit();

        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();

        stmt = connection.createStatement();
        sql = "DELETE FROM COMPANY WHERE ID=2;";
        stmt.executeUpdate(sql);
        stmt.close();
        connection.commit();

        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();
        connection.close();

        if (true) {
            System.out.println("It's ok");
            return;
        }

//        PreparedStatement prepStmnt = c.prepareStatement("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );");
//        int parameterIndex = 234;
//        prepStmnt.setString(parameterIndex, "asd");
//        rs = prepStmnt.executeQuery();


        /**
         * Использование executor для запроса в базу
         */
        QueryExecutor exec = new QueryExecutor();
        List<User> users = exec.execQuery(connection, "SELECT * FROM users;", (rset) -> {
            System.out.println("handle:");
            List<User> data = new ArrayList<>();
            while (rset.next()) {
                User user = new User();
                user.setName(rset.getString(2));
                data.add(user);
            }
            return data;
        });

        System.out.println(users.toString());


        /**
         * Использование prepared executor для запроса в базу
         */
        Map<Integer, Object> prepared = new HashMap<>();
        prepared.put(1, "John");

        users = exec.execQuery(connection, "SELECT * FROM users WHERE name = ?;", prepared, (rset) -> {
            System.out.println("handle:");
            List<User> data = new ArrayList<>();
            while (rset.next()) {
                User user = new User();
                user.setName(rset.getString(2));
                data.add(user);
            }
            return data;
        });

        System.out.println(users.toString());

    }

}
