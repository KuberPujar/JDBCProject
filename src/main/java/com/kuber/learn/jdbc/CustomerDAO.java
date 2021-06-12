package com.kuber.learn.jdbc;

import com.kuber.learn.jdbc.utils.Constants;
import com.kuber.learn.jdbc.utils.DataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO extends DataAccessObject<Customer> {
    private static final Logger logger = Logger.getLogger("CustomerDAO");

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        Customer customer = null;
        ResultSet resultSet = null;
        try (PreparedStatement statement = this.connection.prepareStatement(Constants.GET_ONE_CUST)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getLong("customer_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("zipcode"));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } finally {
            Constants.closeResult(resultSet);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = null;
        try (var preparedStmt = this.connection.prepareStatement(Constants.ALL_CUSTOMERS)) {
            resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                var customer = new Customer(resultSet.getLong("customer_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("zipcode"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        finally {
            Constants.closeResult(resultSet);
        }
        return customers;
    }

    @Override
    public Customer update(Customer dto) {
        Customer customer = null;
        try (PreparedStatement statement = this.connection.prepareStatement(Constants.UPDATE_CUST)) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getEmail());
            statement.setString(4, dto.getPhone());
            statement.setString(5, dto.getAddress());
            statement.setString(6, dto.getCity());
            statement.setString(7, dto.getState());
            statement.setString(8, dto.getZipCode());
            statement.setLong(9, dto.getId());
            statement.execute();
            customer = this.findById(dto.getId());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer create(Customer dto) {
        Customer customer = null;
        try (PreparedStatement statement = this.connection.prepareStatement(Constants.INSERT_CUSTOMER)) {
            statement.setString(1, dto.getFirstName());
            statement.setString(2, dto.getLastName());
            statement.setString(3, dto.getEmail());
            statement.setString(4, dto.getPhone());
            statement.setString(5, dto.getAddress());
            statement.setString(6, dto.getCity());
            statement.setString(7, dto.getState());
            statement.setString(8, dto.getZipCode());
            statement.execute();
            int id = this.getLastVal(CUSTOMER_SEQUENCE);
            customer = this.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void delete(long id) {
        try (var preparedStatement = this.connection.prepareStatement(Constants.DELETE_CUST)) {
            preparedStatement.setLong(1, id);
            boolean deleted=preparedStatement.execute();
            if(deleted)
            {
                logger.log(Level.INFO,"customer is deleted");
            }
            else
            {
                logger.log(Level.WARNING,"customer not found");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
