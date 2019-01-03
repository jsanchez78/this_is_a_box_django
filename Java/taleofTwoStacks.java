import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



/*

Problem Solving:
  If a problem seems increasingly difficult
  Create functions for a specific task therefore have more abstractions and can specifically see
  where your program fails





*/
public class taleofTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        //This stack is the reverse order (top is the bottom of stackNewestOnTop)
        Stack<T> stackOldestOnTop = new Stack<T>();
        //Checks if stackOldestOnTop is empty
        public void shiftStacks(){
          if(stackOldestOnTop.empty()){
            while(!stackNewestOnTop.empty())
              stackOldestOnTop.push(stackNewestOnTop.pop());
          }
        }
        //Add element to the end of the queue
        public void enqueue(T value){
          stackNewestOnTop.push(value);
        }
      //Returns oldest element
      public T peek(){
        shiftStacks();
        return stackOldestOnTop.peek();
      }
      //Removes oldest element from stack then returns it
      public T dequeue(){
        shiftStacks();
        return stackOldestOnTop.pop();
      }

    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
