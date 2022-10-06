package fa.dfa;

import java.util.HashMap;
import fa.State;

/**
 * A class that simulates a specific DFA State within the machine
 * 
 * @author austinhnelson, PatrickSantanaDev
 */
public class DFAState extends State {

    HashMap<Character, String> transitionMap;

    /**
     * Constructor to create a new DFAState
     * 
     * @param name the name of the new state
     */
    public DFAState(String name) {
        this.name = name;

        // transition table
        transitionMap = new HashMap<Character, String>();
    }

    /**
     * insert a specific key and the value it is mapping to into transitionMap
     * 
     * @param k   the key with which the specified value is to be associated
     * @param val the value to be associated with the specified key
     */
    public void addTransition(char k, String val) {
        transitionMap.put(k, val);
    }

}
