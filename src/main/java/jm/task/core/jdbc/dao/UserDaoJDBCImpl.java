package jm.task.core.jdbc.dao;

import com.mysql.cj.jdbc.ha.MultiHostMySQLConnection;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoJDBCImpl implements UserDao {
    private static Util util = new Util();
    Connection conn = null;

    {
        try {
            conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD);
        } catch (SQLException e) {
            System.out.println("conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD): вызвал ошибку" + e);
        }

    }


    ;

//    static Connection connection = new Connection();//Util.runConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Statement statement = conn.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS TableIvan (id BIGINT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(50), Last_Name VARCHAR(50), age INT)");
            System.out.println("String SQL отработал");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("try (Connection conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD))");
        }

    }

    public void dropUsersTable() {
        try (Connection conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD)) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS TableIvan");
            System.out.println("Таблица удалена");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("try (Connection conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD))");
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD)) {

            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO TableIvan (Name, Last_Name, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь с именем: " + name + " " + lastName + " добавлен в базу данных");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("try (Connection conn = DriverManager.getConnection(Util.URL, Util.NAME, Util.PASSWORD))");
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (User user : users) {
            users.add(user);
            System.out.println(user + "users.size() = " + users.size());
        }
        return users;
    }

    public void cleanUsersTable() {

    }
}
