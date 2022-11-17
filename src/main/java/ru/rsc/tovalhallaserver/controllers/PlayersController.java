package ru.rsc.tovalhallaserver.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rsc.tovalhallaserver.domain.model.Player;
import ru.rsc.tovalhallaserver.domain.repository.PlayersRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "api/players")
public class PlayersController {
    private final PlayersRepository repository;

    @GetMapping(path = "random")
    @ResponseBody
    public Player createRandom(){
        return repository.createRandom();
    }
}
