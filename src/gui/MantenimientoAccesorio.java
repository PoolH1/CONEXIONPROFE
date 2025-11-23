package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arrayList.ArrayAccesorio;
import clase.Accesorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MantenimientoAccesorio extends JFrame implements ActionListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtMarca;
	private JTextField txtPre;
	private JTextField txtStock;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTable tbTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoAccesorio frame = new MantenimientoAccesorio();
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
	public MantenimientoAccesorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Código");
			lblNewLabel.setBounds(22, 20, 45, 13);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setBounds(22, 43, 45, 13);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Marca");
			lblNewLabel_2.setBounds(22, 66, 45, 13);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Precio");
			lblNewLabel_3.setBounds(22, 89, 45, 13);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Stock");
			lblNewLabel_4.setBounds(22, 112, 45, 13);
			contentPane.add(lblNewLabel_4);
		}
		{
			txtCod = new JTextField();
			txtCod.setBounds(77, 17, 72, 19);
			contentPane.add(txtCod);
			txtCod.setColumns(10);
		}
		{
			txtNom = new JTextField();
			txtNom.addKeyListener(this);
			txtNom.setColumns(10);
			txtNom.setBounds(77, 40, 72, 19);
			contentPane.add(txtNom);
		}
		{
			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(77, 63, 72, 19);
			contentPane.add(txtMarca);
		}
		{
			txtPre = new JTextField();
			txtPre.addKeyListener(this);
			txtPre.setColumns(10);
			txtPre.setBounds(77, 86, 72, 19);
			contentPane.add(txtPre);
		}
		{
			txtStock = new JTextField();
			txtStock.setColumns(10);
			txtStock.setBounds(77, 109, 72, 19);
			contentPane.add(txtStock);
		}
		{
			btnNewButton = new JButton("Agregar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(240, 39, 85, 21);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Modificar");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBounds(240, 62, 85, 21);
			contentPane.add(btnNewButton_1);
		}
		{
			btnNewButton_2 = new JButton("Eliminar");
			btnNewButton_2.addActionListener(this);
			btnNewButton_2.setBounds(240, 85, 85, 21);
			contentPane.add(btnNewButton_2);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 149, 372, 104);
			contentPane.add(scrollPane);
			{
				tbTable = new JTable();
				tbTable.addMouseListener(this);
				tbTable.setFillsViewportHeight(true);
				scrollPane.setViewportView(tbTable);
			}
		}
		Listar("");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			Accesorio acce = new Accesorio(txtCod.getText(),txtNom.getText(),txtMarca.getText(),
					Double.parseDouble(txtPre.getText()),Integer.parseInt(txtStock.getText()));
			ArrayAccesorio m = new ArrayAccesorio();
			m.insertar(acce);
			Listar("");
			Limpiar();
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Datos vacíos");
		}
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		ArrayAccesorio eliminar = new ArrayAccesorio();
		eliminar.eliminar(txtCod.getText());
		Listar("");
		Limpiar();
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		try {
			Accesorio acce = new Accesorio(txtCod.getText(),txtNom.getText(),txtMarca.getText(),Double.parseDouble(txtPre.getText()),Integer.parseInt(txtStock.getText()));
			ArrayAccesorio m = new ArrayAccesorio();
			m.editar(acce);
			Listar("");
			Limpiar();
		} catch (Exception E) {
			// TODO: handle exception
			
		JOptionPane.showMessageDialog(null, "Datos vacíos");
		}
		Limpiar();
	}
	public void Listar(String nom) {
		DefaultTableModel modelo=new DefaultTableModel();
		ArrayAccesorio acce=new ArrayAccesorio();
		ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
		if(nom.length()==0)
			lista=acce.listarAccesorio();
		else
			lista=acce.consultarAccesorio(nom);
		modelo.setRowCount(lista.size());
		Iterator it=lista.iterator();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		int i=0;
		while (it.hasNext()) {
			Object obj=it.next();
			Accesorio acceso=(Accesorio)obj;
			modelo.setValueAt(acceso.getCodAcce(),i,0);
			modelo.setValueAt(acceso.getNomAcce(),i,1);
			modelo.setValueAt(acceso.getMarcaAcce(),i,2);
			modelo.setValueAt(acceso.getPreAcce(),i,3);
			modelo.setValueAt(acceso.getStockAcce(),i,4);
			i++;
		}
		tbTable.setModel(modelo);
	}
	void Limpiar(){
		txtCod.setText("");
		txtNom.setText("");
		txtMarca.setText("");
		txtPre.setText("");
		txtStock.setText("");
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbTable) {
			do_tbTable_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tbTable_mouseClicked(MouseEvent e) {
		int fila=tbTable.getSelectedRow();
		txtCod.setText(String.valueOf(tbTable.getValueAt(fila, 0)));
		txtNom.setText(String.valueOf(tbTable.getValueAt(fila, 1)));
		txtMarca.setText(String.valueOf(tbTable.getValueAt(fila, 2)));
		txtPre.setText(String.valueOf(tbTable.getValueAt(fila, 3)));
		txtStock.setText(String.valueOf(tbTable.getValueAt(fila, 4)));
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPre) {
			do_txtPre_keyTyped(e);
		}
		if (e.getSource() == txtNom) {
			do_txtNom_keyTyped(e);
		}
	}
	 protected void do_txtNom_keyTyped(KeyEvent e) {
		//PARA QUE SÓLO SE PUEDA INGRESAR LETRAS
		char validarLetras=e.getKeyChar();
		if(Character.isDigit(validarLetras)){
			e.consume();
			JOptionPane.showMessageDialog(this, "¡No puede ingresar números, sólo letras!");
		}	
	}
	protected void do_txtPre_keyTyped(KeyEvent e) {
		//PARA QUE SÓLO SE PUEDA INGRESAR NÚMEROS
		char validarNumeros=e.getKeyChar();
		if(Character.isLetter(validarNumeros)){
			e.consume();
			JOptionPane.showMessageDialog(this, "¡No puede ingresar letras, sólo números!");
		}
	}
}
