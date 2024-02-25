package LLDAmazon.SnakesAndLadders.repository;

import LLDAmazon.SnakesAndLadders.models.Player;

import java.util.List;

public class PlayerRepository {
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }


    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }
}
