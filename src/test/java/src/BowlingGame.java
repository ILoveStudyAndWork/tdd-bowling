package src;

import java.util.LinkedList;
import java.util.ListIterator;

public class BowlingGame {

    LinkedList<GameFrame> linkedGameList = new LinkedList<>();
    int scoreOfLine = 0;

    public void playOneRegularFrame(int firstHit,int secondHit) throws Exception  {
        isTheScoreOfRegularFrameCorrect(firstHit,secondHit);
        GameFrame gameFrame = new GameFrame(firstHit,secondHit);
        linkedGameList.add(gameFrame);
    }

    public void playTheLastFrame(int firstHit,int secondHit,int thirdHit) throws Exception{
        isTheScoreOfLastFrameCorrect(firstHit,secondHit,thirdHit);
        GameFrame gameFrame = new TheLastFrame(firstHit,secondHit,thirdHit);
        linkedGameList.add(gameFrame);
    }


    public void playOneFrameWithSamePerformance(int firstHit,int secondHit,int time) throws Exception{
        isTheScoreOfRegularFrameCorrect(firstHit,secondHit);
        for (int i = 0;i < time;i++){
            GameFrame gameFrame = new GameFrame(firstHit,secondHit);
            linkedGameList.add(gameFrame);
        }
    }

    public int getScoreOfLine() throws Exception{
        if (linkedGameList.size() < 10){
            throw  new NotEnoughException("The line less then 10 frame");
        }
        specifyNextThrow();
        calculateScore();
        scoreOfLine = linkedGameList.stream().reduce(0,(subScore,gameFrame)->subScore = subScore + gameFrame.thisFrameScore,Integer::sum);
        return scoreOfLine;
    }

    private void specifyNextThrow() {
        ListIterator<GameFrame> li = linkedGameList.listIterator();
        //from tail to head
        while (li.hasNext()){
            li.next();
        }
        GameFrame theLastFrame = li.previous();
        int nextForPrevious = theLastFrame.firstThrowScore;
        int nextAfterNextForPrevious = theLastFrame.secondThrowScore;
        while (li.hasPrevious()){
            GameFrame PreviousFrame = li.previous();
            if (whichType(PreviousFrame).equals("spare")){
                PreviousFrame.nextThrowScore = nextForPrevious;
                nextForPrevious = PreviousFrame.firstThrowScore;
                nextAfterNextForPrevious = PreviousFrame.secondThrowScore;
            }
            if (whichType(PreviousFrame).equals("strike")){
                PreviousFrame.secondThrowScore = nextForPrevious;
                PreviousFrame.nextThrowScore = nextAfterNextForPrevious;
                nextForPrevious = PreviousFrame.firstThrowScore;
                nextAfterNextForPrevious = PreviousFrame.secondThrowScore;
            }

            if (whichType(PreviousFrame).equals("not_spare")){
                nextForPrevious = PreviousFrame.firstThrowScore;
                nextAfterNextForPrevious = PreviousFrame.secondThrowScore;
            }
        }

    }

    private void calculateScore() {
        ListIterator<GameFrame> li = linkedGameList.listIterator();
        GameFrame currentFrame;
        while (li.hasNext()){
            currentFrame = li.next();
            currentFrame.thisFrameScore = currentFrame.firstThrowScore+currentFrame.secondThrowScore +currentFrame.nextThrowScore;
        }
    }

    private String whichType(GameFrame gameFrame){
        int firstScore =  gameFrame.firstThrowScore;
        int secondScore = gameFrame.secondThrowScore;
        if ((firstScore +secondScore) < 10){
            return "not_spare";
        }
        if (firstScore == 10){
            return "strike";
        }
        return "spare";
    }

    void isTheScoreOfRegularFrameCorrect(int firstThrowScore,int secondThrowScore) throws Exception{
        if (firstThrowScore < 0||secondThrowScore<0 ||firstThrowScore > 10||secondThrowScore>10){
            throw new WrongHitException("hit number should in [0-10]");
        }
        if ((firstThrowScore + secondThrowScore) > 10){
            throw new WrongHitException("total hit should not over 10");
        }
    }

    void isTheScoreOfLastFrameCorrect(int firstThrowScore,int secondThrowScore,int thirdThrowScore) throws Exception{
        if (firstThrowScore < 0||secondThrowScore<0 || thirdThrowScore <0){
            throw new WrongHitException("hit number can not be negative");
        }
        if ((firstThrowScore + secondThrowScore)<10 && thirdThrowScore >0){
            throw new WrongHitException("should not have the third throw");
        }
    }

}
