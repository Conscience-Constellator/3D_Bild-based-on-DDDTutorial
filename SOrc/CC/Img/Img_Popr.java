package CC.Img;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import java.awt.image.BufferedImage;

public interface Img_Popr
{
	@Lin_DclAr @Finishd(Is_Finishd=true)
	int CalculAt(double X,double Y);
	@Lin_DclAr @Finishd(Is_Finishd=true)
	default void Pop(BufferedImage Img,
		int X,int Y)
	{Img.setRGB(X,Y,CalculAt(X,Y));}
		@Lin_DclAr @Finishd(Is_Finishd=true)
		default void Pop(BufferedImage Img)
		{
			for(int Y=0;Y<Img.getHeight();Y+=1)
			{
				for(int X=0;X<Img.getWidth();X+=1)
				{
					Pop(Img,X,Y);
				}
			}
		}
}