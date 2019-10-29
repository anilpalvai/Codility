
import java.util.*;


public class Brackets {
    public static void main(String[] args) {
        String s="{{{{";
        Brackets sm=new Brackets();
        int res = sm.solution(s);
        System.out.println(res);
    }

    public int solution(String s) {

        Stack<Character> st=new Stack<Character>();
        List<Character> lin= new ArrayList<>();
        lin.add('{');
        lin.add('[');
        lin.add('(');


        for (int i = 0; i < s.length(); i++) {
            if(lin.contains(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                if(st.size()==0){
                    return 0;
                }
                Character c=st.pop();
                if (c =='{' && s.charAt(i) !='}')
                    return 0;
                if (c =='[' && s.charAt(i) !=']')
                    return 0;
                if (c =='(' && s.charAt(i) !=')')
                    return 0;

            }
        }
        if(st.size()==0)
            return 1;
        return 0;
    }

}





