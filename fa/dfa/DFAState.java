package fa.dfa;

import java.util.HashMap;

import fa.State;

public class DFAState extends State {

    HashMap<Character, String> transitionMap;

    public DFAState(String name) {
        this.name = name;

        // transition table
        transitionMap = new HashMap<Character, String>();
    }

    /*
     * insert a specific key and the value it is mapping to into transitionMap
     * k: key with which the specified value is to be associated
     * val: value to be associated with the specified key
     */
    public void addTransition(char k, String val) {
        transitionMap.put(k, val);
    }

}
