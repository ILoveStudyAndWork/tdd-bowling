import org.junit.jupiter.api.Test;
import src.BowlingGame;
import src.NotEnoughException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BowlingGameTest {
    @Test
    void should_throw_error_when_given_game_less_than_10_frame(){
        BowlingGame bowlingGame = new BowlingGame();
        //given:9 game
        bowlingGame.playOneFrameWithSamePerformance(10,0,9);
        //when
        //then throw exception
        NotEnoughException notEnoughException = assertThrows(NotEnoughException.class,()->{bowlingGame.getScoreOfLine();});



        assertEquals("The line less then 10 frame",notEnoughException.getMessage());
    }

    @Test
    void  should_return_score_when_count_score_given_10_frame_all_frame_strike() throws Exception{
        BowlingGame bowlingGame = new BowlingGame();
        //given:10 game
        bowlingGame.playOneFrameWithSamePerformance(10,0,10);
        //when
        int score = bowlingGame.getScoreOfLine();
        //then
        assertEquals(300,score);

    }


    //all frame strike

    //all frame spare
    //all frame neither strike not spare
    //have third type

}
