package function;

import maincharacter.*;
import npc.*;

import java.sql.SQLException;
import java.util.Scanner;

public class FightFunction {

    private static String result;

    public static String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static void fight(Npc npc, Hero hero) throws InterruptedException, SQLException {
        System.out.println("Бой начинается: " + npc.getName() + " VS " + hero.getName());

        System.out.println("Введите число от 10 до 100. Если после генерации это число будет больше 20, то вы атакуете первым.");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (npc.getHealthPoint() > 0) {
            if (hero.getHealthPoint() > 0) {
                if (Math.abs(number - Math.random() * 100) > 20) {
                    System.out.println("Вам выпало число " + number + ". " + hero.getName() + " атакует первым...");
                    specialReception(hero, npc);
                    Thread.sleep(1000);
                    if (Math.random() < 0.5) {
                        System.out.println("Теперь атакует " + npc.getName());
                        if (Math.random() > 0.5) {
                            hero.setHealthPoint(npc.specialReception1(hero.getHealthPoint(), hero.getGuardPoint()));
                        } else {
                            hero.setHealthPoint(npc.specialReception2(hero.getHealthPoint(), hero.getGuardPoint()));
                        }

                    } else {
                        System.out.println("Теперь атакует " + npc.getName());
                        hero.setHealthPoint(npc.normalHit(hero.getHealthPoint(), hero.getGuardPoint()));
                        Thread.sleep(1000);
                    }
                } else {
                    System.out.println("Вам выпало число " + number + ". " + npc.getName() + " атакует первым...");
                    hero.setHealthPoint(npc.normalHit(hero.getHealthPoint(), hero.getGuardPoint()));
                    Thread.sleep(1000);
                    System.out.println("Теперь атакует " + hero.getName());
                    npc.setHealthPoint(hero.normalHit(npc.getHealthPoint(), npc.getGuardPoint()));
                    Thread.sleep(1000);
                }
            } else {
                result = "\'Lose\'";
                DateSend.dataSend(npc);
                System.out.println("Вы проиграли...");
                Thread.sleep(1000);
                System.exit(0);
            }

        }
        result = "\'Win\'";
        DateSend.dataSend(npc);
        System.out.println("Поздравляю вы выиграли !");
    }

    public static void lvlUp(Hero hero) throws InterruptedException {
        System.out.println("Вам доступно одно очко повышения уровня персонажа. Выберите характеристику которую вы хотите усилить: 1) Здоровье 2) Атака 3) Защита 4) Стамина");
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.next();
        switch (scan) {
            case ("1"): {
                System.out.println("Вы усилили свое здоровье");
                Thread.sleep(1000);
                hero.setHealthPoint(hero.getHealthPoint() + (int) (Math.random() * 10));
                break;
            }
            case ("2"): {
                System.out.println("Вы усилили  свою атаку");
                Thread.sleep(1000);
                hero.setAttackPoint(hero.getAttackPoint() + (int) (Math.random() * 10));
                break;
            }
            case ("3"): {
                System.out.println("Вы усилили свою защиту");
                Thread.sleep(1000);
                hero.setGuardPoint(hero.getGuardPoint() + (int) (Math.random() * 10));
                break;
            }
            case ("4"): {
                System.out.println("Вы усилили свою стамину ");
                Thread.sleep(1000);
                hero.setGuardPoint(hero.getGuardPoint() + (int) (Math.random() * 10));
                break;
            }
            default:
                System.out.println("Вы пропустили улучшение...");
                Thread.sleep(1000);
                break;
        }

    }

    public static void specialReception(Hero hero, Npc npc) throws InterruptedException {
        System.out.println("У вас появилась возможность выбрать спец прием. Выберите один из предложенных вариантов: 1) Удар с разворота 2) Удар в прыжке 3) Регенерация ");
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.next();
        switch (scan) {
            case ("1"): {
                System.out.println("Вы выбрали Удар с разворота");
                Thread.sleep(1000);
                npc.setHealthPoint(hero.specialAtack1(npc.getHealthPoint(), npc.getGuardPoint()));
                break;
            }
            case ("2"): {
                System.out.println("Вы выбрали Удар в прыжке");
                Thread.sleep(1000);
                npc.setHealthPoint(hero.specialAtack2(npc.getHealthPoint(), npc.getGuardPoint()));
                break;
            }
            case ("3"): {
                System.out.println("Регенерация");
                Thread.sleep(1000);
                hero.specialReception();
                break;
            }
            default:
                System.out.println("Вы промахнулись...");
                Thread.sleep(1000);
                break;
        }

    }


}
