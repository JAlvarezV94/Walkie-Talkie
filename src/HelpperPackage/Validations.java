package HelpperPackage;

public class Validations {

	
	public static boolean validatePort(String port){
		boolean isCorrect = true;
		
		//Here we try to convert our String with the supposedly port in a integer
		//If we can't convert it then isCorrect turn to false
		
		try{
			Integer.parseInt(port);
		}catch(NumberFormatException e){
			isCorrect = false;
		}
		
		return isCorrect;
	}
	
	public static boolean validateIp(String IP){
		boolean validate = false;
		boolean identifiersCorrect = false;
		boolean isNumbers = true;
		String identifiers[];
		
		//STEP 1: We need to verify that the IP has four networks identifiers
		identifiers = IP.split(".");
		
		if(identifiers.length == 4)
			identifiersCorrect = true;
		//STEP 2:Then if identifiers are corrects, we going to verify if all of this are a numbers
		
		if(identifiersCorrect){
			for (String hostIdentifier : identifiers) {
				try{
					Short.parseShort(hostIdentifier);
				}catch(NumberFormatException e){
					isNumbers = false;	//In the moment that the code arrive here isNumber turn false
				}			
			}
		}
		
		//STEP 3: if the step 1 and step 2 are corrects validate turn true
		if(isNumbers)
			validate = true;
		
		
		return validate;
	}
	
	public static boolean validateOption(String option){
		boolean isNumber = true;
		boolean isCorrect = false;
		int auxiliarNumber = 0;
		
		//STEP 1: We need to know if the introduced option is a number
		try{
			auxiliarNumber = Integer.parseInt(option);
		}catch(NumberFormatException e){
			isNumber = false;
		}
		//STEP 2: Then we'll to verify if this option is in the range accept
		if(isNumber)
			if(auxiliarNumber > 0 && auxiliarNumber < 4)
				isCorrect = true;
		
		return isCorrect;
	}
	
	public static boolean stopCommunication(String message){
		boolean stop = false;
		//verify that the message isn't "corto", if it is then the walkie stop to listen
		if(message.equalsIgnoreCase("corto"))
			stop = true;
		
		return stop;
	}
}
