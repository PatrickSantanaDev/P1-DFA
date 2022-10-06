package fa.dfa;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.Map.Entry;

/**
 * A class to simulate a Deterministic Finite Automata (DFA) with a given input
 * file
 * 
 * @author austinhnelson, PatrickSantanaDev
 */
public class DFA implements DFAInterface {

	/* Declaring Sets */
	DFAState initialState;
	LinkedHashSet<Character> alphabet = new LinkedHashSet<>();
	LinkedHashSet<DFAState> finalStates = new LinkedHashSet<>();
	LinkedHashSet<DFAState> states = new LinkedHashSet<>();

	/**
	 * Adds a state to the machine and specifies it as a final state
	 * 
	 * @param nextToken the final state to add
	 */
	public void addFinalState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken);
		finalStates.add(stateToAdd);
		states.add(stateToAdd);
	}

	/**
	 * Adds a state to the machine and specifies it as an initial state
	 * 
	 * @param startStateName the start state to add
	 */
	public void addStartState(String startStateName) {
		initialState = new DFAState(startStateName);
		states.add(initialState);
	}

	/**
	 * Adds a state to the machine
	 * 
	 * @param nextToken the state to add
	 */
	public void addState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken/* , false */);
		states.add(stateToAdd);
	}

	/**
	 * Adds the transition to the DFA's linkedHashSet
	 * 
	 * @param valueOf  the label of the state where the transition starts
	 * @param c        the symbol from the DFA's alphabet
	 * @param valueOf2 the label of the state where the transition ends
	 */
	public void addTransition(String valueOf, char c, String valueOf2) {
		// iterate through dfa states in linkedHashSet
		Iterator<DFAState> iterator = states.iterator();

		// add transition symbol to alphabet in linkedHashSet
		alphabet.add(c);
		while (iterator.hasNext()) {
			// set dfa states using iterator
			DFAState dfaState = iterator.next();

			// check if dfa state is the state where transition starts
			if (dfaState.getName().equals(valueOf)) {
				// add transition to transitions with end state
				dfaState.addTransition(c, valueOf2);
			}
		}
	}

	/**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * 
	 * @param nextLine the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
	public boolean accepts(String nextLine) {
		DFAState fromState = getStartState();
		// break input string into tokens
		StringTokenizer inputStr = new StringTokenizer(nextLine);
		// build char array from input string
		char[] inputChar = inputStr.nextToken().toCharArray();

		for (int i = 0; i < inputChar.length; i++) {
			// get atState for each transition
			fromState = getToState(fromState, inputChar[i]);

			// does not accept if no toState
			if (fromState == null) {
				return false;
			}
		}

		// accept if toStates accepted and final states reached
		for (DFAState itr : finalStates) {
			if (itr.equals(fromState)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public LinkedHashSet<DFAState> getStates() {
		return states;
	}

	@Override
	public LinkedHashSet<DFAState> getFinalStates() {
		return finalStates;
	}

	@Override
	public DFAState getStartState() {
		return initialState;
	}

	@Override
	public LinkedHashSet<Character> getABC() {
		return alphabet;
	}

	@Override
	public DFAState getToState(DFAState from, char onSymb) {
		// iterate through states
		Iterator<DFAState> iterator = states.iterator();
		String epsilon = "e";

		// if transition is null or epsilon
		if (from.transitionMap.get(onSymb) == null
				|| from.transitionMap.get(onSymb) == epsilon) {
			return null;
		}

		while (iterator.hasNext()) {
			DFAState dfaState = iterator.next();

			// retrieve to state
			if (from.transitionMap.get(onSymb).equals(dfaState.getName())) {
				return dfaState;
			}
		}

		return null;
	}

	@Override
	public String toString() {

		// STATES
		String output = "Q = " + states.toString().replace("[", "{ ").replace("]", " }").replace(",", " ");

		// ALPHABET
		output += "\nSigma = " + alphabet.toString().replace("[", "{ ").replace("]", " }");

		// DELTA
		output += "\ndelta = \n\t";
		for (Character itr : alphabet) {
			output += "\t" + itr.toString();
		}

		output += "\n";

		// TRANSITION TABLE
		for (DFAState itr : states) {
			// add transitions from transitionMap (key(col),value)
			output += "\t" + itr.toString();
			for (Entry<Character, String> entry : itr.transitionMap.entrySet()) {
				output += "\t" + entry.getValue().toString();
			}
			output += "\n";
		}

		// START STATES
		output += "\nq0 = " + initialState.toString();

		// FINAL STATES
		output += "\nF = " + finalStates.toString().replace("[", "{ ").replace("]", " }").replace(",", "") + "\n";

		return output;
	}
}