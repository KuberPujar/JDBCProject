package com.kuber.learn.jdbc;

import com.kuber.learn.jdbc.utils.Constants;
import com.kuber.learn.jdbc.utils.OrderAccessObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO extends OrderAccessObject<Order> {
    private final static Logger logger=Logger.getLogger("OrderDAO");

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order findById(long id) {
        ResultSet resultSet=null;
        Order order=null;
        List<OrderLine> orderLines=new ArrayList<>();
        try(var statment=this.connection.prepareStatement(Constants.GET_ORDER)){
           statment.setLong(1,id);
          resultSet=statment.executeQuery();
          long orderId=0;

          while (resultSet.next())
          {
              if(orderId==0)
              {
                  order=new Order(resultSet.getString("first_name"),
                          resultSet.getString("last_name"),
                          resultSet.getString("email"),
                          resultSet.getLong("order_id"),
                          resultSet.getString("creation_date"),
                          resultSet.getDouble("total_due"),
                          resultSet.getString("status"),
                          resultSet.getString("first_name"),
                          resultSet.getString("last_name"),
                          resultSet.getString("email"));
              }
              var orderLine=new OrderLine(
                      resultSet.getInt("quantity"),
                      resultSet.getString("code"),
                      resultSet.getString("name"),
                      resultSet.getInt("size"),
                      resultSet.getString("variety"),
                      resultSet.getDouble("price"));
           orderLines.add(orderLine);
           order.setOrderLines(orderLines);
          }
        }
        catch(SQLException e)
        {
            logger.log(Level.SEVERE,e.getMessage());
        }
        finally {
            Constants.closeResult(resultSet);
        }
        return order;
    }
}
