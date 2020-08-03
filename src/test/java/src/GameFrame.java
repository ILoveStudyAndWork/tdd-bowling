package src;

public class GameFrame {
    int firstThrowScore = 0;
    int secondThrowScore = 0;
    int previousThrowScore = 0;
    int throwBeforePreviousScore = 0;
    int thisFrameScore = 0;

    public GameFrame(){}

    public GameFrame(int scoreOfFirstThrow, int secondThrowScore){
        this.firstThrowScore = scoreOfFirstThrow;
        this.secondThrowScore = secondThrowScore;
    }
}
