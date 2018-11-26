package data_layer.repositories;

import data_layer.models.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Integer> {

    /*@Modifying
    @Query("select * from produs where nume like ")
    void setMovieTitleById(String nume);
*/
    List<Produs> findByNumeContainingIgnoreCase(String nume);

}
