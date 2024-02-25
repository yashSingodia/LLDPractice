package LLDAmazon.SnakesAndLadders.service;

import LLDAmazon.SnakesAndLadders.models.Player;
import LLDAmazon.SnakesAndLadders.repository.PlayerRepository;

public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.addPlayer(player);
    }
}
