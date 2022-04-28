package npc;

public class Skelet extends Npc {

    public Skelet(String name, int healthPoint, int attackPoint, int guardPoint) {
        super(name, healthPoint, attackPoint, guardPoint);
    }


    @Override
    public int specialReception1(int health, int guard) {
        System.out.println("Спец-удар: Разрез");
        health -=  getAttackPoint();
        System.out.println("Было нанесено " + getAttackPoint() + " урона. Оставшееся здоровье цели: " + health);
        return health ;
    }

    @Override
    public int specialReception2(int health, int guard) {
        System.out.println("Спец-удар: Могильный звон");
        health -=  getAttackPoint() * 2 - guard;
        System.out.println("Было нанесено " + getAttackPoint() * 2 + " урона. Оставшееся здоровье цели: " + health);
        return health ;
    }
}
