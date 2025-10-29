package DDDTutorial_Modd.Object_MAkng;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.Object_MAkng.N_MAkr.N_MAkr_Rapr;
import java.util.List;
import static CC.Encycloped.Abs.Scal.Gom.LOc.Gar_LOc;

public class N_MAkr_LOc_CoP extends N_MAkr_Rapr
{
	@Lin_DclAr
	public List<RL_LOc_Havr> MAk_N(
		Physc_SpAc SpAc,Object Loc_Sorc,
		Object_MAkr MAkr,int Num)
	{return super.MAk_N(
		SpAc,Gar_LOc(Loc_Sorc),
		MAkr,Num);
	}

	public N_MAkr_LOc_CoP(N_MAkr Rapd)
	{super(Rapd);}
}