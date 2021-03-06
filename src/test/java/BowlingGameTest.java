import org.junit.jupiter.api.Test;
import src.BowlingGame;
import src.NotEnoughException;
import src.WrongHitException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BowlingGameTest {
    @Test
    void should_throw_error_when_given_game_less_than_10_frame() throws Exception{
        BowlingGame bowlingGame = new BowlingGame();
        //given:9 game
        bowlingGame.playOneFrameWithSamePerformance(10,0,9);
        //when
        //then throw exception
        NotEnoughException notEnoughException = assertThrows(NotEnoughException.class,()->{bowlingGame.getScoreOfLine();});

        assertEquals("The line less then 10 frame",notEnoughException.getMessage());
    }

    @Test
    void should_throw_error_when_given_frame_with_hit_is_negative() throws Exception{
        BowlingGame bowlingGame = new BowlingGame();

        //given negative hit then throw exception
        WrongHitException wrongHitException = assertThrows(src.WrongHitException.class,()->{bowlingGame.playOneFrameWithSamePerformance(-1,0,9);});

        assertEquals("hit number should in [0-10]",wrongHitException.getMessage());
    }

    @Test
    void should_throw_error_when_given_frame_with_totol_hit_more_than_10(){
        BowlingGame bowlingGame = new BowlingGame();
        //given:total hit more than 10  throw exception
        WrongHitException wrongHitException = assertThrows(src.WrongHitException.class,
                ()->{bowlingGame.playOneFrameWithSamePerformance(9,2,9);});

        assertEquals("total hit should not over 10",wrongHitException.getMessage());
    }

    @Test
    void should_throw_error_when_given_the_last_frame_with_more_throw() throws Exception{
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.playOneFrameWithSamePerformance(5,1,9);
        //given:total hit more than 10  throw exception
        WrongHitException wrongHitException = assertThrows(src.WrongHitException.class,
                ()->{bowlingGame.playTheLastFrame(3,1,9);});

        assertEquals("should not have the third throw",wrongHitException.getMessage());
    }


    @Test
    void  should_return_score_when_count_score_given_10_frame_all_frame_strike() throws Exception{
        //todo
        BowlingGame bowlingGame = new BowlingGame();
        //given:10 game
        bowlingGame.playOneFrameWithSamePerformance(10,0,9);
        bowlingGame.playTheLastFrame(10,10,10);
        //when
        int score = bowlingGame.getScoreOfLine();
        //then
        assertEquals(300,score);

    }

    @Test
    void  should_return_score_when_count_score_given_all_frame_spare() throws Exception{
        //todo
        BowlingGame bowlingGame1 = new BowlingGame();
        //given:10 game
        bowlingGame1.playOneFrameWithSamePerformance(5,5,9);
        bowlingGame1.playTheLastFrame(5,5,5);
        //when
        int score1 = bowlingGame1.getScoreOfLine();
        //then
        assertEquals(150,score1);

        BowlingGame bowlingGame2 = new BowlingGame();
        //given:10 game
        bowlingGame2.playOneFrameWithSamePerformance(4,6,9);
        bowlingGame2.playTheLastFrame(4,6,5);
        //when
        int score2 = bowlingGame2.getScoreOfLine();
        //then
        assertEquals(141,score2);


    }


    @Test
    void  should_return_0_when_count_score_given_all_frame_hit_0() throws Exception{
        //todo
        BowlingGame bowlingGame = new BowlingGame();
        //given:10 game
        bowlingGame.playOneFrameWithSamePerformance(0,0,9);
        bowlingGame.playTheLastFrame(0,0,0);
        //when
        int score = bowlingGame.getScoreOfLine();
        //then
        assertEquals(0,score);

    }

    @Test
    void  should_return_score_when_count_score_given_frame_neither_strike_nor_spare() throws Exception{
        //todo
        BowlingGame bowlingGame = new BowlingGame();
        //given:10 game
        bowlingGame.playOneFrameWithSamePerformance(3,4,9);
        bowlingGame.playTheLastFrame(3,4,0);
        //when
        int score = bowlingGame.getScoreOfLine();
        //then
        assertEquals(70,score);

    }

    @Test
    void  should_return_score_when_count_score_given_frame_have_three_different_performance() throws Exception{
        //todo
        BowlingGame bowlingGame = new BowlingGame();
        //given:10 game
        bowlingGame.playOneRegularFrame(10, 0);
        bowlingGame.playOneRegularFrame(10, 0);
        bowlingGame.playOneRegularFrame(10, 0);
        bowlingGame.playOneRegularFrame(4, 6);
        bowlingGame.playOneRegularFrame(4, 4);
        bowlingGame.playOneRegularFrame(7, 3);
        bowlingGame.playOneRegularFrame(10, 0);
        bowlingGame.playOneRegularFrame(10, 0);
        bowlingGame.playOneRegularFrame(1, 7);
        bowlingGame.playTheLastFrame(10,3,7);
        //when
        int score = bowlingGame.getScoreOfLine();
        //then
        assertEquals(183,score);

    }


}
