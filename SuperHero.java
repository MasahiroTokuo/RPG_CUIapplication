package rpg.creature.character;
import rpg.creature.monster.*;
public class SuperHero extends Hero{
    public void attack(Monster m) throws Exception {
        super.attack(m);
        if(m.getHp() > 0){
            super.attack(m);
        }
    }
    public SuperHero(String name){
        super(name, 150);
    }
}