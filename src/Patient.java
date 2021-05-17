public class Patient extends User {

	private String birthday;
	private double weight;
	private double height;
	private String bloodType;

	Patient (String name, String email) {
		super(name, email);
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\nAge: " + birthday + "\n Weight: " +getWeight()+ "\n Height"+getHeight()+"\nBlood"+ bloodType;
	}
}
