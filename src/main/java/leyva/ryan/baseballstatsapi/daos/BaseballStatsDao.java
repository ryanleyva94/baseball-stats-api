package leyva.ryan.baseballstatsapi.daos;

import leyva.ryan.baseballstatsapi.model.Player;

public interface BaseballStatsDao
{
    void readStatsByPlayer(String playerID);

    void addPlayerStats(int gameNo, Player player);
}
