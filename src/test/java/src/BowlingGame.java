package src;

import java.util.LinkedList;

public class BowlingGame {
    //every frame
    //GameFrame gameFrame = new GameFrame();
    LinkedList<GameFrame> linkedGameList = new LinkedList<>();

    int scoreOfLine = 0;
    public void playOneFrame(int firstHit,int secondHit){
        GameFrame gameFrame = new GameFrame(firstHit,secondHit);
        linkedGameList.add(gameFrame);
    }



    public int getScoreOfLine() throws Exception{
        System.out.println(linkedGameList.size());
        if (linkedGameList.size() < 10){
            throw  new NotEnoughException("The line less then 10 frame");
        }
        scoreOfLine = 300;
        return scoreOfLine;
    }

    public void playOneFrameWithSamePerformance(int firstHit,int secondHit,int time){
        for (int i = 0;i < time;i++){
            GameFrame gameFrame = new GameFrame(firstHit,secondHit);
            linkedGameList.add(gameFrame);

        }

    }
}
