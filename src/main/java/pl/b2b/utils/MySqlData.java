package pl.b2b.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlData {
    private static String url = "jdbc:mysql://localhost:3306/testowanie?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    public static void sendToBase(boolean result,String name, String surname, String adres, String cash, String title){
        String testResult;
    try {
        if(result)
        {
            testResult = "Pozytywny";
        }else{
            testResult = "Negatywny";
        }
        Connection con = DriverManager.getConnection(url, user, password);
        Statement statement = con.createStatement();
        String sql = "insert into testy values(NULL,'%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql, name, surname, adres,cash,title,testResult);
        statement.executeUpdate(sql);
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public String getIdFromBase() {
        String id="";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "select id_uruchomienia from skrypty_monitorujace where grupa = 'sanity' order by ID desc limit 1";
            Statement statement = con.createStatement();
            statement.execute(sql);
            ResultSet rs = statement.getResultSet();
            if (rs.next()) {
                id = rs.getString("id_uruchomienia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int id_nr = Integer.parseInt(id);
        id_nr = id_nr+1;
        id = String.valueOf(id_nr);
        return id;
    }
}
