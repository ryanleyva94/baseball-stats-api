package leyva.ryan.baseballstatsapi.daos.mappers;

import leyva.ryan.baseballstatsapi.model.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDataMapper implements RowMapper<Player>
{
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Player player = new Player();
        player.setPlayerName(rs.getString("PLAYER_NAME"));
        player.setAtBats(rs.getInt("AT_BATS"));
        player.setHits(rs.getInt("HITS"));
        player.setHitsByPitch(rs.getInt("HITS_BY_PITCH"));
        player.setWalks(rs.getInt("WALKS"));
        player.setSacrificeFlies(rs.getInt("SAC_FLIES"));

        return player;
    }
}
