package leyva.ryan.baseballstatsapi.daos;

import leyva.ryan.baseballstatsapi.daos.mappers.PlayerDataMapper;
import leyva.ryan.baseballstatsapi.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BaseballStatsMySQL implements BaseballStatsDao
{
    private final Logger LOGGER = LoggerFactory.getLogger(BaseballStatsMySQL.class);

    private final JdbcTemplate jdbcTemplate;

    public BaseballStatsMySQL(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Player> readStatsByPlayer(String playerID)
    {
        String readSql = "SELECT PLAYER_NAME, AT_BATS, HITS, HITS_BY_PITCH, WALKS, SAC_FLIES " +
                "FROM BASEBALL_STATS " +
                "WHERE PLAYER_ID = ?;";

        return jdbcTemplate.query(readSql, new PlayerDataMapper(), playerID);
    }

    @Override
    public void addPlayerStats(int gameNo, Player player)
    {
        String addStatsSQL = "INSERT INTO BASEBALL_STATS " +
                "(PLAYER_ID, GAME_NO, PLAYER_NAME, AT_BATS, HITS, HITS_BY_PITCH, WALKS, SAC_FLIES) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(addStatsSQL,
                player.getPlayerId(), gameNo, player.getPlayerName(), player.getAtBats(), player.getHits(), player.getHitsByPitch(), player.getWalks(), player.getSacrificeFlies());

        LOGGER.info(String.format("Inserted player %s into table", player.getPlayerId()));
    }
}
