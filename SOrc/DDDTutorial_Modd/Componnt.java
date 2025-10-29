package DDDTutorial_Modd;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

public class Componnt
{
	public static int[] Get_CNtr(Component Componnt)
	{
		Dimension Dim=Componnt.getSize();
		Point LOc=Componnt.getLocationOnScreen();

		return new int[]
			{
				(int)(LOc.getX()+(Dim.getWidth()/2)),
				(int)(LOc.getY()+(Dim.getHeight()/2))
			};
	}
}