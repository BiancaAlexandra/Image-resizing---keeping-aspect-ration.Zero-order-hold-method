package temaJava;

public class Detalii  extends Informatii{
	
	public String materie;
	
	//returneaza numele materiei
	public String getMaterie() {
		return materie;
	}
	
	//seteaza numele materiei
	public void setMaterie(String materie) {
		this.materie = materie;
	}
	
	//ofera informatii despre poza
	public void getInformatii() {
		// TODO Auto-generated method stub
		super.getInformatii();
		System.out.println("Materia este : " + materie);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zoom z = new Zoom();
		Informatii i = new Informatii();
		Detalii d = new Detalii();
		String nume;
		String materie;
		z.setNrLinii(200);
		z.afisare(z.getNrLinii());
		i.setProiect("Zoom using zero order hold method");
		nume = i.getProiect();
		System.out.println(nume);
		d.setMaterie("AWJ");
		materie = d.getMaterie();
		System.out.println("Materie : " + materie);
	}
}
