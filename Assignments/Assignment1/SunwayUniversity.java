import java.util.Scanner;
import java.util.Arrays;

class SunwayUniversity {
	private static Student[] students = new Student[10];
	private static int studentID = 1000;
	private static String [] availableSubjects = {
		"Programming 1",
		"Programming 2",
		"General Chemistry 1",
		"General Chemistry 2",
		"Basic Principle in Accounting",
		"Introduction to Journalism",
		"Calculus 1",
		"Calculus 2",
		"Research Methods",
		"Advertising"
	};
	private static String [] availableCourses = {
		"Computer Science",
		"Computer Engineering",
		"Software Engineering"
	};
	private static String[] commitmentOptions = {
		"Part Time",
		"Full Time"
	};
	private static String[] feeOptions = {
		"Per subject",
		"Per semester"
	};

	public static String studetNameInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name: ");
		return scan.nextLine();
	}

	public static boolean validateStudyYear(String yearOfStudy) {
		if (yearOfStudy == null) {
			return false;
		}

		try {
			int checkIfInteger = Integer.parseInt(yearOfStudy);
			if (checkIfInteger < 0) {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	public static String yearOfStudyInput() {
		String yearOfStudy = "";
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter year of study: ");
			yearOfStudy = scan.nextLine();
			if (Boolean.compare(validateStudyYear(yearOfStudy), true) == 0) {
				break;
			}
			System.out.println("Invalid input!");
		}

		return yearOfStudy;
	}

	public static boolean validateCourseName(String courseName) {
		return Arrays.asList(availableCourses).contains(courseName);
	}

	public static String courseNameInput() {
		String courseName = "";
		Scanner scan = new Scanner(System.in);
		while (true) {
			for (String courses : availableCourses) {
				System.out.println("-" + courses);
			}
			System.out.println("Enter course: ");

			courseName = scan.nextLine();
			if (Boolean.compare(validateCourseName(courseName), true) == 0) {
				break;
			}
			System.out.println("Invalid input!");
		}

		return courseName;
	}

	public static String commitmentInput() {
		Scanner scan = new Scanner(System.in);
		for (String studyCommitment : commitmentOptions) {
			System.out.println("-" + studyCommitment);
		}
		System.out.println("Enter study commitment: ");

		return scan.nextLine();
	}

	public static String feesInput(String studyCommitment) {
		if (studyCommitment.equals("Full Time")) {
			return "-";
		}

		Scanner scan = new Scanner(System.in);
		for (String feeStructure : feeOptions) {
			System.out.println("-" + feeStructure);
		}
		System.out.println("Enter fee structure: ");

		return scan.nextLine();
	}

	public static boolean validateFullTimeSubjects (int numberOfSubjects) {
		if (numberOfSubjects > 3 || numberOfSubjects < 0) {
			System.out.println("Invalid input!");
			return false;
		}

		return true;
	}

	public static boolean validatePartTimeSubjects (int numberOfSubjects) {
		if (numberOfSubjects > 2 || numberOfSubjects < 0) {
			System.out.println("Invalid input!");
			return false;
		}

		return true;
	}

	public static void displaySubjects() {
		for (String subjects : availableSubjects) {
			System.out.println("-" + subjects);
		}
	}

	public static String subjectInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter subject: ");
		String subjectOutput = scan.nextLine();
		return subjectOutput;
	}

	public static boolean validateResults(String result) {
		switch (result) {
			case "A":
			case "B+":
			case "B":
			case "C+":
			case "C":
			case "D":
			case "F": return true;
		}

		return false;
	}

	public static String resultInput() {
		Scanner scan = new Scanner(System.in);
		String result;

		while (true) {
			System.out.println("Enter result: ");
			result = scan.nextLine();
			if (Boolean.compare(validateResults(result), true) == 0) {
				break;
			}
		}

		return result;
	}

	public static Subject[] fullTimeSubjects() {
		int numberOfSubjects;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter number of subjects: ");
			numberOfSubjects = scan.nextInt();
			if (Boolean.compare(validateFullTimeSubjects(numberOfSubjects), true) == 0) {
				break;
			}
		}

		Subject[] subjectAndResultOutput = new Subject[numberOfSubjects];
		displaySubjects();
		for (int i = 0; i < numberOfSubjects; i++) {
			Subject subject = new Subject(subjectInput(), resultInput());
			subjectAndResultOutput[i] = subject;
		}

		return subjectAndResultOutput;
	}

	public static Subject[] partTimeSubjects() {
		int numberOfSubjects;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter number of subjects: ");
			numberOfSubjects = scan.nextInt();
			if (Boolean.compare(validatePartTimeSubjects(numberOfSubjects), true) == 0) {
				break;
			}
		}

		Subject[] subjectAndResultOutput = new Subject[numberOfSubjects];
		displaySubjects();
		for (int i = 0; i < numberOfSubjects; i++) {
			Subject subject = new Subject(subjectInput(), resultInput());
			subjectAndResultOutput[i] = subject;
		}

		return subjectAndResultOutput;
	}

	public static Subject[] subjectAndResultInput(String studyCommitment) {		
		if (studyCommitment.equals("Full Time")) {
			return fullTimeSubjects();
		}

		return partTimeSubjects();
	}

	public static void addStudent() {
		studentID += 1;
		System.out.println("\nAdd student to records. \n");
		
		String studentName = studetNameInput();
		String yearOfStudy = yearOfStudyInput();
		String courseName = courseNameInput();
		String studyCommitment = commitmentInput();
		String fees = feesInput(studyCommitment);
		Subject[] sub = subjectAndResultInput(studyCommitment);

		ADTP adtp = new ADTP(courseName, studyCommitment, fees);
		Student student = new Student(studentID, studentName, Integer.parseInt(yearOfStudy), adtp, sub);
		
		System.out.println(student);
		System.out.println(adtp);
		for (Subject temp : sub) {
			System.out.println(temp);
		}
	}

	public static void deleteStudent() {
		System.out.println("\nRemove student to records. \n");
	}

	public static void displayRecords() {
		System.out.println("\nDisplay records. \n");
	}

	public static void displayMenu() {
		System.out.println("\nMain Menu \n" +
			"\t 1. Add new student record \n" +
			"\t 2. Delete student record \n" +
			"\t 3. List all students' records \n" +
			"\t 4. Exit \n" +
			"Enter your choice [1..4]");
	}

	public static void main(String[] args) {
		int menuOption = 1;
		Scanner scan = new Scanner(System.in);

		while (menuOption > 0 && menuOption != 4) {
			displayMenu();
			menuOption = scan.nextInt();

			switch(menuOption) {
				case 1: addStudent();
				break;
				case 2: deleteStudent();
				break;
				case 3: displayRecords();
				break;
			}
		}
	}
}