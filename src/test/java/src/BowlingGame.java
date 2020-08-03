package src;

import java.util.LinkedList;

public class BowlingGame {

    LinkedList<GameFrame> linkedGameList = new LinkedList<>();
    int scoreOfLine = 0;

    public void playOneFrame(int firstHit,int secondHit){
        GameFrame gameFrame = new GameFrame(firstHit,secondHit);
        linkedGameList.add(gameFrame);
    }

    public void playTheLastFrame(int firstHit,int secondHit,int thirdHit){
        GameFrame gameFrame = new TheLastFrame(firstHit,secondHit,thirdHit);
        linkedGameList.add(gameFrame);
    }


    public void playOneFrameWithSamePerformance(int firstHit,int secondHit,int time){
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
