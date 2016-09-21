package co.jultrun.statistics;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Object[] columnNames = new String[] { "x", "fi", "Fi-", "Fi+", "hi", "Hi-", "Hi+" };
				DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
				if (true) {
					dtm = new DefaultTableModel(columnNames, 0);
					try {
						BufferedReader br = new BufferedReader(new FileReader("d.stad"));
						String line;
						while ((line = br.readLine()) != null) {
							Vector<Float> model = new Vector<>();
							model.addAll(readLine(line.split(",")));

							dtm.addRow(model);
						}
						br.close();

					} catch (IOException | NumberFormatException e) {
						dtm = new DefaultTableModel(new String[] { "x", "fi", "Fi-", "Fi+", "hi", "Hi-", "Hi+" }, 6);
						;

					}

				}
				try {
					Gui frame = new Gui(dtm);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static ArrayList<Float> readLine(String[] line) throws NumberFormatException {
		ArrayList<Float> lineF = new ArrayList<>();
		for (int i = 0; i < line.length; i++) {
			lineF.add(Float.parseFloat(line[i]));
		}
		return lineF;

	}

}
