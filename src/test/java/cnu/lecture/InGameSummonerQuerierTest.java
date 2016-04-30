package cnu.lecture;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.mockito.internal.matchers.GreaterThan;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.hamcrest.core.IsAnything;
import static org.junit.Assert.*;
/**
 * Created by tchi on 2016. 4. 25..
 */
public class InGameSummonerQuerierTest {
    private InGameSummonerQuerier querier;

    @Before
    public void setup() {
        final String apiKey = "8242f154-342d-4b86-9642-dfa78cdb9d9c";
        GameParticipantListener dontCareListener = mock(GameParticipantListener.class);

        querier = new InGameSummonerQuerier(apiKey, dontCareListener);
    }

    @Test
    public void shouldQuerierIdentifyGameKeyWhenSpecificSummonerNameIsGiven() throws Exception {
        final String summonerName;

        GIVEN: {
            summonerName = "내가바로루저";
        }

        final String actualGameKey;
        WHEN: {
            actualGameKey = querier.queryGameKey(summonerName);
        }

        final String expectedGameKey = "IZFJ5QIQ7z9G7KLZQpYE8PJuekxh9WSt";
        THEN: {
            assertThat(actualGameKey, is(expectedGameKey));
        }
    }
    
    @Test
    public void shouldQuerierReportMoreThan5Summoners() throws Exception {
    	querier.queryGameKey("내가바로루저");
    	int numberOfParticipants = querier.getGameInfo().getParticipants().length;

    	assertThat(numberOfParticipants, greaterThan(4));
    }
}
