import java.util.ArrayList;

public class MultipleChoice extends Question {
    private String prompt;
    private ArrayList<String> answers;
    private Integer correctAnswer;

    public MultipleChoice(String prompt, ArrayList<String> answers, Integer correctAnswer) {
        this.prompt = prompt;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String displayPrompt() {
        String str = "Select the number that corresponds to the correct answer: \n" + this.prompt + "\n";
        for (int i = 1; i <= answers.size(); i++) {
            str += i + ". " + answers.get(i-1) + "\n";
        }
        return str;
    }

    @Override
    public boolean checkAnswer(String answer) {
        Integer inputAnswer;
        try {
            inputAnswer = Integer.parseInt(answer);
        } catch (NumberFormatException ignored) {
            return false;
        }
        return inputAnswer.equals(this.correctAnswer);
    }
}
