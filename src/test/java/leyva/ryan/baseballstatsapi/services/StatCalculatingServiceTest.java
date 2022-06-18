package leyva.ryan.baseballstatsapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import leyva.ryan.baseballstatsapi.model.Player;
import leyva.ryan.baseballstatsapi.model.PlayerBySeason;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StatCalculatingServiceTest
{
    private StatCalculatingService statCalculatingService;

    @BeforeEach
    public void setup()
    {
        statCalculatingService = new StatCalculatingService();
    }

    @Test
    public void testCalculateTotals()
    {
        Player playerGame1 = new Player();
        playerGame1.setAtBats(5);
        playerGame1.setHits(4);
        playerGame1.setWalks(3);
        playerGame1.setSacrificeFlies(2);
        playerGame1.setHitsByPitch(1);

        Player playerGame2 = new Player();
        playerGame2.setAtBats(4);
        playerGame2.setHits(3);
        playerGame2.setWalks(2);
        playerGame2.setSacrificeFlies(1);
        playerGame2.setHitsByPitch(0);

        PlayerBySeason playerBySeason = statCalculatingService.calculateTotals(Arrays.asList(playerGame1, playerGame2));

        assertAll(
                () -> assertEquals(9, playerBySeason.getTotalAtBats()),
                () -> assertEquals(7, playerBySeason.getTotalHits()),
                () -> assertEquals(5, playerBySeason.getTotalWalks()),
                () -> assertEquals(3, playerBySeason.getTotalSacrificeFlies()),
                () -> assertEquals(1, playerBySeason.getTotalHitsByPitch())
        );
    }

    @Test
    public void testCalculateBattingAverage()
    {
        PlayerBySeason playerBySeason = new PlayerBySeason();
        playerBySeason.setTotalAtBats(500);
        playerBySeason.setTotalHits(125);

        double battingAverage = statCalculatingService.calculateBattingAverage(playerBySeason);

        assertEquals(.25, battingAverage);
    }

    @Test
    public void calculateOnBasePercentage()
    {
        PlayerBySeason playerBySeason = new PlayerBySeason();
        playerBySeason.setTotalAtBats(500);
        playerBySeason.setTotalHits(125);
        playerBySeason.setTotalWalks(70);
        playerBySeason.setTotalSacrificeFlies(25);
        playerBySeason.setTotalHitsByPitch(5);

        // (125 + 70 + 5)/(500 + 70 + 5 + 25) = 200/600 = .333

        double onBasePercentage = statCalculatingService.calculateOnBasePercentage(playerBySeason);;

        assertEquals(.333, onBasePercentage);
    }
}
