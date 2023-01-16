package ru.rsc.tovalhallaserver.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rsc.tovalhallaserver.domain.model.Player;
import ru.rsc.tovalhallaserver.dto.BestScoresDto;
import ru.rsc.tovalhallaserver.dto.PlayerDto;
import ru.rsc.tovalhallaserver.dto.PlayerSessionDto;
import ru.rsc.tovalhallaserver.services.PlayerService;

import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "api/players")
public class PlayersController {
    private final PlayerService playerService;

    @PostMapping(path = "saveSession")
    public void saveSession(@RequestBody PlayerSessionDto dto) {
        playerService.saveSession(dto);
    }

    @GetMapping(path = "getPlayerById")
    @ResponseBody
    @CrossOrigin
    public PlayerDto getPlayerById(@RequestParam UUID id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping(path = "getBestScores")
    @ResponseBody
    @CrossOrigin
    public BestScoresDto getBestScores(@RequestParam String levelName, @RequestParam Integer count){
        return playerService.getBestScores(levelName, count);
    }
}
