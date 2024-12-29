package try_again.other_data_structure.exercise;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lukew
 * @create 2024-11-19 9:23
 * 950.按递增顺序显示卡牌
 */
public class DeckRevealedIncreasing {

    public int[] deckRevealedIncreasing(int[] deck){
        int n = deck.length;
        LinkedList<Integer> res = new LinkedList<>();

        Arrays.sort(deck);

        for(int i = n - 1; i >= 0; i--){
            if(!res.isEmpty()){
                res.addFirst(res.removeLast());
            }
            res.addFirst(deck[i]);
        }

        //将双向链表转为java数组
        int[] arr = new int[n];
        int i = 0;
        for(int e : res){
            arr[i++] = e;
        }

        return arr;

    }


}
