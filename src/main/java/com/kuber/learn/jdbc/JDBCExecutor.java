package com.kuber.learn.jdbc;


import com.kuber.learn.jdbc.utils.PropertyFileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCExecutor {
    private static final Logger logger=Logger.getLogger("JDBCExecutor");
    private static final PropertyFileReader fileReader=new PropertyFileReader();
    private static final DataBaseConnectionManager db=new
            DataBaseConnectionManager(fileReader.getProperty("DATABASE_URL"),
            fileReader.getProperty("USERNAME"),fileReader.getProperty("PASSWORD"));
    private static  Connection connection = null;
    public static void main(String[] args) {
        try {
            connection=db.getConnection();
            var orderDAO=new OrderDAO(connection);
            logger.log(Level.INFO,orderDAO.findById(1000).toString());
        }
        catch(SQLException e)
        {
               logger.log(Level.SEVERE,e.getMessage());
        }
        finally
        {
          db.closeConnection(connection);
        }
    }
}
