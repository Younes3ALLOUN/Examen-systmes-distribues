package queries.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor  @AllArgsConstructor
public class GetCustomerByIdQuery {
    private String customerId;
}
