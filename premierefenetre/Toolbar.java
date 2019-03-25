package premierefenetre;


import premierefenetre.interfaces.StringListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar implements ActionListener
{
	private StringListener sgl;
	private JButton hello;
	private JButton goodbye;

	public Toolbar()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setFloatable(false);
		
		hello=new JButton("Hello");
		goodbye=new JButton("Goodbye");
		
		add(hello);
		add(goodbye);
		
		hello.addActionListener(this);
		goodbye.addActionListener(this);
	}
	public void setStringListener(StringListener sgl)
	{
		this.sgl=sgl;
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		JButton source = (JButton)ev.getSource();
		if(sgl!=null)
		{
			if(source==hello)
				sgl.textEmitted("Hello\n");
			else
				sgl.textEmitted("Goodbye\n");
		}
	}
}