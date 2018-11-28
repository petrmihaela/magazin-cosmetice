package data_layer.repositories;

import data_layer.dto.ProductDto;
import data_layer.models.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Integer> {


    List<Produs> findByNumeContainingIgnoreCase(String nume);

    List<Produs> getAllProdus();

    @Modifying
    @Query("select url from Imagine i where i.id_produs=?1")
    List<String> getUrlForProduct(int id);
}
