/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;


/**
 *
 * @author jovan
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionGen {

    private static final String DB_URL = "jdbc:derby://localhost:1527/Questions";
    private static final String DB_USER = "pdc";
    private static final String DB_PASSWORD = "pdc";

    public static ArrayList<Question> Genquestion() {
        ArrayList<Question> qlist = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT QUESTIONTEXT, OPTIONA, OPTIONB, OPTIONC, OPTIOND, CORRECTANSWER FROM QUESTION";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String questionText = resultSet.getString("QUESTIONTEXT");
                    String ans1 = resultSet.getString("OPTIONA");
                    String ans2 = resultSet.getString("OPTIONB");
                    String ans3 = resultSet.getString("OPTIONC");
                    String ans4 = resultSet.getString("OPTIOND");
                    int correctAnswer = resultSet.getInt("CORRECTANSWER");

                    qlist.add(new triviaquestion(ans1, ans2, ans3, ans4, questionText, correctAnswer));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return qlist;
    }

    public static void main(String[] args) {
        ArrayList<Question> questions = Genquestion();
        int batchSize = 4;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i += batchSize) {
            int end = Math.min(i + batchSize, questions.size());
            ArrayList<Question> batch = new ArrayList<>(questions.subList(i, end));

            for (Question question : batch) {
                System.out.println(question.getQuestionText());
                for (int j = 0; j < 4; j++) {
                    System.out.println((j + 1) + ") " + question.getOption(j));
                }
                System.out.print("Enter your answer (1-4): ");
                int userAnswer = scanner.nextInt();

                if (question.checkAns(userAnswer)) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect. The correct answer is: " + question.getOption(0) + "\n");
                }
            }

            // Prompt for input to continue
            if (end < questions.size()) {
                System.out.print("Press Enter to continue...");
                scanner.nextLine(); // Consume the newline character
                scanner.nextLine(); // Wait for user input (Enter key)
            }
        }

        scanner.close();
    }
}
