package backendapi.service;

import backendapi.model.EcomOrder;
import backendapi.repository.EcomOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vaibhavhajela on 27/12/20.
 */
@Service
public class EcomOrderService {

    @Autowired
    EcomOrderRepository ecomOrderRepository;

    public List<EcomOrder> getEcomOrders(){
        return ecomOrderRepository.findAll();
    }
}
