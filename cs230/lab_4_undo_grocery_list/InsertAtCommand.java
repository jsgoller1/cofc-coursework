package lab_4_undo_grocery_list;

import java.util.ArrayList;

public class InsertAtCommand extends UndoCommand {
    private ArrayList<String> sourceList;
    private String item;
    private int removalIndex;

    public InsertAtCommand(ArrayList<String> lst, String item, int removalIndex) {
        this.sourceList = lst;
        this.item = item;
        this.removalIndex = removalIndex;
    }

    @Override
    public void execute() {
        this.sourceList.add(removalIndex, item);
    }
}
