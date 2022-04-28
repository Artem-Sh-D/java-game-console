package function;

import maincharacter.*;

import java.sql.*;

public class DataGet {

    private static String url = "jdbc:postgresql://localhost/thisBase";
    private static String userName = "postgres";
    private static String password = "admin";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void dataGet(Hero hero) throws SQLException {

        String query = "SELECT HERO_NAME,HERO_HEATH,HERO_ATTACK,HERO_GUARD,HERO_STAMINA from hero";
        Connection connection1 = DriverManager.getConnection(url,userName,password);
        Statement statement = connection1.createStatement();
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        hero.setName(rs.getString("HERO_NAME"));
        hero.setHealthPoint(rs.getInt("HERO_HEATH"));
        hero.setAttackPoint(rs.getInt("HERO_ATTACK"));
        hero.setGuardPoint(rs.getInt("HERO_GUARD"));
        hero.setStaminaPoint(rs.getInt("HERO_STAMINA"));
        statement.close();
        connection1.close();

    }
}
