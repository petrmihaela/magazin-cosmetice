package data_layer.repositories;

import data_layer.models.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Integer> {


    List<Produs> findByNumeContainingIgnoreCase(String nume);

    List<Produs> findAll();

    @Query("select nume from Produs  where  id =?1")
    String getNameOfProduct(int productId);
}
