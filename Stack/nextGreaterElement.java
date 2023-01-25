package Stack;
import java.util.*;
public class nextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] nextGreaterElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				res[i] = Integer.MAX_VALUE;
			} else {
				res[i] = st.peek();
			}
			st.push(arr[i]);
		}
		return res;
	}

	public int[] previousGreaterElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[arr.length];
		int k = 0;
		for (int i = 0; i < arr.length; i++) {	
			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				res[i] = Integer.MAX_VALUE;
			} else {
				res[i] = st.peek();
			}
			st.push(arr[i]);
		}
		return res;
	}
	
	//smaller ke liye sign change krdo bas.
	//previous greater/smaller ke liye 0-> n loop lagao
	//next greater/smaller ke liye n-1->=0 ka loop lagao.
   // Aur jrruri nahi h element value hi rkhe. Jrrurat pdne pe index bhi rkh skte h . USke liye st.push(i) krenge aur checking mei arr[st.peek()] se check krenge.
}
