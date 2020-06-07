package com.footballmanager.dto;

public class Player {
  private String name;
  private int shirtNo;
  private String clubName;

  public Player(String name, int shirtNo, String clubName) {
    this.name = name;
    this.shirtNo = shirtNo;
    this.clubName = clubName;
  }

  public String getName() {
    return name;
  }

  public int getShirtNo() {
    return shirtNo;
  }

  @Override
  public String toString() {
    return shirtNo + " " + name;
  }

  public String getClubName() {
    return clubName;
  }
}
