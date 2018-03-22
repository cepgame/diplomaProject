package survey;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    int numOfQuestions = 4;
    int field;
    int field2;

    // mb i should use another collection
    // This list have size = 0 and capacity = 10
    List<Integer> answers = new ArrayList<>(numOfQuestions);

    // Some shit


    public Survey() {
        for(int i = 0; i < numOfQuestions; i++) {
            answers.add(0);
        }
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    // mb i should use something to collect questions

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
