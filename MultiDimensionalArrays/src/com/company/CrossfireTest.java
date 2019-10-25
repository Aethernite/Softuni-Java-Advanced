import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, double[]> studentGrades = new TreeMap<>();

        putStudentsAndGrades(reader, n, studentGrades);

        printStudentsAndAverageGrade(studentGrades);
    }

    private static void printStudentsAndAverageGrade(Map<String, double[]> studentGrades) {
        for (Map.Entry<String, double[]> student : studentGrades.entrySet()) {
            System.out.printf("%s is graduated with ", student.getKey());
            String avg = findAvgGrade(student.getValue());
            System.out.printf("%s%n", avg);
        }
    }

    private static String findAvgGrade(double[] values) {
        Double avg = 0.0;
        double sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        avg = sum / values.length;

        DecimalFormat decimalFormat = new DecimalFormat("#.############################");
        return decimalFormat.format(sum / values.length);
    }

    private static void putStudentsAndGrades(BufferedReader reader, int n, Map<String, double[]> studentGrades) throws IOException {
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentGrades.putIfAbsent(name, grades);
        }
    }
}