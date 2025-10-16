package lab_4_undo_grocery_list;

import java.util.ArrayList;

public class SwapCommand extends UndoCommand {
    private ArrayList<String> sourceList;
    int index1, index2;

    public SwapCommand(ArrayList<String> lst, int index1, int index2) {
        this.sourceList = lst;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public void execute() {
        String item1 = this.sourceList.get(index1);
        String item2 = this.sourceList.get(index2);
        this.sourceList.set(index2, item1);
        this.sourceList.set(index1, item2);
    }

}
