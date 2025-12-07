import java.util.Scanner;
class library{ // Library class
    int availableCount = 0;
    int issueCount =0;
    String[] availableBooks = new String[100];// Array which can store 100
    String[] issuedBooks = new String[100];
    Scanner sc = new Scanner(System.in);
    library(){
        System.out.println("Welcome to my library! ");
    }
    public void addBook(){ // Adding a book to an array
        while(true) {
            System.out.println("Enter the book you want to add ");
            String add = sc.next();
            System.out.println(add);
            availableBooks[availableCount] = add; // adds the book in the array
            availableCount++; // increments
            System.out.println(add + " has been added!");
            System.out.println("Do you wish to add more books? press(y for yes and n for no)");
            String choice = sc.next();
            if(choice.equalsIgnoreCase("n")){
                break;
            }
        }
    }
    public void issueBook() { // Issue the book
        System.out.println("Enter the book to issue: ");
        String issue = sc.next();
        for (int i = 0; i < availableCount; i++) {
            if (availableBooks[i].equals(issue)) { // checks the book if it's available
                issuedBooks[issueCount] = availableBooks[i];
                issueCount++;

                for (int j = i; j < availableCount; j++) { // deletes and shifts the array order
                    availableBooks[j] = availableBooks[j + 1];
                }
                availableCount--;
                System.out.println(issue + " sucessfully issued");
                return;
            }
        }
        System.out.println("book not found"); // prints if the book isn't available
    }
    public void returnBook(){ // returning the book
        System.out.println("Enter the book you want to return: ");
        String returnBook = sc.next();
        for(int i = 0; i<issueCount;i++){
            if(issuedBooks[i].equals(returnBook)) {
                availableBooks[availableCount] = returnBook;
                availableCount++;

                for (int j = i; j < issueCount; j++) {
                    issuedBooks[j] = issuedBooks[j + 1];
                }
                issueCount--;
                System.out.println(returnBook + " sucessfully returned");
                return;
            }
        }
        System.out.println("book not found");
    }
    public void showAvailableBooks(){ // Displays the list of books in the array
        for (int i =0; i<availableCount;i++) {
            System.out.println(availableBooks[i]);
        }
    }
}
public class online_library {
    public static void main(String[] args) {
        System.out.println("=".repeat(30));
        library lb = new library();
        System.out.println("=".repeat(30));
        Scanner cv = new Scanner(System.in);

        while (true){
            System.out.println("-----------MENU-------------"); // Menu Display
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            int choice = cv.nextInt();

            switch (choice){ // Calling all the method
                case 1: lb.addBook();break;
                case 2: lb.issueBook();break;
                case 3: lb.returnBook();break;
                case 4: lb.showAvailableBooks();break;
                case 5: return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
