package co.jultrun.statistics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	/**
	 * Create the frame.
	 */
	public Gui(DefaultTableModel dtm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Archivo");
		menuBar.add(fileMenu);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		fileMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		fileMenu.add(mntmGuardar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(){
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column>1){
					return false;
				}else{
					return true;
				}
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		
		this.dtm=dtm;
		table.setModel(this.dtm);
		scrollPane.setViewportView(table);
		
		Box horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("agregar columna");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add(e);
			}
		});
		horizontalBox.add(btnAdd);
		
		JButton btnRemove = new JButton("remover columna");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(e);
			}
		});
		horizontalBox.add(btnRemove);
		
		JButton btnCalculate = new JButton("calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate(e);
				
			}
		});
		horizontalBox.add(btnCalculate);
	}

	public void calculate(ActionEvent e) {
		float totalS=0;
		float fAcumulteS=0;
		for (int i = 0; i < table.getModel().getRowCount(); i++) {
			totalS=totalS+(float) table.getModel().getValueAt(i, 1);
			table.getModel().setValueAt(totalS, i,2);
		}
		for (int i = 0; i < table.getModel().getRowCount(); i++) {
			fAcumulteS=fAcumulteS+(float) table.getModel().getValueAt(i, 1);
			table.getModel().setValueAt( ((float) table.getModel().getValueAt(i, 1))/totalS*100F, i,4);
			table.getModel().setValueAt(fAcumulteS/totalS*100F, i,5);
		}
		for (int i = 0; i < table.getModel().getRowCount(); i++) {
			table.getModel().setValueAt(fAcumulteS, i,3);
			table.getModel().setValueAt(fAcumulteS/totalS*100F, i,6);
			fAcumulteS=fAcumulteS-(float) table.getModel().getValueAt(i, 1);
			
		}
		
		
	}

	public  void remove(ActionEvent e) {
		dtm.removeRow(dtm.getRowCount()-1);
		
	}

	public void add(ActionEvent e) {
		dtm.addRow(new Vector<>(7));
		
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}
	

}
