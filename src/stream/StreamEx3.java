package stream;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of(new String[]{"김", "이", "박", "최", "강"}));
        ArrayList<Student> students = Stream.generate(() -> {
            int i = new Random().nextInt(300);
            return new Student(names.get(i % 5), i % 2 == 0, i % 3 + 1, i % 2 + 1, i);
        }).limit(15).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("1. 반별 분류");
        Map<Integer, List<Student>> byTeam = students.stream().collect(Collectors.groupingBy(Student::getTeam));
        byTeam.forEach((key, value) -> {
            System.out.println(value);
        });

        System.out.println("2. 성적별 분류");
        IntFunction<Student.Level> scoreToLevel = (score) -> {
            if (score > 200) {
                return Student.Level.HIGH;
            } else if (score > 100) {
                return Student.Level.MID;
            } else {
                return Student.Level.LOW;
            }
        };
        Map<Student.Level, List<Student>> byLevel =
                students.stream().collect(Collectors.groupingBy(student -> scoreToLevel.apply(student.getScore())));
        byLevel.keySet().forEach((key) -> {
            System.out.print(key + ": ");
            System.out.println(byLevel.get(key));
        });

        System.out.println("3. 성적별 통계");
        Map<Student.Level, Long> countByLevel =
                students.stream().collect(Collectors.groupingBy(student -> scoreToLevel.apply(student.getScore()),
                        Collectors.counting()));
        Arrays.stream(Student.Level.values()).forEach(level -> {
            System.out.println(level + ": " + countByLevel.get(level));
        });

        System.out.println("4. 학년별 반별 1등");
        Map<Integer, Map<Integer, Student>> topByGradeAndTeam = students.stream().collect(
                Collectors.groupingBy(Student::getGrade,
                        Collectors.groupingBy(Student::getTeam,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingInt(Student::getScore)
                                        ), Optional::get
                                )
                        )
                )
        );
        topByGradeAndTeam.forEach((grade, studentByGrade) -> {
            studentByGrade.forEach((team, student) -> {
                System.out.println(grade + "-" + team + " " + student);
            });
        });
    }
}

class Student {
    private final String name;
    private final boolean isMale;
    private final int grade;
    private final int team;
    private final int score;


    public Student(String name, boolean isMale, int grade, int team, int score) {
        this.name = name;
        this.isMale = isMale;
        this.grade = grade;
        this.team = team;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "이름='" + name + '\'' + ", 성별=" + (isMale ? "남" : "여") + ", 학년=" + grade + ", 반=" + team + ", 점수=" + score + '}';
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getGrade() {
        return grade;
    }

    public int getTeam() {
        return team;
    }

    public int getScore() {
        return score;
    }

    enum Level {
        HIGH, MID, LOW
    }
}
