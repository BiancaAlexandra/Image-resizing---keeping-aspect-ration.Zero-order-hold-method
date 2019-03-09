package temaJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;

public class Zoom implements Interfata{
	
	//get image width and height 
	int width;    //width of the image
	int height;  //height of the image
	
	//new image dimension
	int newWidth;		//width of the image
	int newHeight;	//height of the image
	
	private int nrLinii;
	private int nrColoane;
	
	public BufferedImage image = null;
	public static File f = null;
		
	//incapsulare
	public int getNrLinii() {
		return nrLinii;
	}

	public void setNrLinii(int nrLinii) {
		if(nrLinii > 0)
			this.nrLinii = nrLinii;
	}

	public int getNrColoane() {
		return nrColoane;
	}

	public void setNrColoane(int nrColoane) {
		if(nrColoane > 0)
			this.nrColoane = nrColoane;
	}
	
	//polimorfism
	//afisare numar de linii
	public void afisare(int nrLinii)
	{
		System.out.println("Numar linii : " + this.nrLinii);
	}
	
	//afisare numar linii si numar coloane
	public void afisare(int nrLinii, int nrColoane)
	{
		System.out.println("Numar linii : " + this.nrLinii + "\n" + "Numar coloane : " + this.nrColoane);
	}
	
	//citirea unei imagini
	public BufferedImage readImage(String nume)
	{
		//read image
		 try{
			
		   //imaginea care se citeste
		    f = new File("D:\\Image\\"+ nume + ".bmp"); //image file path
		    image = new BufferedImage(225, 225, BufferedImage.TYPE_INT_ARGB);
		    image = ImageIO.read(f);
		    
		    System.out.println("Reading complete.");
		    
		  }catch(IOException e){
		    System.out.println("Error: "+e);
		  }
		return image;
			 
	}
	
	//se retuneaza width-ul imaginii
	public int getWidth(BufferedImage image2) {
		return ((RenderedImage) image2).getWidth();    //width of the image
	}
	
	//se seteaza width-ul imaginii
	public void setWidth(int width) {
		if(width > 0)
			this.width = width;
	}
	
	//se retuneaza height-ul imaginii
	public int getHeight(BufferedImage image2) {
		return ((RenderedImage) image2).getHeight();  //height of the image
	}
	
	//se seteaza height-ul imaginii
	public void setHeight(int height) {
		if(height > 0)
			this.height = height;
	}
	
	//se retuneaza width-ul imaginii redimensionate
	public static int getnewWidth(int width) {
		return 2 * width - 1;	//width of the image
	}
	
	//se seteaza width-ul imaginii redimensionate
	public void setnewWidth(int newWidth) {
		if(newWidth > 0)
			this.newWidth = newWidth;
	}
	
	//se retuneaza height-ul imaginii redimensionate
	public static int getnewHeight(int height) {
		return 2 * height - 1;	//height of the image
	}
	
	//se seteaza height-ul imaginii redimensionate
	public void setnewHeight(int newHeight) {
		if(newHeight > 0)
			this.newHeight = newHeight;
	}
	
	//folosire varargs
	public void afis(int ...in )
	{
		for(int i : in)
			System.out.print(i + " ");
	}

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Zoom z = new Zoom();
		BufferedImage image;
		
		//get image width and height 
		int width;    //width of the image
		int height;  //height of the image
		
		//new image dimension
		int newWidth;		//width of the image
		int newHeight;	//height of the image
		
		z.setNrLinii(200);
		z.afisare(z.getNrLinii());
		
		//citirea de la tastatura a numelui pozei ce se doreste sa se mareasa si numele pozei rezultate  
		
	 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduceti numele pozei ce doriti sa o mariti:");
		String numeFisierIn = br.readLine();
		System.out.println("Introduceti un nume pentru poza marita:");
		String numeFisierOut = br.readLine();
		
		br.close();
		
		System.out.println("Numele pozei " + numeFisierIn);
		System.out.println("Numele pozei marite " + numeFisierOut);
		
		image = z.readImage(numeFisierIn);
		
		//get image width and height 
		System.out.println("Width " +z.getWidth(image));
		height = z.getWidth(image);
		System.out.println("Height " +z.getHeight(image));
		width = z.getWidth(image);
		
		//folosire varargs
		System.out.println("Varargs");
		z.afis(height);
		System.out.println();
		z.afis(height,width);
		System.out.println();
		
		//matricea valoare contine valoarea fiecarui pixel
		int[][] valoare = new int [height][width];
		
		//new image dimension
		newWidth = getnewWidth(width);
		newHeight = getnewHeight(height);
		System.out.println("newWidth " +  newWidth);
		System.out.println("newHeight " + newHeight);
		
		//cream o matrice ce este o copie intermediara o imaginii finale
		int[][] inter = new int [newHeight][newWidth];
		
		//create buffered image object img
		BufferedImage newimg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		//file object
		File newf = null;
			
		//am luat valorile lui alpha,read,green si blue pentru fiecare pixel al imaginii 
		//am retinut aceste valori in vectorul valoare
	    for(int i = 0; i < height; i++) {
	    	for(int j = 0; j < width; j++) {
	           
	    		Color c = new Color(image.getRGB(i, j));           
	    		int p = (c.getAlpha()<<24) | (c.getRed()<<16) | (c.getGreen()<<8) | c.getBlue(); //pixel
	    		valoare[i][j] = p;
	    	}
	    }

	    int l = -1;
		int c = -1;
		//initializam poza cea noua
		for(int i = 0; i < newHeight; i = i + 2) {
			l++;
			c = -1;
			for(int j = 0; j < newWidth; j = j + 2) { 
				c++;
				newimg.setRGB(i, j, valoare[l][c]);         
			}
		}
	        
		int newValoare = 0;
	      
		//cream o matrice ce este o copie intermediara o imaginii finale
		for(int i = 0; i < newHeight; i++) {
			for(int j = 0; j < newWidth; j++) {
	          
				Color c2 = new Color(newimg.getRGB(i, j));             
				int p = (c2.getAlpha()<<24) | (c2.getRed()<<16) | (c2.getGreen()<<8) | c2.getBlue(); //pixel
				inter[i][j] = p;
				newimg.setRGB(i, j, p);
			}
		}
	      
		//lucram intai pe linii 
		for(int i = 0; i < newHeight; i = i + 2) {
			for(int j = 0; j < newWidth-2; j = j + 2) { 
				newValoare = (int)((inter[i][j] + inter[i][j+2])/2);
				newimg.setRGB(i, j + 1, newValoare);               
			}
		}
	        
		//apoi lucram pe coloane
		for(int j = 0; j < newWidth; j = j + 2) {
			for(int i = 0; i < newHeight-2; i = i + 2) {
				newValoare = (int)((inter[i][j] + inter[i+2][j])/2);
				newimg.setRGB(i + 1, j, newValoare);
			}
		}  
	 
		//write image
		try{
			newf = new File("D:\\Image\\" + numeFisierOut + ".png");
			ImageIO.write(newimg, "png", newf);
	       
			f = new File("D:\\Image\\initial.png");
			ImageIO.write(image, "png", f);
	       
			System.out.println("Writing complete.");
			}catch(IOException e){
				System.out.println("Error: " + e);
			}

		}
	
	@Override
	public void getInformatii() {
		// TODO Auto-generated method stub
		System.out.println("Width = " + width);
		System.out.println("Height = " + height);
	}
	

}



