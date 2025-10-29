package DDDTutorial_Modd.Object_MAkng;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.List.SeqNtl_Map;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Out_Box_Getbl;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;

import static DDDTutorial_Modd.Tool.Bak_Rad_;

public interface Object_MAkr<Object_Typ extends RL_LOc_Havr>
{
	@Lin_DclAr @Finishd(Is_Finishd=false)
	Object_Typ MAk(Physc_SpAc SpAc,Object LOc_SOrc);

	SeqNtl_Map<String,Object_MAkr> Object_MAkrg=new SeqNtl_Map<>();
	@Finishd(Is_Finishd=false)
	static RL_LOc_Havr MAk_Object(int[] WAt,Physc_SpAc SpAc,Object LOc_SOrc)
	{return ((Object)Object_MAkrg.Try_Get(WAt,0) instanceof Object_MAkr<?> MAkr)?
		MAkr.MAk(SpAc,LOc_SOrc):
		null;
	}
		@Finishd(Is_Finishd=false)
		static RL_LOc_Havr MAk_Object_CNtrd(int[] WAt,Physc_SpAc SpAc,Object LOc_SOrc)
		{
			RL_LOc_Havr Object=MAk_Object(WAt,SpAc,LOc_SOrc);
			if(Object instanceof Out_Box_Getbl Box)
			{
				try
				{Bak_Rad_((Out_Box_Getbl)Object);}
				catch(Exception X)
				{throw new RuntimeException("Error centering "+X+':'+Object);}
			}

			return Object;
		}
			@Finishd(Is_Finishd=false)
			static RL_LOc_Havr MAk_Object_CNtrd_Movng(int[] WAt,Physc_SpAc SpAc,Object LOc_SOrc,Tik_Tran Tran)
			{
				RL_LOc_Havr Object=MAk_Object_CNtrd(WAt,SpAc,LOc_SOrc);
				if(
					Object instanceof SpAc_Object SpAc_Object&&
					(Object)SpAc_Object.Has_Physc_LMNt("Tik_Tran") instanceof Tik_Tran Tran_)
				{Tran_.Set_Trajectory(Tran.Trajectry);}

				return Object;
			}

	class Object_MAkr_Rapr<Object_Typ extends RL_LOc_Havr> implements Object_MAkr<Object_Typ>
	{
		public Object_MAkr<Object_Typ> Rapd_Object_MAkr;
			@Override @Finishd(Is_Finishd=true)
			public Object_Typ MAk(Physc_SpAc SpAc,Object LOc_SOrc)
			{return Rapd_Object_MAkr.MAk(SpAc,LOc_SOrc);}

		@Finishd(Is_Finishd=true)
		public Object_MAkr_Rapr(Object_MAkr<Object_Typ> Rapd)
		{this.Rapd_Object_MAkr=Rapd;}
	}
}