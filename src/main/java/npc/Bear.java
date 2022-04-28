package npc;

public class Bear extends Npc {


    public Bear(String name, int healthPoint, int attackPoint, int guardPoint) {
        super(name, healthPoint, attackPoint, guardPoint);
    }

    @Override
    public int specialReception1(int health, int guard) {
        System.out.println("Спец-удар: Рев медведя");
        health -=  getAttackPoint();
        System.out.println("Было нанесено " + getAttackPoint() + " урона. Оставшееся здоровье цели: " + health);
        return health ;
    }

    @Override
    public int specialReception2(int health, int guard) {
        System.out.println("Спец-удар: Удар когтями");
        health -=  getAttackPoint() * 1.5 - guard;
        System.out.println("Было нанесено " + getAttackPoint() * 1.5 + " урона. Оставшееся здоровье цели: " + health);
        return health ;
    }
}
