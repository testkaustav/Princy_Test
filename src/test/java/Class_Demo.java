import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Class_Demo {

			
			 
			JFrame f;  
			Class_Demo(){  
			    f=new JFrame();   
			    String name=JOptionPane.showInputDialog(f,"Enter Name");   
			    System.out.println(name);
			}  
			public static void main(String[] args) {  
			    new Class_Demo();  
			}    
				 
	

}
