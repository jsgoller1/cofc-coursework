package lab_4_undo_grocery_list;

import java.util.ArrayList;

public class RemoveLastCommand extends UndoCommand {
    private ArrayList<String> sourceList;

    public RemoveLastCommand(ArrayList<String> lst) {
        this.sourceList = lst;
    }

    @Override
    public void execute() {
        this.sourceList.remove(sourceList.size()-1);
    }
}
