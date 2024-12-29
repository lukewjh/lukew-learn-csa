package try_again.other_data_structure.exercise;

/**
 * @author lukew
 * @create 2024-11-29 10:09
 * 1700.无法吃午餐的学生数量
 */
public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches){
        int[] studentCount = new int[2];
        for(int type : students){
            studentCount[type]++;
        }

        for(int type : sandwiches){
            if (studentCount[type] == 0){
                return studentCount[0] + studentCount[1];
            }

            studentCount[type]--;
        }
        return 0;

    }
}
