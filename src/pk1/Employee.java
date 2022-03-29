/**
 * Employee class
 * To create and manipulate one Employee object
 */
package pk1;

public class Employee {
	//Declare id of employee
	private String id;
	//Declare name of employee
	private String name;
	//Declare Date of birth of employee
	private String dateOfBirth;
	//Declare Birthplace of employee
	private String birthPlace;
	
	/**
	 * Group of methods to get ID, get name, get date of birth, get birthplace
	 * @return
	 */
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	
	/**
	 * group methods to set id, set name, set date of birth, set birthPlace
	 * @param id, name, dateOfBirth, birthPlace
	 */
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	@Override
	public String toString() {
		return ""+id+" \t\t "+name+" \t\t "+dateOfBirth+"  \t\t "+birthPlace;
	}
	
	
}
