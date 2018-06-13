package challenge_363;

import java.util.ArrayDeque;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/8q96da/20180611_challenge_363_easy_i_before_e_except/
 */
public class Iterative {

    ArrayDeque<Character> queue;

    public Boolean check(String arg){
        queue = new ArrayDeque<>(3);
        for (char element:arg.toLowerCase().toCharArray()) {
            enqueue(element);
            if (queue.size() < 3) continue;
            if (!ei_follow_c(queue.clone())) return false;
            if (!ie_not_follow_c(queue.clone())) return false;
        }
        return true;
    }

    private Boolean ei_follow_c(ArrayDeque<Character> myQueue) {
        if(myQueue.pop().equals('i')) if (myQueue.pop().equals('e')) return myQueue.pop().equals('c');
        return true;
    }

    private Boolean ie_not_follow_c(ArrayDeque<Character> myQueue) {
        if(myQueue.pop().equals('e')) if(myQueue.pop().equals('i')) return !myQueue.pop().equals('c');
        return true;
    }

    private void enqueue(char element) {
        if (queue.size() >= 3) queue.removeLast();
        queue.push(element);
    }

    public static void main(String[] args) {
        // init
        Iterative main = new Iterative();

        // check
        Boolean check = main.check("a");
        System.out.println(check);
        check = main.check("zombie");
        System.out.println(check);
        check = main.check("transceiver");
        System.out.println(check);
        check = main.check("veil");
        System.out.println(check);
        check = main.check("icier");
        System.out.println(check);
    }
}
