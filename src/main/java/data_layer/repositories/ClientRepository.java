package data_layer.repositories;

import data_layer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Customer, Integer> {

    Customer findByUsernameAndParola(String username, String parola);

}
