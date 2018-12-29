package data_layer.repositories;

import data_layer.models.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Integer> {

  //  @Modifying
//    @Query("select count(id) from MyOrder o where o.data_comanda like '%?1%'")
    int countByDatacomandaContaining(String month);
}
