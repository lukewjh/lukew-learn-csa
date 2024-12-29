package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-10 11:15
 * 1475.商品的最终价格
 */
public class FinalPrices {

    public int[] finalPrices(int[] prices){

        int n = prices.length;

        int[] res = new int[n];

        //下一个小于等于price[i]的价格就是优惠券折扣
        int[] nextElement = nextLessOrEqualElement(prices);

        //计算最终的优惠商品价格
        for(int i = 0; i < prices.length; i++){
            if (nextElement[i] != -1){
                res[i] = prices[i] - nextElement[i];
            }else{
                res[i] = nextElement[i];
            }

        }

        return res;

    }

    private int[] nextLessOrEqualElement(int[] prices) {

        int n = prices.length;

        int[] res = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peek() > prices[i]){
                stk.pop();
            }

            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(prices[i]);

        }
        return res;
    }
}
