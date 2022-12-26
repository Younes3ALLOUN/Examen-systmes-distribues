package commands.category;

import commands.BaseCommand;
import lombok.Getter;

@Getter
public class CategoryUpdateCommand extends BaseCommand<String> {

    private String name;
    private  String description;

    public CategoryUpdateCommand(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
