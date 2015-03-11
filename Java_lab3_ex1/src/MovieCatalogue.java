import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

public class MovieCatalogue {
	ArrayList<Movie> catalogue = new ArrayList<Movie>();

	void addMovie(String name, int rating, int id, String date,
			String[] category) throws Exception {
		Movie m = new Movie();
		m.setName(name);
		m.setRating(rating);
		m.setIdIMDB(id);
		m.setDate(date);
		try {
			m.setCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catalogue.add(m);
	}

	void addMovie(Movie m) {
		catalogue.add(m);
	}

	void deleteMovie(Movie m) {
		if (catalogue.contains(m) == true)
			catalogue.remove(m);
		else
			throw new EmptyStackException();

	}

	void deleteMovie(String name) {
		for(int i=0 ; i<catalogue.size(); i++)
			if(catalogue.get(i).getName().compareTo(name)==0)
			catalogue.remove(i);
		else
			throw new EmptyStackException();
	}
	
	
	@Override
	public String toString() {
		return "MovieCatalogue [catalogue=" + catalogue + "]";
	}

	void insertValues() {
		Movie m = new Movie();
		Scanner scan = new Scanner(System.in);
		System.out.println("Add movies until you add ok = 0");
		int ok = 1;
		while (ok == 1) {
			System.out.println("Movie name: ");
			m.setName(scan.nextLine());
			System.out.println("Movie category - insert number of categories ");
			
			int nrCat=scan.nextInt();
			System.out.println("Insert categories: ");
			String[] categories = new String[nrCat];
			for (int i = 0; i < categories.length; i++)
				categories[i] = scan.next();
			m.setCategory(categories);
			System.out.println("Insert release date: ");
			try {
				m.setDate(scan.next());
			} catch (MovieException e1) {
				System.out.println( e1.getMessage());
				e1.printStackTrace();
			}
			System.out.println("Movie rating: ");
			
			
			try {
				m.setRating(scan.nextInt());
			} catch (MovieException e) {
				System.out.println( e.getMessage());
				e.printStackTrace();
			}

			System.out.println("Movie IMDB id: ");
			
			try {
				m.setIdIMDB(scan.nextInt());
			} catch (MovieException e) {
				System.out.println( e.getMessage());
				e.printStackTrace();
			}
			catalogue.add(m);

			System.out.println("Want to add another movie? Enter 1 else 0");
			ok = scan.nextInt();
		}
		scan.close();
	}

}
