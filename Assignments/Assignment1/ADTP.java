class ADTP {
	String course;
	String commitment;
	String fees;

	ADTP (String course, String commitment, String fees) {
		this.course = course;
		this.commitment = commitment;
		this.fees = fees;
	}

	public String getCourse() {
		return course;
	}

	public String getCommitment() {
		return commitment;
	}

	public String getFees() {
		return fees;
	}

	public String toString() {
		// String temp = " ";

		// return temp;
		return "\n Course: " +
			getCourse() +
			"\n Commitment: " +
			getCommitment() +
			"\n Fees: " +
			getFees() + "\n";
	}
}