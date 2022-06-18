package leyva.ryan.baseballstatsapi.services;

import leyva.ryan.baseballstatsapi.model.Player;
import leyva.ryan.baseballstatsapi.model.PlayerBySeason;

import java.text.DecimalFormat;
import java.util.List;

public class StatCalculatingService
{
    PlayerBySeason calculatePlayerSeasonStats(List<Player> playerGames)
    {
        PlayerBySeason playerBySeason = calculateTotals(playerGames);
        playerBySeason.setBattingAverage(calculateBattingAverage(playerBySeason));
        playerBySeason.setOnBasePercentage(calculateOnBasePercentage(playerBySeason));

        return playerBySeason;
    }

    PlayerBySeason calculateTotals(List<Player> playerGames)
    {
        PlayerBySeason playerBySeason = new PlayerBySeason();

        int totalHits = 0;
        int totalAtBats = 0;
        int totalHitsByPitch = 0;
        int totalWalks = 0;
        int totalSacrificeFlies = 0;

        for(Player player: playerGames)
        {
            totalHits += player.getHits();
            totalAtBats += player.getAtBats();
            totalHitsByPitch += player.getHitsByPitch();
            totalWalks += player.getWalks();
            totalSacrificeFlies += player.getSacrificeFlies();
        }

        playerBySeason.setTotalHits(totalHits);
        playerBySeason.setTotalAtBats(totalAtBats);
        playerBySeason.setTotalHitsByPitch(totalHitsByPitch);
        playerBySeason.setTotalWalks(totalWalks);
        playerBySeason.setTotalSacrificeFlies(totalSacrificeFlies);

        return playerBySeason;
    }

    double calculateBattingAverage(PlayerBySeason playerBySeason)
    {
        DecimalFormat dFThousandths = new DecimalFormat("#.###");
        double battingAverage = (double) playerBySeason.getTotalHits() / (double) playerBySeason.getTotalAtBats();

        return Double.parseDouble(dFThousandths.format(battingAverage));
    }

    double calculateOnBasePercentage(PlayerBySeason playerBySeason)
    {
        //on base percentage = (hits + walks + hitsByPitch) / (atBats + walks + hitsByPitch + sacrificeFlies)

        int numerator = playerBySeason.getTotalHits() + playerBySeason.getTotalWalks() + playerBySeason.getTotalHitsByPitch();
        int denominator = playerBySeason.getTotalAtBats() + playerBySeason.getTotalWalks() + playerBySeason.getTotalHitsByPitch() + playerBySeason.getTotalSacrificeFlies();

        DecimalFormat dFThousandths = new DecimalFormat("#.###");
        double obp = (double) numerator / (double) denominator;

        return Double.parseDouble(dFThousandths.format(obp));
    }
}
