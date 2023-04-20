import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {
	private JFrame frame;
	private JTextField sideOneEntry;
	private JTextField sideTwoEntry;
	private JTextField sideThreeEntry;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() throws IOException {
		System.out.println("System Starting");
		initialize();
		System.out.println("System Started");
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblHeading = new JLabel("What Triangle Is It?");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeading.setBounds(110, 11, 215, 40);
		frame.getContentPane().add(lblHeading);

		JLabel lblSides = new JLabel("Enter the Side Lengths");
		lblSides.setHorizontalAlignment(SwingConstants.CENTER);
		lblSides.setBounds(110, 65, 215, 40);
		frame.getContentPane().add(lblSides);

		sideOneEntry = new JTextField();
		sideOneEntry.setBounds(10, 115, 125, 30);
		frame.getContentPane().add(sideOneEntry);
		sideOneEntry.setColumns(10);

		sideTwoEntry = new JTextField();
		sideTwoEntry.setBounds(150, 115, 125, 30);
		frame.getContentPane().add(sideTwoEntry);
		sideTwoEntry.setColumns(10);

		sideThreeEntry = new JTextField();
		sideThreeEntry.setBounds(290, 115, 125, 30);
		frame.getContentPane().add(sideThreeEntry);
		sideThreeEntry.setColumns(10);

		JButton btnTriangleCheck = new JButton("All Set");
		btnTriangleCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(sideOneEntry.getText().equals("") && sideTwoEntry.getText().equals("")
						&& sideThreeEntry.getText().equals(""))) {
					boolean canRun = true;
					int i = 1;
					try {
						Double.parseDouble(sideOneEntry.getText());
						i++;
						Double.parseDouble(sideTwoEntry.getText());
						i++;
						Double.parseDouble(sideThreeEntry.getText());
					} catch (Exception checkInput) {
						JOptionPane.showMessageDialog(frame, "Invaild input on Input Box " + i);
						canRun = false;
					}
					if (canRun) {
						Triangle user = new Triangle(Double.parseDouble(sideOneEntry.getText()),
								Double.parseDouble(sideTwoEntry.getText()),
								Double.parseDouble(sideThreeEntry.getText()));
						if (user.sideTwo + user.sideThree > user.sideOne) {
							if (user.sideOne == user.sideThree) {
								JOptionPane.showMessageDialog(frame, "Equilateral Triangle");
							} else if (user.sideOne == user.sideTwo || user.sideTwo == user.sideThree) {
								JOptionPane.showMessageDialog(frame, "Isosceles Triangle");
							} else if (user.sideOne * user.sideOne == user.sideTwo * user.sideTwo + user.sideThree * user.sideThree) {
								JOptionPane.showMessageDialog(frame, "Right Triangle");
							} else {
								JOptionPane.showMessageDialog(frame, "Regular Triangle");
							}
						} else if (user.sideTwo + user.sideThree == user.sideOne) {
							JOptionPane.showMessageDialog(frame, "Not a Triangle\nYou made a Line");
						} else {
							JOptionPane.showMessageDialog(frame,
									"Not a Possible Triangle\nEither Shorten the Longest side or extend one or both of the shorter sides");
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "");
				}
			}
		});
		btnTriangleCheck.setBounds(135, 180, 160, 25);
		frame.getContentPane().add(btnTriangleCheck);
	}
}
