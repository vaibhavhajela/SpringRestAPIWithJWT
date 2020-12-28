package backendapi.repository;

import backendapi.model.EcomOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vaibhavhajela on 27/12/20.
 */
public interface EcomOrderRepository extends JpaRepository<EcomOrder,String>{
}
