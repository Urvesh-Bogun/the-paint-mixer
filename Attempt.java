public class Attempt {
    PaintMix suggestion;
    PaintMix solution;
    
    public Attempt(PaintMix suggestion, PaintMix solution) {
        this.suggestion = suggestion;
        this.solution = solution;
    }
    
    public PaintMix getPaintMix() {
        return this.suggestion;
    }  
    
    //Methods to iterate through sugestion and count how many are correct and how many are incorrect
    public int getNumGood() {   
        int numGood = 0;
        for (int i = 0; i < 5 ; i ++) {
                if (suggestion.getPaint(i) == solution.getPaint(i)) {
                    numGood++;
                }
            }
        return numGood;
    }
    
    public int getNumWrongQuantity() {
        int numWrongQuantity = 0;
        for (int i = 0; i < 5 ; i ++) {
                if (suggestion.getPaint(i) != solution.getPaint(i)) {
                    numWrongQuantity++;
                }
            }
        return numWrongQuantity;
    }
    
    //Boolean to check if solution = suggestion
    public boolean isCorrect() {
        return suggestion.equals(solution);
    }
    
    public String toString() {
        return (getPaintMix().toString() + 
                " (Good " + getNumGood() + 
                ", Wrong quantity " + getNumWrongQuantity() +
                ")");
    }
}