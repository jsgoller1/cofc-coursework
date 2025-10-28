JAVA:=/opt/homebrew/opt/openjdk/bin/java
JAVAC:=/opt/homebrew/opt/openjdk/bin/javac
BIN_DIR:=bin

.PHONY: natural_mergesort sorting \
lab_1_introduction \
lab_2_binary_search \
lab_3_natural_mergesort \
lab_4_undo_grocery_list \
lab_5_sorted_number_list \
lab_6_course_gradebook_with_hashmap \
lab_7_timeout_manager_with_pq \
lab_8_bst_validity_checker
 
clean:
	reset
	-rm -r $(BIN_DIR)
	mkdir $(BIN_DIR)

hello_world: clean
	$(JAVAC) $@.java
	$(JAVA) Main

algorithms: clean
	$(JAVAC) algorithms/*/*.java -d $(BIN_DIR)

sorting: algorithms
	$(JAVA) -cp $(BIN_DIR) algorithms.sorting.Sorting

searching: algorithms
	$(JAVA) -cp $(BIN_DIR) algorithms.searching.Searching

stacks heaps queues linked_lists: algorithms
	$(JAVA) -cp $(BIN_DIR) algorithms.$@.Main

lab_1_introduction: clean
	$(JAVAC) $@/*.java -d $(BIN_DIR)
	$(JAVA) -cp $(BIN_DIR) IntroToDSELabs

lab_2_binary_search: clean
	$(JAVAC) $@/*.java -d $(BIN_DIR)
	$(JAVA) -cp $(BIN_DIR) BinarySearch

lab_3_natural_mergesort: clean
	$(JAVAC) $@/*.java -d $(BIN_DIR)
	$(JAVA) -cp $(BIN_DIR) NaturalMerge

lab_4_undo_grocery_list \
lab_5_sorted_number_list \
lab_6_course_gradebook_with_hashmap \
lab_7_timeout_manager_with_pq \
lab_8_bst_validity_checker: clean 
	$(JAVAC) $@/*.java -d $(BIN_DIR)
	$(JAVA) -cp $(BIN_DIR) $@.LabProgram
