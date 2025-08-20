JAVA:=/opt/homebrew/opt/openjdk/bin/java
JAVAC:=/opt/homebrew/opt/openjdk/bin/javac
BIN_DIR:=bin/

.PHONY: 1_7

clean:
	reset
	-rm -r $(BIN_DIR)
	mkdir $(BIN_DIR)

hello_world: clean
	$(JAVAC) $@.java
	$(JAVA) Main

1_7: clean
	$(JAVAC) $@/*.java -d $(BIN_DIR)
	$(JAVA) -cp $(BIN_DIR) IntroToDSELabs