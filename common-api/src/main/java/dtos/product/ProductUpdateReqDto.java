package dtos.product;

import enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductUpdateReqDto {
    private String id;
    private String name;
    private double price;
    private int qte;
    private ProductStatus status;
    private String categoryId;
}
