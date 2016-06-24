package com.ee.vasco.fizzbuzzvf;

/**
 * Created by Vasco on 22/06/2016.
 */
public class RunRangeFB {

    public static String step1 (int min, int max, boolean report){
        String res = "";
        int fizz=0, buzz=0, fibu=0, num=0;

        for(int i=min;i<=max;i++){
            if (i % 3 == 0) {
                res = res.concat(" fizz");
                fizz++;
                if (i % 15 == 0) {
                    res = res.concat("buzz");
                    fibu++;
                    fizz--;
                }
            }
            else {
                if (i % 5 == 0) {
                    res = res.concat(" buzz");
                    buzz++;
                }
                else
                {
                    res = res.concat(" " + i);
                    num++;
                }
            }

        }

        res = res.replaceFirst("^ *", "");

        if(report){
            res = res.concat("\n"+"fizz: "+fizz);
            res = res.concat("\n"+"buzz: "+buzz);
            res = res.concat("\n"+"fizzbuzz: "+fibu);
            res = res.concat("\n"+"integer: "+num);
        }

        return res;
    }

    public static String step2 (int min, int max, boolean report){
        String res = "";
        int fizz=0, buzz=0, fibu=0, lucky=0, num=0;

        for(int i=min;i<=max;i++){
            if(String.valueOf(i).contains("3")){
                res = res.concat(" lucky");
                lucky++;
                continue;
            }

            if (i % 3 == 0) {
                res = res.concat(" fizz");
                fizz++;
                if (i % 15 == 0) {
                    res = res.concat("buzz");
                    fibu++;
                    fizz--;
                }
            }
            else
            if (i % 5 == 0) {
                res = res.concat(" buzz");
                buzz++;
            }
            else {
                res = res.concat(" " + i);
                num++;
            }
        }

        res = res.replaceFirst("^ *", "");

        if(report){
            res = res.concat("\n"+"fizz: "+fizz);
            res = res.concat("\n"+"buzz: "+buzz);
            res = res.concat("\n"+"fizzbuzz: "+fibu);
            res = res.concat("\n"+"lucky: "+lucky);
            res = res.concat("\n"+"integer: "+num);
        }

        return res;
    }




}
