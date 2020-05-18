package Job2019.B59;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] nums = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i] == '(' || nums[i] == ')' || nums[i] == ']' || nums[i] == '['){
                if (!stack.isEmpty() && stack.peek() == ')' && nums[i] == '(' ){
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == ']' && nums[i] == '[' ){
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        System.out.println(stack.isEmpty());
    }
}
