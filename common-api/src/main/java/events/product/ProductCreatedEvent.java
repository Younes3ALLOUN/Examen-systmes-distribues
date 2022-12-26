package events.product;

import commands.BaseCommand;
import enums.ProductStatus;
import events.BaseEvent;
import lombok.Getter;

@Getter
public class ProductCreatedEvent extends BaseEvent<String> {
        private String name;
        private double price;
        private int qte;
        private ProductStatus status;
        private String categoryId;
    public ProductCreatedEvent(String id, String name, double price, int qte, ProductStatus status, String categoryId) {
        super(id);
        this.name = name;
        this.price = price;
        this.qte = qte;
        this.status = status;
        this.categoryId = categoryId;
    }
}
