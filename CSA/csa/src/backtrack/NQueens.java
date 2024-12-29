package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author lukew
 * @create 2024-03-22 9:07
 * 回溯算法解决N皇后问题
 *
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        ArrayList<ArrayList<ArrayList<String>>> result = nq.solveNQueens(8);
        for (ArrayList<ArrayList<String>> solution : result) {
            for (ArrayList<String> row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

    }


    ArrayList<ArrayList<ArrayList<String>>> res = new ArrayList<>();


    /**
     * 输入棋盘的变成n，返回所有合法的皇后放置
     */
    ArrayList<ArrayList<ArrayList<String>>> solveNQueens(int n){
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        //初始化表盘
        for(int i = 0; i < n; i++){
            ArrayList<String> row = new ArrayList<>();
            // 每行添加n个字符
            for (int j = 0; j < n; j++){
                row.add(".");
            }

            board.add(row);
        }
        backTrack(board,0);
        return res;

    }

    /**
     * 回溯
     * 路径：board中小于row的行已经放置了该行的皇后
     * 选择列表：第row行的所有列都是可选
     * 结束条件：row达到board的最后一行
     */
    void backTrack(ArrayList<ArrayList<String>> board,int row){

        //最后一行判断
        if (board.size() == row){
            res.add(new ArrayList<>(board));
            return;
        }

        //列数  遍历列数
        int n = board.get(row).size();
        for (int col = 0; col < n; col++){
            //排除不合法的选择
            if (!isValid(board,row,col)){
                continue;
            }

            //做选择
            board.get(row).set(col,"Q");
            //进入下一行抉择
            backTrack(board,row + 1);
            //撤销选择
            board.get(row).set(col,".");
        }


    }


    /**
     * 能否在board[row][col]上放置皇后
     */
    boolean isValid(ArrayList<ArrayList<String>> board,int row,int col){

        //同列不同行的判断
        int n = board.size();
        for (int i = 0; i < n; i++){
            if (board.get(i).get(col).equals("Q")){
                return false;
            }
        }

        //右上方的检查
        for (int i = row - 1,j = col + 1; i>=0 && j<n; i--,j++){
            if (board.get(i).get(j).equals("Q")){
                return false;
            }
        }

        //检查左上方是否有冲突
        for (int i = row - 1,j = col - 1; i>=0 && j>=0;i--,j--){
            if (board.get(i).get(j).equals("Q")){
                return false;
            }
        }

        //所以情况检查通过则为true
        return true;

    }
}
