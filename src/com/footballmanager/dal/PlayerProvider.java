package com.footballmanager.dal;

import com.footballmanager.dto.Player;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PlayerProvider {
  private static PlayerProvider instance;

  private PlayerProvider() {}

  public static PlayerProvider getInstance() {
    if (instance == null) instance = new PlayerProvider();
    return instance;
  }

  public List<Player> getPlayers() {
    try {
      var data = new ArrayList<Player>();
      var resultSet = DataProvider
        .getInstance()
        .getRecords("SELECT * FROM Player");

      while (resultSet.next()) {
        int playerID = resultSet.getInt("player_id");
        String name = resultSet.getString("name");
        String born = resultSet.getString("born");
        String preferFoot = resultSet.getString("prefer_foot");
        int totalGoal = resultSet.getInt("total_goal");
        int teamID = resultSet.getInt("team_id");

        data.add(new Player(name, playerID, preferFoot));
      }

      DataProvider.getInstance().closeConnection();
      return data;
    }
    catch (Exception e) {
      return null;
    }
  }

  public int addPlayer(Player player) {
    var command = "INSERT INTO Player VALUES (990, 'A', 'England', 'RIGHT', 9, 1)";
    return DataProvider.getInstance().executeNonQuery(command);
  }
}
