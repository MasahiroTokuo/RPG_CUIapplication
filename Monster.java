package rpg.creature.monster;
import rpg.creature.character.*;
public abstract class Monster extends rpg.creature.BattleCreature{

    public abstract void attack(Hero h) throws Exception;
    public void run() throws Exception {
        this.setHp(0);
        System.out.println(this.getName() + "は逃げ出した！");
        Thread.sleep(1000);
    }

    public void setName(String name){this.name = name;}
}