package com.kuber.learn.jdbc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Constants {
    public final static String CUSTOMER_COUNT="select count(*) from customer";
    public final static String INSERT_CUSTOMER="insert into customer(first_name,last_name,email," +
            "phone,address,city,state,zipcode) values" +
            "(?,?,?,?,?,?,?,?)";
    public final static String GET_ONE_CUST="select customer_id,first_name, last_name,email, phone, address, city, state, zipcode FROM customer WHERE customer_id=?";
    public final static String UPDATE_CUST="update customer set first_name= ?, last_name= ?,email= ?, phone= ?, address= ?, city= ?, state= ?, zipcode= ? where customer_id=?";
    public final static String DELETE_CUST="delete from customer where customer_id=?";
    public final static String ALL_CUSTOMERS="select * from customer";
    public final static String GET_ORDER="select c.first_name,c.last_name,c.email,o.order_id,o.creation_date,o.total_due,o.status,\n" +
            "s.first_name,s.last_name,s.email,ol.quantity,p.code,p.name,p.size,p.variety,p.price\n" +
            "from orders o\n" +
            "join customer c on o.customer_id=c.customer_id\n" +
            "join salesperson s on o.salesperson_id=s.salesperson_id\n" +
            "join order_item ol on ol.order_id=o.order_id\n" +
            "join product p on ol.product_id=p.product_id\n" +
            "where o.order_id=?";
    public static final void closeResult(ResultSet resultSet)
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
}
