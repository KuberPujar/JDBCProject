package com.kuber.learn.jdbc.utils;

import com.kuber.learn.jdbc.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class OrderAccessObject<T extends OrderTransferObject>{
    private static final Logger logger= Logger.getLogger("OrderAccessObject");
    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT last_value FROM ";
    protected final static String ORDER_SEQUENCE = "hp_order_seq";

    public  OrderAccessObject(Connection connection){
        super();
        this.connection = connection;
    }

    public abstract T findById(long id);

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
