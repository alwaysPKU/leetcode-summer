package the_wealth;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhangwei on 2017/7/24.
 */
public class random_wealth {
    public static void main(String[] args) {
        ArrayList<Integer> onesMoney = new ArrayList<>();
        for (int i =0;i<100;i++){
            onesMoney.add(100);
        }
        int number = 0;
        while (number<10000){
            for (int i = 0;i<100;i++){
                onesMoney.set(i,onesMoney.get(i)-1);
                int random = (int)(Math.random()*100);
                onesMoney.set(random,onesMoney.get(random)+1);
            }
            number++;
        }
        Collections.sort(onesMoney);
        for (int i =0;i<100;i++){
            System.out.print(onesMoney.get(i)+"  ");
        }
    }

}
