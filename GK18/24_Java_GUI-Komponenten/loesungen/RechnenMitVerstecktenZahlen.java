import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechnenMitVerstecktenZahlen extends JFrame {

	private JPanel contentPane;
	private JTextField tfEins;
	private JTextField tfZwei;
	private JButton btnAddieren;
	private JLabel lblErgebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		RechnenMitVerstecktenZahlen frame = new RechnenMitVerstecktenZahlen();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public RechnenMitVerstecktenZahlen() {
		createGUI();
	}

	private void createGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfEins = new JTextField();
		tfEins.setBounds(12, 12, 114, 19);
		contentPane.add(tfEins);
		tfEins.setColumns(10);

		tfZwei = new JTextField();
		tfZwei.setBounds(138, 12, 114, 19);
		contentPane.add(tfZwei);
		tfZwei.setColumns(10);

		btnAddieren = new JButton("Addieren");
		btnAddieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addieren();
			}
		});
		btnAddieren.setBounds(264, 9, 98, 25);
		contentPane.add(btnAddieren);

		lblErgebnis = new JLabel("");
		lblErgebnis.setBounds(12, 50, 240, 15);
		contentPane.add(lblErgebnis);
	}

	private void addieren() {
		int zahl1 = zahlenExtrahieren(tfEins);
		int zahl2 = zahlenExtrahieren(tfZwei);
		lblErgebnis.setText(zahl1 + " + " + zahl2 + " = " + (zahl1 + zahl2));
	}

	private int zahlenExtrahieren(JTextField tf) {
		String alles = tf.getText();
		String nurZiffern = "";
		for (int i = 0; i < alles.length(); i++) {
			if (Character.isDigit(alles.charAt(i))) {
				nurZiffern += alles.charAt(i);
			}
		}
		if(nurZiffern.isEmpty()) {
			nurZiffern = "0";
		}
		int ergebnis = Integer.parseInt(nurZiffern);
		return ergebnis;
	}
}
