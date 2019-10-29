
import com.sun.tools.javac.util.Convert;

import java.util.*;

class Maxcounters {
    public static void main(String[] args) {

        int[] a={3,4,4,6,1,4,4};
        Maxcounters sm=new Maxcounters();

        int[] res = sm.solution(5,a);
        System.out.println(Arrays.toString(res));
    }

    public int[] solution(int n,int[] a) {
        int[] em=new int[0];
        int flg=0;
        int maxflg=-1;

        if(n<1||n>100000||a.length<1||a.length>100000){
            return  em;
        }
        int max=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for (int i = 1; i <n+1 ; i++) {
            hm.put(i,0);
        }
        for(int j=0; j<a.length; j++){

            if (a[j]==n+1){

                    hm.put(maxflg,a[maxflg]-max);
                    flg=flg+max;

            }
            else{
                int nv=hm.get(a[j]);
                nv++;
                hm.put(a[j],nv);
                if(max<nv){
                    max=nv;
                    maxflg=a[j];
                }


            }
            System.out.println(hm);

        }
        int[] res=hm.values().stream().mapToInt(Integer::intValue).toArray();
        int[] newres=new int[res.length];
        for (int iz = 0; iz <res.length ; iz++) {
            newres[iz]=res[iz]+flg;

        }
        return newres;
    }

}





