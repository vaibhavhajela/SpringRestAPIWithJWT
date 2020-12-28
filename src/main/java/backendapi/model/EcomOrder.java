package backendapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vaibhavhajela on 27/12/20.
 */
@Entity
@Table(name="EcommerceOrder")
public class EcomOrder {

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "EcomOrder{" +
                "Id='" + Id + '\'' +
                ", product='" + product + '\'' +
                '}';
    }

    @Id
    private String Id;



    private String product;

    public EcomOrder(String id, String product) {
        Id = id;
        this.product = product;
    }

    public EcomOrder() {
    }

}
