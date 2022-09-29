	package ip;
	
	import java.io.*;  
	import java.net.*; 

	import java.io.File;
	import java.io.IOException;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JInternalFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;

	import org.opencv.videoio.*;
    
    public class openCVTest
    {
		static videoCamera cam1;
		static videoCamera cam2;
		static videoCamera cam3;
		static videoCamera cam4;
		static videoCamera cam5;
    	static  JLabel l;
    	static boolean IP1 = false;
    	static boolean IP2 = false;
    	static boolean IP3 = false;
    	static boolean IP4 = false;
    	static boolean IP5 = false;
    	static JInternalFrame j1 = new JInternalFrame();
    	static JInternalFrame j2 = new JInternalFrame();
    	static JInternalFrame j3 = new JInternalFrame();
    	static JInternalFrame j4 = new JInternalFrame();
    	static JInternalFrame j5 = new JInternalFrame();
    	static JFrame jf=new JFrame();
    	
    	
    public static void main(String[] args) throws IOException
    {
    	String filePath = new File("").getAbsolutePath();
        System.load(filePath + "\\opencv_videoio_ffmpeg460_64.dll");
        System.load(filePath + "\\opencv_java460.dll");

        jf.setLayout(null);
        jf.setSize(1280, 720);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
        JInternalFrame mainControl = new JInternalFrame();
 
        // set the title of the frame
        mainControl.setTitle("Main Control");
 
        // create Buttons and text fields
        JButton b = new JButton("IP1 Set");
        JTextField fieldOne = new JTextField(20);
        fieldOne.setText("Enter IP 1");
        
        JButton b2 = new JButton("IP2 Set");
        JTextField fieldTwo = new JTextField(20);
        fieldTwo.setText("Enter IP 2");
        
        JButton b3 = new JButton("IP3 Set");
        JTextField fieldThree = new JTextField(20);
        fieldThree.setText("Enter IP 3");
        
        JButton b4 = new JButton("IP4 Set");
        JTextField fieldFour = new JTextField(20);
        fieldFour.setText("Enter IP 4");
        
        JButton b5 = new JButton("IP5 Set");
        JTextField fieldFive = new JTextField(20);
        fieldFive.setText("Enter IP 5");

 
        // create a panel
        JPanel p = new JPanel();
 
        // add labels and buttons to panel
        p.add(fieldOne);
        p.add(b);
        
        p.add(fieldTwo);
        p.add(b2);
        
        p.add(fieldThree);
        p.add(b3);
        
        p.add(fieldFour);
        p.add(b4);
        
        p.add(fieldFive);
        p.add(b5);
 
        // set visibility internal frame
        mainControl.setVisible(true);
 
        // add panel to internal frame
        mainControl.add(p);
 
        // add internal frame to frame
        jf.add(mainControl);
        
        mainControl.setLocation(100, 100);
        mainControl.setSize(500, 300);
        mainControl.setVisible(true);
        mainControl.setClosable(true);
        mainControl.setResizable(true);


        b.addActionListener(ev -> {
        	IP1 = false;
        	j1.setVisible(false);
            j1.dispose();
            jf.remove(j1);
            String valOne = fieldOne.getText();
            fieldOne.setText("Enter IP 1");
            frameMaker(j1, 500, 300, 500, 100, "IP 1: " + valOne);
            jf.add(j1);
            VideoCapture camera = new VideoCapture(valOne);
            openCVTest.cam1 = new videoCamera(camera);
    	    j1.add(cam1);
    	    IP1 = true;
    	    new IP1(1).start();
        });
        
        b2.addActionListener(ev -> {
        	IP2 = false;
        	j2.setVisible(false);
            j2.dispose();
            jf.remove(j2);
            String valTwo = fieldTwo.getText();
            fieldTwo.setText("Enter IP 2");
            frameMaker(j2, 500, 300, 500, 100, "IP 2: " + valTwo);
            jf.add(j2);
            VideoCapture camera = new VideoCapture(valTwo);
            openCVTest.cam2 = new videoCamera(camera);
    	    j2.add(cam2);
    	    IP2 = true;
    	    new IP1(2).start();
        });
        
        b3.addActionListener(ev -> {
        	IP3 = false;
        	j3.setVisible(false);
            j3.dispose();
            jf.remove(j3);
            String valThree = fieldThree.getText();
            fieldThree.setText("Enter IP 3");
            frameMaker(j3, 500, 300, 500, 100, "IP 3: " + valThree);
            jf.add(j3);
            VideoCapture camera = new VideoCapture(valThree);
            openCVTest.cam3 = new videoCamera(camera);
    	    j3.add(cam3);
    	    IP3 = true;
    	    new IP1(3).start();
        });
        
        b4.addActionListener(ev -> {
        	IP4 = false;
        	j4.setVisible(false);
            j4.dispose();
            jf.remove(j4);
            String valFour = fieldFour.getText();
            fieldFour.setText("Enter IP 4");
            frameMaker(j4, 500, 300, 500, 100, "IP 4: " + valFour);
            jf.add(j4);
            VideoCapture camera = new VideoCapture(valFour);
            openCVTest.cam4 = new videoCamera(camera);
    	    j4.add(cam4);
    	    IP4 = true;
    	    new IP1(4).start();
        });
        
        b5.addActionListener(ev -> {
        	IP5 = false;
        	j5.setVisible(false);
            j5.dispose();
            jf.remove(j5);
            String valFive = fieldFive.getText();
            fieldFive.setText("Enter IP 5");
            frameMaker(j5, 500, 300, 500, 100, "IP 5: " + valFive);
            jf.add(j5);
            VideoCapture camera = new VideoCapture(valFive);
            openCVTest.cam5 = new videoCamera(camera);
    	    j5.add(cam5);
    	    IP5 = true;
    	    new IP1(5).start();
        });

        //IP for testing: http://114.152.150.34:8082/nphMotionJpeg?Resolution=320x240&Quality=Standard

        //IP for testing: http://114.152.150.34:8081/nphMotionJpeg?Resolution=320x240&Quality=Standardx?.mjpg

    }
    public static void frameMaker(JInternalFrame jf, int sx, int sy, int lx, int ly, String name) {
        jf.setSize(sx, sy);
        jf.setLocation(lx, ly);
        jf.setTitle(name);
        jf.setVisible(true);
        jf.setClosable(true);
        jf.setResizable(true);
    }
    
    public static void frameKiller(boolean IPFalse, JInternalFrame close) {
    	IPFalse = false;
    	close.setVisible(false);
    	close.dispose();
		jf.remove(close);
    	
    }
}    
    
    class IP1 extends Thread {
    	static int IP;
		public IP1(int IPin) {
            // super: Allocates a new Thread object.
            super();
            IP=IPin;
        }
        public void run() {
        	switch (IP){
        	case 1:
        		System.out.println("Video is run");
				while(openCVTest.IP1)
		        {
		    		openCVTest.cam1.repaint();
		        }
				break;
        	case 2:
        		System.out.println("Video is run 2");
		    	while(openCVTest.IP2)
		        {
		    		openCVTest.cam2.repaint();
		        }
		    	break;
        	case 3:
				System.out.println("Video is run 3");
		    	while(openCVTest.IP3)
		        {
		    		openCVTest.cam3.repaint();
		        }
		    	break;
        	case 4:
        		System.out.println("Video is run 4");
		    	while(openCVTest.IP4)
		        {
		    		openCVTest.cam4.repaint();
		        }
        		break;
        	case 5:
        		System.out.println("Video is run 5");
		    	while(openCVTest.IP5)
		        {
		    		openCVTest.cam5.repaint();
		        }
        		break;
        		
        	default:
        		break;
        	}

        }
    }
    
        class MyServer {  
    	public static void main(String[] args){  
    	try{  
    	ServerSocket ss=new ServerSocket(6666);  
    	Socket s=ss.accept();//establishes connection   
    	DataInputStream dis=new DataInputStream(s.getInputStream());  
    	String  str=(String)dis.readUTF();  
    	System.out.println("message= "+str);  
    	ss.close();  
    	}catch(Exception e){System.out.println(e);}  
    	}  
    	}

