package com.footballmanager.pl;

import javax.swing.*;
import java.awt.*;

public class MainBorderLayoutPanel extends JPanel {
  private JPanel panel;
  private JPanel north;
  private JPanel south;
  private JPanel west;
  private JPanel east;
  private JPanel center;

  public MainBorderLayoutPanel() {
    panel = new JPanel(new BorderLayout());
  }

  public void addToPanel() {
    if (north != null) panel.add(north, BorderLayout.NORTH);
    if (south != null)panel.add(south, BorderLayout.SOUTH);
    if (west != null)panel.add(west, BorderLayout.WEST);
    if (east != null)panel.add(east, BorderLayout.EAST);
    if (center != null) panel.add(center, BorderLayout.CENTER);
  }

  public void setPanel(LayoutManager layout) {
    this.panel = new JPanel(layout);
  }

  public void setNorth(LayoutManager layout) {
    this.north = new JPanel(layout);
  }

  public void setSouth(LayoutManager layout) {
    this.south = new JPanel(layout);
  }

  public void setWest(LayoutManager layout) {
    this.west = new JPanel(layout);
  }

  public void setEast(LayoutManager layout) {
    this.east = new JPanel(layout);
  }

  public void setCenter(LayoutManager layout) {
    this.center = new JPanel(layout);
  }

  public JPanel getPanel() {
    return panel;
  }

  public JPanel getNorth() {
    return north;
  }

  public JPanel getSouth() {
    return south;
  }

  public JPanel getWest() {
    return west;
  }

  public JPanel getEast() {
    return east;
  }

  public JPanel getCenter() {
    return center;
  }
}
