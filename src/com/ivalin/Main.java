package com.ivalin;
import java.util.Scanner;
class Strings{
    String str;
    Strings(String a){
        this.str = a;
    }
    String printString()
    {
        return str;
    }
}
class Algo{

    static int lastpos;
    static int[] buildArray(String P, int l){
        int[] arr = new int[l];
        int i=1;
        arr[0] = 0;
        int len=0;
        while(i<l){
            if(P.charAt(i) == P.charAt(len))
            {
                len++;
                arr[i] = len;
                i++;
            }
            else if(len!=0)
            {
                len = arr[len-1];
            }
            else{
                arr[i]=0;
                i++;
            }
        }
    return arr;
    }
    static String kmp(String S, String P, int[] arr, int l){

        int r=0, q=0;
    int flag = 0;

        while(r<=S.length()){
            //System.out.println("idk" + q + " " +l + " " + r);
            if(q == l){
              //  System.out.println("in2");
                flag = 1;
                Algo.lastpos = r;
                return "true";
            }

            else if(P.charAt(q) == '?' || (r < S.length() && S.charAt(r) == P.charAt(q))){
               // System.out.println("in1");
                r++;
                q++;
            }

            else if(r < S.length() && P.charAt(q)!=S.charAt(r)){
                if(q!=0)
                {
                   // System.out.println("in3");
                    q=arr[q-1];
                }
                else{
                   // System.out.println("in4");
                    r++;
                }
            }
            else{
              //  System.out.println("Fatal error");
                return "false";
            }
        }
       // System.out.println("ahh");
        if(flag == 0)
        {
            return "false";
        }

    return "false";
    }

}


public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String tS = sc.next();
        String tP = sc.next();
        Strings S = new Strings(tS);
        Strings P = new Strings(tP);

        ///S.printString();
        String[] PP = P.printString().split("\\*");
        int flag = 0;
        for(int i=0;i<PP.length;i++)
        {
            //System.out.println(PP[i] + " " + S.str);
            int[] lps = new int[P.printString().length()];

            lps = Algo.buildArray(P.printString(), P.printString().length());

            /*for (int i = 0; i < P.printString().length(); i++) {
                System.out.print(lps[i] + " ");
            }*/
           // System.out.println();

            String h = Algo.kmp(S.printString(), PP[i], lps, PP[i].length());
            if(h.equals("true")){
                S.str = S.str.substring(Algo.lastpos);
            }
            else{
                flag = 1;
                break;
            }

            //System.out.println(h);


        }
        if(flag == 0)
        {
            System.out.println("true");
        }

        else{
            System.out.println("false");
        }
    }
}
