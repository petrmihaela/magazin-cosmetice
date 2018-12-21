package data_layer.repositories;

import data_layer.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByProdusidEquals(int id);

    @Modifying
    @Query("update Stock s set s.cantitate = ?1 where s.id = ?2")
    void updateCantitate(int cantitate, int id);

}
