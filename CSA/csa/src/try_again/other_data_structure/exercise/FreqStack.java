package try_again.other_data_structure.exercise;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lukew
 * @create 2024-12-02 13:36
 * 895.最大频率栈
 */
public class FreqStack {

    //记录FreqStack 中元素的最大频率
    int maxFreq = 0;

    //记录FreqStack中每个val对应的出现频率
    HashMap<Integer,Integer> valToFreq = new HashMap<>();

    //记录频率freq对应val列表
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();

    public void push(int val){
        int freq = valToFreq.getOrDefault(val,0) + 1;
        valToFreq.put(val,freq);

        //修改freqToVals
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);

        maxFreq = Math.max(maxFreq,freq);
    }

    public int pop(){
        Stack<Integer> vals = freqToVals.get(maxFreq);
        int v = vals.pop();

        int freq = valToFreq.get(v) - 1;
        valToFreq.put(v, freq);

        if (vals.isEmpty()){
            maxFreq--;
        }

        return v;
    }
}
