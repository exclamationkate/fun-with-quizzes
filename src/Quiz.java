import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        Integer score = 0;

        //Added questions
        questions.add(new TrueFalse("The earth is flat.", false));
        questions.add(new MultipleChoice("How many hours are there in an earth day?", new ArrayList<>(Arrays.asList("12", "24", "18")), 2));

        Scanner input = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.displayPrompt());
            try {
                if (question.checkAnswer(input.nextLine())) {
                    score ++;
                    System.out.println("Correct answer. Current score: " + score);
                } else {
                    System.out.println("Wrong answer.");
                }
            } catch (IllegalAnswerException ex) {
                System.out.println("Nope.");
            }
        }
        System.out.println("Final score: " + score + "/" + questions.size());
    }
}
