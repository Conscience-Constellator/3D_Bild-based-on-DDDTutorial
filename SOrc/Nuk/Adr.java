package Nuk;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.LOc$LOc;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.List;
import java.util.ArrayList;
import static CC.Encycloped.Abs.Scal.Gom.LOc$LOc.Rtrnr;

public class Adr<Rapd_Inbl_Typ extends Trand_Inbl<Physc_SpAc,?>>
	 extends Nuk<Rapd_Inbl_Typ>
{
	public List<Tik_Tran> List;
	public LOc$LOc LOc_SOrc;

	public static void Emit(Physc_SpAc SpAc,LOc$LOc LOc_SOrc,List<Tik_Tran> List)
	{
		double[] LOc=new double[3];
		for(int IndX=0;
				IndX<List.size();
				IndX+=1)
		{
			SpAc_Object TRget=List.get(IndX).TRget;
			TRget.Ad_To_SpAc(SpAc);
			LOc_SOrc.Aply(TRget,LOc);
		}
	}
	@Lin_DclAr
	public void Emit(List<Tik_Tran> Objectg)
	{
		Emit(Get_SpAc(),LOc_SOrc,
			List);
	}

	@Override
	public void ActivAt()
	{Emit(Get_SpAc().Get_Physc_LMNt_Cast("Tran"));}

	public Adr(Rapd_Inbl_Typ Bordr,List<Tik_Tran> List,LOc$LOc LOc_SOrc)
	{
		super(Bordr);
		this.List=List;
		this.LOc_SOrc=LOc_SOrc;
	}
		public Adr(Rapd_Inbl_Typ Bordr,LOc$LOc LOc_SOrc)
		{this(Bordr,new ArrayList<>(),LOc_SOrc);}
		public Adr(Rapd_Inbl_Typ Bordr,List<Tik_Tran> List)
		{this(Bordr,List,Rtrnr(Bordr));}
			public Adr(Rapd_Inbl_Typ Bordr)
			{this(Bordr,new ArrayList<>(),Rtrnr(Bordr));}
}