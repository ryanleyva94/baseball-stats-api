package leyva.ryan.baseballstatsapi.services;

import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao;
import leyva.ryan.baseballstatsapi.model.Player;
import leyva.ryan.baseballstatsapi.model.PlayerBySeason;

import java.util.List;

public class GameReadingService
{
    private final BaseballStatsDao baseballStatsDao;
    private final StatCalculatingService statCalculatingService;

    public GameReadingService(BaseballStatsDao baseballStatsDao, StatCalculatingService statCalculatingService)
    {
        this.baseballStatsDao = baseballStatsDao;
        this.statCalculatingService = statCalculatingService;
    }

    public PlayerBySeason getSeasonStatsByPlayer(String playerId)
    {
        List<Player> playerGames = baseballStatsDao.readStatsByPlayer(playerId);

        PlayerBySeason playerBySeason = statCalculatingService.calculatePlayerSeasonStats(playerGames);
        playerBySeason.setPlayerId(playerId);

        return playerBySeason;
    }
}
