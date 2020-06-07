package com.footballmanager;

import com.footballmanager.bll.PlayerManager;
import com.footballmanager.dal.PlayerProvider;
import com.footballmanager.pl.GUI;

public class Main {
  public static void main(String[] args) {
    new GUI(new PlayerManager()).createGUI();
  }
}
