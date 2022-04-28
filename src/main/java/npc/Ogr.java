package npc;

public class Ogr extends Npc {

    public Ogr(String name, int healthPoint, int attackPoint, int guardPoint) {
        super(name, healthPoint, attackPoint, guardPoint);
    }

    @Override
    public int specialReception1(int health, int guard) {
        System.out.println("Спец-удар: Удар дубиной");
        health -=  getAttackPoint();
        System.out.println("Было нанесено " + getAttackPoint() + " урона. Оставшееся здоровье цели: " + health);
        return health ;
    }

    @Override
    public int specialReception2(int health, int guard) {
        System.out.println("Спец-удар: Удар о землю");
        health -=  getAttackPoint() * 2.5 - guard;
        System.out.println("Было нанесено " + getAttackPoint() * 2.5 + " урона. Оставшееся здоровье цели: " + health);
        return health ;
    }
}
