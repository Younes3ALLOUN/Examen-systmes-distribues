package events.category;

import commands.BaseCommand;
import events.BaseEvent;
import lombok.Getter;

@Getter
public class CategoryCreatedEvent extends BaseEvent<String> {

    private String name;
    private  String description;

    public CategoryCreatedEvent(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
