public class Player {
    private int totalScore;
    private int roundScore;
    private boolean turn;

    public Player() {
        turn = false;
        totalScore = 0;
        roundScore = 0;

    }

    public void startTurn() {
        turn = true;
    }


    public void pass(){
        totalScore += roundScore;
        turn = false;
        roundScore = 0;
    }


    public int getTotalScore(){
        return totalScore;

    }

    public int getRoundScore(){
        return roundScore;
    }

    public void clearTotal(){
        totalScore = 0;
    }

    public void clearRound(){
        roundScore = 0;
    }

    public void scoreRoll(int sum){
        roundScore += sum;
    }

    public void scoreRound(int round){
        totalScore += roundScore;
    }

    public boolean isTurn() {return turn;}
}
