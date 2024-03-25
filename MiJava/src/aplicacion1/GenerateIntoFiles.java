package aplicacion1;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
 
 
 
 
//Meotodo creacion de archivos
 
public class GenerateIntoFiles {
	static File sellerInformation;
	static File productInfo;
	private void createFileText() {
		sellerInformation = new File("sellerInfo.txt");
		productInfo = new File("productInfo.txt");
		try {
			if(sellerInformation.createNewFile()) {
				System.out.println("Sellers file created successfully");
			}
			if(productInfo.createNewFile()) {
				System.out.println("Product file created successfully");
			}
			else {
				System.out.println("error creating file");
				}
		}catch(IOException exepcion) {
			exepcion.printStackTrace(System.out);	
		}
	}
	private void eliminateFileText() {
			if(sellerInformation.delete()) {
				System.out.println("Sellers file remove successfully");
			}
			if(productInfo.delete()) {
				System.out.println("Product file remove successfully");
			}
			else {
				System.out.println("error remove file");
				}
	}
	
	// GENERATE METHOD TO DELETE FILE
	
	private static void WriteFileText() {
		
		try {
			FileWriter writerFile = new FileWriter(sellerInformation);
			writerFile.write("CC ; 123456789 ; Pepito; Perez");
			writerFile.write("\nCC ; 987654321 ; Juanito; Ruiz");
			writerFile.write("\nCC ; 546123788 ; Luisa; Lopez");
			writerFile.write("\nCC ; 369852147 ; Maria; Martinez");
			writerFile.close();
			
			FileWriter writerFile2 = new FileWriter(productInfo);
			writerFile2.write("1 ; Arroz; 5400");
			writerFile2.write("\n2 ; Frijol; 6500");
			writerFile2.write("\n3 ; Leche; 3700");
			writerFile2.write("\n4 ; Pan; 4900");
			writerFile2.close();
			
			System.out.println("Sucesfull agregate text");
			
		}catch(IOException exception) {
			exception.printStackTrace(System.out);
		}
	}
 
	public static void main(String[] arg) {
		GenerateIntoFiles fileText = new GenerateIntoFiles();
		fileText.createFileText();
		fileText.WriteFileText();
		//fileText.eliminateFileText();
	}
 
}

	

