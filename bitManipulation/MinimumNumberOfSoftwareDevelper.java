package bitManipulation;

import java.util.*;

public class MinimumNumberOfSoftwareDevelper {
    static ArrayList<Integer> sol = new ArrayList<>();

    public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int skillsMask) {

        if (cp == people.length) {
            if (skillsMask == ((1 << nskills) - 1)) {        // this will check all last bits (skill bits) are 1's or not
                if (sol.size() == 0 || sol.size() > onesol.size()) {
                    sol = new ArrayList<>(onesol);
                }
            }
            return;
        }

        solution(people, nskills, cp + 1, onesol, skillsMask); // no case

        onesol.add(cp);
        solution(people, nskills, cp + 1, onesol, (skillsMask | people[cp])); // yes case
        onesol.remove(onesol.size() - 1);

    }

    public static void main(String[] args) {

        // INPUT:
        // 3
        // java nodejs reactjs
        // 3
        // 1
        // java
        // 1
        // nodejs
        // 2
        // nodejs
        // reactjs

        // OUTPUT: 
        // [0, 2]
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // no of skills

        HashMap<String, Integer> smap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            smap.put(scn.next(), i);
        }

        int np = scn.nextInt(); // no of people

        int[] people = new int[np];

        for (int i = 0; i < np; i++) {
            int personSkills = scn.nextInt();
            // create skills mask for each person
            for (int j = 0; j < personSkills; j++) {
                String skill = scn.next();
                int snum = smap.get(skill);
                people[i] = people[i] | (1 << snum);
            }
        }

        scn.close();

        solution(people, n, 0, new ArrayList<>(), 0);
        System.out.println(sol);

    }
}
