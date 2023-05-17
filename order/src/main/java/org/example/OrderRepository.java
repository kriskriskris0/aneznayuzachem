package org.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {


    private final String url;
    private final String user;
    private final String password;

    private ScheduleDao dao;

    public OrderRepository(String url, String user, String password, ScheduleDao dao) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.dao = dao;
    }

    public Order create() {
        dao.
    }

    public List<Order> get() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM postgres";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setName(rs.getString("name"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка получения", e);
        }
        return orders;
    }





//    private final String url;
//    private final String user;
//    private final String password;
//
//    public OrderRepository(@Value("${spring.datasource.url}") String url,
//                           @Value("${spring.datasource.username}") String user,
//                           @Value("${spring.datasource.password}") String password) {
//        this.url = url;
//        this.user = user;
//        this.password = password;
//    }
//
//
//    public Order create(Order order) {
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "INSERT INTO orders (id, name) VALUES (?, ?)")) {
//
//            int nextId;
//            try (PreparedStatement maxIdStatement = connection.prepareStatement(
//                    "SELECT MAX(id) FROM orders")) {
//                ResultSet resultSet = maxIdStatement.executeQuery();
//                if (resultSet.next()) {
//                    nextId = resultSet.getInt(1) + 1;
//                } else {
//                    nextId = 1;
//                }
//            }
//            statement.setInt(1, nextId);
//            statement.setString(2, order.getName());
//
//            statement.executeUpdate();
//
//            order.setId(nextId);
//
//            return order;
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка создания", e);
//        }
//    }
//
//
//    public List<Order> get() {
//        List<Order> orders = new ArrayList<>();
//        String sql = "SELECT * FROM orders";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement ps = conn.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                Order order = new Order();
//                order.setId(rs.getLong("id"));
//                order.setName(rs.getString("name"));
//                orders.add(order);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка получения", e);
//        }
//        return orders;
//    }
//
//    public Order getById(long id) {
//        Order order = null;
//        String sql = "SELECT * FROM orders WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setLong(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    order = new Order();
//                    order.setId(rs.getInt("id"));
//                    order.setName(rs.getString("name"));
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка получения по id: " + id, e);
//        }
//        return order;
//    }
//
//    public Order getClientId(long id) {
//        Order order = null;
//        String sql = "SELECT * FROM orders WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setLong(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    order = new Order();
//                    order.setId(rs.getInt("id"));
//                    order.setName(rs.getString("name"));
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка получения по id: " + id, e);
//        }
//        return order;
//    }
//
//    public void update(Order order) {
//        String sql = "UPDATE orders SET name = ? WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, order.getName());
//            ps.setLong(2, order.getId());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка обновления : " + order.getId(), e);
//        }
//    }
//
//    public void delete(long id) {
//        String sql = "DELETE FROM orders WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setLong(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Ошибка удаления: " + id, e);
//        }
//    }
}