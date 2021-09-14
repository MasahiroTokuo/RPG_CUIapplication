package rpg.creature.monster;
import rpg.creature.character.*;
import static java.lang.System.out;
public class Matango extends Monster{
    public final int LEVEL;

    public void attack(Hero h) throws Exception {
        out.println(this.getName() + "の攻撃！");
        Thread.sleep(1000);
        int enemyDamage = new java.util.Random().nextInt(20);
        if(enemyDamage == 0){
            out.println(h.getName() + "は攻撃をかわした！");
            Thread.sleep(1000);
        }else{
            h.setHp(h.getHp() - enemyDamage);
            out.println(h.getName() + "に" + enemyDamage + "のダメージ！");
            Thread.sleep(1000);
        }
    }

    public int getLEVEL(){return this.LEVEL;}

    public Matango(char suffix, int level){
        this.setName("お化けキノコ" + suffix);
        this.LEVEL = level;
        this.setHp(this.getLEVEL() * 5);
    }
}