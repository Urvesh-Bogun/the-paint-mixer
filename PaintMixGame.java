import java.util.*;

public class PaintMixGame {
    PaintMix solution;
    linkedList log;
    
    //Creating random array (game solution)
    public PaintMixGame() {
        char[] randArray = new char[5];
        Random rand = new Random();
        for(int i = 0; i < randArray.length; i++) {
            int randNum = rand.nextInt(5);
            randArray[i] = (char)('A' + randNum);
        }
        this.solution = new PaintMix(randArray);
    }
    
    //Stores attempt at the head of a linked list
    public boolean attemptPaintMix(PaintMix paintMix) {
        Attempt attempt = new Attempt(paintMix, this.solution);
        log = new linkedList(attempt, log);
        return attempt.isCorrect();
    }
    
    //Gets previous attempts
    public linkedList getPreviousAttempts() {
        if(log == null) {
            return null;
        }
        else {
            return log;
        }
    }
    
    public PaintMix getSolution() {
        return this.solution;
    }
}

//LinkedList class
class linkedList {
    private Attempt payload;
    private linkedList next;
    
    public linkedList(Attempt payload, linkedList next) {
        this.payload = payload;
        this.next = next;
    }
    
    public Attempt getPayload() {
        return this.payload;
    }
    
    public linkedList getNext() {
        return this.next;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(linkedList cursor = this ; cursor != null ; cursor = cursor.getNext()) {
            sb.append(cursor.getPayload().toString());;
            if (cursor.getNext() != null) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}