package leyva.ryan.baseballstatsapi.daos;

import leyva.ryan.baseballstatsapi.model.Player;

import java.util.List;

public interface BaseballStatsDao
{
    List<Player> readStatsByPlayer(String playerID);

    void addPlayerStats(int gameNo, Player player);
}
