import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ScoreTrakker {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public void loadDataFile(String file) throws FileNotFoundException {
		FileReader reader = new FileReader(file);
		try (Scanner in = new Scanner(reader)) {
			while(in.hasNextLine()) {
				String name = in.nextLine();
				int score = Integer.parseInt(in.nextLine());
				studentList.add(new Student(name,score));
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printInOrder() {
		Collections.sort(studentList, Collections.reverseOrder());;
		for(Student student : studentList) {
			System.out.println(student);
		}
	}
	
	public void processFiles(String file) throws FileNotFoundException {
		loadDataFile(file);
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles("scores.txt");

	}

}
