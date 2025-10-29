package MAn;

import CC.$.$Q.$Point;
import UI.Butn_MAkr;
import UI.Custom_Actn;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
//import static CC.MpT_Meth_Findr.Find_Rongly_MpT_Methg;
import static java.util.Arrays.asList;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Control_Panl extends JPanel
{
	public static String Prompt_String(String TXt)
	{return showInputDialog(TXt);}
		public static $Point<String> String_Promptr(String TXt)
		{return ()->{return Prompt_String(TXt);};}
	public static void Alrt(String String)
	{showMessageDialog(null,String);}
	public JButton Ad_Butn(String TXt,Runnable Actn)
	{
		JButton Butn=new JButton(TXt);
		Butn.setAction(new Custom_Actn(Actn,TXt));

		add(Butn);
		return Butn;
	}
	public static List<Butn_MAkr> MAkrg=asList(
		new Butn_MAkr("Search unallowed empty functions",()->{
			try
			{/*Find_Rongly_MpT_Methg(new File(Prompt_String("Enter file:")));*/}
			catch(Exception EvNt)
			{throw new RuntimeException(EvNt);}
		})
	);
	public void Pop_Butn()
	{
		for(Butn_MAkr MAkr:MAkrg)
		{Ad_Butn(MAkr.TXt,MAkr.Actn);}
	}

	public Control_Panl()
	{Pop_Butn();}
}