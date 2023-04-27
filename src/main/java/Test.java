import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Test {


    List<Node> distOfWords = new ArrayList<>();

    public static void main(String[] args) {
        Test test = new Test();
        List<String> suggestion = findSuggestion("aa");

        test.buildWordGraph("ball");
    }

    private static List<String> findSuggestion(String aa) {
        return null;
    }



    private List<Node> buildWordGraph(String word) {

        ExecutorService executorService = new ScheduledThreadPoolExecutor(5);
        Runnable runnable = () -> System.out.println(word);
        executorService.submit(runnable);


        if (word == null || word.isEmpty() || word.isBlank())
            return Collections.emptyList();

        Node tempNode = null;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(0);
            if (tempNode != null && tempNode.getNext() != null) {
                Optional<Node> node = tempNode.getNext().stream().filter(value -> value.alpha == c).findFirst();
                if (node.isPresent())
                    tempNode = node.get();
                else {
                    Node node1 = new Node(c);
                    tempNode.setNext(new Node(c));
                    tempNode = node1;
                }
            }
            else if (distOfWords.contains(c)) {
                Node node = distOfWords.stream().filter(value-> value.alpha == c).findFirst().get();
                tempNode = node;
            } else {
                Node node = new Node(c);
                distOfWords.add(node);
                tempNode = node;
            }

        }
        return distOfWords;
    }

    class  Node {
        char alpha;
        Set<Node> next;

        public Node(char alpha) {
            this.alpha = alpha;
        }

        public char getAlpha() {
            return alpha;
        }

        public void setAlpha(char node) {
            this.alpha = node;
        }

        public Set<Node> getNext() {
            return next;
        }

        public void setNext(Node next) {
            if (this.next == null)
                this.next = new HashSet<>();
            this.next.add(next);
        }
    }
}
