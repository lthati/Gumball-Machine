/**
 * @author leela
 */
import java.util.Random;

public class HasQuarterState implements State {

	GumballMachine machine;
	
	// we get passed a reference to the GumballMachine 
	// through the constructor.  We just stash this
	// in an instance variable.
	public HasQuarterState(GumballMachine machine) {
		this.machine = machine;
	}
	
	// if a quarter is already inserted, another quarter cannot be instantiated
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");		
	}

	// if there is a quarter, we return it and go back to the
	// NO_QUARTER state
	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		machine.setState(machine.getNoQuarterState());
	}

	// Success! They get a gumball,  Change the state and call
	// the mahcine's dispense() method
	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		Random generator = new Random();
		int winner = generator.nextInt(10);
		State state = winner == 0 ? machine.getWinnerState() : machine.getSoldState();
		machine.setState(state);
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");		
	}

}
