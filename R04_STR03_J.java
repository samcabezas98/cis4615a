// Rule 04. Characters and Strings (STR)
// STR03-J. Do not encode noncharacter data as a string Given the non-compliant code below:

BigInteger x = new BigInteger (”530500452766”); byte []
byteArray = x.toByteArray();
String s = newString (byteArray);
byteArray = s.getBytes ();
x = new BigInteger (byteArray);

// Correct the code as shown in theCompliant Solution below:

BigInteger x = new BigInteger (”530500452766”);
String s = x . toString ();
// Valid character data byte []
byteArray = s.getBytes();
String ns = newString (byteArray); 
x = new BigInteger (ns );
