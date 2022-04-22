## Base64-Java


# Project's requirements
All the programs should validate the input data correctness. All
the programs should allow for providing data through command-line
arguments and reading them interactively from the user.
The program should implement Base648 encoding and decoding.
The program should include the variants based on RFC 4648 including the
standard and URL-safe versions. The encoding/decoding variant should
be provided by the user. The encoding/decoding should not change the
case of the text and they should allow for multi-word texts. Text containing characters outside of the encodable range should be considered invalid.
You must not use the ready-made Java classes for the encoding/decoding.

# Project functionality
The application enables conversion of character strings from ASCII to Base64 encoding and
decoding from Base64 to ASCII. The user can also view the last encoding/decoding operations.
The application is designed for desktop use with a GUI interface written in Swing and for web use
with servlets and HTML language support.

# Final version no. 1

- run as a standalone console application (no GUI allowed),
- initial parameters in the command line,
- UI uses standard streams,
- separate classes for model, view, and controller,
- use of packages (separate for model, view, and controller),
- own exception used in the model,
- only private fields,
- static elements (except main()) are prohibited,
- in case of errors the user should be allowed to correct them (the program should not terminate),
- documentation (Javadoc) - description of all classes, methods, fields, and packages,
- documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws
- Java naming convention and English identifiers.

# Final version no. 2
scope of the final project no. 1,
use of generic collection in one of the model classes,
use of the for-each loop (Java 5 or Java 8 version),
use of one of the following elements:
enum type,
own generic type,
varargs,
own annotation (different from the one used in the examples),
lambda expression with own functional interface,
use of streams for collections' data processing,
unit tests for all public model methods (except for constructors, accessors and mutators)
unit tests should cover correct, incorrect and border situations,
parametrized tests,
documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
Java naming convention and English identifiers.

# Final version no. 3
scope of the final projects no. 1 & 2,
GUI application based on Swing or JavaFX, including:
an advanced container (tabbed pane, split pane),
message box (JOptionPane for Swing, Alert for JavaFX) to indicate validation errors or information messages,
table to store the history of performed operations,
menu,
documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
Java naming convention and English identifiers.

# Final version no. 4
scope of the final projects no. 1-3 (model, tests),
HTML form as the view part, using the POST method,
servlet(s) providing access to the model,
use of include or forward method,
use of session for storing the history of performed operations (the user has to be able to DISPLAY this history),
use of cookies to store simple statistics, for example, number of errors or visits to the history page,
same way of handling GET and POST requests,
data validation and use of sendError in case of invalid data,
documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
Java naming convention and English identifiers.

# Final version no. 5
scope of the final projects no. 1-4 (model, tests, web application),
database support using JDBC or JPA,
automatic database schema creation on the first run of the application,
database connection should be established only once for the run of the application,
storing the history of performed operations in the database,
ability to see all database records through the web application,
database exceptions handling,
documentation (Javadoc) - description of all classes, methods, fields, and packages (including unit tests),
documentation (Javadoc) - mandatory tags: @author, @version, @param, @return, @throws,
Java naming convention and English identifiers.
