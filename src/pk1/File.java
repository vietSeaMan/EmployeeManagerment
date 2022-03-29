package pk1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File {
	BufferedReader br;

	
	public File(String path) {
		try {
			this.br  = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Can not load file!");
		}
		
	}
	
	//To get data from File 
	public void getDataFromFile(ArrayList<ArrayList<Integer>> list) {
		String temp = "";
		int row = 0;
		try {
			while((temp = br.readLine()) != null) {
				list.add(new ArrayList<Integer>());
				//Split string from file to get data
				String[] arrStr = temp.split(",");
				//Use i to get right data and save to product object
				for(int i=0; i<arrStr.length; i++) {
					
					list.get(row).add(Integer.parseInt(arrStr[i]));
				}
				row++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
