package npc;

public class Npc {

    private String name;
    private int healthPoint;
    private int attackPoint;
    private int guardPoint;


    public Npc() {
    }

    public Npc(String name, int healthPoint, int attackPoint, int guardPoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
        this.guardPoint = guardPoint;
    }

    public int normalHit(int health, int guard) {
        health -= attackPoint - guard;
        System.out.println("Было нанесено " + attackPoint + " урона. Оставшееся здоровье цели: " + health);
        return health;

    }

    public int specialReception1(int health, int guard) {
        health -= attackPoint - guard;
        System.out.println("Было нанесено " + attackPoint + " урона. Оставшееся здоровье цели: " + health);
        return health;
    }

    public int specialReception2(int health, int guard) {
        health -= attackPoint - guard;
        System.out.println("Было нанесено " + attackPoint + " урона. Оставшееся здоровье цели: " + health);
        return health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public int getGuardPoint() {
        return guardPoint;
    }

    public void setGuardPoint(int guardPoint) {
        this.guardPoint = guardPoint;
    }

}