package lab_4_undo_grocery_list;

import java.util.*;
import java.io.PrintWriter;

public class GroceryList {
    protected ArrayList<String> listItems = new ArrayList<String>();
    protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

    public void addWithUndo(String newItemName) {
        // Add the new list item
        listItems.add(newItemName);

        // Make an undo command that removes the last item and push onto stack
        undoStack.push(new RemoveLastCommand(listItems));
    }

    public void removeAtWithUndo(int removalIndex) {
        // The method removes the list item at the specified index, then pushes an
        // InsertAtCommand, to undo that removal, onto the undo stack.
        String item = this.listItems.get(removalIndex);
        this.listItems.remove(removalIndex);
        undoStack.push(new InsertAtCommand(listItems, item, removalIndex));
    }

    public void swapWithUndo(int index1, int index2) {
        String item1 = this.listItems.get(index1);
        String item2 = this.listItems.get(index2);
        this.listItems.set(index2, item1);
        this.listItems.set(index1, item2);

        undoStack.push(new SwapCommand(listItems, index1, index2));
    }

    // Pop and execute the command at the top of the stack
    public void executeUndo() {
        UndoCommand cmd = undoStack.pop();
        cmd.execute();
    }

    final int getListSize() {
        return listItems.size();
    }

    final int getUndoStackSize() {
        return undoStack.size();
    }

    final ArrayList<String> getVectorCopy() {
        return listItems;
    }

    public void print(PrintWriter outputStream) {
        for (int i = 0; i < listItems.size(); i++) {
            outputStream.write(i + ". " + listItems.get(i) + "\n");
        }
    }
}
