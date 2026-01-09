package CRUD_RESTful_Mecanica.main.repository;

import CRUD_RESTful_Mecanica.main.config.DatabaseConnection;
import CRUD_RESTful_Mecanica.main.model.User;

import java.sql.*;
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
            if (rs.next()){
                user.setId(rs.getString(1));
            }
            return user;

        } catch (SQLException e){
            throw new RuntimeException("Failed to save User", e);
        }
    }

    //Update
    //Usuário pode mudar apenas seu Nome e Email
    //As roles são controladas pelo servidor
    public User updateUser(User user) {
        String sql_update = "UPDATE users SET nome = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql_update)){

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getId());

            stmt.executeUpdate();

            return user;

        } catch (SQLException e){
            throw new RuntimeException("Failed to update User", e);
        }
    }

    //Busca
    //Retorna uma lista de usuarios
    public List<User> searchAllUser(){
        String sql_searchAllUser = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try(PreparedStatement stmt = connection.prepareStatement(sql_searchAllUser); 
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                users.add(mapResultSet(rs));
            }

            return users;

        } catch (SQLException e){
            throw new RuntimeException("Failed to Search all User", e);
        }
    }


    //Busca por id
    //Retorna um objeto do tipo Optional
    public Optional<User> searchUserById(String id){
        String sql_searchById = "SELECT * FROM users WHERE id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql_searchById)){

            stmt.setString(1, sql_searchById);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return Optional.of(mapResultSet(rs));
            }

            return Optional.empty();

        } catch(SQLException e){
            throw new RuntimeException("Failed to Search by id User", e);
        }
    }

    //Delete por Id
    public void deleteUserById(String id){
        String sql_deleteById = "DELETE FROM users WHERE id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql_deleteById)){
            
            stmt.setString(1, sql_deleteById);
            stmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Failed to delete User", e);
        }
    }

    //Aux Func
    private User mapResultSet(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setContact(rs.getString("contact"));
        user.setRole(User.Role.valueOf(rs.getString("role")));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
