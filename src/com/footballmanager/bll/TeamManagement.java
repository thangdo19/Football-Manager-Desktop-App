package com.footballmanager.bll;

import com.footballmanager.dto.Player;

import java.util.List;
import java.util.stream.Collectors;

public class TeamManagement {
  private List<Player> teamPlayers;

  public TeamManagement(List<Player> teamPlayers) {
    this.teamPlayers = teamPlayers;
  }

  public void listingPlayers() {
    teamPlayers.stream()
      .map(Player::getName)
      .forEach(System.out::println);
  }

  public void printTeamsStatistic() {
    var statistic = teamPlayers.stream()
      .collect(Collectors.summarizingInt(Player::getShirtNo));
    System.out.println(statistic);
  }
}

