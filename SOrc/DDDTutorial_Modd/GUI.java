package DDDTutorial_Modd;

import java.awt.*;
import static DDDTutorial_Modd.D2.Rectangl.Draw_Rectangl;
import static java.awt.event.KeyEvent.*;

public class GUI
{
	//<editor-fold desc="Axis">
	public static int[] Axis(int A,int B)
	{return new int[]{A,B};}
	public static int[]
		WS_Axis=Axis(VK_W,VK_S),
		DA_Axis=Axis(VK_D,VK_A),
		SpAc_B_Axis=Axis(VK_SPACE,VK_B),
		RF_Axis=Axis(VK_R,VK_F),
		GD_Axis=Axis(VK_G,VK_D),
		Up_Down_Axis=Axis(VK_UP,VK_RIGHT),
		Rit_LFt_Axis=Axis(VK_RIGHT,VK_LEFT);
	//</editor-fold>
	//<editor-fold desc="PlAn">
	public static int[][] PlAn(int[] A,int[] B)
	{return new int[][]{A,B};}
	public static int[][]
		ArO_PlAn=PlAn(Up_Down_Axis,Rit_LFt_Axis),
		RFGD_PlAn=PlAn(RF_Axis,GD_Axis),
		WSDA_PlAn=PlAn(WS_Axis,DA_Axis)
	;
	//</editor-fold>

	public static void Fil(Component Com,Graphics Graphcs,Color Colr)
	{
		Draw_Rectangl(Graphcs,
			0,0,
			Com.getWidth(),Com.getHeight(),
			Colr);
	}
}