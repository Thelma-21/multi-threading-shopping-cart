package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements Comparator<CustomerDTO> {
    private String customerName;
    private String productName;
    private long productQuantity;


    @Override
    public int compare(CustomerDTO o1, CustomerDTO o2) {
        return Long.compare(o2.getProductQuantity(), o1.getProductQuantity());

    }
}
