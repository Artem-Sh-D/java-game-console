package function;

import npc.Npc;
import function.FightFunction;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateSend {

    private static String url = "jdbc:postgresql://localhost/thisBase";
    private static String userName = "postgres";
    private static String password = "admin";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DateSend.url = url;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DateSend.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DateSend.password = password;
    }

    public static void dataSend(Npc npc) throws SQLException {
        String query = "INSERT INTO gameresult (RESULT_FIGHT,ENEMY,DATEGAME) VALUES (" + FightFunction.getResult() + ","
                + "\'" + npc.getName() + "\'" + "," + "\'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "\'" + ")";
        Connection connection1 = DriverManager.getConnection(url,userName,password);
        Statement statement = connection1.createStatement();
        statement.executeQuery(query);
        statement.close();
        connection1.close();
    }

}
