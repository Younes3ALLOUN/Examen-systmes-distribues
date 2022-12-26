package ma.enset.CustomerService.commandSide.aggregate;

import commands.customer.CustomerCreateCommand;
import commands.customer.CustomerUpdateCommand;
import events.customer.CustomerCreatedEvent;
import events.customer.CustomerUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String adresse;
    private String email;
    private String phone;

    public CustomerAggregate() {
    }
@CommandHandler
    public CustomerAggregate(CustomerCreateCommand command) {
        log.info("===========> create command recieved");
    AggregateLifecycle.apply(new CustomerCreatedEvent(
            command.getId(), command.getName(), command.getAdresse(),
            command.getEmail(),
            command.getPhone()
    ));
    }
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        log.info("===========> create Event recieved");
        this.id = event.getId();
        this.name = event.getName();
        this.adresse = event.getAdresse();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }

    @CommandHandler
    public void updateCustomer(CustomerUpdateCommand command){
        log.info("===========> update command recieved");
        AggregateLifecycle.apply(new CustomerUpdatedEvent(
                command.getId(), command.getName(), command.getAdresse(),
                command.getEmail(),
                command.getPhone()
        ));
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        log.info("===========> update Event recieved");
        this.id = event.getId();
        this.name = event.getName();
        this.adresse = event.getAdresse();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }
}
