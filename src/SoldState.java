/**
 * 
 * @author leela
 *
 */
public class SoldState implements State {

	GumballMachine machine;
	
	// we get passed a reference to the GumballMachine 
	// through the constructor.  We just stash this
	// in an instance variable.
	public SoldState(GumballMachine machine) {
		this.machine = machine;
	}
	
	// if the customer just bought a gumball, he/she needs to wait until the
	// transaction is complete before inserting another quarter
	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we are already giving you a gumball");		
	}

	// if the customer just turned the crank, we can't give a refund;
	// he already has the gumball
	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
		
	}

	// someone is trying to cheat the machine
	@Override
	public void turnCrank() {
		System.out.println("Turning twice does not give you another gumball");		
	}

	// we are in the SOLD state; give them a gumball
	@Override
	public void dispense() {
		machine.releaseBall();
		State state = machine.getNoQuarterState();
		if(machine.getCount()==0)
		{
			// if this was the last one, we set the machine' state to
			// SOLD_OUT;
			System.out.println("Oops, out of gumballs");
			state = machine.getSoldOutState();
		}
		machine.setState(state);
	}

}
