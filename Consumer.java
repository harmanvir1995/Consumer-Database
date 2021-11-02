
/**
 * -----------------------------------------------------
 * Assignment 1
 * Question: Design and implement a Consumer class.
 * @author  HARMANVIR SINGH (40019114)
 * @author  SARABPREET SINGH (40154067)
 * -----------------------------------------------------
 */

/**
 * 
 * The class Consumer contains all the methods to provide and change the
 * information of the consumer of the marketing company.
 *
 */
enum MaritalStatus {
		SINGLE, MARRIED, DIVORCED;
	}

enum Education {
	ELEMENTARY, SECONDARY, POSTSECONDARY;
}


public class Consumer {
	// All 9 attributes that define a Consumer object.
	private String name;
	private int streetNumber;
	private String streetName;
	private String city;
	private String postalCode;
	private int age;
	private String gender;
	private static int counter = 0;

	

	// Declared a MaritalStatus object.
	MaritalStatus maritalStatus;

	
	// Declared a Education object.
	Education education;

	/**
	 * Creates a new object with the given parameters.
	 * 
	 * @param name          Describes the name of the consumer.
	 * @param streetNumber  Describes the street number of the consumer.
	 * @param streetName    Describes the street name of the consumer.
	 * @param city          the city of the consumer.
	 * @param postalCode    the postal code of the address.
	 * @param age           the age of the consumer.
	 * @param gender        the gender of the consumer.
	 * @param maritalStatus the marital status of the consumer.
	 * @param education     the education level of the consumer.
	 */
	public Consumer(String name, int streetNumber, String streetName, String city, String postalCode, int age,
			String gender, MaritalStatus maritalStatus, Education education) {
		this.name = name;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.education = education;
		counter++;
	}

	/**
	 * Provides the name of the consumer.
	 * 
	 * @return the name of the consumer.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of the consumer.
	 * 
	 * @param name the new name of the consumer.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Provides the street number where the consumer is currently residing.
	 * 
	 * @return the street number of the consumer where he is currently residing.
	 */
	public int getStreetNumber() {
		return this.streetNumber;
	}

	/**
	 * Changes the street number of the consumer.
	 * 
	 * @param streetNumber the new street number
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * Provides the street name of the consumer.
	 * 
	 * @return the street name of the consumer.
	 */
	public String getStreetName() {
		return this.streetName;
	}

	/**
	 * Changes the street name of the consumer.
	 * 
	 * @param streetName the new street name of the consumer.
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Provides the name of the city.
	 * 
	 * @return the name of the city.
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Changes the name of the city.
	 * 
	 * @param city the new name of the city.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Provides the postal code of the consumer.
	 * 
	 * @return the postal code of the consumer.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Changes the postal code of the consumer.
	 * 
	 * @param postalCode the new postal code of the consumer.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Provides the age of the consumer.
	 * 
	 * @return the age of the consumer.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Changes the age of the consumer.
	 * 
	 * @param age the new age of the consumer.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Provides the gender of the consumer.
	 * 
	 * @return the gender of the consumer.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Changes the gender of the consumer.
	 * 
	 * @param gender the gender of the consumer.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Provides the marital Status of the consumer.
	 * 
	 * @return the marital status.
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	// Sets the Marital Status of the Consumer.
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		if (maritalStatus.toString().equalsIgnoreCase("Married")) {
			this.maritalStatus = MaritalStatus.MARRIED;
		} else if (maritalStatus.toString().equalsIgnoreCase("Single")) {
			this.maritalStatus = MaritalStatus.SINGLE;
		} else if (maritalStatus.toString().equalsIgnoreCase("Divorced")) {
			this.maritalStatus = MaritalStatus.DIVORCED;
		} else {
			System.out.println("Fatal error creating a Consumer Object." + " Enter correct Marital Status.");
			System.exit(0);
		}
	}

	/**
	 * Provides the level of Education of the consumer.
	 * 
	 * @return the education level of the consumer.
	 */
	public Education getEducation() {
		return education;
	}

	/**
	 * Changes the education level of the consumer.
	 * 
	 * @param educationLevel the new education level.
	 */
	public void setEducation(Education educationLevel) {
		if (educationLevel.toString().equalsIgnoreCase("ELEMENTARY")) {
			education = Education.ELEMENTARY;
		} else if (educationLevel.toString().equalsIgnoreCase("SECONDARY")) {
			education = Education.SECONDARY;
		} else if (educationLevel.toString().equalsIgnoreCase("POSTSECONDARY")) {
			education = Education.POSTSECONDARY;
		} else {
			System.out.println("Fatal error creating a Consumer Object." + " Enter correct Education Level.");
			System.exit(0);
		}
	}

	@Override
	/**
	 * 
	 */
	public String toString() {
		return "Name: " + this.getName() + "\nLocation: " + this.getStreetNumber() + ", " + this.getStreetName() + ", "
				+ this.getCity() + ", " + this.getPostalCode() + "\nAge: " + this.getAge() + "\nGender: "
				+ this.getGender() + "\nMarital Status: " + this.getMaritalStatus() + "\nEducation: "
				+ this.getEducation() + "\n";
	}

	// This method returns the total number of
	// Consumer objects created prior to invocation of this method. The method would
	// simply return 0
	// if no Consumer has been created by the time the method is called.
	public static int getNumberOfConsumers() {
		return counter;
	}

	// It compares two Consumer objects for similarity. It returns true when two
	// Consumer objects are similar
	// if they have the same age, gender, and education and false if these
	// attributes are different.
	public boolean equals(Consumer consumer) {
		boolean isSimilar = false; // Not Sure if we will be able to access consumer.education because education is
									// a private attribute.
		if (this.age == consumer.age && this.gender.equalsIgnoreCase(consumer.getGender())
				&& this.education.equals(consumer.education)) {
			isSimilar = true;
		}
		return isSimilar;
	}
}
