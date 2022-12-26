package dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerReqDto {
    private String name;
    private String adresse;
    private String email;
    private String phone;
}
