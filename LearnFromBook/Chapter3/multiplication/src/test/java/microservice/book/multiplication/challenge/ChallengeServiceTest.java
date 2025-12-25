package microservice.book.multiplication.challenge;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class ChallangeServiceTest{

    private ChallengeService challengeService;

    @BeforeEach
    public void setup(){
        challengeService = new ChallengeServiceImpl();
    }

    @Test
    public void checkCorrectAttemptTest(){
        //given
        ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO(20,30,"Amit",6000);

        //when
        ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);

        //then

        then(resultAttempt.isCorrect()).isTrue();
    }

}