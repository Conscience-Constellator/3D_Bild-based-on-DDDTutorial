package DDDTutorial_Modd.ConstL;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;

public class StR_MAkr
{
	public String NAm,DisplA;
		public void Set(String NAm,String DisplA)
		{
			this.NAm=NAm;
			this.DisplA=DisplA;
		}
			public void Set(String NAm)
			{Set(NAm,NAm);}
		@MAk_Fun
		public StR MAk(ConstLatn ConstLatn,RL_LOc_Havr Parnt,StR_Typ Typ)
		{return ConstLatn.Ad_StR(new StR(Parnt,null,Typ,NAm,DisplA));}
			@MAk_Fun
			public StR MAk(ConstLatn ConstLatn,StR_Typ Typ)
			{return MAk(ConstLatn,ConstLatn,Typ);}
			@MAk_Fun
			public StR MAk_Child(ConstLatn ConstLatn,Object Parnt,StR_Typ Typ)
			{return ConstLatn.Ad_Child(Parnt,Typ,NAm,DisplA);}
//			public static StR Gar_StR(Object Sorc,StR_Typ Typ)
//			{
//				if(Sorc instanceof StR)
//				{return (StR)Sorc;}
//				if(Sorc instanceof String)
//				{return new StR(Typ,(String)Sorc);}
//				throw new AssertionError("Invalid Sorc");
//			}

	public StR_MAkr(String NAm,String DisplA)
	{Set(NAm,DisplA);}
		public StR_MAkr(String NAm)
		{Set(NAm);}
}