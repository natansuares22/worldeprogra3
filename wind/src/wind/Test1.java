package wind;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Test1 {

	private JFrame frame;
	private JTextField texto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 window = new Test1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	int vidas= 5;
	Palabra sec = new Palabra("bueno");
	public Test1() {
		initialize(sec);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Palabra secreto) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel letra1 = new JLabel("*");
		letra1.setOpaque(true);
		letra1.setForeground(new Color(0, 0, 0));
		letra1.setFont(new Font("Papyrus", Font.BOLD, 25));
		letra1.setBackground(Color.RED);
		letra1.setBounds(117, 191, 31, 48);
		frame.getContentPane().add(letra1);
		
		JLabel letra2 = new JLabel("*");
		letra2.setOpaque(true);
		letra2.setForeground(Color.BLACK);
		letra2.setFont(new Font("Papyrus", Font.BOLD, 25));
		letra2.setBackground(Color.RED);
		letra2.setBounds(158, 191, 31, 48);
		frame.getContentPane().add(letra2);
		
		JLabel letra3 = new JLabel("*");
		letra3.setOpaque(true);
		letra3.setForeground(Color.BLACK);
		letra3.setFont(new Font("Papyrus", Font.BOLD, 25));
		letra3.setBackground(Color.RED);
		letra3.setBounds(201, 192, 31, 48);
		frame.getContentPane().add(letra3);
		
		JLabel letra4 = new JLabel("*");
		letra4.setOpaque(true);
		letra4.setForeground(Color.BLACK);
		letra4.setFont(new Font("Papyrus", Font.BOLD, 25));
		letra4.setBackground(Color.RED);
		letra4.setBounds(242, 192, 31, 48);
		frame.getContentPane().add(letra4);
		
		JLabel letra5 = new JLabel("*");
		letra5.setOpaque(true);
		letra5.setForeground(Color.BLACK);
		letra5.setFont(new Font("Papyrus", Font.BOLD, 25));
		letra5.setBackground(Color.RED);
		letra5.setBounds(284, 192, 31, 48);
		frame.getContentPane().add(letra5);
		
		ArrayList<JLabel> letras= new ArrayList<JLabel>();
		letras.add(letra1);
		letras.add(letra2);
		letras.add(letra3);
		letras.add(letra4);
		letras.add(letra5);
		
		
		texto1 = new JTextField();
		texto1.setFont(new Font("Papyrus", Font.PLAIN, 18));
		texto1.setBounds(20, 65, 113, 44);
			
		frame.getContentPane().add(texto1);
		texto1.setColumns(10);
		
		JLabel label1 = new JLabel("Ingrese palabra");
		label1.setFont(new Font("Papyrus", Font.BOLD, 18));
		label1.setBounds(20, 10, 220, 25);
		frame.getContentPane().add(label1);
		
		
		JLabel palabrasecreta = new JLabel(secreto.oculta.toString());
		palabrasecreta.setFont(new Font("Papyrus", Font.PLAIN, 18));
		palabrasecreta.setBounds(155, 69, 123, 35);
		frame.getContentPane().add(palabrasecreta);
		
		JProgressBar vidaddisplaybar = new JProgressBar();
		vidaddisplaybar.setToolTipText("Vidas restantes "+vidas);
		vidaddisplaybar.setForeground(Color.GREEN);
		vidaddisplaybar.setMaximum(5);
		vidaddisplaybar.setBounds(288, 74, 139, 35);
		vidaddisplaybar.setValue(vidas);
		frame.getContentPane().add(vidaddisplaybar);
		
		JLabel vidadisplay = new JLabel("Vidas");
		vidadisplay.setFont(new Font("Papyrus", Font.PLAIN, 18));
		vidadisplay.setBounds(328, 52, 50, 12);
		frame.getContentPane().add(vidadisplay);
		
		JButton btnNewButton = new JButton("adivinar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(null);
		btnNewButton.setSelectedIcon(new ImageIcon(Test1.class.getResource("/wind/360_F_1035523141_NdOngDnIdkOR6NVKENN8C7d5rPJFarD0.jpg")));

		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Papyrus", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secreto.compararpalabras(texto1.getText());
			System.out.println(texto1.getText());
			palabrasecreta.setText(secreto.oculta.toString());
			boolean gano= Updateletras(letras,sec,texto1.getText());
			if (gano) {
				System.out.println("aguante el cafe con leche");}
			vidas-=1;
			secreto.printoculto();
			vidaddisplaybar.setValue(vidas);
			vidaddisplaybar.setToolTipText("Vidas restantes "+vidas);
			
			
			}
		});
		btnNewButton.setBounds(160, 126, 113, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\usuario\\Desktop\\360_F_1035523141_NdOngDnIdkOR6NVKENN8C7d5rPJFarD0.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel_1);
	}

	boolean Updateletras(ArrayList<JLabel> letras, Palabra pal, String comparar) {
		Color[] colores= pal.colores(comparar);
		boolean correcto= true;
		char[] novaletras= comparar.toCharArray();
		for (int i=0; i<pal.largo;i++) {
			letras.get(i).setBackground(colores[i]);
			letras.get(i).setText(novaletras[i]+"");;
		}
		for (int i=0; i<pal.largo;i++) {
			correcto= correcto && colores[i].equals(Color.green);
		}
		return correcto;
	}
}
