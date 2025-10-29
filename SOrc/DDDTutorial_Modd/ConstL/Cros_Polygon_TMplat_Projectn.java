package DDDTutorial_Modd.ConstL;

import DDDTutorial_Modd.D2.D2_Drawbl_TMplat;
import DDDTutorial_Modd.D2.D2_Drawbl_TMplat.D2_Drawbl_TMplat_Projectn;
import CC.Encycloped.Abs.Scal.Physc.SIt.Projectbl;
import java.awt.*;
import static DDDTutorial_Modd.D2.AWT_X.MAk_Polygon;

public class Cros_Polygon_TMplat_Projectn
	 extends D2_Drawbl_TMplat_Projectn
{
	public Polygon A,B;

	@Override
	public void Get_Bordr_Out_Box_StRt(double[] Box)
	{}
	@Override
	public void Get_Bordr_Out_Box(double[] Box)
	{}
	@Override
	public void Set_Projectd(Projectbl Projectd)
	{}

	public Cros_Polygon_TMplat_Projectn(D2_Drawbl_TMplat TMplat,int VrtX_Num)
	{
		super(TMplat);
		A=MAk_Polygon(VrtX_Num);
		B=MAk_Polygon(VrtX_Num);
	}
}