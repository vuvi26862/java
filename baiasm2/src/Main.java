import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String code;
    private int gender; // 0: Female, 1: Male
    private float grade;

    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.code = code;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + (gender == 0 ? "Female" : "Male") +
                ", grade=" + grade +
                '}';
    }
}

class StudentManagement {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enter new student information");
            System.out.println("2. Print the student list");
            System.out.println("3. Delete student by code");
            System.out.println("4. Sort students in descending order of grade");
            System.out.println("5. Search for students by code or name");
            System.out.println("6. Search for students with grade >= x");
            System.out.println("7. Exit");
            System.out.print("Choose a function: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    printStudents();
                    break;
                case 3:
                    deleteStudentByCode(scanner);
                    break;
                case 4:
                    sortStudentsByGrade();
                    break;
                case 5:
                    searchStudent(scanner);
                    break;
                case 6:
                    searchStudentByGrade(scanner);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter student code: ");
        String code = scanner.nextLine();
        System.out.print("Enter gender (0: Female, 1: Male): ");
        int gender = scanner.nextInt();
        System.out.print("Enter grade: ");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // consume newline

        students.add(new Student(name, age, email, phone, code, gender, grade));
        System.out.println("Student added successfully!");
    }

    private static void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void deleteStudentByCode(Scanner scanner) {
        System.out.print("Enter the student code to delete: ");
        String code = scanner.nextLine();
        students.removeIf(student -> student.getCode().equals(code));
        System.out.println("Student deleted successfully!");
    }

    private static void sortStudentsByGrade() {
        students.sort(Comparator.comparing(Student::getGrade).reversed());
        System.out.println("Students sorted by grade in descending order successfully!");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student code or name: ");
        String keyword = scanner.nextLine().toLowerCase();
        for (Student student : students) {
            if (student.getCode().equalsIgnoreCase(keyword) || student.getName().toLowerCase().contains(keyword)) {
                System.out.println(student);
            }
        }
    }

    private static void searchStudentByGrade(Scanner scanner) {
        System.out.print("Enter the grade x: ");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // consume newline
        for (Student student : students) {
            if (student.getGrade() >= grade) {
                System.out.println(student);
            }
        }
    }
}