import java.util.Scanner;

public class PigGame {

    private static Player p1;
    private static Player comp;
    private static Die d1;
    private static Die d2;

    private static Scanner scan;

    public static void main(String[] args){
        p1 = new Player();
        comp = new Player();
        d1 = new Die();
        d2 = new Die();
        scan = new Scanner(System.in);
        String input;

        while(p1.getTotalScore() < 100 && comp.getTotalScore() < 100) {
            p1.startTurn();
            while (p1.isTurn()) {
                System.out.println("\nYour Turn:");
                System.out.println("Your Total Score = " + p1.getTotalScore());
                System.out.println("Your Round Score = " + p1.getRoundScore());
                System.out.println("Computer Total Score = " + comp.getTotalScore());
                System.out.println("Player's Turn: Enter r to roll or anything else to pass");


                input = scan.next();
                if (input.equals("r")) {
                    d1.roll();
                    d2.roll();
                    System.out.println("D1: " + d1.getFace() + " D2: " + d2.getFace());
                    scoreDice(p1, comp);

                } else {
                    p1.pass();

                }

            }


            comp.startTurn();
            while (comp.isTurn()) {
                System.out.println("\nComputer's Turn ");
                System.out.println("Comp Total Score = " + comp.getTotalScore());
                System.out.println("Comp Round Score = " + comp.getRoundScore());
                System.out.println("Your Total Score = " + p1.getTotalScore());
                if (comp.getRoundScore() <= 20) {
                    d1.roll();
                    d2.roll();
                    System.out.println("D1: " + d1.getFace() + " rD2: " + d2.getFace());
                    scoreDice(comp, p1);
                } else {
                    comp.pass();

                }

            }
        }

        if (p1.getTotalScore() > 100)
            System.out.println("YOU WIN");
        else
            System.out.println("The Computer Wins Again");
    }


    public static void scoreDice(Player active, Player passive){
        if (d1.isOne() && d2.isOne()) {
            active.clearTotal();
            active.clearRound();
            active.pass();
            passive.startTurn();
        }
        if (d1.isOne() || d2.isOne()) {
            active.clearRound();
            active.pass();
            passive.startTurn();
        }
        else
            active.scoreRoll(d1.getFace() + d2.getFace());

    }
}
