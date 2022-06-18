package leyva.ryan.baseballstatsapi.daos;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseballStatsMySQL implements BaseballStatsDao
{
    private final JdbcTemplate jdbcTemplate;

    public BaseballStatsMySQL(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void readStatsByPlayer(String playerID)
    {
        System.out.println(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM BASEBALL_STATS", Integer.class));
    }
}
