// Rule 01. Declarations and Initialization (DCL)
// Noncompliant Code Example (Intraclass Cycle) This noncompliant code example contains an
// intraclass initialization cycle:

public class Cycle {
  private final int balance;
  private static final Cycle c = new Cycle();
  private static final int deposit = (int) (Math.random() * 100); // Random deposit

  public Cycle() {
    balance = deposit - 10; // Subtract processing fee
  }

  public static void main(String[] args) {
    System.out.println("The account balance is: " + c.balance);
  }
}

// Compliant Solution (Intraclass Cycle)changes the initialization order of the class Cycle so that the
// fields are initialized without creating any dependency cycles

public class Cycle {
  private final int balance;
  private static final int deposit = (int) (Math.random() * 100); // Random deposit
  private static final Cycle c = new Cycle();  // Inserted after initialization of required fields
  public Cycle() {
    balance = deposit - 10; // Subtract processing fee
  }

  public static void main(String[] args) {
    System.out.println("The account balance is: " + c.balance);
  }
}
