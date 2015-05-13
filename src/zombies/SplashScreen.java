package zombies;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SplashScreen extends JFrame {

	private JPanel pane;
	private boolean currentlyRunning = false;
	private boolean isClicked = false;
	private JComboBox<Object> cB;
	private int selection;


	public SplashScreen() {
		currentlyRunning = true;
	}

	public int chooseLevel() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		pane = new JPanel();
		pane.setBackground(Color.GRAY);
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		GridBagLayout gridPane = new GridBagLayout();
		gridPane.columnWidths = new int[] { 350 };
		gridPane.rowHeights = new int[] { 20, 50, 50, 50, 50 };
		gridPane.columnWeights = new double[] { 1.0 };
		gridPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		pane.setLayout(gridPane);

		JLabel Toolbar = new JLabel("Zombie Game");
		Toolbar.setForeground(Color.GREEN);
		Toolbar.setFont(new Font("Serif", Font.BOLD, 24));
		Toolbar.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gridTool = new GridBagConstraints();
		gridTool.insets = new Insets(0, 0, 5, 0);
		gridTool.anchor = GridBagConstraints.NORTH;
		gridTool.fill = GridBagConstraints.HORIZONTAL;
		gridTool.gridx = 0;
		gridTool.gridy = 1;
		pane.add(Toolbar, gridTool);

		JLabel Scene = new JLabel("Pick your scene");
		Scene.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints SceneGrid = new GridBagConstraints();
		SceneGrid.insets = new Insets(0, 0, 5, 0);
		SceneGrid.gridx = 0;
		SceneGrid.gridy = 2;
		pane.add(Scene, SceneGrid);

		cB = new JComboBox<Object>();
		cB.setFont(new Font("Serif", Font.BOLD, 16));
		cB.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(
				new String[] { "SCENE 1", "SCENE 2", "SCENE 3", "SCENE 4",
						"SCENE 5" }));
		GridBagConstraints gridCB = new GridBagConstraints();
		gridCB.insets = new Insets(0, 0, 5, 0);
		gridCB.fill = GridBagConstraints.HORIZONTAL;
		gridCB.gridx = 0;
		gridCB.gridy = 3;
		pane.add(cB, gridCB);

		JButton placeholder = new JButton("GO");
		placeholder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFrame();
				selection(getSelection());
				click();
			}
		});
		GridBagConstraints placeholder2 = new GridBagConstraints();
		placeholder2.gridx = 0;
		placeholder2.gridy = 4;
		pane.add(placeholder, placeholder2);

		setLocationRelativeTo(null);
		setVisible(true);

		while (currentlyRunning) {
			
			if (isClicked) {
				currentlyRunning = false;
				return selection;
			}
		}
		return 0;
	}

	private void click() {
		this.isClicked = true;
	}

	private int getSelection() {
		return cB.getSelectedIndex() + 1;
	}

	private void selection(int decision) {
		this.selection = decision;
	}

	private void closeFrame() {
		this.dispose();
	}

}