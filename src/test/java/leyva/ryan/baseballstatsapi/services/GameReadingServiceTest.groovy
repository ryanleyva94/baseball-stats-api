package leyva.ryan.baseballstatsapi.services

import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao
import leyva.ryan.baseballstatsapi.model.Player
import leyva.ryan.baseballstatsapi.model.PlayerBySeason
import spock.lang.Specification

class GameReadingServiceTest extends Specification
{
    private BaseballStatsDao baseballStatsDao
    private StatCalculatingService statCalculatingService

    private GameReadingService gameReadingService

    def "setup"()
    {
        baseballStatsDao = Mock(BaseballStatsDao)
        statCalculatingService = Mock(StatCalculatingService)

        gameReadingService = new GameReadingService(baseballStatsDao, statCalculatingService)
    }

    def "test gameReadingService getSeasonStatsByPlayer"()
    {
        given:
        String playerId = "123456";

        List<Player> playersInDb = Arrays.asList(new Player())

        PlayerBySeason playerBySeason = new PlayerBySeason()

        when:
        baseballStatsDao.readStatsByPlayer(playerId) >> playersInDb

        statCalculatingService.calculatePlayerSeasonStats(playersInDb) >> playerBySeason

        then:
        gameReadingService.getSeasonStatsByPlayer(playerId) == playerBySeason
    }

}
