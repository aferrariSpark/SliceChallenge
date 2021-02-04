Instructions to run:

01.- Make sure Gradle 5.2.1 is installed.
02.- Decompress the project.
03.- Open a terminal and navigate to the project root folder.
04.- Build the project by executing the following command (Ubuntu):

		./gradlew assemble

05.- Run the project by executing the following command (Ubuntu):

		./gradlew run --args="5x5 (0, 0) (1, 3) (4, 4) (4, 2) (4, 2) (0, 1) (3, 2) (2, 3) (4, 1)"

06.- Run the tests by executing the following command (Ubuntu):

		./gradlew test

Notes:
* If the board size input does not match the proper format, an exception will be throwed, an error message will be printed in console and the application will end.
* If any of the instruction inputs does not match the proper format, and exception will be throwed, an error message will be printed in console and the application will end.
* If any offset exceeds the board