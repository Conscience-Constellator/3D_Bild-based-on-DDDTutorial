package DDDTutorial_Modd.Object_MAkng;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;

import java.util.List;

public interface N_MAkr
{
	@Lin_DclAr
	List<RL_LOc_Havr> MAk_N(
		Physc_SpAc SpAc,Object Loc_Sorc,
		Object_MAkr MAkr,int Num);

	class N_MAkr_Rapr implements N_MAkr
	{
		public N_MAkr Rapd_N_MAkr;

		@Override
		public List<RL_LOc_Havr> MAk_N(
			Physc_SpAc SpAc,Object Loc_Sorc,
			Object_MAkr MAkr,int Num)
		{return Rapd_N_MAkr.MAk_N(
			SpAc,Loc_Sorc,
			MAkr,Num);
		}

		public N_MAkr_Rapr(N_MAkr Rapd)
		{Rapd_N_MAkr=Rapd;}
	}
}