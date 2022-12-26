package commands.product;

import commands.BaseCommand;
import enums.ProductStatus;
import lombok.Getter;

@Getter
public class ProductUpdateCommand extends BaseCommand<String> {
        private String name;
        private double price;
        private int qte;
        private ProductStatus status;
        private String categoryId;
    public ProductUpdateCommand(String id, String name, double price, int qte, ProductStatus status, String categoryId) {
        super(id);
        this.name = name;
        this.price = price;
        this.qte = qte;
        this.status = status;
        this.categoryId = categoryId;
    }
}
