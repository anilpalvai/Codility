import java.util.*;

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
