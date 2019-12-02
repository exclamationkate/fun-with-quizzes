import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Checkbox extends Question {
    private String prompt;
    private ArrayList<String> answers;
    private ArrayList<Integer> correctAnswers;

    public Checkbox(String prompt, ArrayList<String> answers, ArrayList<Integer> correctAnswers) {
        this.prompt = prompt;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String displayPrompt() {
        String str = "Select the numbers that correspond to the correct answers: \n" + this.prompt + "\n";
        for (int i = 1; i <= answers.size(); i++) {
            str += i + ". " + answers.get(i-1) + "\n";
        }
        return str;
    }

    @Override
    public boolean checkAnswer(String input) {
        List<String> answers = new ArrayList<>(Arrays.asList(input.split(",")));
        for (String singleAnswer : answers) {
            try {
                Integer thisElem = Integer.parseInt(singleAnswer);
                if (thisElem < 1 || thisElem > answers.size())
                    throw new IllegalAnswerException();
                if (!correctAnswers.contains(thisElem))
                    return false;
            } catch (NumberFormatException ignored) {
                throw new IllegalAnswerException();
            }
        }
        return answers.size() == correctAnswers.size();
    }
}
