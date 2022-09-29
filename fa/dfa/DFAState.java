package fa.dfa;

import fa.State;

public class DFAState extends State {

    boolean isFinal;

    public DFAState(String stateName, boolean isFinalState) {
        name = stateName;
        isFinal = isFinalState;
    }

    public boolean isFinal() {
        if (isFinal) {
            return true;
        }
        return false;
    }

}
