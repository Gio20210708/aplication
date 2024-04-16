package aplicacion1;
import java.io.*;
import java.util.*;
 
//FILE CREATE METHOD
 
public class GenerateIntoFiles {
    private static final String SELLER_FILE_NAME = "sellerInfo.csv";
    private static final String PRODUCT_FILE_NAME = "productInfo.csv";
    private static final String INFO_SALES = "infoSales.csv";
    public static Map<String, Integer> ListTotal = new HashMap<>();
    
public static void sellersBill(String name, Map<Integer, Integer> products,Map<Integer, List <String>> valueProduct) {
	
	 String SELLER_FILE_BILL = "billInfo"+name+".csv";
	 String content="";
	 int product=0;
	 int quantity=0;
	 String NameProduct="";
	 String productPrice="";
	 int total=0;
	 int totalGlobal=0;
	
	
	 content="Producto;Cantidad;Nombre;Valor;Total\n";
	 GenerateIntoFiles fileReader = new GenerateIntoFiles();
     fileReader.createFiles();
	
	
	 for (Map.Entry<Integer, Integer> entry: products.entrySet()) {
		
		
		 product=entry.getKey();
		 quantity=entry.getValue();
		 NameProduct=valueProduct.get(product).get(0);
		 productPrice=valueProduct.get(product).get(1);
		 total=quantity*Integer.parseInt(productPrice);
		 totalGlobal+=total;
		
		 		
		 content+=product+";"+quantity+";"+NameProduct+";"+productPrice+";"+total+"\n";
		
		
		 fileReader.writeToFile(new File(SELLER_FILE_BILL), content);
		
		 }
	
	 ListTotal.put(name,totalGlobal);
	
}
    
 
    private void createFiles() {
        try {
            File sellerInformation = new File(SELLER_FILE_NAME);
            File productInfo = new File(PRODUCT_FILE_NAME);
            File infoSales = new File(INFO_SALES);
            
            
            if (sellerInformation.createNewFile()) {
                System.out.println("Sellers file created successfully");
            }
            if (productInfo.createNewFile()) {
                System.out.println("Product file created successfully");
            }
            if (infoSales.createNewFile()) {
                System.out.println("Info Sales file created successfully");
            }
        } catch (IOException exception) {
            System.out.println("Error creating files: " + exception.getMessage());
        }
    }
    
// FILE WRITE METHOD
 
    private void writeToFile(File file, String data) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
            System.out.println("Data written to file: " + file.getName());
        } catch (IOException exception) {
            System.out.println("Error writing to file: " + file.getName() + " - " + exception.getMessage());
        }
    }
   
// FILE READER METHOD    
    
    public void filereadertext () {
		String Info_Sellers;
		String Info_Products;
		
		try {
			FileReader Lector = new FileReader(SELLER_FILE_NAME);
			BufferedReader lectura = new BufferedReader(Lector);
			
			Info_Sellers = lectura.readLine();
			while(Info_Sellers !=null) {
				
				System.out.println(Info_Sellers);
				Info_Sellers = lectura.readLine();
			}
			
			lectura.close();
 
			System.out.println(Info_Sellers);
		}catch(IOException exepcion){
			exepcion.printStackTrace(System.out);			
			
		}
		
		try {
			FileReader Lector = new FileReader(PRODUCT_FILE_NAME);
			BufferedReader lectura = new BufferedReader(Lector);
			Info_Products = lectura.readLine();
			while(Info_Products !=null) {
				System.out.println(Info_Products);
				Info_Products = lectura.readLine();
			}
			
			lectura.close();
 
			System.out.println(Info_Products);
		}catch(IOException exepcion){
			exepcion.printStackTrace(System.out);
		}
	}
    
 
    // INTEGER INFORMATION MAIN
    
    public static void main(String[] args) {
    	
    	Map<Integer, Integer> LuisaLopez = new HashMap<>();
    	//
    	LuisaLopez.put(1,150);
    	LuisaLopez.put(2,300);
    	LuisaLopez.put(3,50);
    	LuisaLopez.put(4,25);
    	LuisaLopez.put(5,0);
    	//
    	Map<Integer, Integer> JuanitoRuiz = new HashMap<>();
    	//
    	JuanitoRuiz.put(1,225);
    	JuanitoRuiz.put(2,630);
    	JuanitoRuiz.put(3,15);
    	JuanitoRuiz.put(4,85);
    	JuanitoRuiz.put(5,410);
    	//
    	Map<Integer, Integer> LuisGonzalez = new HashMap<>();
    	//
    	LuisGonzalez.put(1,130);
    	LuisGonzalez.put(2,315);
    	LuisGonzalez.put(3,410);
    	LuisGonzalez.put(4,39);
    	LuisGonzalez.put(5,98);
    	//
    	Map<Integer, Integer> MariaMartinez = new HashMap<>();
    	//
    	MariaMartinez.put(1,315);
    	MariaMartinez.put(2,20);
    	MariaMartinez.put(3,35);
    	MariaMartinez.put(4,48);
    	MariaMartinez.put(5,115);
    	//
    	Map<Integer, Integer> PepitoPerez = new HashMap<>();
    	//
    	PepitoPerez.put(1,5);
    	PepitoPerez.put(2,49);
    	PepitoPerez.put(3,385);
    	PepitoPerez.put(4,115);
    	PepitoPerez.put(5,201);
    	//
    	Map<Integer, List <String>> productos = new HashMap<>();
    	//
    	List<String> Arroz = new ArrayList<>();
    	Arroz.add("Arroz");
    	Arroz.add("5400");
    	//
    	List<String> Frijol = new ArrayList<>();
    	Frijol.add("Frijol");
    	Frijol.add("6500");
    	//
    	List<String> Leche = new ArrayList<>();
    	Leche.add("Leche");
    	Leche.add("3700");
    	//
    	List<String> Pan = new ArrayList<>();
    	Pan.add("Pan");
    	Pan.add("4900");
    	//
    	List<String> Huevos = new ArrayList<>();
    	Huevos.add("Huevos");
    	Huevos.add("5200");
    	//
    	productos.put(1, Arroz);
    	productos.put(2, Frijol);
    	productos.put(3, Leche);
    	productos.put(4, Pan);
    	productos.put(5, Huevos);
    	//
    	   	
    	// CREATE SELLERS BILL ARCHIVE METHOD
    	
    	sellersBill("PepitoPerez",PepitoPerez,productos);
    	sellersBill("LuisaLopez",LuisaLopez,productos);
    	sellersBill("JuanitoRuiz",JuanitoRuiz,productos);
    	sellersBill("LuisGonzalez",LuisGonzalez,productos);
    	sellersBill("MariaMartinez",MariaMartinez,productos);
    	
    	List<Map.Entry<String, Integer>> lista = new ArrayList<>(ListTotal.entrySet());
    	
    	//Collections.sort(lista, Comparator.comparing(Map.Entry::getValue));
    	
    	Collections.sort(lista, Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
    	
    	Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : lista) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }
    	
    	String name;
    	int totalAmount;
    	String content;
    	content="Vendedor;Total Ventas\n";
    	
    	for (Map.Entry<String, Integer> entry: mapaOrdenado.entrySet()) {
    		
    	name=entry.getKey();
   		totalAmount=entry.getValue();
   		content+=name+";"+totalAmount+"\n";
   		   		
    		
    	}
    	
    	
    	 // CREATE FILE METHOD
    	
        GenerateIntoFiles fileReader = new GenerateIntoFiles();
        fileReader.createFiles();
        fileReader.writeToFile(new File(SELLER_FILE_NAME), "CC ; 123456789 ; Pepito; Perez\n" +
                                                             "CC ; 987654321 ; Juanito; Ruiz\n" +
                                                             "CC ; 546123788 ; Luisa; Lopez\n" +
                                                             "CC ; 369852147 ; Maria; Martinez\n" +
                                                             "CC ; 741852963 ; Luis; Gonzalez");
 
        fileReader.writeToFile(new File(PRODUCT_FILE_NAME), "1 ; Arroz; 5400\n" +
                                                              "2 ; Frijol; 6500\n" +
                                                              "3 ; Leche; 3700\n" +
                                                              "4 ; Pan; 4900\n" +
                                                              "5 ; Huevos; 5200");
        
        fileReader.writeToFile(new File(INFO_SALES), content);
        
    
  
        fileReader.filereadertext();
        
        System.out.println("Successful execution");
    }
    	
     
}
 