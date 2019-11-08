// FIO04-J. Release resources when they are no longer needed
// Noncompliant Code Example (File Handle)This noncompliant code example opens a
// file and uses it but fails to explicitly close the file:

public int processFile(String fileName)
                       throws IOException, FileNotFoundException {
  FileInputStream stream = new FileInputStream(fileName);
  BufferedReader bufRead =
      new BufferedReader(new InputStreamReader(stream));
  String line;
  while ((line = bufRead.readLine()) != null) {
    sendLine(line);
  }
  return 1;
}

// Compliant Solution This compliant solution releases all acquired resources, regardless
// of any exceptions that might occur. Even though dereferencing bufRead might result
// in an exception, the FileInputStream object is closed as required.

try {
  final FileInputStream stream = new FileInputStream(fileName);
  try {
    final BufferedReader bufRead =
        new BufferedReader(new InputStreamReader(stream));

    String line;
    while ((line = bufRead.readLine()) != null) {
      sendLine(line);
    }
  } finally {
    if (stream != null) {
      try {
        stream.close();
      } catch (IOException e) {
        // Forward to handler
      }
    }
  }
} catch (IOException e) {
  // Forward to handler
}
