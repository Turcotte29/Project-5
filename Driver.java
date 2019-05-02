import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Driver extends JFrame{

	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton add;
	private JButton delete;
	private JTextArea text;
	private JTextArea text2;
	private JTextArea text3;
	private JTextArea text4;
	private JTextArea text5;
	private JTextArea text6;
	private JTextArea text7;
	private JTextArea text8;
	private JTextArea text9;
	private JTextArea text10;
	private JTextArea text11;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JComboBox<String> dropDown;
	private JComboBox<String> dropDown2;
	private JSlider slider;
	private JScrollBar scrollBar;
	private JScrollPane scroll;

	
	public Driver() throws FileNotFoundException {
		super("Hamming Distance");
		
		setButtons();
		setTextArea();
		setLabel();
		dropDown();
		slider();
		scrollBar();
		scroller();
		
		add(b1);
		add(b2);
		add(b3);
		add(scroll);
		add(text2);
		add(text3);
		add(text4);
		add(text5);
		add(text6);
		add(text7);
		add(text8);
		add(text9);
		add(text10);
		add(text11);
		add(label);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(label7);
		add(label8);
		add(dropDown);
		add(dropDown2);
		add(slider);
		add(add);
		add(delete);		
		add(scrollBar);
		
		setLayout(null);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}

	private void setButtons() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			File file = new File("Mesonet.txt");
			Scanner newFile;
			newFile = new Scanner(file);
			while(newFile.hasNextLine()) {
				list.add(newFile.next());
				newFile.nextLine();
			}
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		b1 = new JButton("Show Station");
		b1.setBounds(10, 100, 130, 30);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String newS = "";
				for(int index = 0; index < list.size(); index++) {
					int HD = 0;
					String s = "";
					s += dropDown.getSelectedItem();
					try {
						HD = calculateHammingDist(s, list.get(index));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(HD == slider.getValue()) {
						newS += list.get(index);
						newS += "\n";
					}
				}
				text.setText(newS);
			}
			
		});
		
		
		b2 = new JButton("Calculate HD");
		b2.setBounds(10, 500, 130, 30);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int counter0 = 0;
				int counter1 = 0;
				int counter2 = 0;
				int counter3 = 0;
				int counter4 = 0;
				
				for(int index = 0; index < list.size(); index++) {
					int HD;
					try {
						HD = calculateHammingDist((String)dropDown.getSelectedItem(), list.get(index));
						if(HD == 0) {
							counter0++;
						}
						else if(HD == 1) {
							counter1++;
						}
						else if(HD == 2) {
							counter2++;
						}
						else if(HD == 3) {
							counter3++;
						}
						else if(HD == 4) {
							counter4++;
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				String c0 = "";
				c0 += counter0;
				text3.setText(c0);
				
				String c1 = "";
				c1 += counter1;
				text4.setText(c1);
				
				String c2 = "";
				c2 += counter2;
				text5.setText(c2);
				
				String c3 = "";
				c3 += counter3;
				text6.setText(c3);
				
				String c4 = "";
				c4 += counter4;
				text7.setText(c4);
			}
			});
		
		b3 = new JButton("Add station");
		b3.setBounds(0, 750, 130, 30);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dropDown.addItem(text8.getText());
			}	
		});
		
		add = new JButton("add");
		add.setBounds(500, 100, 130, 30);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int index = 0; index < list.size(); index++) {
					if(!(text9.getText().equals(list.get(index)))) {
						dropDown2.addItem(text9.getText());
						break;
					}
				}
			}	
		});
		
		delete = new JButton("delete");
		delete.setBounds(500, 150, 130, 30);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int index = 0; index < list.size(); index++) {
					if((text9.getText().equals(list.get(index)))) {
						dropDown2.removeItem(text9.getText());
					}
				}	
			}
		});
	}
	
	private void setTextArea() {
		text2 = new JTextArea();
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		text2.setEditable(false);
		text2.setBounds(150, 15, 130, 20);
		
		text3 = new JTextArea();
		text3.setLineWrap(true);
		text3.setWrapStyleWord(true);
		text3.setEditable(false);
		text3.setBounds(120, 550, 130, 20);
		
		text4 = new JTextArea();
		text4.setLineWrap(true);
		text4.setWrapStyleWord(true);
		text4.setEditable(false);
		text4.setBounds(120, 580, 130, 20);
		
		text5 = new JTextArea();
		text5.setLineWrap(true);
		text5.setWrapStyleWord(true);
		text5.setEditable(false);
		text5.setBounds(120, 610, 130, 20);
		
		text6 = new JTextArea();
		text6.setLineWrap(true);
		text6.setWrapStyleWord(true);
		text6.setEditable(false);
		text6.setBounds(120, 640, 130, 20);
		
		text7 = new JTextArea();
		text7.setLineWrap(true);
		text7.setWrapStyleWord(true);
		text7.setEditable(false);
		text7.setBounds(120, 670, 130, 20);
		
		text8 = new JTextArea();
		text8.setLineWrap(true);
		text8.setWrapStyleWord(true);
		text8.setBounds(150, 750, 130, 20);
		
		text9 = new JTextArea();
		text9.setLineWrap(true);
		text9.setWrapStyleWord(true);
		text9.setBounds(500, 50, 130, 20);
		
		text10 = new JTextArea();
		text10.setLineWrap(true);
		text10.setWrapStyleWord(true);
		text10.setEditable(false);
		text10.setBounds(540, 300, 130, 350);
		
		text11 = new JTextArea();
		text11.setLineWrap(true);
		text11.setWrapStyleWord(true);
		text11.setBounds(540, 300, 130, 350);
	}
	
	private void setLabel() {
		label = new JLabel();
		label.setText("Compare with:");
		label.setBounds(20, 450, 130, 30);
		
		label2 = new JLabel();
		label2.setText("Enter Hamming Dist: ");
		label2.setBounds(10, 10, 160, 30);
		
		label3 = new JLabel();
		label3.setText("Distance 0");
		label3.setBounds(10, 550, 130, 30);
		
		label4 = new JLabel();
		label4.setText("Distance 1");
		label4.setBounds(10, 580, 130, 30);
		
		label5 = new JLabel();
		label5.setText("Distance 2");
		label5.setBounds(10, 610, 130, 30);
		
		label6 = new JLabel();
		label6.setText("Distance 3");
		label6.setBounds(10, 640, 130, 30);
		
		label7 = new JLabel();
		label7.setText("Distance 4");
		label7.setBounds(10, 670, 130, 30);
		
		label8 = new JLabel();
		label8.setText("Type in a station:");
		label8.setBounds(385, 42, 130, 30);
		
	}
	
	private void dropDown() throws FileNotFoundException {
		ArrayList<String> stations = new ArrayList();
		File file = new File("Mesonet.txt");
		Scanner newFile = new Scanner(file);
		while(newFile.hasNextLine()) {
			stations.add(newFile.next());
			newFile.nextLine();
		}
		
		dropDown = new JComboBox<String>();
		
		for(int index = 0; index < stations.size(); index++) {
			dropDown.addItem(stations.get(index));
		}
		
		dropDown.setBounds(120, 450, 130, 30);
		
		dropDown2 = new JComboBox<String>();
		
		for(int index = 0; index < stations.size(); index++) {
			dropDown2.addItem(stations.get(index));
		}	
		dropDown2.setBounds(500, 10, 130, 30);
	}
	
	private void slider() {
		slider = new JSlider(1, 4, 1);
		slider.setBounds(10, 50, 200, 40);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String num = "";
				num += slider.getValue();
				text2.setText(num);			
			}
		});
	}
	
	private void scrollBar() {
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 10, 0, 129);
		scrollBar.setBounds(500, 300, 50, 350);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				ArrayList<String> list = new ArrayList<String>();
				try {
					File file = new File("Mesonet.txt");
					Scanner newFile;
					newFile = new Scanner(file);
					while(newFile.hasNextLine()) {
						list.add(newFile.next());
						newFile.nextLine();
					}
				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				label.setText("Station at index " + scrollBar.getValue() + " in file is: ");
				label.setBounds(500, 250, 200, 50);
				int HD = 0;
				for(int index = 0; index < list.size(); index++) {
					try {
						HD = calculateHammingDist(list.get(scrollBar.getValue()), (String)dropDown2.getSelectedItem());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				String temp = "";
				temp += HD;
				text10.setText(list.get(scrollBar.getValue()) + "\n" + "\n"
						+ "Hamming Distance between " + list.get(scrollBar.getValue())
						+ " and " + dropDown2.getSelectedItem() + " is: " + temp);
				
			}
			
		});
	}
	
	private void scroller() {
		text = new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.setBounds(10, 130, 280, 300);
		scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 130, 280, 300);
	}
	
	public int calculateHammingDist(String stat1, String stat2) throws IOException
	{
		int counter = 0;
		String strg1;
		String strg2;
		strg1 = stat1;
		strg2 = stat2;
		for(int index = 0; index < 4; index++) {
			if(strg1.charAt(index) != strg2.charAt(index)) {
					counter++;
			}
		}
		return counter;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Driver();
	}
	
}
