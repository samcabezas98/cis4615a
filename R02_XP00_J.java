// Rule 02. Expressions (EXP)
// XP00-J. Do not ignore values returned by methods Given the non-compliant code below:

public	void	deleteFile (){

	File someFile = new File(”someFileName.txt ”);
    // Do something with someFile
    someFile . delete ();
}

// Correct the code as shown in the Compliant Solution below:

void deleteFile (){

	File	someFile = new File (”someFileName . txt ”);
    // Do something with someFile
    if(!someFile.delete ()) {
	// Handle failure to delete the	file
    }
    
}
