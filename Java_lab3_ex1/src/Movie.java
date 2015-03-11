
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Movie implements java.io.Serializable {
	private String name;
	private String[] category;
	private String date;
	Date releaseDate;
	private int rating;
	private int idIMDB;

	Movie(){
		this.name = "No Name";
		this.category = null;
		this.date = null;
		this.rating = 0;
		this.idIMDB = 0;
	}
	
	private void setMovie(String name, String[] type, String date,int rating, int idIMDB) {
		this.name = name;
		this.category = type;
		this.date = date;
		this.rating = rating;
		this.idIMDB = idIMDB;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getCategory() {
	//	int i;
		//for( i=0 ; i<category.length; i++)
			return category;
		//return null;
	}

	/*
	 * public void setCategory(String[] type) { String[] cat = {"romance",
	 * "horror", "musical", "thriller", "action", "comedy", "family", "drama",
	 * "crime", "Sci-Fi", "History"}; for(int i=0; i<cat.length; i++) for(int
	 * j=0; j<type.length; j++) if (type[j].equals(cat[i])==false)
	 * System.err.println(cat[i]+" Not a category"); this.category = type; }
	 */

	public void setCategory(String[] type) {
		String[] catStrings = { "romance", "horror", "musical", "thriller",
				"action", "comedy", "family", "drama", "crime", "sci-fi",
				"history" };
		List<String> cat = new ArrayList<String>();

		for (int i = 0; i < catStrings.length; i++) {
			cat.add(i, catStrings[i]);
		}

		for (int j = 0; j < type.length; j++) {
			if (!cat.contains(type[j].toLowerCase())) {
				System.err.println(type[j] + " Not a category");
			}
		}

		this.category = type;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) throws MovieException {
		
		
		int i=0;
		String separator = "-";
		String[] value = date.split("-");
		boolean flag=false;
			System.out.println(value[0]);
			System.out.println(value[1]);
			System.out.println(value[2]);
		if (Integer.parseInt(value[0])<1900 || Integer.parseInt(value[0])>2015)
			flag=true;
		else
			if (Integer.parseInt(value[1])<1 || Integer.parseInt(value[1])>12)
				flag=true;
			else
				if (Integer.parseInt(value[2])<1 || Integer.parseInt(value[2])>31)
					flag=true;
		if(flag)
			throw new MovieException("Date example: 2000-12-13 , year, month,day" + "U entered:" + date);
		else 
			this.date=date;
					
				
		
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) throws MovieException {
		if (rating > 11 || rating < 0)
			
			 throw new MovieException("Rating is from 0 to 10" + "U entered:" + rating);

		this.rating = rating;
	}

	public int getIdIMDB() {
		return idIMDB;
	}

	public void setIdIMDB(int idIMDB) throws MovieException {
		if (idIMDB > 1000 && idIMDB < 9999)
			this.idIMDB = idIMDB;
		else
			 throw new MovieException("IMDB id is from 1000 to 9999" + "U entered:" + idIMDB);
			
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", category="
				+ Arrays.toString(category) + ", date=" // releaseDate
				+ ", rating=" + rating + ", idIMBD=" + idIMDB + "]";
	}

}
