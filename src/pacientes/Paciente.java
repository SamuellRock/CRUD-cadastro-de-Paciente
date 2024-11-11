package pacientes;

public class Paciente {
	
	int idNum;
	String name;
	double weight;
	double height;
	char gender;
	
	public Paciente(int idNum, String name,	double weight,	double height,	char gender) {
		this.idNum = idNum;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}
	
	
	//getter and setter
	public int getIdNum() {
		return idNum;
	}
	public void setIdNum( int idNum) {
		this.idNum = idNum;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getWeight() {
		return weight;
	}
	public void setWeight( double weight) {
		this.weight = weight;
	}
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight( double height) {
		this.height = height;
	}


	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	

	
	public void listarPaciente() {
		System.out.println("\nNome: " + name + "\nID: " + idNum);
		System.out.println("Peso: " + weight + "\nAltura: " + height + "\nSexo: " + gender);
	}

}
