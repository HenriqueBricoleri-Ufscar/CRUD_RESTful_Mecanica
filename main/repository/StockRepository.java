package CRUD_RESTful_Mecanica.main.repository;

import CRUD_RESTful_Mecanica.main.config.DatabaseConnection;
import CRUD_RESTful_Mecanica.main.model.Stock;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class StockRepository {
    
    private Connection connection;

    public StockRepository(){
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    //Create novo Item
    public Stock saveStock(Stock stock){
        String sql_saveNew = "INSERT INTO stocks(name, quantity, car_model, car_year) VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql_saveNew, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, stock.getName());
            stmt.setInt(2, stock.getQuantity());
            stmt.setString(3, stock.getCar_model());
            stmt.setInt(4, stock.getCar_year());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                stock.setId(rs.getString(1));
            }
            return stock;
            
        } catch (SQLException e){
            throw new RuntimeException("Failed to save Stock", e);
        }
    }

    //Search by id
    public Optional<Stock> searchStockById(String id){
        String sql_searchKey = "SELECT * FROM stocks WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql_searchKey)) {
            
            stmt.setString(1, id);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return Optional.of(mapResultSet(rs));
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to search Stock", e);
        }
    }

    //Update Stock por id
    public Stock  updateStockById_qtt(Stock stock, int new_quantity){
        String sql_updateQtt = "UPDATE users SET quantity = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql_updateQtt)) {
            
            stmt.setInt(1, new_quantity);
            stmt.setString(2, stock.getId());
            stmt.executeUpdate();

            return stock;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update Stock", e);
        }
    }

    //Delete Stock by id
    public void DeleteStockById(String id){
        String sql_deleteStock = "DELETE FROM stocks WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql_deleteStock)){
            
            stmt.setString(0, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete Stock", e);
        }
    }


    //Aux func
    private Stock mapResultSet(ResultSet set) throws SQLException{
        Stock stock = new Stock();

        stock.setId(set.getString("id"));
        stock.setName(set.getString("name"));
        stock.setQuantity(set.getInt("quantity"));
        stock.setCar_model(set.getString("car_model"));
        stock.setCar_year(set.getInt("car_year"));

        return stock;
    }
}
