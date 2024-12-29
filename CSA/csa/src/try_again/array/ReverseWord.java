package try_again.array;

/**
 * @author lukew
 * @create 2024-04-15 10:18
 * 151.反转字符串中的单词
 */
public class ReverseWord {


    public String reverWord(String s){

        //清洗数据 将多余的空格删除
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if (c != ' '){
                sb.append(c);
            }else if(sb.length() != 0 && sb.charAt(sb.length() - 1) != ' '){
                sb.append(' ');
            }
        }

        if (sb.length() == 0){
            return "";
        }

        //清除末尾的空格
        if (sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }

        //清洗之后的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;

        //反转整个字符串
        reverse(chars,0,n - 1);

        //接着反转每个单词
        for(int i = 0;i < n;){
            for(int j = i;j < n;j++){
                if (j + 1 == n || chars[j+1] == ' '){
                    reverse(chars,i,j);
                    i = j+2;
                    break;
                }
            }

        }

        return new String(chars);

    }

    void reverse(char[] arr,int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }

    }
}
