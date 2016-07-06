import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.Color;

public class SecretMessagesGUI extends JPanel {
	private JTextField txtIn;
	private JTextField keyTxt;
	private JTextField txtOut;
	private JSlider slider;
    public String encode(String userMsg, int k){
    	
    	String out="";
    	char in =' ';
    	char key = (char)k;
    	
    	 for (int x= 0; x<=userMsg.length()-1;x++){

    		 in = (char) (userMsg.charAt(x));
			 
			
			 if  (in >= 'A' && in <= 'Z') {
				 
				 in+= key;
				 
				 if ( in > 'Z'){
					 
					in -= 26; 
					 
				 }
				 if ( in < 'A'){
					 
					 in += 26;
					 
				 }
				 
		
			 }
			 
			 
			 
			 if  (in >= 'a' && in <= 'z') {
								 
					 in+= key;
								 
						 if ( in > 'z'){
									 
							in -= 26; 
									 
						}
						 if ( in < 'a'){
							 
							 in += 26;
							 
						 }
						
			  }
			 
			 
			 if ( in >= '0' && in <= '9' ){
				 
				in+= (k % 10);
				if ( in > '9')
					in-= 10;
				if ( in < '0')
					in += 10;
			 }
			 
			 out+= in;
			

	   }  
    	
    	return out; 
    	
    }
	
	
	
	public SecretMessagesGUI() {
		setBackground(new Color(135, 206, 250));
		setLayout(null);
		
		txtIn = new JTextField();
		txtIn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtIn.setBounds(0, 0, 450, 107);
		add(txtIn);
		txtIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Key:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(120, 127, 61, 16);
		add(lblNewLabel);
		
		keyTxt = new JTextField();
		keyTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int keyIn= Integer.parseInt(keyTxt.getText());
				
				slider.setValue(keyIn);
				
			}
			
		});
		keyTxt.setHorizontalAlignment(SwingConstants.CENTER);
		keyTxt.setText("0");
		keyTxt.setBounds(180, 122, 37, 26);
		add(keyTxt);
		keyTxt.setColumns(10);
		
		JButton btnEnDe = new JButton("Encode/Decode");
		btnEnDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userIn = txtIn.getText();
				
				int keyIn= Integer.parseInt(keyTxt.getText());
				
				String outMsg = encode(userIn,keyIn);
				txtOut.setText(outMsg);
			}
		});
		btnEnDe.setBounds(229, 122, 191, 29);
		add(btnEnDe);
		
		txtOut = new JTextField();
		txtOut.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtOut.setColumns(10);
		txtOut.setBounds(0, 172, 450, 142);
		add(txtOut);
		setPreferredSize(new Dimension(450,320));
		
		 slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				
				keyTxt.setText(""+ slider.getValue());
                String userIn = txtIn.getText();
				
				int keyIn= Integer.parseInt(keyTxt.getText());
				
				String outMsg = encode(userIn,keyIn);
				txtOut.setText(outMsg);
				
			}
		});
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(13);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setValue(0);
		slider.setMinimum(-13);
		slider.setMaximum(13);
		slider.setBounds(0, 119, 149, 38);
		add(slider);
	}	

	public static void main(String[] args) {
		
		//SET UP A WINDOW FRAM (JFRAME)
		JFrame frame = new JFrame("Secret Message App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add an encoder Panel to frame.
		
		frame.getContentPane().add(new SecretMessagesGUI());
		
		//prepare and show the frame
		
		frame.pack();
		frame.setVisible(true);
		
	}
}
