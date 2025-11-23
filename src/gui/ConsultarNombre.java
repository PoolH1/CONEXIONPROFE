package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayAccesorio;
import clase.Accesorio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ConsultarNombre extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNom;
	private JScrollPane scrollPane;
	private JTable tbTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarNombre frame = new ConsultarNombre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultarNombre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Ingrese nombre");
			lblNewLabel.setBounds(10, 21, 125, 13);
			contentPane.add(lblNewLabel);
		}
		{
			txtNom = new JTextField();
			txtNom.addKeyListener(this);
			txtNom.setBounds(158, 18, 96, 19);
			contentPane.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 83, 416, 155);
			contentPane.add(scrollPane);
			{
				tbTable = new JTable();
				tbTable.setFillsViewportHeight(true);
				scrollPane.setViewportView(tbTable);
				Listar("");
			}
	
		}
	
	}
	public void Listar(String nom) {
		DefaultTableModel modelo=new DefaultTableModel();
		ArrayAccesorio m=new ArrayAccesorio();
		ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
		if(nom.length()==0){
			lista=m.listarAccesorio();
		}
		else
			lista=m.consultarAccesorio(nom);
		modelo.setRowCount(lista.size());
		Iterator<Accesorio> it=lista.iterator();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		int i=0;
		while (it.hasNext()) {
			Object obj=it.next();
			Accesorio acce=(Accesorio)obj;
			modelo.setValueAt(acce.getCodAcce(),i,0);
			modelo.setValueAt(acce.getNomAcce(),i,1);
			modelo.setValueAt(acce.getMarcaAcce(),i,2);
			modelo.setValueAt(acce.getPreAcce(),i,3);
			modelo.setValueAt(acce.getStockAcce(),i,4);
			i++;
		}
		tbTable.setModel(modelo);
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNom) {
			do_txtNom_keyReleased(e);
		}
	}
	protected void do_txtNom_keyReleased(KeyEvent e) {
		String nom=txtNom.getText();
		//txtNom.setText(nom);
		Listar(nom);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
