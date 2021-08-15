all: Student.java Subjects.java ADTP.java SunwayUniversity.java
	javac *.java
	java SunwayUniversity

su: SunwayUniversity.java
	javac SunwayUniversity.java
	java SunwayUniversity

student: Student.java SunwayUniversity.java
	javac Student.java SunwayUniversity.java
	java SunwayUniversity

clean:
	rm *.class