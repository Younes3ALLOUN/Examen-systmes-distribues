package ma.enset.InventoryService.querySide.repositories;

import ma.enset.InventoryService.querySide.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
