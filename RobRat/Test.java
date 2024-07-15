import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a Complex number from two Rationals");
            System.out.println("2. Create a Complex number from a string");
            System.out.println("3. Create a Complex number from two doubles");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice == 4) {
                break;
            }
            
            Complex c;
            
            switch (choice) {
                case 1:
                    System.out.print("Enter real part (as a fraction, e.g., '2/4'): ");
                    String realStr = scanner.nextLine();
                    System.out.print("Enter imaginary part (as a fraction, e.g., '5/1'): ");
                    String imagStr = scanner.nextLine();
                    
                    c = new Complex(new Rational(realStr), new Rational(imagStr));
                    System.out.println("Complex number: " + c);
                    break;
                    
                case 2:
                    System.out.print("Enter complex number (e.g., '2 + 3i' or '4 - 5i'): ");
                    String complexStr = scanner.nextLine();
                    
                    c = new Complex(complexStr);
                    System.out.println("Complex number: " + c);
                    break;
                    
                case 3:
                    System.out.print("Enter real part (as a decimal, e.g., '2.7'): ");
                    double realDouble = scanner.nextDouble();
                    System.out.print("Enter imaginary part (as a decimal, e.g., '1.5'): ");
                    double imagDouble = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    
                    c = new Complex(new Rational(realDouble), new Rational(imagDouble));
                    System.out.println("Complex number: " + c);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
        System.out.println("Program ended.");
    }
}