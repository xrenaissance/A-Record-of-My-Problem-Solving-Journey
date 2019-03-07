package main.interview.oa.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum_AmazonMusic {
    public static void main(String[] args) {
        ArrayList<Integer> songs = new ArrayList<>();
//        songs.add(1);
//        songs.add(10);
//        songs.add(25);
//        songs.add(35);
//        songs.add(60);
//        songs.add(59);
//        songs.add(1);
//        List<Integer> result = IDsOfSongs(90, songs);
        songs.add(100);
        songs.add(180);
        songs.add(40);
        songs.add(120);
        songs.add(10);

        List<Integer> result = IDsOfSongs(250, null);

        for(int s: result) {
            System.out.println(s + " ");
        }
    }

    public static ArrayList<Integer> IDsOfSongs(int rideDuration, ArrayList<Integer> songDurations) {
        // Init
        ArrayList<Integer> result = new ArrayList<Integer>();
        int longestDuration = 0;
        ArrayList<int[]> candidates = new ArrayList<int[]>();
        int targetDuration = rideDuration - 30;
        if(targetDuration <= 0 || songDurations == null || songDurations.isEmpty()) {
            System.out.println("aha!");
            return result;
        }

        // Construct a hash map to record all occurrences
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < songDurations.size(); i++) {
            map.put(songDurations.get(i), i);
        }

        // Get all possible solutions
        for(int i=0; i < songDurations.size(); i++) {
            int desiredDuration = targetDuration - songDurations.get(i);
            if(map.containsKey(desiredDuration)) {
                candidates.add(new int[] {i, map.get(desiredDuration)});
                map.remove(songDurations.get(i));
                map.remove(desiredDuration);
            }
        }

        // Get the candidate pair with longest song
        for(int[] candidate: candidates) {
            if(songDurations.get(candidate[0]) > longestDuration || songDurations.get(candidate[1]) > longestDuration) {
                longestDuration = Math.max(songDurations.get(candidate[0]), songDurations.get(candidate[1]));
                result.clear();
                result.add(candidate[0]);
                result.add(candidate[1]);
            }
        }

        // Debug
        result.add(1337);
        result.add(rideDuration);
        result.addAll(songDurations);

        return result;
    }
}
