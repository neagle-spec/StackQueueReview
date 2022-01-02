// Aaron Neagle
// 12-9-2021
// Review: Stacks and Queues
// File: StackQueueReview.java

import java.util.*;

public class StackQueueReview {

    public static void main(String[] args){
        System.out.println("This is the stack and queue problem");

        Stack<String> myWords = new Stack<>();
        myWords.push("me");
        myWords.push("myself");
        myWords.push("hi");
        myWords.push("cranberries");

        System.out.println(myWords);
        shiftStack(myWords);
        System.out.println(myWords);
    }

    // takes a stack of Strings as a parameter and splits it into short words (three letters or less)
    // and long words (four or more letters).
    public static void shiftStack (Stack<String> words){
        // a single auxillary queue named temp
        Queue<String> temp = new LinkedList<>();

        // move everything from stack over to queue
        while(!words.isEmpty()){
            temp.add(words.pop());
        }

        // walk through the queue
        for(int i = 0; i < temp.size(); i++){

            // if string has more than three letters, remove from the queue, add to the stack
            if(temp.peek().length() > 3){
                words.push(temp.remove());
            }else{
                // otherwise, the string is three letters or fewer, remove from front of queue, add back of queue
                temp.add(temp.remove());
            }
        }

        // add remaining queue words to the stack
        while (!temp.isEmpty()){
            words.push(temp.remove());
        }

    }
}
