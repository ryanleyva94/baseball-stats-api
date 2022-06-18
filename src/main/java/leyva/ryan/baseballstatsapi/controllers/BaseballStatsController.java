package leyva.ryan.baseballstatsapi.controllers;

import leyva.ryan.baseballstatsapi.model.PlayerBySeason;
import leyva.ryan.baseballstatsapi.services.GameReadingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseballStatsController
{
    private final GameReadingService gameReadingService;

    public BaseballStatsController(GameReadingService gameReadingService)
    {
        this.gameReadingService = gameReadingService;
    }

    @GetMapping("/statsByPlayer/playerID/{playerID}")
    public ResponseEntity<PlayerBySeason> getStatsByPlayer(@PathVariable("playerID") String playerID)
    {
        return new ResponseEntity<>(gameReadingService.getSeasonStatsByPlayer(playerID), HttpStatus.OK);
    }
}
