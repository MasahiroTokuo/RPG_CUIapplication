package rpg.creature.monster;
import rpg.creature.character.*;
import static java.lang.System.out;
public class PoisonMatango extends Matango{
    public int poisonCount;
    public int recoverCount;

    public void attack(Hero h) throws Exception {
        if(this.getHp() <= 15){
            if(this.getRecoverCount() > 0){
                recover();
            }else if(this.getRecoverCount() == 0){
                out.println(this.getName() + "は回復の胞子をばらまこうとした");
                out.println("しかし回復の胞子はもう出せないようだ");
                Thread.sleep(1000);
                this.setRecoverCount(-1);
            }else{
                out.println(this.getName() + "は怯えて動けないようだ");
                Thread.sleep(1000);
            }
        }else{
            super.attack(h);
            if(this.getPoisonCount() > 0){
                int poisonDamage = (h.getHp() / 8) + 1;
                h.setHp(h.getHp() - poisonDamage);
                this.setPoisonCount(this.getPoisonCount()-1);
                out.println("さらに毒の胞子をばらまいた！");
                Thread.sleep(1000);;
                out.println(h.getName() + "に" + poisonDamage + "ポイントのダメージ！");
                Thread.sleep(1000);
            }else if(this.getPoisonCount() == 0){
                out.println("毒の胞子はもう出せないようだ");
                Thread.sleep(1000);
                this.setPoisonCount(this.getPoisonCount()-1);
            }
        }
    }
    public void recover() throws Exception {
        this.setHp(this.getHp() + 30);
        this.setRecoverCount(this.getRecoverCount()-1);
        out.println(this.getName() + "は回復の胞子をばらまいた！");
        Thread.sleep(1000);
        out.println(this.getName() + "は30ポイント回復した！");
        Thread.sleep(1000);
    }

    public int getPoisonCount(){return this.poisonCount;}
    public int getRecoverCount(){return this.recoverCount;}
    public void setPoisonCount(int pc){this.poisonCount = pc;}
    public void setRecoverCount(int rc){this.recoverCount = rc;}

    public PoisonMatango(char suffix, int level){
        super(suffix, level);
        this.setPoisonCount(5);
        this.setRecoverCount(1);
        this.setName("お化け毒キノコ" + suffix);
        this.setHp(this.getLEVEL() * 7);
    }
}