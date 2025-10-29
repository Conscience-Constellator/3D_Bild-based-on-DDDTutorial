package From_Scrach;

import javax.swing.*;
import java.awt.*;

public class MAn
{
	public static Dimension Dfalt_Siz=new Dimension(400,400);

	public static void main(String[] Rgg)
	{
		JFrame FrAm=new JFrame();
		SpAc SpAc=new SpAc();
//		Ad_Dfalt_Objectg(SpAc);
		ScrEn ScrEn=new ScrEn(SpAc);
		FrAm.add(ScrEn);
		FrAm.setSize(Dfalt_Siz);
		FrAm.setVisible(true);
		FrAm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}