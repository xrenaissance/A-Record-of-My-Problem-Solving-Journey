package main.interview.oa.amazon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnectCities {
    public static void main(String[] args) {
        List<List<Integer>> roadsAvailable = new ArrayList<List<Integer>>();
        List<Integer> roadAvail1 = new ArrayList<Integer>();
        roadAvail1.add(1);
        roadAvail1.add(4);
        roadsAvailable.add(roadAvail1);
        List<Integer> roadAvail2 = new ArrayList<Integer>();
        roadAvail2.add(4);
        roadAvail2.add(5);
        roadsAvailable.add(roadAvail2);
        List<Integer> roadAvail3 = new ArrayList<Integer>();
        roadAvail3.add(2);
        roadAvail3.add(3);
        roadsAvailable.add(roadAvail3);

        List<List<Integer>> costNewRoadsConstruct = new ArrayList<List<Integer>>();
        List<Integer> costNewRoad1 = new ArrayList<Integer>();
        costNewRoad1.add(1);
        costNewRoad1.add(2);
        costNewRoad1.add(5);
        costNewRoadsConstruct.add(costNewRoad1);
        List<Integer> costNewRoad2 = new ArrayList<Integer>();
        costNewRoad2.add(1);
        costNewRoad2.add(3);
        costNewRoad2.add(10);
        costNewRoadsConstruct.add(costNewRoad2);
        List<Integer> costNewRoad3 = new ArrayList<Integer>();
        costNewRoad3.add(1);
        costNewRoad3.add(6);
        costNewRoad3.add(2);
        costNewRoadsConstruct.add(costNewRoad3);
        List<Integer> costNewRoad4 = new ArrayList<Integer>();
        costNewRoad4.add(5);
        costNewRoad4.add(6);
        costNewRoad4.add(5);
        costNewRoadsConstruct.add(costNewRoad4);


        int cost = getMinimumCostToConstruct(6, 3, roadsAvailable, 4, costNewRoadsConstruct);
        System.out.println("cost = " + cost);
    }

    public static int getMinimumCostToConstruct(int numTotalAvailableCities,
                                  int numTotalAvailableRoads,
                                  List<List<Integer>> roadsAvailable,
                                  int numNewRoadsConstruct,
                                  List<List<Integer>> costNewRoadsConstruct)
    {
        // Step1: combine all mutual connected cities to become "city groups"
        List<int[]> cityGroups = new ArrayList<int[]>();

        // Step2: keep building the cheapest "city link" and between all "city groups", then recalculate costs between
        // "city groups", until there's only one "city group" left

        // Step3: return total cost

        return -1;
    }
}
