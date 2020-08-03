package src;

import java.util.LinkedList;

public class BowlingGame {

    LinkedList<GameFrame> linkedGameList = new LinkedList<>();
    int scoreOfLine = 0;

    public void playOneFrame(int firstHit,int secondHit) throws Exception  {
        isTheScoreOfRegularFrameCorrect(firstHit,secondHit);
        GameFrame gameFrame = new GameFrame(firstHit,secondHit);
        linkedGameList.add(gameFrame);
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
        scoreOfLine = linkedGameList.stream().reduce(0,(subScore,gameFrame)->subScore = subScore + gameFrame.thisFrameScore,Integer::sum);
        return scoreOfLine;
    }


}
