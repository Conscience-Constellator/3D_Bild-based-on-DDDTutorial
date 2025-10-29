package MAn;

import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom.Atom_Projectn;
import DDDTutorial_Modd.D3.Cub;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import java.awt.*;
import java.util.List;
import static DDDTutorial_Modd.D2.D2_Drawbl_Atom.Draw_Loop;
import static DDDTutorial_Modd.D2.D2_Drawbl_Atom.UpdAt_Loop;

public class HUD_Util
{
	public static double[] UpdAt_Box(ScrEn ScrEn,Cub Cub,Atom_Projectn[] Projectn,Object Box_Sorc,double[] Dfalt)
	{
		double[] Box=
			(Box_Sorc instanceof double[] Box_)?Box_:
			(Box_Sorc instanceof Out_Box_Getbl Sorc)?Sorc.Get_Bordr_Out_Box_StRt():
			null;
		if(Box!=null)
		{
			double
				X=Box[0],
				Y=Box[2],
				Z=Box[4];
			Cub.UpdAt_LOc(
				X,
				Y,
				Z);
			Cub.Set_LNg(
				Box[1]-X,
				Box[3]-Y,
				Box[5]-Z);
		}
		else
		{
			Cub.UpdAt_LOc(
				Dfalt[0]-.5,
				Dfalt[1]-.5,
				Dfalt[2]-.5);
			Cub.Set_LNg(1,1,1);
		}
		UpdAt_Loop(ScrEn,Projectn);

		return Box;
	}
	public static void Draw_Box_Projectn(ScrEn ScrEn,Graphics2D Graphcs,Atom_Projectn[] Projectn)
	{Draw_Loop(ScrEn,Graphcs,Projectn);}
		public static void Draw_Box(ScrEn ScrEn,Graphics2D Graphcs,Cub Cub,Atom_Projectn[] Projectn,Out_Box_Getbl Box,double[] Dfalt)
		{
//			out.println("Draw_Box");
			UpdAt_Box(ScrEn,Cub,Projectn,Box,Dfalt);
			Draw_Box_Projectn(ScrEn,Graphcs,Projectn);
		}
			public static void Draw_Boxg(ScrEn ScrEn,Graphics2D Graphcs,Cub Cub,Atom_Projectn[] Projectn,List<? extends Out_Box_Getbl> Boxg)
			{
				for(Out_Box_Getbl Box:Boxg)
				{Draw_Box(ScrEn,Graphcs,Cub,Projectn,Box,null);}
			}
}