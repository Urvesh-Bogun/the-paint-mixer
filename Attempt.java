public class Attempt
{
    PaintMix suggestion;
    PaintMix solution;
    
    public Attempt(PaintMix suggestion, PaintMix solution)
    {
        this.suggestion = suggestion;
        this.solution = solution;
    }
    
    public PaintMix getPaintMix()
    {
        return this.suggestion;
    }  
    
    public int getNumGood()
    {   
        int numGood = 0;
        for (int i = 0; i < 5 ; i ++)
            {
                if (suggestion.getPaint(i) == solution.getPaint(i))
                {
                    numGood++;
                }
            }
        return numGood;
    }
    
    public int getNumWrongQuantity()
    {
        int numWrongQuantity = 0;
        for (int i = 0; i < 5 ; i ++)
            {
                if (suggestion.getPaint(i) != solution.getPaint(i))
                {
                    numWrongQuantity++;
                }
            }
        return numWrongQuantity;
    }
    
    public boolean isCorrect()
    {
        return suggestion.equals(solution);
    }
    
    public String toString()
    {
        return (getPaintMix().toString() + 
                " (Good " + getNumGood() + 
                ", Wrong quantity " + getNumWrongQuantity() +
                ")");
    }
}