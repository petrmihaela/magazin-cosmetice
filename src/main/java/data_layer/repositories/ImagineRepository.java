package data_layer.repositories;

import data_layer.models.Imagine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagineRepository extends JpaRepository<Imagine, Integer> {

    @Modifying
    @Query("select url from Imagine i where i.id_produs=?1")
    List<String> getUrlForProduct(int id);
}
