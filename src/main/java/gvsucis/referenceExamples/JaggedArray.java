
package gvsucis.referenceExamples;


/**
 * Created by IntelliJ IDEA.
 * User: kurmasz
 * Date: 2/10/12
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class JaggedArray {

    public static Object[] shallowCopy(Object[] array) {
        Object[] answer = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            answer[i] = array[i];
        }
        return answer;
    }


    public static boolean[][] topHalf(int size) {

        boolean[][] answer = new boolean[size][];
        for (int i = size; i > 0; i--) {
            answer[size -i] = new boolean[i];
        }
        return answer;
    }
}
