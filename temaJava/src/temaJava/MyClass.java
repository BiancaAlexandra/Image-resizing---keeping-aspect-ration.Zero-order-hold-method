package temaJava;

//clasa abstracta
abstract class MyClass extends Detalii{
	
	String nume;
	
	//returneaza numele
	public String getNume() {
		return nume;
	}
	
	//seteaza numele
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	//metoda abstracta
	abstract void afisareNume();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Detalii d = new Detalii();
		String materie;
		d.setMaterie("AWJ");
		materie = d.getMaterie();
		System.out.println("Materie : " + materie);
	}
}
