package dtos.product;

import enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductReqDto {
    private String name;
    private double price;
    private int qte;
    private ProductStatus status;
    private String categoryId;
}
