class Subject {
	String enrolledSubject;
	String result;

	Subject(String enrolledSubject, String result) {
		this.enrolledSubject = enrolledSubject;
		this.result = result;
	}

	public String getSubject() {
		return enrolledSubject;
	}

	public String getResult() {
		return result;
	}

	public String toString() {
		// String temp = " ";

		// return temp;
		return "\n Subject: " +
			getSubject() +
			"\t Result: " +
			getResult() + "\n";
	}
}