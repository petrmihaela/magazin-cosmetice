package data_layer.poolingSystem;

import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

public class PoolFactory {
    private static String url = "jdbc:postgresql://ec2-50-19-249-121.compute-1.amazonaws.com:5432/d7mbmh0uc5ugj4?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private static String password = "4036580fff2d5e292945c640e29b0727140775b3265bf6561518296ac723099e";
    private static String username = "rjgzravucbcaed";

    @Bean
    public static ConnectionPool createPool(String poolType) {
        switch (poolType) {
            case "CONNECTION_POOL":
                try {
                    return BasicConnectionPool.create(url, username, password);
                } catch (SQLException e){
                    System.out.println("Could not create connections!");
                }
            default:
                return null;
        }
    }
}
