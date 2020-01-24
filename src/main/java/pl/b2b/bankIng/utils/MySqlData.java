package pl.b2b.bankIng.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlData {
    private static String url = "jdbc:mysql://localhost:3306/testy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    public static void sendToBase(String name, String surname, String address, String amount, String title, String result) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "insert into testowa values (null, '%s', '%s', '%s', '%s', '%s', '%s')";
            sql = String.format(sql, name, surname, address, amount, title, result);
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Object[]> getFromBase() {
        List<Object[]> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "select name, surname, address, title from customerData limit 3;";
            statement.execute(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String address = rs.getString("address");
                String title = rs.getString("title");

                Object ob[] = {name, surname, address, title};
                list.add(ob);

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
