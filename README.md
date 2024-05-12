# Library Book Lending System

This is a Java-based library book lending system that allows users to manage borrowers, lenders, and the books they interact with. The system provides functionality to add users, track borrowed books, and perform various actions through a command-line interface (CLI).

## Project Structure

The project is organized into the following classes and interfaces:

- `IUser`: An interface that defines the basic methods for a library user.
- `User`: An abstract class that implements the `IUser` interface and provides common functionality for users.
- `Lender`: A class that extends `User` and represents a user who lends books.
- `Borrower`: A class that extends `User` and represents a user who borrows books.
- `Library`: A class that represents the library and manages the users and their books.
- `CLI`: A class that provides the command-line interface for interacting with the library system.
- `Test`: A class that contains test cases for the various classes and methods.

## Getting Started

To run the library book lending system:

1. Compile all the Java source files.
2. Run the `CLI` class to start the command-line interface.

## Usage

The command-line interface provides a menu with the following actions:

1. Print the total number of books borrowed by all users.
2. Add a new user to the library.
3. Get the number of books borrowed by a given user.
4. Increase the number of books of a given user.
5. Decrease the number of books of a given user.
6. Quit the program.

To perform an action, enter the corresponding number when prompted.

### Adding a User

When adding a user, you will be prompted to specify the user role (1 for lender, 2 for borrower), the name of the user, and the initial number of books they are lending or borrowing.

### Getting User Information

To get information about a specific user, enter the user's name when prompted. The system will display the number of books borrowed by that user.

### Modifying User Books

To increase or decrease the number of books for a user, select the appropriate action from the menu and enter the user's name and the number of books to modify.

## Error Handling

The system includes error handling for various scenarios:

- If an invalid user role is provided when adding a user, an error message will be displayed.
- If an invalid action is selected from the menu, an error message will be displayed.
- If an unknown user name is entered when performing user-specific actions, an `UnknownUserException` will be thrown and handled appropriately.
- If a borrower attempts to lend books or if the number of books becomes negative, a `NotALenderException` will be thrown and handled.

## Testing

The `Test` class contains test cases for the various classes and methods in the system. You can run these tests to verify the functionality of the library book lending system.

## Notes

- The system assumes that user names are unique within the library.
- The `readLine` and `readPosInt` methods in the `CLI` class handle user input and perform necessary validation and error handling.
- The `setBook` method in the `User` class is protected and can only be accessed by subclasses.
