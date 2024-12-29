package try_again.array.sliderWindow;

/**
 * @author lukew
 * @create 2024-04-30 10:45
 * 经典RK算法
 */
public class RabinKarp {

    //滑动窗口+求模hash计算
    int rabinKarp(String txt, String pat){

        //位数
        int L = pat.length();

        //进制
        int R = 256;

        //去一个比较大的素数作为求模的除数
        long Q = 1658598167;

        //最高位的结果
        long RL = 1;
        for (int i = 1; i <= L - 1; i++){
            RL = (RL * R) % Q;
        }

        //计算模式串的哈希值
        long patHash = 0;
        for(int i = 0; i < pat.length(); i++){
            patHash = (R * patHash + pat.charAt(i)) % Q;
        }

        //滑动窗口字符串的hash
        long windowHash = 0;

        //滑动窗口
        int left = 0, right = 0;
        while(right < txt.length()){

            //扩大窗口
            windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
            right++;
            //缩小窗口  窗口中的字符串长度已达到要求 就检查是否要开始缩小窗口
            if (right - left == L){
                if (windowHash == patHash){
                    if (pat.equals(txt.substring(left,right))){
                        return left;
                    }
                }

                windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
                left++;
            }


        }
        return -1;

    }
}
