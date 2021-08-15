class Student {
	String studentName;
	int studentID;
	int yearOfStudy;
	ADTP adtp;
	Subject[] sub;


	Student(int studentID, String studentName, int yearOfStudy, ADTP adtp, Subject[] sub) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.yearOfStudy = yearOfStudy;
		this.adtp = adtp;
		this.sub = sub;
	}

	public String getStudentID() {
		return String.valueOf(studentID);
	}

	public String getStudentName() {
		return studentName;
	}

	public String getYear() {
		return String.valueOf(yearOfStudy);
	}

	public String toString() {
		// String output = " ";

		// return output;
		return "\n Student ID: " + 
			getStudentID() + 
			"\n Name: " + 
			getStudentName() +
			"\n Year: " +
			getYear() + "\n";
	}
}