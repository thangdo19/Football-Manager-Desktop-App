package com.footballmanager.dal;

import java.sql.*;

public class DataProvider {
  private static DataProvider instance;
  private Connection connection;

  private DataProvider() {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=FM";
    String user = "thang";
    String password = "thang207";
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException throwables) {
      System.out.println("Connection Error");
    }
  }

  public ResultSet getRecords(String query) {
    try {
      var statement = connection.prepareStatement(query);
      return statement.executeQuery();
    }
    catch (SQLException e) {
      return null;
    }
  }

  public static DataProvider getInstance() {
    if (instance == null) instance = new DataProvider();
    return instance;
  }
}
