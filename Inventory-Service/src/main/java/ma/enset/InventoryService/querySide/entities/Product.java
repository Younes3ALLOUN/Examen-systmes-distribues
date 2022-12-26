package ma.enset.InventoryService.querySide.entities;

import enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int qte;
    private ProductStatus status;
    @ManyToOne
    private Category category;
}
