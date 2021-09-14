package rpg.main;
import java.util.*;
import static java.lang.System.out;
public class Main{
    public static void main(String[] args) throws Exception {
        rpg.creature.character.Hero h = setHero();
        int difficulity = 0;
        try{
            do {
                try{
                    out.println("1~3を入力して難易度を決めてください\n1:かんたん　2:ふつう　3:むずかしい");
                    difficulity = new Scanner(System.in).nextInt();
                    if(difficulity < 1 || difficulity > 3){
                        throw new InputMismatchException();
                    }
                }catch(InputMismatchException ime){
                    out.println("1~3の数字を入力してください");
                    Thread.sleep(1000);
                    continue;
                }
            }while(difficulity < 1 || difficulity > 3);
            rpg.creature.monster.Matango n1 = setEnemy(difficulity);
            rpg.creature.monster.Matango n2;
            if(difficulity == 3){
                n2 = setEnemy(difficulity + 1);
            }else{
                n2 = new rpg.creature.monster.DeadMatango();
            }
            
            while(true){
                out.print("\n" + h.getName() + "のHP：" + h.getHp() + "　" + n1.getName() + "のHP：" + n1.getHp());
                if(n2.getHp() > 0){
                    out.println("　" + n2.getName() + "のHP：" + n2.getHp());
                }else{
                    out.println(" ");
                }
                Thread.sleep(1000);
                int act = h.action(n1);
                if(act == 4){break;}
                if(n1.getHp() == 0){
                    out.println(n1.getName() + "を倒した！");
                    Thread.sleep(1000);
                    n1 = n2;
                    n2 = new rpg.creature.monster.DeadMatango();
                }else if(n1.getHp() <= 5){
                    n1.run();
                    n1 = n2;
                    n2 = new rpg.creature.monster.DeadMatango();
                }
                if(n1.getHp() == 0 && n2.getHp() == 0){
                    out.println("GAME CLEAR!!");
                    Thread.sleep(1000);
                    break;
                }
                n1.attack(h);
                if(h.getHp() == 0){
                    h.dead();
                    break;
                }
                if(n2.getHp() > 0){
                    n2.attack(h);
                }
                if(h.getHp() == 0){
                    h.dead();
                    break;
                }
            }
        }catch(Exception e){
            out.println("想定外のエラーです");
            e.printStackTrace();
        }
    }

    public static rpg.creature.character.Hero setHero() throws Exception {
        out.println("勇者の名前を入力してください");
        String name = new Scanner(System.in).nextLine();
        rpg.creature.character.Hero h;
        if(name.equals("スーパーヒーロー")){
            out.println("スーパーヒーローの名前を入力してください");
            name = new Scanner(System.in).nextLine();
            h = new rpg.creature.character.SuperHero(name);
            out.println("スーパーヒーロー" + h.getName() + "を生み出しました。");
            Thread.sleep(1000);
            out.println("スーパーヒーローは１ターンに２回攻撃できます");
            Thread.sleep(1000);
        }else{
            h = new rpg.creature.character.Hero(name);
            out.println("勇者" + h.getName() + "を生み出しました。");
            Thread.sleep(1000);
        }
        return h;
    }
    public static rpg.creature.monster.Matango setEnemy(int dif) throws Exception {
        rpg.creature.monster.Matango n1;
        switch(dif){
            case 1:
                n1 = new rpg.creature.monster.Matango('A', 10);
                break;
            case 2:
            case 3:
                n1 = new rpg.creature.monster.PoisonMatango('A', 10);
                break;
            default:
                n1 = new rpg.creature.monster.PoisonMatango('B', 10);
        }
        out.println(n1.getName() + "が現れた！");
        Thread.sleep(1000);
        return n1;
    }
}