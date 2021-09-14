package rpg.creature.character;
import rpg.creature.monster.*;
import java.util.*;
import static java.lang.System.out;
public class Hero extends rpg.creature.character.Character{
    protected int power;
    protected final int MAXHP;

    public int action(Monster m) throws Exception {
        int act = 0;
        do{
            try{
                out.println(this.getName() + "はどうする？");
                out.println("1.攻撃　2.眠る 3.溜める 4.逃げる");
                act = new Scanner(System.in).nextInt();
                if(act < 1 || act > 4){
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException ime){
                out.println("1~4の数字を入力してください");
                Thread.sleep(1000);
                continue;
            }
        }while(act < 1 || act > 4);
        switch (act){
            case 1:
                attack(m);
                break;
            case 2:
                sleep();
                break;
            case 3:
                charge();
                break;
            case 4:
                run();
                break;
            default:
                out.println("1~4の数字を入力してください");
                Thread.sleep(1000);
                action(m);
        }
        return act;
    }
    public void attack(Monster m) throws Exception {
        out.println(this.getName() + "の攻撃！");
        Thread.sleep(1000);
        int attackDamage = new Random().nextInt(6) + 5;
        switch(attackDamage){
            case 5:
                out.println("攻撃は失敗した！");
                Thread.sleep(1000);
                slip();
                break;
            case 10:
                attackDamage += 5;
                out.println("かいしんのいちげき！");
                Thread.sleep(1000);
            default:
                if(this.getPower() > 0){
                    out.println(this.getName() + "は力を" + this.getPower() + "回溜めている！");
                    Thread.sleep(1000);
                    while(this.getPower() > 0){
                    attackDamage *= 1.5;
                    this.setPower(this.getPower()-1);
                    }
                }
                m.setHp(m.getHp() - attackDamage);
                out.println(m.getName() + "に" + attackDamage + "ポイントのダメージ！");
                Thread.sleep(1000);
        }
    }
    public void sleep() throws Exception {
        int recover = new Random().nextInt(20) + 15;
        int recoverActual = Math.min(this.getMAXHP() - this.getHp(), recover);
        out.println(this.getName() + "は、眠って" + recoverActual + "ポイント回復した！");
        this.setHp(this.getHp() + recoverActual);
        Thread.sleep(1000);
        if(this.getPower() != 0){
            chargeOff();
        }
    }
    public void charge() throws Exception {
        this.setPower(this.getPower()+1);
        out.println(this.getName() + "は力を" + this.getPower() + "回溜めた！");
        Thread.sleep(1000);
    }
    public void chargeOff() throws Exception {
        out.println("溜めた力が無くなった！");
        Thread.sleep(1000);
        this.setPower(0);
    }
    public void slip() throws Exception {
        this.setHp(this.getHp() - 5);
        out.println(this.getName() + "は、転んだ！");
        Thread.sleep(1000);
        out.println(this.getName() + "に5のダメージ！");
        Thread.sleep(1000);
        if(this.getPower() != 0){
            chargeOff();
        }
    }
    public void dead() throws Exception {
        out.println(this.getName() + "は倒された！");
        Thread.sleep(1000);
        out.println("GAME OVER");
        Thread.sleep(1000);
    }

    public int getPower(){return this.power;}
    public int getMAXHP(){return this.MAXHP;}
    public void setPower(int power){this.power = power;}

    public Hero(String name){
        this.setHp(100);
        this.setName(name);
        this.MAXHP = 100;
        this.setPower(0);
    }
    public Hero(String name, int hp){
        this.setHp(hp);
        this.setName(name);
        this.MAXHP = hp;
        this.setPower(0);
    }
}