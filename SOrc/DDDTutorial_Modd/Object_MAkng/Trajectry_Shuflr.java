package DDDTutorial_Modd.Object_MAkng;

import static CC.Encycloped.Abs.Scal.Gom.Gom.LOc_Shuflr.Box_Shuflr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.Object_MAkng.Object_MAkr.Object_MAkr_Rapr;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import static java.util.concurrent.ThreadLocalRandom.current;

public class Trajectry_Shuflr<Object_Typ extends RL_LOc_Havr>
	extends Object_MAkr_Rapr<Object_Typ>
{
	public double Mag;
		@Override
		public Object_Typ MAk(Physc_SpAc SpAc,Object LOc_SOrc)
		{
			Object_Typ Object=Rapd_Object_MAkr.MAk(SpAc,LOc_SOrc);
			((Tik_Tran)((SpAc_Object)Object).Get_Physc_LMNt("Tran")).Trajectry=Box_Shuflr.Shufl(current(),1);

			return Object;
		}

	public Trajectry_Shuflr(Object_MAkr<Object_Typ> Rapd,double Mag)
	{
		super(Rapd);
		this.Mag=Mag;
	}
}