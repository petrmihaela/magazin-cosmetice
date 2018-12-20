package data_layer.repositories;

import data_layer.models.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {
}
