package CRUD_RESTful_Mecanica.config;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;

    //Construtor que passa os dados do db (url, user e senha) para o arquivo do projeto
    //Utilizado apenas dentro da própria classe
    private DatabaseConnection(){
        try{
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().
                                getResourceAsStream("db.properties");
            
            props.load(input);
            
            Class.forName(props.getProperty("db.driver"));

            this.connection = DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
            );

        } catch(Exception e) {
            throw new RuntimeException("Database connection error", e);
        }
    }
    
    //Cria uma instancia mantendo o encapsulamento do construtor
    //Mantém todas as modificações dessa classe dentro dela mesma
    //Trabalha apenas com getters e o construtor
    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    //Retorna a conexão com o banco
    //utilizado para fazer chamadas ao banco
    public Connection getConnection(){
        return connection;
    }
}
