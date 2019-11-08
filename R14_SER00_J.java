// SER00-J. Enable serialization compatibility during class evolution
// Noncompliant Code Example This noncompliant code example implements a GameWeapon class
// with a serializable field called numOfWeapons and uses the default serialized form.
// Any changes to the internal representation of the class can break the existing serialized form.

class GameWeapon implements Serializable {
  int numOfWeapons = 10;

  public String toString() {
    return String.valueOf(numOfWeapons);
  }
}

// Compliant Solution (serialVersionUID) In this solution, the class has an explicit
// serialVersionUID that contains a number unique to this version of the class. The JVM
// will make a good-faith effort to deserialize any serialized object with the same class
// name and version ID.

class GameWeapon implements Serializable {
  private static final long serialVersionUID = 24L;

  int numOfWeapons = 10;

  public String toString() {
    return String.valueOf(numOfWeapons);
  }
}
