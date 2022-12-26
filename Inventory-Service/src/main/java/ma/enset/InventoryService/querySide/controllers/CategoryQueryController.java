package ma.enset.InventoryService.querySide.controllers;

import lombok.AllArgsConstructor;
import ma.enset.InventoryService.querySide.entities.Category;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.category.GetAllCategoriesQuery;

import java.util.List;

@RestController
@RequestMapping("/queries/category")
@AllArgsConstructor
public class CategoryQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        List<Category> categories = queryGateway.query(new GetAllCategoriesQuery(), ResponseTypes.multipleInstancesOf(Category.class)).join();
        return categories;
    }

}
