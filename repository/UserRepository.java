package CRUD_RESTful_Mecanica.repository;

import CRUD_RESTful_Mecanica.config.DatabaseConnection;
import CRUD_RESTful_Mecanica.model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class UserRepository {
    
    private Connection connection;

    //Conexão com o db
    public UserRepository(){
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    //Operações CRUD
    //Create

    public User saveUser(User user){
        String sql_insert = "INSERT INTO users (name, contact, role, email, password) " + "VALUES (?, ?, ?, ?, ?)";
        
        try(PreparedStatement stmt = connection.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getContact());
            stmt.setString(3, user.getRole().toString());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            return user;

        } catch (SQLException e){
            throw new RuntimeException("Failed to save User", e);
        }

    }
}
