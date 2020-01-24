package pl.b2b.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlData {

    private static String url = "jdbc:mysql://localhost:3306/testy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    public static void sendToBase(String name, String surname, String address, String amount, String title, String result) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "insert into testowa values (null, '%s', '%s', '%s', '%s', '%s', '%s')";
            sql = String.format(sql, name, surname, address, amount, title, result); // String.format podmienia nam '%s' na podane przez nas zmienne
            statement.executeUpdate(sql);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void takeFromBase(String name, String surname, String address, String amount, String title, String result) {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "select name, surname, address, amount, title from testowa where id=1";
//            sql = String.format(sql, name, surname, address, amount, title, result); // String.format podmienia nam '%s' na podane przez nas zmienne
//            statement.executeUpdate(sql);
            statement.getResultSet();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}