import java.util.IllegalFormatException;

public class TrueFalse extends Question {
    private String prompt;
    private boolean isTrue;

    public TrueFalse(String prompt, boolean isTrue) {
        this.prompt = prompt;
        this.isTrue = isTrue;
    }

    @Override
    public String displayPrompt() {
        return "True or False: " + this.prompt;
    }

    @Override
    public boolean checkAnswer(String answer) {
        if (isTrue) {
            if (answer.equals("true"))
                return true;
            if (answer.equals("false"))
                return false;
        } else {
            if (answer.equals("false"))
                return true;
            if (answer.equals("true"))
                return false;
        }
        throw new IllegalAnswerException();
    }
}
