package gvsucis.sorts;

import java.util.*;

/**
 * RadixSort driver demonstrates the use of queues in the execution of a radix
 * sort.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class RadixSort {
	/**
	 * Performs a radix sort on a set of numeric values.
	 */
	public static void main(String[] args) {
		int[] list = { 7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211 };

		String temp;
		Integer numObj;
		int digit, num;

		@SuppressWarnings("unchecked")
		Queue<Integer>[] digitQueues = (LinkedList<Integer>[]) (new LinkedList[10]);
		for (int digitVal = 0; digitVal <= 9; digitVal++)
			digitQueues[digitVal] = (Queue<Integer>) (new LinkedList<Integer>());

		// sort the list
		for (int position = 0; position <= 3; position++) {
			for (int scan = 0; scan < list.length; scan++) {
				temp = String.valueOf(list[scan]);
				digit = Character.digit(temp.charAt(3 - position), 10);
				digitQueues[digit].add(new Integer(list[scan]));
			}

			// gather numbers back into list
			num = 0;
			for (int digitVal = 0; digitVal <= 9; digitVal++) {
				while (!(digitQueues[digitVal].isEmpty())) {
					numObj = digitQueues[digitVal].remove();
					list[num] = numObj.intValue();
					num++;
				}
			}
		}

		// output the sorted list
		for (int scan = 0; scan < list.length; scan++)
			System.out.println(list[scan]);
	}
}
