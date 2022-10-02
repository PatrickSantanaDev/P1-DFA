package fa.dfa;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import fa.State;

public class DFA implements DFAInterface {

	DFAState initialState;
	LinkedHashSet<Character> alphabet = new LinkedHashSet<>();
	LinkedHashSet<DFAState> finalStates = new LinkedHashSet<>();
	LinkedHashSet<DFAState> states = new LinkedHashSet<>();
	//start states set?
	LinkedHashSet<DFAState> startStates = new LinkedHashSet<>();

	public void addFinalState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken/*, true*/);
		finalStates.add(stateToAdd);
		states.add(stateToAdd);
	}

	public void addStartState(String startStateName) {
		initialState = new DFAState(startStateName/*, false*/);
		states.add(initialState);
		startStates.add(initialState);
	}

	public void addState(String nextToken) {
		DFAState stateToAdd = new DFAState(nextToken/*, false*/);
		states.add(stateToAdd);
	}
	/*
	*Adds the transition to the DFA's linkedHashSet 
	*valueOf is the label of the state where the transition starts
	*c is the symbol from the DFA's alphabet.
	*valueOf2 is the label of the state where the transition ends
	*/
	public void addTransition(String valueOf, char c, String valueOf2) {
		//iterate through dfa states in linkedHashSet
		Iterator<DFAState> iterator = states.iterator();
//		System.out.print(valueOf);
//		System.out.print(c);
//		System.out.print(valueOf2 + "\n");
		
		//add transition symbol to alphabet in linkedHashSet
		alphabet.add(c);
		while(iterator.hasNext())
		{
			//set dfa states using iterator
			DFAState dfaState = iterator.next();
			
			//check if dfa state is the state where transition starts  
			if(dfaState.getName().equals(valueOf))
			{
				//add transition to transitions with end state
				dfaState.addTransition(c,valueOf2);
			}
		}

	}
	
	/**
	* Simulates a DFA on input s to determine
	* whether the DFA accepts s.
	* @param nextLine - the input string
	* @return true if s in the language of the DFA and false otherwise
	*/
	public boolean accepts(String nextLine) 
	{
		DFAState fromState = getStartState();
		//break input string into tokens
		StringTokenizer inputStr = new StringTokenizer(nextLine);
		//build char array from input string
		char[] inputChar = inputStr.nextToken().toCharArray();
		
		
		for (int i = 0; i < inputChar.length; i++)
		{
			//get atState for each transition
			fromState = getToState(fromState, inputChar[i]);
			
			//does not accept if no toState
			if (fromState == null)
			{
				return false;
			}
		}
		
		//accept if toStates accepted and final states reached
		for (DFAState itr : finalStates)
		{
			if (itr.equals(fromState))
			{
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
		return startStates.iterator().next();
		//return initialState;
	}

	@Override
	public LinkedHashSet<Character> getABC() {
		return alphabet;
	}
	
	/*
	 * Uses transition function delta of FA
	 * from: the source state
	 * onSymb: the label of the transition
	 */
	@Override
	public DFAState getToState(DFAState from, char onSymb) {
		//iterate through states
		Iterator<DFAState> iterator = states.iterator();
		String epsilon = "e";
		
		//if transition is null or epsilon
		if (from.transitionMap.get(onSymb) == null
				|| from.transitionMap.get(onSymb) == epsilon)
		{
			return null;
		}
		
		while (iterator.hasNext())
		{
			DFAState dfaState = iterator.next();
			
			//retrieve to state
			if (from.transitionMap.get(onSymb).equals(dfaState.getName()))
			{
				return dfaState;
			}
		}
		
		
		return null;
	}

	@Override
	public String toString() {
//		Character a = 'a';
//		Character b = 'b';
//		Character c = 'c';
//		Character d = 'd';
//		alphabet.add(a);
//		alphabet.add(b);
//		alphabet.add(c);
//		alphabet.add(d);
		//System.out.print(states);
		
		//STATES
		String output = "Q = " + states.toString().replace("[", "{ ").replace("]", " }").replace(",", " ");
		
		//ALPHABET
		output += "\nSigma = " + alphabet.toString().replace("[", "{ ").replace("]", " }");
		
		//DELTA
		output += "\ndelta = \n\t";
		for (Character itr : alphabet) 
		{
			output += "\t" + itr.toString();
		}
		
		output += "\n";
		for (DFAState itr : states) 
		{
			output += "\t" + itr.toString() + "\n";
			
		}
		
		output += "\n FIX TRANSITION TABLE ENTRIES - CORRECT, BUT NEED TO BE ORDERED IN TABLE!!! ------>";
		for (DFAState itr : states) 
		{	
			//add transitions from transitionMap (key(col),value)
			for (Entry<Character, String> entry : itr.transitionMap.entrySet()) 
			{
				output += "\t" + entry.getValue().toString();
				//System.out.print(entry + "\n");
					
			}		
		}
		
		//START STATES
		output += "\nq0 = " + initialState.toString();
		
		//FINAL STATES
		output += "\nF = " + finalStates.toString().replace("[", "{ ").replace("]", " }").replace("", "") + "\n";

		return output;
	}

}
