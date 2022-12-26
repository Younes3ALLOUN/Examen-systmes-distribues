package ma.enset.InventoryService.CommandSide.aggregates;

import commands.category.CategoryCreateCommand;
import commands.category.CategoryUpdateCommand;
import events.category.CategoryCreatedEvent;
import events.category.CategoryUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private  String description;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CategoryCreateCommand command) {
        AggregateLifecycle.apply(new CategoryCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription()
        ));

    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event){
        this.id= event.getId();
        this.name= event.getName();
        this.description= event.getDescription();
    }

    @CommandHandler
    public void updateCategory(CategoryUpdateCommand command) {
        AggregateLifecycle.apply(new CategoryUpdatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription()
        ));

    }

    @EventSourcingHandler
    public void on(CategoryUpdatedEvent event){
        this.name= event.getName();
        this.description= event.getDescription();
    }



}
