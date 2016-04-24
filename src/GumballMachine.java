/**
 * 
 * @author leela
 *
 */
public class GumballMachine {
	
    // Here are all the states again
    private State soldOutState;
    private State noQuarterState; 
    private State hasQuarterState;
    private State soldState;
    private State winnerState;
    
    // and the current state of the machine
    private State currentState = soldOutState;
    
    // count holds the number of gumballs.  Initially the
    // machine is empty
    int count = 0;
    
    /** constructor takes the initial number of gumballs
     * and stores it in the instance variable.
     * It also creates the State instances, one of each
     * @param numberGumballs the initial count of gumballs
     */
    public GumballMachine(int numberGumballs) {
    	// WRITE CODE HERE TO INITILIZE THE State instance variables
    	soldOutState = new SoldOutState(this);
    	noQuarterState = new NoQuarterState(this);
    	hasQuarterState = new HasQuarterState(this);
    	soldState = new SoldState(this);
    	winnerState = new WinnerState(this);
    	
    	this.count = numberGumballs;
    	// if there are more than 0 gumballs, we set the state
    	// to the NoQuarterState
    	if (count > 0) {
    		currentState = noQuarterState;
    	}
    }
    
    // Actions are very easy to implement now.  We just delegate
    // to the current state
    public void insertQuarter() {
    	currentState.insertQuarter();
    }
    
    public void ejectQuarter() {
    	currentState.ejectQuarter();
    }
    
    // Note that we don't need an action method for
    // dispense() in GumballMachine because it is just an
    // internal action; a user cannot ask the machine
    // to dispense directly.  But we do call dispense()
    // on the State object from the turnCrank() method.
    public void turnCrank() {
    	currentState.turnCrank();
    	currentState.dispense();
    }
    
    public void setState(State s) {
    	currentState = s;
    }
    
    // this is a helper method that releases the ball and
    // decrements the count instance variable
    public void releaseBall() {
    	System.out.println("A gumball comes rolling out of the slot...");
    	if (count != 0)
    		count--;
    }
    
    public int getCount()  {
    	return count;
    }
    
    public State getNoQuarterState() {
    	return noQuarterState;
    }
    
    public State getSoldOutState() {
    	return soldOutState;
    }
    
    public State getSoldState() {
    	return soldState;
    }
    
    public State getHasQuarterState() {
    	return hasQuarterState;
    }
    
    public State getWinnerState() {
    	return winnerState;
    }
    
    public String toString() {
    	String s = "\nMighty Gumball, Inc.\n";
    	s += "Java enabled Standing Gumball Model #2014\n";
    	s += "Inventory: " + count + " gumballs\n";
    	if (count == 0) 
    		s += "Machine is sold out\n";
    	else
    		s += "Machine is waiting for quarter\n";
    	return s;    
    }
}