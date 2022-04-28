package maincharacter;

public class Hero {
    private String name;
    private int healthPoint;
    private int attackPoint;
    private int guardPoint;
    private int staminaPoint;

    public Hero() {
    }

    public Hero(String name, int healthPoint, int attackPoint, int guardPoint, int staminaPoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
        this.guardPoint = guardPoint;
        this.staminaPoint = staminaPoint;
    }

    public int specialAtack1(int health, int guard) throws InterruptedException {
        System.out.println("Спец-прием: Удар с разворота");
        Thread.sleep(1000);
        health -= attackPoint * (int) Math.round(Math.random() * 1.5) - guard;
        staminaPoint -= 5;
        System.out.println("Было нанесено " + attackPoint * (int) Math.round(Math.random() * 1.5) + " урона. Оставшееся здоровье цели: " + health);
        Thread.sleep(1000);
        return health;
    }

    public int specialAtack2(int health, int guard) throws InterruptedException {
        System.out.println("Спец-прием: Удар в прыжке");
        Thread.sleep(1000);
        health -= attackPoint;
        staminaPoint -= 3;
        System.out.println("Было нанесено " + attackPoint + " урона. Оставшееся здоровье цели: " + health);
        Thread.sleep(1000);
        return health;
    }

    public void specialReception() throws InterruptedException {
        System.out.println("Спец-прием: Регенерация");
        Thread.sleep(1000);
        healthPoint += 10;
        staminaPoint -= 6;
        System.out.println("Вы были излечены на 10 единиц");
        Thread.sleep(1000);
    }

    public int normalHit(int health, int guard) {
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

    public int getStaminaPoint() {
        return staminaPoint;
    }

    public void setStaminaPoint(int staminaPoint) {
        this.staminaPoint = staminaPoint;
    }
}
