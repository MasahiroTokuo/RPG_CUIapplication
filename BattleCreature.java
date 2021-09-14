package rpg.creature;
public abstract class BattleCreature implements Creature{
    protected String name;
    protected int hp;

    public abstract void setName(String name);

    public String getName(){return this.name;}
    public int getHp(){return this.hp;}
    public void setHp(int hp){
        if(hp < 0){
            this.hp = 0;
        }else{
        this.hp = hp;
        }
    }

    public abstract void run() throws Exception;
}