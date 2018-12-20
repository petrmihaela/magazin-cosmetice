package data_layer.repositories;

import data_layer.models.Comanda;
import data_layer.models.ProdCom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdComRepository extends JpaRepository<ProdCom, Integer> {
}
