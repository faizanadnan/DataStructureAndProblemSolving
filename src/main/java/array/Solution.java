package array;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static String pluralityWinner(Map<List<String>, Integer> ballots) {
        Map<String, Integer> allCandidatesWithVotes = allCandidateVsVotes(ballots);
        if (allCandidatesWithVotes == null) return "";
        String winner = "";
        int max = 0;
        for (Map.Entry<String, Integer> keyValue: allCandidatesWithVotes.entrySet()) {

            Integer value = keyValue.getValue();

            if (value > max) {
                max = value;
                winner = keyValue.getKey();
            }
        }
        return winner;
    }
    public static String rankedChoiceWinner(Map<List<String>, Integer> ballots) {

        String looser = "";

        Map<List<String>, Integer> withoutLeastVotedCandidate = new HashMap<>(ballots);
        // remove the looser
        boolean hasMoreThan2Elements = true;
        while(hasMoreThan2Elements) {

            int max = Integer.MAX_VALUE;
            Map<String, Integer> allCandidatesWithVotes = allCandidateVsVotes(withoutLeastVotedCandidate);
            for (Map.Entry<String, Integer> keyValue: allCandidatesWithVotes.entrySet()) {
                Integer value = keyValue.getValue();
                if (value < max) {
                    max = value;
                    looser = keyValue.getKey();
                }
            }

            final String loser2 = looser;
            for (Map.Entry<List<String>, Integer> keyValue : new HashSet<>(withoutLeastVotedCandidate.entrySet())) {
                withoutLeastVotedCandidate.remove(keyValue.getKey());
                List<String> withoutLooser = keyValue.getKey()
                        .stream()
                        .filter(candidate -> !candidate.equals(loser2))
                        .collect(Collectors.toList());
                if (withoutLooser.size() == 2) {
                    hasMoreThan2Elements = false;
                }
                Integer integer = Optional.ofNullable(withoutLeastVotedCandidate.get(withoutLooser)).orElse(0);
                withoutLeastVotedCandidate.put(withoutLooser, keyValue.getValue() + integer);
            }
        }
        return pluralityWinner(withoutLeastVotedCandidate);
    }

    public static void main(String[] args) {
        // Sample Test Case
        final Map<List<String>, Integer> ballots = new HashMap<>();
        ballots.put(Arrays.asList("A", "B", "C", "E"), 4);
        ballots.put(Arrays.asList("B", "C", "A", "E"), 3);
        ballots.put(Arrays.asList("C", "B", "A", "E"), 2);

        System.out.println("The plurality winner is: " + pluralityWinner(ballots));
        System.out.println("The ranked choice winner is: " + rankedChoiceWinner(ballots));
    }


    private static Map<String, Integer> allCandidateVsVotes(Map<List<String>, Integer> ballots) {
        Map<String, Integer> allCandidatesWithVotes = new HashMap<>();
        if (ballots.isEmpty()) {
            return null;
        }
        else {
            for (Map.Entry<List<String>, Integer> keyValue: ballots.entrySet()) {
                String candidate = keyValue.getKey().get(0);
                Integer value = keyValue.getValue();

                Integer integer = allCandidatesWithVotes.get(candidate);
                if (integer != null) {
                    allCandidatesWithVotes.put(candidate, integer + value);
                } else {
                    allCandidatesWithVotes.put(candidate, value);
                }
            }
        }
        return allCandidatesWithVotes;
    }
}

