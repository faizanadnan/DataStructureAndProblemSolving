import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Notepad {
    private Stack<String> data = new Stack<>();
    private Stack<String> undoData = new Stack<>();

    void addWord(String word) {
        data.push(word);
        if (!undoData.isEmpty()) {
            undoData.clear();
        }
    }

    String save() {
        String finalData = getData();
        data.clear();
        undoData.clear();
        return finalData;
    }

    // input hello word!
    String getData() {
        String finalData = "";
        if (data.isEmpty()) {
            return finalData;
        }
        for (int i = data.size() - 1; i >= 0; i--) {
            finalData = data.get(i) + finalData;
        }
        return finalData.trim();
    }

    void undo() {
        if (data.isEmpty()) {
            return;
        }
        undoData.push(data.pop());

    }

    void redo() {
        if (undoData.isEmpty()) {
            return;
        }

        String removedWord = undoData.pop();
        data.push(removedWord);
    }

    void notepadRunner() {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            Stream.of(line.split(" "))
                    .forEach(word->{

                        if (word.equalsIgnoreCase("~exit")) {
                            System.out.println(save());
                            System.exit(1);
                        }
                        data.push(word);
                        data.push(" ");


                        if (word.equalsIgnoreCase("undo")) {
                            undo();
                        }

                        if (word.equalsIgnoreCase("redo")) {
                            undo();
                        }

                    });

        }


    }


    public static void main(String[] args) throws InterruptedException {
        Notepad notepad = new Notepad();
        notepad.addWord("Hello");
        notepad.addWord(" ");
        notepad.addWord("Testing");
        notepad.addWord(" ");
        notepad.addWord("Code");

        System.out.println(notepad.getData());
        Thread.sleep(1000);

        notepad.undo();
        System.out.println(notepad.getData());
        Thread.sleep(1000);

        notepad.addWord(" ");
        notepad.addWord("Java");
        notepad.addWord(" ");
        notepad.addWord("code.");


        System.out.println(notepad.getData());
        Thread.sleep(1000);

        notepad.undo();
        System.out.println(notepad.getData());
        Thread.sleep(1000);

        notepad.redo();
        System.out.println(notepad.getData());
        Thread.sleep(1000);
    }


}