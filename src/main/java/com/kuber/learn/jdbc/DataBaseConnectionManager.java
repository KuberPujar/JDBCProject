package com.kuber.learn.jdbc;

import java.sql.*;
import java.util.Properties;

public class DataBaseConnectionManager {
    private final String url;
    private final Properties properties;

    public DataBaseConnectionManager(String url, String userName,String password) {
        this.url = url;
        this.properties =new Properties();
        this.properties.setProperty("user",userName);
        this.properties.setProperty("password",password);
    }

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(this.url,this.properties);
    }

    public void closeConnection(Connection connection)
    {
        try{
            if(connection!=null)
            {
                connection.close();
            }
        }
        catch(SQLException e)
        {
         e.getLocalizedMessage();
        }
    }

    public void closeStmt(Statement statement)
    {
        try{
            if(statement!=null)
            {
                statement.close();
            }
        }
        catch(SQLException e)
        {
            e.getLocalizedMessage();
        }
    }

    public void closeResult(ResultSet resultSet)
    {
        try{
            if(resultSet!=null)
            {
                resultSet.close();
            }
        }
        catch(SQLException e)
        {
            e.getLocalizedMessage();
        }
    }

    public void closePstmt(PreparedStatement preparedStatement)
    {
        try{
            if(preparedStatement!=null)
            {
                preparedStatement.close();
            }
        }
        catch(SQLException e)
        {
            e.getLocalizedMessage();
        }
    }

}
