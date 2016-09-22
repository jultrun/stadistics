package co.jultrun.statistics;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import co.jultrun.statistics.storage.Storage;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Object[] columnNames = new String[] { "x", "fi", "Fi-", "Fi+", "hi", "Hi-", "Hi+" };

				DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
				if (true) {
					try {
						dtm.setDataVector(Storage.load(new FileReader("d.stad")),
								new Vector<>(Arrays.asList(columnNames)));
					} catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
