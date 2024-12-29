package stringmatchalgorithm;

/**
 * @author lukew
 * @create 2024-03-12 14:16
 *
 * BM算法 坏字符规则 和 好后缀规则
 */
public class BMMain {

    public static void main(String[] args) {
        String a = "abcfgthujaskhfolaj";
        String b = "jaskh";

        System.out.println(bm(a.toCharArray(), a.length(), b.toCharArray(), b.length()));


    }


    private static final int SIZE = 256;

    //坏字符散列表
    private static void generateBC(char[] b,int m,int[] bc){
        //初始化bc
        for(int i = 0; i < SIZE;i++){
            bc[i] = -1;
        }

        //将模式串中的每个字符以其ASCII值为下标，最后出现位置为元素值放入
        for (int i = 0; i < m; i++){
            int acsii = (int)b[i];
            bc[acsii] = i;
        }
    }

    //好后缀相关 suffix数组和prefix数组的初始化
    private static void generateGS(char[] b,int m,int[] suffix,boolean[] prefix){
        for (int i = 0; i<m; i++){
            suffix[i] = -1;
            prefix[i] = false;
        }

        for(int i = 0;i < m-1; i++){
            int j = i;
            int k = 0;
            while(j >= 0 && b[j] == b[m - 1 - k]){
                --j;
                ++k;
                suffix[k] = j+1;
            }
            if (j == -1){
                prefix[k] = true;
            }
        }
    }



    /**
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return
     */
    private static int bm(char[] a,int n,char[] b,int m){
        //构建模式串的散列表
        int[] bc = new int[SIZE];
        generateBC(b,m,bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b,m,suffix,prefix);


        //初始化主串和模式串的对齐下标
        int i = 0;
        //从i开始  最多会右移n-m下标
        while(i <= n-m){
            int j;
            //模式串从后往前遍历
            for(j = m-1; j >= 0; j-- ){
                if (a[i + j] != b[j]){
                    //发现了坏字符 在下标j
                    break;
                }
            }

            if (j < 0){
                //如果j < 0 则遍历完了，说明已匹配 返回当前的主串中的i
                return i;
            }

            //开始滑动 需要查看j对应在模式串中是否存在，若不存在则散列表中初始化为-1 存在则返回散列表中已存储的模式串对应字符的下标 再用坏字符对应模式串的下标 - xi位置
            //坏字符的滑动位数
            int x =  (j - bc[(int)a[i + j]]);
            int y = 0;
            //如果有好后缀
            if (j < m-1){
                y = moveByGS(j,m,suffix,prefix);
            }

            i = i + Math.max(x,y);

        }
        return -1;
    }

    //j表示坏字符的对应模式串的下标，m代表模式串的长度
    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        //好后缀的长度
        int k = m - 1 - j;
        //好后缀的第一种情况：模式串中有匹配到完整好后缀的另一个子串
        if (suffix[k] != -1) return j - suffix[k] + 1;
        //好后缀的第二种情况：模式串中没有匹配到完整好后缀的另一个子串，然后找好后缀后缀子串再来匹配
        for (int r = j + 2; m <= m-1; r++){
            if (prefix[m-r] == true){
                return r;
            }
        }
        return m;

    }


}
