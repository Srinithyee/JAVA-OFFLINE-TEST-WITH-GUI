
	
	

/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0,dec;
	int m[]=new int[10];	
	OnlineTest(String s,int decide)
	{
		super(s);
		
		int dec=decide;
		//System.out.println(dec);
		if(dec==1)
		{
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
		}
		else
		{
			l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set1();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(dec==1)
		{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
		
				set();
			
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
		
				set();
			
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"YOUR SCORE => "+count);
			System.exit(0);
		}
		}
		else
		{
			if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set1();
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
		
				set1();
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set1();
			
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"YOUR SCORE => "+count);
			System.exit(0);
		}
		}
			
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Which one among these is not a datatype");
			jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");	
			dec=1;
		}
		if(current==1)
		{
			l.setText("Que2: Which class is available to all the class automatically");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
			dec=1;
		}
		if(current==2)
		{
			l.setText("Que3: Which package is directly available to our class without importing it");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
			dec=1;
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
			dec=1;
		}
		if(current==4)
		{
			l.setText("Que5: Feature that allows the conversion of wrapper to primitive data types");
			jb[0].setText("auto unboxing");jb[1].setText("encapsulation");jb[2].setText("autoboxing");jb[3].setText("Generics");
			dec=1;
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
			dec=1;
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
			dec=1;
		}
		if(current==7)
		{
			l.setText("Que8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");
			dec=1;				
		}
		if(current==8)
		{
			l.setText("Que9: which function is not present in Applet class");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
			dec=1;
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
			dec=1;
		}
		
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	
		void set1()
	{
		jb[4].setSelected(true);
		
		
		if(current==0)
		{
			l.setText("Que1: Which of the following is not OOPS concept in Java?");
			jb[0].setText("Inheritance");jb[1].setText("Compilation");jb[2].setText("Abstraction");jb[3].setText("Association");	
		}
		if(current==1)
		{
			l.setText("Que2: When is method overloading determined?");
			jb[0].setText("Run Time");jb[1].setText("Coding Time");jb[2].setText("Compile Time");jb[3].setText("Execution Time");
		}
		if(current==2)
		{
			l.setText("Que3: Which of the following is a type of polymorphism in Java?");
			jb[0].setText("Multilevel polymorphism");jb[1].setText("Multiple polymorphism");jb[2].setText("execution time polymorphism");jb[3].setText("Compile time polymorphism");
		}
		if(current==3)
		{
			l.setText("Que4: Which concept converts real world objects in terms of class?");
			jb[0].setText("Abstraction");jb[1].setText("Encapsulation");jb[2].setText("Polymorphism");jb[3].setText("Inheritance");
		}
		if(current==4)
		{
			l.setText("Que5: Combining methods and attribute into a class is realised by?");
			jb[0].setText("Inheritance");jb[1].setText("Polymorphism");jb[2].setText("Encapsulation");jb[3].setText("Abstraction");
		}
		
		
		if(current==5)
		{
			l.setText("Que6: Loose coupling in java programs can be done by?");
			jb[0].setText("Generics");jb[1].setText("Abstract Class");jb[2].setText("Using interface");jb[3].setText("Encapsulation");
		}
		if(current==6)
		{
			l.setText("Que7: What is it called if an object has its own lifecycle and there is no owner?");
			jb[0].setText("Aggregation");jb[1].setText("Association");jb[2].setText("Composition");jb[3].setText("Encapsulation");
		}
		if(current==7)
		{
			l.setText("Que8: What is it called where child object gets killed if parent object is killed?");
			jb[0].setText("Garbagedestruction");jb[1].setText("Binding");jb[2].setText("Encapsulation");jb[3].setText("Composition");		
		}
		if(current==8)
		{
			l.setText("Que9: IS-A relationship in java is related to");
			jb[0].setText("Composition");jb[1].setText("Inheritance");jb[2].setText("Encapsulation");jb[3].setText("Association");
		}
		if(current==9)
		{
			l.setText("Que10: Encapsulation concept in java is");
			jb[0].setText("Hiding constructor");jb[1].setText("Method hiding");jb[2].setText("Hiding complexity");jb[3].setText("None");
		}
		
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	
		
	public static void main(String s[])
	{
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String actionCommand=e.getActionCommand();
				if(actionCommand.equals("EASY"))
				{
					new OnlineTest("EASY",1);
				}
				if(actionCommand.equals("HARD"))
				{
					new OnlineTest("HARD",2);
				}
		
				
			}
		}
		//new OnlineTest("Difficulty level");
		JLabel sign;
		sign=new JLabel("Choose difficulty");
		
		JFrame f=new JFrame("Difficulty Level");
		f.setLayout(null);
		JButton b=new JButton("HARD");
		b.setBounds(60,75,75,25);
		f.add(b);
		JButton b1=new JButton("EASY");
		b1.setBounds(150,75,75,25);
		f.add(b1);
		b.addActionListener(new ButtonListener());
		b1.addActionListener(new ButtonListener());
		sign.setBounds(80,35,130,25);
		f.add(sign);
		f.setSize(290,220);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


}
