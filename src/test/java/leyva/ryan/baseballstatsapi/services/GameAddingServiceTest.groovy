package leyva.ryan.baseballstatsapi.services

import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao
import leyva.ryan.baseballstatsapi.model.Game
import leyva.ryan.baseballstatsapi.model.Player
import spock.lang.Specification

class GameAddingServiceTest extends Specification
{
    private BaseballStatsDao baseballStatsDao

    private GameAddingService gameAddingService

    def "setup"()
    {
        baseballStatsDao = Mock(BaseballStatsDao)

        gameAddingService = new GameAddingService(baseballStatsDao)
    }

    def "test gameAddingService addGameStats number of players in list is added to database"()
    {
        given:
        Game game = new Game()
        game.setGameNumber(1)
        Player player1 = new Player()
        Player player2 = new Player()
        game.setPlayers(Arrays.asList(player1, player2)) //size of array is 2 in this message, for simplicity's sake

        when:
        gameAddingService.addGameStats(game)

        then:
        1 * baseballStatsDao.addPlayerStats(1, player1)
        1 * baseballStatsDao.addPlayerStats(1, player2)
    }
}
