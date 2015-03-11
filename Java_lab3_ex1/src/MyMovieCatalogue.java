
import java.io.*;


public class MyMovieCatalogue 
{

	public static void main(String[] args) throws Exception 
	{
		MovieCatalogue myList = new MovieCatalogue ();
		Movie mo = new Movie();
		String [] moCategory = {"comedy", "romance"}; 
		mo.setCategory(moCategory);
		mo.setIdIMDB(2345);
		mo.setName("What if");
		mo.setRating(6);
		mo.setDate("2015-01-01");
		myList.addMovie(mo);
		
		//String [] cat ={"Horror", "SF"};
	//	myList.addMovie("Book thief", 6, 4567,"2015-01-05", cat);
		//myList.deleteMovie(mo);
	//	System.out.println(myList.toString());
		myList.insertValues();
	//	System.out.println(myList.toString());
				
	   Movie m1 = new Movie();
	   String [] mCategory = {"comedy","romance"}; 
		m1.setCategory(mCategory);
		m1.setIdIMDB(1235);
		m1.setName("Minions");
		m1.setRating(6);
		m1.setDate("2015-05-01");
		myList.addMovie(m1);
	    try
	    {
	       FileOutputStream fileOut =
	       new FileOutputStream("E:/School/SemII/JAVA/Java_lab3_ex1/src/movies.ser");
	       
	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
	       out.writeObject(m1);
	       out.close();
	       fileOut.close();
	       System.out.printf("Serialized data is saved in /tmp/employee.ser");
	    }catch(IOException i)
	    {
	        i.printStackTrace();
	    }
	
	    //deserialization
	    
	    Movie e = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("E:/School/SemII/JAVA/Java_lab3_ex1/src/movies.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Movie) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.getName());
	      String[] cate= new String[10];
	   	  System.out.print("Categories: " );
	      for(int i =0 ; i<e.getCategory().length; i++)
	      {
	 
	    	  System.out.print(e.getCategory()[i] +" ");
	      }
	      System.out.println(" ");
	      System.out.println("Release date: " + e.getDate());
	      System.out.println("IMDB: " + e.getIdIMDB());
	      System.out.println("Rating: " + e.getRating());
	      }	
}
