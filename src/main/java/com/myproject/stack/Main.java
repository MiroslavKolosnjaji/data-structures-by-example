package stack;



/**
 * @author Miroslav Kološnjaji
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println(stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }

    public static String reverseString(String input){

        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (Character ch: input.toCharArray()){
            stack.push(ch);
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
