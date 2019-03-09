package temaJava;

public class Informatii extends Zoom{
	
	public String proiect;
	
	//returneaza numele proiectului
	public String getProiect() {
		return proiect;
	}
	
	//seteaza numele proiectului
	public void setProiect(String proiect) {
		this.proiect = proiect;
	}
	
	//ofera informatii despre poza
	public void getInformatii() {
		// TODO Auto-generated method stub
		super.getInformatii();
		System.out.println("Proiectul este : " + proiect);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zoom z = new Zoom();
		Informatii i = new Informatii();
		String nume;
		z.setNrLinii(200);
		z.afisare(z.getNrLinii());
		i.setProiect("Zoom using zero order hold method");
		nume = i.getProiect();
		System.out.println(nume);
		
	}

}
