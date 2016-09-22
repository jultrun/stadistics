package co.jultrun.statistics.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Storage {
	public static void save(File f){
		
	}
	public static Vector<Vector<Float>> load(FileReader f) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(f);
		String line;
		Vector<Vector<Float>> data=new Vector<>();
		while ((line = br.readLine()) != null) {
			Vector<Float> row = new Vector<>();
			row.addAll(readLine(line.split(",")));
			data.add(row);
		}
		br.close();
		return data;
		
	}
	private static ArrayList<Float> readLine(String[] line) throws NumberFormatException {
		ArrayList<Float> lineF = new ArrayList<>();
		for (int i = 0; i < line.length; i++) {
			lineF.add(Float.parseFloat(line[i]));
		}
		return lineF;

	}

}
