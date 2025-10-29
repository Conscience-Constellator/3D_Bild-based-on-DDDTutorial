package Nuk;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.ArrayList;
import java.util.List;

public class Rmovr<Rapd_Inbl_Typ extends Trand_Inbl<Physc_SpAc,?>>
	   extends Nuk<Rapd_Inbl_Typ>
{
	public List<Tik_Tran> List;

	public static void Rmov_Al_In_From_SpAc(Inbl Bordr,List<Tik_Tran> Objectg,List<Tik_Tran> To)
	{
		double[] LOc=new double[3];
		for(int IndX =0;
				IndX<Objectg.size();
				IndX+=1)
		{
			Tik_Tran Object=Objectg.get(IndX);
			SpAc_Object TRget=Object.TRget;
			TRget.Get_LOc_CoP_As_ArA(LOc);
			if(Bordr.Is_In(LOc))
			{
				TRget.Rmov_From_SpAc();
				To.add(Object);
			}
		}
	}
	@Lin_DclAr
	public void Rmov_Al_In_From_SpAc(List<Tik_Tran> Objectg)
	{
		Rmov_Al_In_From_SpAc(Get_Rapd_Inbl(),
			Objectg,
			List);
	}

	@Override
	public void ActivAt()
	{Rmov_Al_In_From_SpAc(Get_SpAc().Get_Physc_LMNt_Cast("Tran"));}

	public Rmovr(Rapd_Inbl_Typ Bordr,List<Tik_Tran> List)
	{
		super(Bordr);
		this.List=List;
	}
		public Rmovr(Rapd_Inbl_Typ Bordr)
		{this(Bordr,new ArrayList<>());}
}