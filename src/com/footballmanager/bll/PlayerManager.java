package com.footballmanager.bll;

import com.footballmanager.dal.PlayerProvider;
import com.footballmanager.dto.Player;

import java.util.List;

public class PlayerManager implements PlayerGetter {
  private List<Player> players;

  public List<Player> getPlayers() {
    players = PlayerProvider.getInstance().getPlayers();
    return players;
  }

  public int addPlayer() {
    return PlayerProvider.getInstance().addPlayer(null);
  }
}
