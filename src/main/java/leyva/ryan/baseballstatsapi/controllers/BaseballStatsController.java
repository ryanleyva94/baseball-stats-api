package leyva.ryan.baseballstatsapi.controllers;

import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseballStatsController
{
    private final BaseballStatsDao baseballStatsDao;

    public BaseballStatsController(BaseballStatsDao baseballStatsDao)
    {
        this.baseballStatsDao = baseballStatsDao;
    }

    @GetMapping("/statsByPlayer/playerID/{playerID}")
    public ResponseEntity<String> getStatsByPlayer(@PathVariable("playerID") String playerID)
    {
        baseballStatsDao.readStatsByPlayer(playerID);
        return ResponseEntity.ok("hello");
    }
}
