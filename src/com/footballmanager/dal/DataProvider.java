package com.footballmanager.dal;

import java.sql.*;

public class DataProvider {
  private static DataProvider instance;
  private Connection connection;

  private String url;
  private String user;
  private String password;

  private DataProvider() {
    url = "jdbc:sqlserver://localhost:1433;databaseName=FM";
    user = "thang";
    password = "thang207";
  }

  public void closeConnection() {
    try {
      System.out.println("Connection: " + connection.isClosed());
      connection.close();
      System.out.println("Connection: " + connection.isClosed());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public ResultSet getRecords(String query) {
    try {
      connection = DriverManager.getConnection(url, user, password);
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
