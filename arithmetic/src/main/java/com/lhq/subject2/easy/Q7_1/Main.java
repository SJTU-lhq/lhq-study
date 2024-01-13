package com.lhq.subject2.easy.Q7_1;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/11 20:10
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 *
 * int pop() 从队列的开头移除并返回元素
 *
 * int peek() 返回队列开头的元素
 *
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 注意：返回的的字符串结果需要是小写的格式
 *
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * 输入格式:
 * 第一行输入是操作的序列，即MinStack类之中的成员函数；
 *
 * 第二行输入是成员函数所对应的参数，若没有参数则输入为 []
 *
 * 输出格式:
 * 输出为对应序列中每个操作的返回值
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * push,push,peek,pop,empty
 * 1,2,,,
 * 输出样例:
 * 在这里给出相应的输出。例如：
 *
 * null,null,1,1,false
 * 解释:
 * MyQueue myQueue = new MyQueue();
 *
 * myQueue.push(1); // queue is: [1]
 *
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 *
 * myQueue.peek(); // return 1
 *
 * myQueue.pop(); // return 1, queue is [2]
 *
 * myQueue.empty(); // return false
 *
 * 提示:
 * 1 <= x <= 9
 *
 * 最多调用 100 次 push、pop、peek 和 empty
 *
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class Main {

    public static void main(String[] args) {
        Main myQueue = new Main();
        Scanner input=new Scanner(System.in);
        String functions = input.next();
        String params = input.next();
        String[] functionArray = functions.split(",");
        String[] paramArr = new String[functionArray.length];
        if(! params.equals("[]")){
            paramArr = params.split(",");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < functionArray.length; i++) {
            if (functionArray[i].equals("push")) {
                myQueue.push(Integer.parseInt(paramArr[i]));
                sb.append("null");
            }else if(functionArray[i].equals("pop")){
                sb.append(myQueue.pop().toString());
            }else if(functionArray[i].equals("peek")){
                sb.append(myQueue.peek().toString());
            }else if(functionArray[i].equals("empty")){
                sb.append(myQueue.empty() ? "true" : "false");
            }
            if(i < functionArray.length - 1){
                sb.append(",");
            }
        }
        System.out.println(sb);
    }
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public Main() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public Integer pop() {
        if (outStack.isEmpty()){
            moveToOutStack();
        }
        return outStack.pop();
    }

    public Integer peek() {
        if (outStack.isEmpty()){
            moveToOutStack();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void moveToOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
