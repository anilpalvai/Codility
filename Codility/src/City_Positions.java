import java.util.*;

/*
A network consisting of M cities and M-1 roads connecting them is given. Cities are labeled with distinct integers within the range [o. (M-1)]
Roads connect cities in such a way that each pair of distinct cities is connected either by a direct road or along a path consisting of direct roads.
There is exactly one way to reach any city from any other city. In other words, cities and direct roads form a tree.
The number of direct roads that must be traversed is called the distance between these two cities.
For example, consider the following network consisting of ten cities and nine roads: 2 0 Cities 2 and 4 are connected directly, so the distance between them is 1.
Cities 4 and 7 are connected by a path consisting of the direct roads 4-0,0-9 and 9-7; hence the distance between them is 3.
One of the cities is the capital, and the goal is to count the number of cities positioned away from it at each of the distances 1,2,3,.., M -1.
If city number 1 is the capital, then the cities positioned at the various distances from the

        If city number 1 is the capital, then the cities positioned at the various distances from the capital would be as follows: . 9 is at a distance of 1 ·
        0, 3, 7 are at a distance of 2;
        4 are at a distance of 3;
        2, 5, 6 are at a distance of 4.

        Write a function: class Solution t public int[] solution(int[] T)h that, given a non-empty array T consisting of M integers describing a network of M cities and M 1 roads,
        returns an array consisting of M-1 integers, specifying the number of cities positioned at each distance 1, 2,..., M - 1. Array T describes a network of cities as follows: ·

        if T[P] Q and P = Q, then P is the capital;
        if T[P Q and P Q, then there is a direct road between cities P and Q.

        For example, given the following array T consisting of ten elements: T[2] 4 T[6]8 T[9] = 1 = 9 T[7]
        the function should return [1, 3, 2,3,0,0,0,0,0],
        as explained above. Write an efficient algorithm for the following assumptions:
              M is an integer within the range [1..100,000]; each element of array T is an integer within the range [0.M-1]
              there is exactly one (possibly indirect) connection between any two distinct cities.
*/

public class City_Positions {


    public static void main(String[] args) {
       int[] ip={9,1,4,9,0,4,8,9,0,1};
        City_Positions cp=new City_Positions();
        System.out.println(Arrays.toString(cp.solution(ip)));


    }

    public int[] solution(int[] ip)   {
        int[] res=null;
        if(ip.length<1|| ip.length>100000){
            return res;
        }
        res=new int[ip.length-1];
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        int start=-1;

        for(int i=0;i<ip.length;i++){
            hm.put(i,null);
        }
        for(int i=0;i<ip.length;i++){
            if(ip[i]>=ip.length){
                return res;
            }
            if(i==ip[i]){
                start=i;
                continue;
            }
            if(hm.get(ip[i])!=null){
                List<Integer> val_list=hm.get(ip[i]);
                val_list.add(i);
                hm.put(ip[i],val_list);


            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                hm.put(ip[i],list);

            }
        }

        res=maker(start,hm,ip.length-1);
        return res;

    }

    private int[] maker(int start, HashMap<Integer, List<Integer>> hm,int res_size) {
        int[] res=new int[res_size];
        int size=0;
        List<Integer> nextList=new ArrayList<>();
        nextList.add(start);
        List<Integer> newList=new ArrayList<>() ;


        for (int i = 0; i <res.length ; i++) {
            for (Integer in : nextList) {
                if (hm.get(in) != null){
                    newList.addAll(hm.get(in));

                    size = size + hm.get(in).size();
                    }

                }
            res[i]=size;
            nextList.clear();
            nextList.addAll(newList);
            newList.clear();
            size=0;


        }
        return  res;
    }


}
