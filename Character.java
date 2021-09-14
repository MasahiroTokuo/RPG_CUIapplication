package rpg.creature.character;
import rpg.creature.monster.*;
public abstract class Character extends rpg.creature.BattleCreature{
    public abstract int action(Monster m) throws Exception;
    public void run() throws Exception {
        this.setHp(0);
        System.out.println(this.getName() + "は、逃げ出した！");
        Thread.sleep(1000);
        System.out.println("GAME OVER");
        Thread.sleep(1000);
    }

    public void setName(String name){
        if(name.equals("")){
            this.name = "A";
        }else{
        this.name = name;
        }
    }
}