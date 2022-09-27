package fa.dfa;

import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

	DFAState initialState;
	Set<DFAState> finalStates = new HashSet<DFAState>();
	Set<DFAState> states = new HashSet<DFAState>();

	public void addFinalState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken);
		finalStates.add(stateToAdd);
		states.add(stateToAdd);
	}

	public void addStartState(String startStateName) {
		initialState = new DFAState(startStateName);
		states.add(initialState);
	}

	public void addState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken);
		states.add(stateToAdd);
	}

	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub

	}

	public boolean accepts(String nextLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<? extends State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<? extends State> getFinalStates() {
		return finalStates;
	}

	@Override
	public State getStartState() {
		return initialState;
	}

	@Override
	public Set<Character> getABC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getToState(DFAState from, char onSymb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String output = "";

		output += "Q = { }\n";
		output += "Sigma = { }\n";
		output += "delta = \n";

		return output;
	}

}
