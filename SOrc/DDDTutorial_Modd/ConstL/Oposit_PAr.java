package DDDTutorial_Modd.ConstL;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.Object_PlAn;
import static DDDTutorial_Modd.ConstL.PlAn_DFinitn.Gar_NAm;
import static CC.Encycloped.Abs.Scal.Gom.Object_PlAn.Gar_PlAn;

public class Oposit_PAr
{
	public Object StM,
		A,B;
		public void Set(Object StM,
			Object A,
			Object B)
		{
			this.StM=StM;
				this.A=A;
				this.B=B;
		}

	public StR MAk(ConstLatn ConstLatn,RL_LOc_Havr Parnt,StR_Typ Typ,Object PlAn_Sorc)
	{
		Object_PlAn PlAn=Gar_PlAn(PlAn_Sorc,Parnt,null);
		StR StM=ConstLatn.Gar_StR_In(Parnt,this.StM,Typ),
			A=ConstLatn.Conect_To_PlAn(StM,this.A,PlAn,PlAn,Typ,"Oposit_A");
			B=ConstLatn.Conect_To_PlAn(StM,this.B,PlAn,PlAn,Typ,"Oposit_B");
		ConstLatn.Conect(A,B,"Oposit");

		return StM;
	}

	@Override
	public String toString()
	{return Gar_NAm(StM);}

	public Oposit_PAr(Object StM,
					  Object A,Object B)
	{Set(StM,A,B);}
		/**Assumes uncertain is phrased relative to positive.*/
		public Oposit_PAr(Object A,Object B)
		{
			String NAm=B.toString();
			Set("?"+NAm,A,B);
		}
			/**Assumes non-positives are phrased relative to positive.*/
			public Oposit_PAr(Object B)
			{
				String NAm=B.toString();
				Set("?"+NAm,"!"+NAm,B);
			}
}