package DDDTutorial_Modd;

import java.awt.*;
import java.awt.image.BufferedImage;
import static DDDTutorial_Modd.Componnt.Get_CNtr;
import static java.awt.Color.*;
import static java.awt.Cursor.getDefaultCursor;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.awt.Cursor.getDefaultCursor;

public class Crsr
{
	public static void Mov(Robot Robot,int[] Vectr)
	{
		Robot.mouseMove(
			Vectr[0],
			Vectr[1]);
	}
	public static void CNtr_Mous(Component Componnt,Robot Robot)
	{Mov(Robot,Get_CNtr(Componnt));}

	public static Cursor Crsr(BufferedImage Imag,
		Point Point,String NAm)
	{
		return Toolkit.
			getDefaultToolkit().
			createCustomCursor(Imag,Point,NAm);
	}
	public static Cursor
		Invisbl=Crsr(
			new BufferedImage(1,1,TRANSLUCENT),
			new Point(0,0),"Invisbl"
		),
		Visbl=Crsr(
			new BufferedImage(10,10,TYPE_INT_ARGB),
			new Point(0,0),"Visbl"
		);
	public static void Set_Crsr(Component Componnt,Cursor Crsr)
	{Componnt.setCursor(Crsr);}
	public static void Invisbl_Crsr(Component Component)
	{Set_Crsr(Component,Invisbl);}
	public static void Visbl_Crsr(Component Component)
	{Set_Crsr(Component,Visbl);}
	public static void Norml_Crsr(Component Component)
	{Set_Crsr(Component,getDefaultCursor());}
}