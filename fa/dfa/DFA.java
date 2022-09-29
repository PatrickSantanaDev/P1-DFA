package fa.dfa;

import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {

	DFAState initialState;
	LinkedHashSet<Character> alphabet = new LinkedHashSet<>();
	LinkedHashSet<DFAState> finalStates = new LinkedHashSet<>();
	LinkedHashSet<DFAState> states = new LinkedHashSet<>();

	public void addFinalState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken, true);
		finalStates.add(stateToAdd);
		states.add(stateToAdd);
	}

	public void addStartState(String startStateName) {
		initialState = new DFAState(startStateName, false);
		states.add(initialState);
	}

	public void addState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken, false);
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
		return states;
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
		Character a = 'a';
		Character b = 'b';
		Character c = 'c';
		Character d = 'd';
		alphabet.add(a);
		alphabet.add(b);
		alphabet.add(c);
		alphabet.add(d);
		String output = "Q = " + states.toString().replace("[", "{ ").replace("]", " }").replace(",", " ");
		output += "\nSigma = " + alphabet.toString().replace("[", "{ ").replace("]", " }");
		output += "\ndelta = \n\t";
		for (Character itr : alphabet) {
			output += "\t" + itr.toString();
		}
		output += "\n";
		for (DFAState itr : states) {
			output += "\t" + itr.toString() + "\n";
		}
		output += "\nq0 = " + initialState.toString();
		output += "\nF = " + finalStates.toString().replace("[", "{ ").replace("]", " }").replace("", "") + "\n";

		return output;
	}

}
