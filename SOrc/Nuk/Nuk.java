package Nuk;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl_Rapr.Trand_Inbl_Rapr_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;

public abstract class Nuk<Rapd_Inbl_Typ extends Trand_Inbl<Physc_SpAc,?>>
	extends Trand_Inbl_Rapr_ConcrEt<Physc_SpAc,Rapd_Inbl_Typ>
{
	@Lin_DclAr
	public abstract void ActivAt();

	public Nuk(Rapd_Inbl_Typ AOE)
	{super(AOE);}
}