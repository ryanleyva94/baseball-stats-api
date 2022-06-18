package leyva.ryan.baseballstatsapi.services;

import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao;
import leyva.ryan.baseballstatsapi.model.Game;
import leyva.ryan.baseballstatsapi.model.Player;

public class GameAddingService
{
    private final BaseballStatsDao baseballStatsDao;

    public GameAddingService(BaseballStatsDao baseballStatsDao)
    {
        this.baseballStatsDao = baseballStatsDao;
    }

    public void addGameStats(Game game)
    {
        for(Player player: game.getPlayers())
        {
            baseballStatsDao.addPlayerStats(game.getGameNumber(), player);
        }
    }
}
