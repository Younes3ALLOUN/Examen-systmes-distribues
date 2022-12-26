package events.customer;

import events.BaseEvent;
import lombok.Getter;

@Getter
public class CustomerUpdatedEvent extends BaseEvent<String> {

    private String name;
    private String adresse;
    private String email;
    private String phone;

    public CustomerUpdatedEvent(String id, String name, String adresse, String email, String phone) {
        super(id);

        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
    }
}
