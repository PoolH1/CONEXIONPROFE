package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrayList.ArrayAccesorio;
import clase.Accesorio;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ItemEvent;

public class ConsultarCodigo extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cboCod;
	private JTextField txtNom;
	private JTextField txtMarca;
	private JTextField txtPre;
	private JTextField txtStock;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCodigo frame = new ConsultarCodigo();
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
	public ConsultarCodigo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Código");
			lblNewLabel.setBounds(26, 36, 45, 13);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setBounds(26, 68, 45, 13);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Marca");
			lblNewLabel_2.setBounds(26, 98, 45, 13);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Precio");
			lblNewLabel_3.setBounds(26, 127, 45, 13);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Stock");
			lblNewLabel_4.setBounds(26, 150, 45, 13);
			contentPane.add(lblNewLabel_4);
		}
		{
			cboCod = new JComboBox();
			cboCod.addItemListener(this);
			cboCod.setBounds(81, 32, 96, 21);
			contentPane.add(cboCod);
		}
		{
			txtNom = new JTextField();
			txtNom.setBounds(81, 65, 96, 19);
			contentPane.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(81, 95, 96, 19);
			contentPane.add(txtMarca);
		}
		{
			txtPre = new JTextField();
			txtPre.setColumns(10);
			txtPre.setBounds(81, 124, 96, 19);
			contentPane.add(txtPre);
		}
		{
			txtStock = new JTextField();
			txtStock.setColumns(10);
			txtStock.setBounds(81, 147, 96, 19);
			contentPane.add(txtStock);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(216, 32, 102, 21);
			contentPane.add(comboBox);
		}
		llenarCombo();
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCod) {
			do_cboCod_itemStateChanged(e);
		}
	}
	protected void do_cboCod_itemStateChanged(ItemEvent e) {
	String codi=cboCod.getSelectedItem().toString();
	LLenarTexto(codi);
	}
	public void LLenarTexto(String cod) {
		ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
		ArrayAccesorio acce=new ArrayAccesorio();
		lista=acce.ConsultarCod(cod); 
		Iterator it=lista.iterator();
		int i=0;
		while(it.hasNext()){//devuelve true si existe un siguiente elemento 
			Object obj=it.next();//devuelve el siguiente elemento 
			Accesorio ac=(Accesorio)obj;
			txtNom.setText(ac.getNomAcce());
			txtMarca.setText(ac.getMarcaAcce());
			txtPre.setText(ac.getPreAcce()+"");
			txtStock.setText(ac.getStockAcce()+"");
			i++;
		}
	}
	public void llenarCombo(){
		
		ArrayList<Accesorio> lista=new ArrayList<Accesorio>();
		ArrayAccesorio m=new ArrayAccesorio();
		
		lista=m.listarAccesorio();
		
		Iterator<Accesorio> it=lista.iterator();
		int i=0;
		while(it.hasNext()){
			Object obj=it.next();
			Accesorio acc=(Accesorio)obj;
			cboCod.addItem(acc.getCodAcce());
			i++;
		}
		
	}
}
