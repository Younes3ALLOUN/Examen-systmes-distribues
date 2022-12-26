package commands.category;

import commands.BaseCommand;
import lombok.Getter;

@Getter
public class CategoryCreateCommand extends BaseCommand<String> {

    private String name;
    private  String description;

    public CategoryCreateCommand(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
