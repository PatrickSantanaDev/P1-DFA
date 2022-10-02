package fa.dfa;

import java.util.HashMap;

import fa.State;

public class DFAState extends State {

    boolean isFinal;
    
    HashMap<Character, String> transitionMap;

    public DFAState(String stateName/*, boolean isFinalState*/) {
        name = stateName;
        //isFinal = isFinalState;
        
        //transition table
        transitionMap = new HashMap<Character,String>();
    }

    public boolean isFinal() 
    {
        if (isFinal) 
        {
            return true;
        }
        return false;
    }
    
    /*
     *insert a specific key and the value it is mapping to into transitionMap
     *k: key with which the specified value is to be associated
     *val: value to be associated with the specified key
     */
    public void addTransition(char k, String val)
    {
    	transitionMap.put(k,val);
    }

}
