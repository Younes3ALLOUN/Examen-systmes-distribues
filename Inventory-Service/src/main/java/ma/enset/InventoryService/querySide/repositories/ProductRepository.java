package ma.enset.InventoryService.querySide.repositories;

import ma.enset.InventoryService.querySide.entities.Category;
import ma.enset.InventoryService.querySide.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
