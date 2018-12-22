package data_layer.repositories;

import data_layer.models.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Integer> {
}
