
import npc.*;
import function.*;
import maincharacter.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException, SQLException {
        // Начало игры
        Hero hero = new Hero();
        DataGet.dataGet(hero);
        System.out.println("Добро пожаловать в игру!");
        Thread.sleep(1000);



        System.out.println("Загрузка врагов...");
        Thread.sleep(1000);

        Bear bear = new Bear("Бурый",50,5,2);
        Skelet skelet = new Skelet("Скелет",65,6,1);
        Ogr ogr = new Ogr("Oгр",75,8,5);


        System.out.println("Начало вашего приключения... Вы начинаете свой путь в столице и двигаете в западным воротам. Выходя из ворот вы двигаете в сторону леса... Но вдруг на пути вам встречается медведь!!!");
        Thread.sleep(1000);

        //Начинается бой
        System.out.println("Первый бой!");




        FightFunction.fight(bear,hero);
        FightFunction.lvlUp(hero);

        System.out.println("Далее вам повстречался скелет....");
        Thread.sleep(1000);

        FightFunction.fight(skelet,hero);
        FightFunction.lvlUp(hero);

        System.out.println("Далее вам повстречался огр....");
        Thread.sleep(1000);

        FightFunction.fight(ogr,hero);


        System.out.println("Поздравляю вы прошли игру!!!");

        /*String url1 = "jdbc:postgresql://localhost/thisBase";
        String userName = "postgres";
        String password = "admin";
        String query = "INSERT INTO hero (HERO_NAME,HERO_HEATH,HERO_ATTACK,HERO_GUARD,HERO_STAMINA) VALUES ("
                + "\'Maxim\'" + "," + hero.getHealthPoint() + "," + hero.getAttackPoint() + "," + hero.getGuardPoint() + ","
                + hero.getStaminaPoint() + ")";
        Connection connection1 = DriverManager.getConnection(url1,userName,password);
        Statement statement = connection1.createStatement();
        statement.executeQuery(query);
        statement.close();
        connection1.close();*/

    }
}