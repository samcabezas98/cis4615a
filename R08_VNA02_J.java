// VNA02-J. Ensure that compound operations on shared variables are atomic
// Noncompliant Code Example (Logical Negation) This noncompliant code example declares a
// shared boolean flag variable and provides a toggle() method that negates the current value of flag:

final class Flag {
  private boolean flag = true;

  public void toggle() {  // Unsafe
    flag = !flag;
  }

  public boolean getFlag() { // Unsafe
    return flag;
  }
}

// Compliant Solution (Synchronization) This compliant solution declares both the
// toggle() and getFlag() methods as synchronized:

final class Flag {
  private boolean flag = true;

  public synchronized void toggle() {
    flag ^= true; // Same as flag = !flag;
  }

  public synchronized boolean getFlag() {
    return flag;
  }
}
