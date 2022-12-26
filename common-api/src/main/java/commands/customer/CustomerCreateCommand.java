package commands.customer;

import commands.BaseCommand;
import lombok.Getter;

@Getter
public class CustomerCreateCommand extends BaseCommand<String> {

    private String name;
    private String adresse;
    private String email;
    private String phone;

    public CustomerCreateCommand(String id,  String name, String adresse, String email, String phone) {
        super(id);

        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
    }
}
