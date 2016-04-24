/**
 * 
 * @author leela
 *
 */
public class WinnerState implements State{

GumballMachine machine;
	
	// we get passed a reference to the GumballMachine 
	// through the constructor.  We just stash this
	// in an instance variable.
	public WinnerState(GumballMachine machine) {
		this.machine = machine;
	}
	
	// if the customer just bought a gumball and won extra gumball, 
	// he/she needs to wait until the transaction is complete
	// before inserting another quarter
	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we are already giving you a gumball");		
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");		
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning twice does not win you another gumball");		
	}

	@Override
	public void dispense() {
		int count = machine.getCount();
		State state = machine.getNoQuarterState();
		if(count==1)
		{
			// if this was the last one, we set the machine' state to
			// SOLD_OUT;
			System.out.println("Sorry.. WINNER but only one gum ball left");
			machine.releaseBall();
			state = machine.getSoldOutState();
		}
		else
		{
			System.out.println("****WINNER****. Here's your free gum ball..!!!!!!!!");
			machine.count--;
			machine.releaseBall();
			if(count == 2)
			{
				System.out.println("Oops, out of gumballs");
				state =  machine.getSoldOutState();	
			}
		}
		machine.setState(state);
	}

}
