The assignment contains 4 Java files (ADTP.java, Subject.java, Student.java, SunwayUniversity.java) 
where SunwayUniversity.java is the main driver file, a Makefile, a README and the assignment question.

Program execution can be done automatically by calling the Makefile.

To compile all the files and execute:
- Step 1: Call the Makefile using the "make" command in terminal.
- Step 2: Follow steps on the terminal.

To manually compile the files:
- Step 1: Use the "javac" command followed by the .java files to compile
- Step 2: An executable file should be present with the name of the .java file that contained the main method.
        : In this case, as SunwayUniversity.java contains the main method, the executable will be SunwayUniversity.
        : Use the "java" command followed by the executable file name to execute.

To remove all the *.class files:
- Step 1: Call the Makefile using the "make" command in terminal and follow it up with the "clean" keyword.
          Example: make clean