package MAn;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.Cub;
import DDDTutorial_Modd.D3.GNrAtd_TerAn;
import DDDTutorial_Modd.D3.Prism;
import DDDTutorial_Modd.D3.Pyramid;
import CC.Encycloped.Abs.Scal.Gom.LOc;

import java.awt.*;
import static MAn.Physc_.Litng_Efect;
import static java.awt.Color.*;

public class Originl
{
	public static void Ad_Originl_Objectg(Physc_SpAc SpAc)
	{
		GNrAtd_TerAn TerAn=new GNrAtd_TerAn(SpAc,null,
			0,new Color(16,128,16)
//			new Color(0,255,50)
		);
		TerAn.Ad_Efect(Litng_Efect);
		Ad_Dfalt_Polyhedrong(SpAc);
	}
		public static void Ad_Dfalt_Polyhedrong(Physc_SpAc SpAc)
		{
			new Cub(SpAc,
				new LOc(0,-5,0),
				2,
				red);
			new Prism(SpAc,
				new LOc(6,-5,0),
				2,
				green);
			new Pyramid(SpAc,
				new LOc(12,-5,0),
				2,
				blue);
			Ad_Bildng(SpAc);
		}
		public static void Ad_Bildng(Physc_SpAc SpAc)
		{
			new Cub(SpAc,
				new LOc(18,-5,0),
				2,
				red);
			new Cub(SpAc,
				new LOc(20,-5,0),
				2,
				red);
			new Cub(SpAc,
				new LOc(22,-5,0),
				2,
				red);
			new Cub(SpAc,
				new LOc(20,-5,2),
				2,
				red);
			new Prism(SpAc,
				new LOc(18,-5,2),
				2,
				green);
			new Prism(SpAc,
				new LOc(22,-5,2),
				2,
				green);
			new Pyramid(SpAc,
				new LOc(20,-5,4),
				2,
				blue);
		}
}