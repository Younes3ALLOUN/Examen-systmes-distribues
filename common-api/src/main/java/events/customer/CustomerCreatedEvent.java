package events.customer;

import commands.BaseCommand;
import events.BaseEvent;
import lombok.Getter;

@Getter
public class CustomerCreatedEvent extends BaseEvent<String> {

    private String name;
    private String adresse;
    private String email;
    private String phone;

    public CustomerCreatedEvent(String id, String name, String adresse, String email, String phone) {
        super(id);

        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
    }
}
