package stack;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeInterval {

    @ToString
    static class Intervals {
        public int start, end;

        public Intervals(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static void mergeIntervals() {
        List<Intervals> intervals = new ArrayList<>();
        intervals.add(new Intervals(1,3));
        intervals.add(new Intervals(2,4));
        intervals.add(new Intervals(6,8));
        intervals.add(new Intervals(9,10));

        intervals.sort(Comparator.comparingInt(a -> a.start));

       Stack<Intervals> stack = new Stack<>();


        for (int i = 0; i <  intervals.size(); i++) {
            Intervals item = intervals.get(i);
            if (stack.isEmpty())
                stack.push(item);
            else {
                Intervals peek = stack.peek();
                if (peek.end >= item.start) {
                    Intervals pop = stack.pop();
                    stack.push(new Intervals(pop.start, item.end));
                } else {
                 stack.push(item);
                }

            }

        }

        stack.forEach(System.out::print);

    }

    public static void main(String[] args) {
        mergeIntervals();

    }


}
