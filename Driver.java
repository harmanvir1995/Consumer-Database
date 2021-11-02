import java.util.Scanner;

/**
 * Helps marketing company to keep track of their consumer base and performs
 * various functions to add, modify and display the information.
 * 
 * @author HARMANVIR SINGH(40019114) 
 * @author SARABPREET SINGH(40154067)
 *
 */
public class Driver {
	private static Scanner keyIn = new Scanner(System.in);
	private static int passwordCounterFor3Attemps = 0;
	private static int passwordCounterFor12Attemps = 0;
	private static int optionSelected;
	private static int currentCursorPositionAt = 0;
	private static Consumer[] consumerDatabase;
	private static int consumerChange;

	public static void main(String[] args) {
		System.out.println("\n\n*********************************************************************************** \n"
				+ "\t\t WELCOME TO THE CONSUMER DATABASE \n \t\t\t\t\t\t Operated by h&s co. \n"
				+ "***********************************************************************************");
		System.out.print("Enter the maximum number of Consumers that can be handled: ");
		consumerDatabase = new Consumer[keyIn.nextInt()];
		selectOption();
	}

	/**
	 * Different options user can select in order to manipulate the data from the
	 * database.
	 */
	public static void selectOption() {
		System.out.println("What do you want to do?\r\n" + "\t1. Enter a new Consumer (password required)\r\n"
				+ "\t2. Change information of a Consumer (password required)\r\n"
				+ "\t3. Display all Consumers similar to a given consumer\r\n"
				+ "\t4. Display all Consumers with given age and location\r\n" + "\t5. Quit\r\n"
				+ "Please enter your choice >");
		int duplicateOptionSelected = keyIn.nextInt();
		optionSelected = duplicateOptionSelected;
		switch (duplicateOptionSelected) {
		case 1:
			checkPassword();
			break;
		case 2:
			checkPassword();
			break;
		case 3:
			System.out.print("Enter the age of the given Consumer: ");
			int age = keyIn.nextInt();
			keyIn.nextLine();
			System.out.print("Enter the gender of the given Consumer (MALE or FEMALE): ");
			String gender = keyIn.nextLine();
			System.out.print("Enter the education of the given Consumer (ELEMENTARY, SECONDARY, POSTSECONDARY): ");
			Education education = Education.valueOf(keyIn.nextLine().toUpperCase());
			findConsumersBy(age, gender, education);
			break;
		case 4:
			System.out.print("Enter the age of the given Consumer: ");
			int ageConsumer = keyIn.nextInt();
			keyIn.nextLine();
			System.out.print("Enter the postal code of the given Consumer: ");
			String postalCode = keyIn.nextLine();
			findConsumerByAgeNpostalCode(ageConsumer, postalCode);
			break;
		case 5:
			System.out
					.println("\n*********************************************************************************** \n"
							+ "\t\tTHANK YOU FOR USING CONSUMER DATABASE \n \t\t\t\t\t\t     Operated by h&s co. \n"
							+ "*********************************************************************************** \n");
			System.exit(0);
		default:
			System.out.println("\nEnter a valid key from 1 to 5 ...!!\n");
			selectOption();
		}
		selectOption();
	}

	/**
	 * For the option 1: The user has a maximum of 3 attempts to enter the correct
	 * password. After the 3rd wrong attempt, the main menu is displayed again.
	 * Additionally, after this process is repeated 4 times (i.e. after consecutive
	 * 12 failed attempts), the program exits. For the option 2: the user has 3
	 * attempts to enter the correct password. However, after the 3rd wrong attempt
	 * entry, the program exits.
	 */
	public static void checkPassword() {
		final String PASSWORD = "password";
		System.out.print("Enter password: ");
		String passwordEntered = keyIn.next();
		while (passwordCounterFor3Attemps < 3) {
			if (passwordEntered.equals(PASSWORD)) {
				System.out.println("Password matched...!!\n");
				if (optionSelected == 1) {
					addNewConsumer();
				} else if (optionSelected == 2) {
					changeConsumerInformation();
				}
				break;
			} else {
				System.out.println("Password didn't match please try again...!!\n");
				passwordCounterFor3Attemps++;
				passwordCounterFor12Attemps++;
				if (passwordCounterFor3Attemps == 3) {
					System.out.println("You have tried the password " + passwordCounterFor12Attemps + " times....!!\n");
					if (optionSelected == 2) {
						System.out.println("Program terminated due to safety reasons....!!");
						System.exit(0);
					}
					passwordCounterFor3Attemps = 0;
					if (passwordCounterFor12Attemps == 12) {
						System.out.println("In total you have tried 12 times and ");
						System.out.println(
								"Program has detected suspicious activity and will terminate\r\n" + "immediately!");
						System.exit(0);
					}
					selectOption();
				}
				checkPassword();
			}
		}
	}

	/**
	 * User is asked how many consumers he/she wants to enter and checks to make
	 * sure that there is enough space in the consumerDatabase (array of Consumer)
	 * to add that many consumers. If so, it adds them; otherwise inform the user
	 * that he/she can only add the number of remaining places in the array. (How
	 * the consumer information will be input/entered by the user, is up to you).
	 */
	public static void addNewConsumer() {
		System.out.println("Enter the number of Consumer to add: ");
		int addConsumers = keyIn.nextInt();
		keyIn.nextLine();
		int consumerNumber = 0;
		int newCursorPositionAt = currentCursorPositionAt + addConsumers;
		if (newCursorPositionAt <= (consumerDatabase.length)) {
			while (addConsumers > 0) {
				System.out.print("Enter the name of the consumer " + consumerNumber + " to add: ");
				String name = keyIn.nextLine();
				System.out.print("Enter the Street number: ");
				int streetNumber = keyIn.nextInt();
				keyIn.nextLine();
				System.out.print("Enter the Street Name: ");
				String streetName = keyIn.nextLine();
				System.out.print("Enter the city Name: ");
				String city = keyIn.nextLine();
				System.out.print("Enter the Postal Code: ");
				String postalCode = keyIn.nextLine();
				System.out.print("Enter the age: ");
				int age = keyIn.nextInt();
				keyIn.nextLine();
				System.out.print("Enter the Gender(Male or Female): ");
				String gender = keyIn.nextLine();
				System.out.print("Enter the Marital Status(SINGLE, MARRIED or DIVORCED): ");
				MaritalStatus maritalStatus = MaritalStatus.valueOf(keyIn.nextLine().toUpperCase());
				System.out.print("Enter the education(ELEMENTARY, SECONDARY, POSTSECONDARY): ");
				Education education = Education.valueOf(keyIn.nextLine().toUpperCase());
				consumerDatabase[currentCursorPositionAt] = new Consumer(name, streetNumber, streetName, city,
						postalCode, age, gender, maritalStatus, education);
				System.out.print("\nConsumer " + consumerDatabase[currentCursorPositionAt].getName()
						+ " has been added succesfully...!!\n");
				currentCursorPositionAt++;
				addConsumers--;
				consumerNumber++;
			}
		} else {
			System.out.println("There is not enough space in database to add " + addConsumers + " Consumers.\n"
					+ "You can only add maximum of " + (consumerDatabase.length - currentCursorPositionAt)
					+ " Consumers");
			addNewConsumer();
		}
	}

	/**
	 * User is asked which consumer he/she wishes to update. The Consumer number is
	 * the index in the array consumerDatabase. If there is no Consumer at the
	 * specified index location, display a message asking user if he/she wishes to
	 * re-enter another consumer, or quit this operation and go back to the main
	 * menu. If the consumer is present, display the current information of that
	 * consumer.
	 */
	public static void changeConsumerInformation() {
		System.out.println(
				"Which Consumer would you like to change?\n" + "(Enter the Consumer number(index) of the array....)");
		consumerChange = keyIn.nextInt();
		if (consumerDatabase[consumerChange] == null) {
			System.out.println("There is no Consumer present at this location.");
			reEnterOrQuit();
		} else if (consumerChange < 0 || consumerChange >= consumerDatabase.length) {
			System.out.println("Enter a valid Consumer Number(index) from the given Database....");
			reEnterOrQuit();
		} else {
			changeConsumerPersonalInformation();
		}
	}

	/**
	 * If the consumer is present in the consumerDatabase then a list of options is
	 * displayed which asks the user the information he\she would like to change. If
	 * the correct choice is not input, then list is displayed until the correct
	 * option is selected.
	 */
	public static void changeConsumerPersonalInformation() {
		System.out.println("\n\t\tSelected Consumer details are as follow...\nConsumer: " + consumerChange + "\n"
				+ consumerDatabase[consumerChange]);
		System.out.println("What information would you like to change?\r\n" + "1. Consumer name\r\n" + "2. Location\r\n"
				+ "3. Age\r\n" + "4. Gender\r\n" + "5. Marital Status\r\n" + "6. Quit\r\n"
				+ "Please enter your choice >");
		int choice = keyIn.nextInt();
		keyIn.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Current Consumer Name is: " + consumerDatabase[consumerChange].getName() + "\n"
					+ "Enter the new Name: ");
			consumerDatabase[consumerChange].setName(keyIn.nextLine());
			break;
		case 2:
			System.out.println("Current Consumer Location is: " + "\nLocation: "
					+ consumerDatabase[consumerChange].getStreetNumber() + ", "
					+ consumerDatabase[consumerChange].getStreetName() + ", "
					+ consumerDatabase[consumerChange].getCity() + ", "
					+ consumerDatabase[consumerChange].getPostalCode());
			System.out.print("Enter the new StreetNumber: ");
			consumerDatabase[consumerChange].setStreetNumber(keyIn.nextInt());
			keyIn.nextLine();
			System.out.println("Enter the new Street Name: ");
			consumerDatabase[consumerChange].setStreetName(keyIn.nextLine());
			System.out.println("Enter the new City Name: ");
			consumerDatabase[consumerChange].setCity(keyIn.nextLine());
			System.out.println("Enter the postal code");
			consumerDatabase[consumerChange].setPostalCode(keyIn.nextLine());
			break;
		case 3:
			System.out.println("Current Consumer age is: " + consumerDatabase[consumerChange].getAge());
			System.out.print("Enter the new age: ");
			consumerDatabase[consumerChange].setAge(keyIn.nextInt());
			keyIn.nextLine();
			break;
		case 4:
			System.out.println("Current Consumer gender is: " + consumerDatabase[consumerChange].getGender());
			System.out.print("Enter the new gender: ");
			consumerDatabase[consumerChange].setGender(keyIn.nextLine());
			break;
		case 5:
			System.out.println(
					"Current Consumer Marital Status is: " + consumerDatabase[consumerChange].getMaritalStatus());
			System.out.print("Enter the new Marital Status: ");
			MaritalStatus status = MaritalStatus.valueOf(keyIn.nextLine().toUpperCase());
			consumerDatabase[consumerChange].setMaritalStatus(status);
			break;
		case 6:
			System.out.println("\nQuitting the \"Change information of a Consumer\"...\n"
					+ "And returning to the Main Menu....\n");
			selectOption();
			break;
		default:
			System.out.println("Enter a valid key....");
			changeConsumerPersonalInformation();
		}
		System.out.println("\n\t\tUpdated Consumer details are as follow...");
		System.out.println("\nConsumer: " + consumerChange + "\n" + consumerDatabase[consumerChange]);
		changeConsumerPersonalInformation();
	}

	/**
	 * When the consumer is not present in the consumerDatabase array or the index
	 * entered by the user is out of bound then reEnterOrQuit() is called, which
	 * asks the user if he\she wants to re-enter another user or he\she wants to
	 * quit the operation.
	 */
	public static void reEnterOrQuit() {
		System.out
				.println("What Would you like to do\n" + "1. Re-enter another consumer.\n" + "2. Quit this operation.");
		switch (keyIn.nextInt()) {
		case 1:
			changeConsumerInformation();
			break;
		case 2:
			System.out.println(
					"Quiting the operation \"Change information of the Consumer.\"\n" + "Moving to Main Menu...!!");
			selectOption();
			break;
		default:
			System.out.println("Enter a valid key...!!");
			reEnterOrQuit();
		}
	}

	/**
	 * Checks and displays all the consumers with same age, gender and education.
	 * 
	 * @param age       represents the age of the consumer.
	 * @param gender    represents the gender of the consumer.
	 * @param education represents the education level of the consumer.
	 */
	public static void findConsumersBy(int age, String gender, Education education) {
		boolean flag = false;
		System.out.println("\nDisplaying all the Consumer with the age of " + age + " years, gender "
				+ gender + " and with the education level of " + education);
		for (int i = 0; i < consumerDatabase.length; i++) {
			if (consumerDatabase[i] != null) {				
				if (consumerDatabase[i].getAge() == age && consumerDatabase[i].getGender().equalsIgnoreCase(gender)
						&& consumerDatabase[i].getEducation().toString().equalsIgnoreCase(education.toString())) {					
					System.out.println(consumerDatabase[i]);
					flag = true;
				}
			}
		}
		if (flag == false) {
			System.out.println("No Such Consumer Found...!!");
		}
	}

	/**
	 * Finds the consumer based on the given age and the postal Code and then prints
	 * all the details of the consumer.
	 * 
	 * @param age        represents the age of the consumer.
	 * @param postalCode represents the postal Code of the consumer.
	 */
	public static void findConsumerByAgeNpostalCode(int age, String postalCode) {
		boolean flag = false;
		System.out.println("\nDisplaying all the Consumer of " + age + " years and Postal Code " + postalCode);
		for (int i = 0; i < consumerDatabase.length; i++) {			
			if (consumerDatabase[i] != null && consumerDatabase[i].getAge() == age
					&& consumerDatabase[i].getPostalCode().trim().equalsIgnoreCase(postalCode.trim())) {				
				System.out.println(consumerDatabase[i]);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("No Such Consumer Found...!!");
		}
	}
}
