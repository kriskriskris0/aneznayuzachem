package org.example;

import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.sql.*;

@Component
public class PostgresTest {
    @PersistenceContext
    private EntityManager entityManager;


     public Connection getConnection() throws SQLException {
         String url = "jdbc:postgresql://localhost:5432/order";
         String user = "postgres";
         String password = "1";
         return DriverManager.getConnection(url, user, password);
     }
     public int getOrder() {
         try (
                 final Connection connection = getConnection();
                 Statement statement = connection.createStatement()) {
             String sql = "select * from public.orders where (`id` = ? ) ";
             final ResultSet resultSet = statement.executeQuery(sql);
             resultSet.next();
             final int orderId = resultSet.getInt(1);
             final double price = resultSet.getDouble(2);
             final Timestamp timestamp = resultSet.getTimestamp(3);

             return orderId;
         } catch (Exception e) {
             e.printStackTrace();
         }
        return 0;
     }

    @Transactional
    public void createOrder(int id,double price){
        OrderEntity orderEntity = new OrderEntity();


        entityManager.persist(orderEntity);
    }


}


