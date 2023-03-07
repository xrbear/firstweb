package com.study.demo.hj;

import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/3 11:11 下午
 */
public class 扑克牌大小HJ88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String[] split = a.split("-");
            String puke1 = split[0];
            String puke2 = split[1];
            String[] split1 = puke1.split(" ");
            String[] split2 = puke2.split(" ");
            if (split1.length == 2 && split1[0].equals("joker")){
                System.out.println(puke1);
                continue;
            }
            if (split2.length == 2 && split2[0].equals("joker")){
                System.out.println(puke2);
                continue;
            }
            if (split1.length == 4 && split2.length != 4){
                System.out.println(puke1);
                continue;
            }
            if (split2.length == 4 && split1.length != 4){
                System.out.println(puke2);
                continue;
            }
            if (split1.length == 4 && split2.length ==4){
                if (split1[0].charAt(0) - split2[0].charAt(0) >0){
                    System.out.println(puke1);
                    continue;
                }else{
                    System.out.println(puke1);
                    continue;
                }
            }
            if (split1.length != split2.length){
                System.out.println("ERROR");
                continue;
            }else{
                if (split1[0].charAt(0) - split2[0].charAt(0) >0){
                    System.out.println(puke1);
                }else{
                    System.out.println(puke1);
                }
            }
        }
    }
}
