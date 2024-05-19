package com.example.gameserviceapi.controller.impl;

import com.example.gameserviceapi.commons.entities.Game;
import com.example.gameserviceapi.controller.GameApi;
import com.example.gameserviceapi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Para poner que es un controller
@RestController
@RequestMapping("/games")
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @Override
    public ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game game) {
        System.out.println(userId);
        Game gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Void> deleteGameById(String id) {
        this.gameService.deleteGameById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = this.gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @Override
    public ResponseEntity<Game> updateGame(Game game) {
        return ResponseEntity.ok(this.gameService.updateGame(game));
    }

}
