package com.kuber.learn.jdbc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DataAccessObject<T extends  DataTransferObject> {
    private static final Logger logger= Logger.getLogger("DataAccessObject");
    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT last_value FROM ";
    protected final static String CUSTOMER_SEQUENCE = "hp_customer_seq";

    public  DataAccessObject(Connection connection){
        super();
        this.connection = connection;
    }

    public abstract T findById(long id);
    public abstract List<T> findAll();
    public abstract T update(T dto);
    public abstract T create(T dto);
    public abstract void delete(long id);

    protected int getLastVal(String sequence){
        int key = 0;
        ResultSet rs=null;
        String sql = LAST_VAL + sequence;
        try(var statement = connection.createStatement()){
             rs = statement.executeQuery(sql);
            while(rs.next()){
                key=rs.getInt(1);
                logger.log(Level.INFO,"key:"+key);
            }
        }catch (SQLException e ){
            logger.log(Level.SEVERE, e.getMessage());
        }
        finally {
            Constants.closeResult(rs);
        }
        return key;
    }
}
