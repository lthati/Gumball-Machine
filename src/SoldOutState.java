/**
 * 
 * @author leela
 *
 */
public class SoldOutState implements State{
	GumballMachine machine;

	// we get passed a reference to the GumballMachine
	// through the constructor. We just stash this
	// in an instance variable.
	public SoldOutState(GumballMachine machine) {
			this.machine = machine;
		}

	// if the machine is sold out, we reject the quarter
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");		
	}

	// if the machine is sold out, it doesn't accept quarters
	// so you cannot eject!
	@Override
	public void ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");		
	}

	// we can't deliver gumballs; there are none
	@Override
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");		
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");		
	}

	
}
