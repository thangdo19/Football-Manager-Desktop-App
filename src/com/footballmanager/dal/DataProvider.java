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
      if (!connection.isClosed())
        connection.close();
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
      e.printStackTrace();
      return null;
    }
  }

  public int executeNonQuery(String command) {
    try {
      connection = DriverManager.getConnection(url, user, password);
      var statement = connection.prepareStatement(command);
      return statement.executeUpdate();
    }
    catch (SQLException throwables) {
      throwables.printStackTrace();
      return 0;
    }
  }

  public static DataProvider getInstance() {
    if (instance == null) instance = new DataProvider();
    return instance;
  }
}
