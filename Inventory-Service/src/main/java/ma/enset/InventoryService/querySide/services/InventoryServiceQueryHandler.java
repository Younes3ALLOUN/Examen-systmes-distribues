package ma.enset.InventoryService.querySide.services;

import events.category.CategoryCreatedEvent;
import lombok.AllArgsConstructor;
import ma.enset.InventoryService.querySide.entities.Category;
import ma.enset.InventoryService.querySide.repositories.CategoryRepository;
import ma.enset.InventoryService.querySide.repositories.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.category.GetAllCategoriesQuery;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceQueryHandler {
    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    @EventHandler
    public  void on(CategoryCreatedEvent event){
        Category category =new Category();
        category.setId(event.getId());
        category.setName(event.getName());
        category.setDescription(event.getDescription());
        categoryRepository.save(category);
    }

    @QueryHandler
    public List<Category> on(GetAllCategoriesQuery query){
        return categoryRepository.findAll();
    }
}
