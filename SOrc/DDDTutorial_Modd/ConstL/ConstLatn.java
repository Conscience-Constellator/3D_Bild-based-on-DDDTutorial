package DDDTutorial_Modd.ConstL;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.RL_LOc_Havr_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.Object_PlAn;
import java.util.*;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.*;
import static DDDTutorial_Modd.ConstL.Conectn_Typ.Gar_Conectn_Typ;
import static DDDTutorial_Modd.ConstL.ConstLatn_Typ.Gar_ConstLatn_Typ;
import static DDDTutorial_Modd.ConstL.PlAn_DFinitn.Gar_NAm;
import static DDDTutorial_Modd.ConstL.StR_Typ.Gar_StR_Typ;
import static CC.Encycloped.Abs.Scal.Gom.Grid_Managr_.Itr_PlAc;
import static CC.Encycloped.Abs.Scal.Gom.Object_PlAn.Gar_PlAn;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import static DDDTutorial_Modd.Util.*;

import static java.lang.System.out;
import static CC.UI.ConsOl.Print;

public class ConstLatn extends RL_LOc_Havr_ConcrEt
{
	//<editor-fold desc="StR">
	public Map<String,StR> StRg=new HashMap<>();
		@Lin_DclAr
		public StR Get_StR_By_AdrS(String AdrS)
		{return StRg.get(AdrS);}
		@Lin_DclAr
		public boolean ContAns_StR_By_AdrS(String AdrS)
		{return StRg.containsKey(AdrS);}
		public Map<String,ArrayList<StR>> StRg_By_NAm=new HashMap<>();
			public ArrayList<StR> Gar_NAm_Category(String NAm)
			{
				ArrayList<StR> Category=StRg_By_NAm.get(NAm);

				if(Category==null)
				{
					Category=new ArrayList<>();
					StRg_By_NAm.put(NAm,Category);
				}
				return Category;
			}
			@Lin_DclAr
			public StR Get_StR_By_NAm(String NAm,int IndX)
			{return Gar_NAm_Category(NAm).get(IndX);}
			@Lin_DclAr
			public boolean ContAns_StR_By_NAm(String NAm)
			{return StRg_By_NAm.containsKey(NAm);}
			public String Othrg_Of_NAm(String NAm)
			{return Dlimit(Gar_NAm_Category(NAm),(StR)->{return StR.AdrS;},",");}
		public boolean ContAns_StR(String NAm)
		{
			return
				ContAns_StR_By_AdrS(NAm)||
				ContAns_StR_By_NAm(NAm);
		}
		public StR Get_StR(String NAm,int IndX)
		{
			try
			{
				StR StR=Get_StR_By_AdrS(NAm);
				if(StR==null)
				{StR=Get_StR_By_NAm(NAm,IndX);}

				return Nul_Chek(StR);
			}
			catch(NullPointerException|IndexOutOfBoundsException X)
			{
				String Othrg_Of_NAm=Othrg_Of_NAm(NAm);
				throw new NullPointerException("No StR named "+QOt(NAm)+((Othrg_Of_NAm.length()>0)?
					", only ["+Othrg_Of_NAm+"]":
					""
				));
			}
		}
			@Lin_DclAr
			public StR Get_StR(String NAm)
			{return Get_StR(NAm,0);}
		public StR Gar_StR(Object Sorc)
		{
			if(Sorc instanceof StR StR)
			{return StR;}
			else if(Sorc instanceof String NAm)
			{return Get_StR(NAm);}
			throw new NullPointerException("Invalid Sorc: "+Sorc.getClass()+","+QOt(Sorc));
		}
	public boolean Do_Print_StR_Ad=false;
	public StR Ad_StR(StR StR,String NAm)
	{
		String AdrS=StR.AdrS;
		if(StRg.containsKey(AdrS))
		{throw new RuntimeException("Already registered StR "+QOt(AdrS));}
		StRg.put(AdrS,StR);
		ArrayList<StR> Category=Gar_NAm_Category(NAm);
		String Othrg_Of_NAm=Othrg_Of_NAm(NAm);
		Category.add(StR);

		if(Do_Print_StR_Ad)
		{out.println("Added star "+QOt(AdrS)+((NAm.equals(AdrS))?
			"":
			"("+QOt(NAm)+((Othrg_Of_NAm.length()>0)?
				"["+Othrg_Of_NAm+"]":
				""
			)+")"
		));}
		return StR;
	}
		public StR Ad_StR(StR StR)
		{return Ad_StR(StR,StR.AdrS);}
		public StR Ad_StR(StR_Typ Typ,String AdrS,String DisplA,String NAm)
		{return Ad_StR(new StR(this,null,Typ,AdrS,DisplA),NAm);}
			public StR Ad_StR(StR_Typ Typ,String AdrS,String NAm)
			{return Ad_StR(Typ,AdrS,AdrS,NAm);}
				public StR Ad_StR(StR_Typ Typ,String AdrS)
				{return Ad_StR(Typ,AdrS,AdrS);}
		public StR Ad_Child(Object Parnt_SOrc,StR_Typ Typ,
							String NAm		 ,String DisplA)
		{
			StR Child=Gar_StR(Parnt_SOrc).MAk_Child(Typ,NAm,DisplA);

			return Ad_StR(Child,NAm);
		}
			public StR Ad_Child(Object StM_Sorc,StR_Typ Typ,String NAm)
			{return Ad_Child(StM_Sorc,Typ,NAm,NAm);}
		public void Ad_StRg(StR... StRg)
		{for(StR StR:StRg){Ad_StR(StR);}}
		public StR Gar_StR_In(StR StR)
		{
			if(!ContAns_StR(StR.AdrS))
			{Ad_StR(StR);}
			return StR;
		}
			public StR Gar_StR_In(PlAn_DFinitn DFinitn)
			{return Gar_StR_In(DFinitn.MAk(this));}
			public StR Gar_StR_In(StR_Grid Grid)
			{return Gar_StR_In(Grid.MAk(this));}
		public StR Gar_StR_In(Object Sorc)
		{
			try
			{
				return Nul_Chek((Sorc instanceof StR StR)?Gar_StR_In(StR):
								(Sorc instanceof String NAm)?Get_StR(NAm):
								(Sorc instanceof PlAn_DFinitn DFinitn)?Gar_StR_In(DFinitn):
								(Sorc instanceof StR_Grid Grid)?Gar_StR_In(Grid):
								null);
			}
			catch(NullPointerException X)
			{
				String Othrg_Of_NAm;
				if(Sorc instanceof String NAm)
				{
					Othrg_Of_NAm=Othrg_Of_NAm(NAm);
					if(Othrg_Of_NAm.length()>0)
					{Othrg_Of_NAm=", found only ["+Othrg_Of_NAm+"]";}
				}
				else
				{Othrg_Of_NAm="";}
				throw new NullPointerException("Invalid Sorc "+QOt(Sorc)+Othrg_Of_NAm);
			}
		}
		public StR Gar_StR_In(Object Sorc,StR_Typ Typ)
		{
			try
			{
				try
				{
					if(Sorc instanceof String NAm)
					{
						StR StR=Get_StR_By_AdrS(NAm);
						if(StR!=null)
						{return Gar_StR_In(StR);}
						else
						{return new StR_MAkr(NAm).MAk(this,Typ);}
					}
					else if(Sorc instanceof StR_MAkr MAkr)
					{return MAkr.MAk(this,Typ);}
					else if(Sorc instanceof Child_MAkr MAkr)
					{return MAkr.MAk(this,Typ);}
					else
					{return Gar_StR_In(Sorc);}
				}
				catch(NullPointerException X)
				{return Ad_StR(Typ,Gar_NAm(Sorc));}
			}
			catch(NullPointerException X)
			{throw new NullPointerException("Invalid Sorc "+QOt(Sorc));}
		}
		public StR Gar_StR_In(Object StM_Sorc,Object Sorc,StR_Typ Typ)
		{
			try
			{
				try
				{
					if(Sorc instanceof String NAm)
					{
						StR StR=Get_StR_By_AdrS(Gar_StR_In(StM_Sorc).Get_Child_NAm(NAm));
						if(StR!=null)
						{return StR;}
						else
						{return new StR_MAkr(NAm).MAk_Child(this,StM_Sorc,Typ);}
					}
					else if(Sorc instanceof StR_MAkr MAkr)
					{return MAkr.MAk_Child(this,StM_Sorc,Typ);}
					else
					{return Gar_StR_In(Sorc);}
				}
				catch(NullPointerException X)
				{return Ad_Child(StM_Sorc,Typ,Gar_NAm(Sorc));}
			}
			catch(NullPointerException X)
			{throw new NullPointerException("Invalid Sorc "+QOt(Sorc));}
		}
		public StR Gar_StR_In(Object SOrc,
							  StR_Typ StR_Typ,Conectn_Typ Conectn_Typ,
							  Object PlAn_SOrc)
		{
			try
			{
				if(SOrc instanceof Object[] Rgg)
				{
					return Ad_PlAn(PlAn_SOrc,StR_Typ,Conectn_Typ,Rgg);
				}
				else
				{
					return (SOrc instanceof Oposit_PAr PAr)?PAr.MAk(this,Get_Gom_PArnt(),StR_Typ,PlAn_SOrc):
															Gar_StR_In(SOrc,StR_Typ);
				}
			}
			catch(NullPointerException X)
			{throw new NullPointerException("Invalid SOrc "+QOt(SOrc));}
		}
		public StR Gar_StR_In(Object StM_SOrc,Object SOrc,
							  StR_Typ StR_Typ,Conectn_Typ Conectn_Typ,
							  Object PlAn_SOrc)
		{
			try
			{
				StR StM=Gar_StR_In(StM_SOrc);
				if(SOrc instanceof Object[] Rgg)
				{
					Object Rg_A=Rgg[0];
					if(Rg_A instanceof String NAm)
					{Rgg[0]=StM.MAk_Child_MAkr(NAm);}
					else
					{Rgg[1]=StM.MAk_Child_MAkr((String)Rgg[1]);}

					return Ad_PlAn(PlAn_SOrc,StR_Typ,Conectn_Typ,Rgg);
				}
				else
				{
					return (SOrc instanceof Oposit_PAr PAr)?PAr.MAk(this,StM,StR_Typ,PlAn_SOrc):
															Gar_StR_In(StM_SOrc,SOrc,StR_Typ);
				}
			}
			catch(NullPointerException X)
			{
				throw //new NullPointerException("Invalid SOrc "+QOt((SOrc instanceof Object[] ArA)?
//					Arrays.toString(ArA):
//					SOrc))
					X
				;
			}
		}
	//</editor-fold>

	//<editor-fold desc="Conectn">
	public Map<String,Conectn_> Conectng=new HashMap<>();
		public void Ad_Conectn(Conectn_ Conectn)
		{Conectng.put("|",Conectn);}
			public void Ad_Conectng(Conectn_... Conectng)
			{for(Conectn_ Conectn:Conectng){Ad_Conectn(Conectn);}}
		public Conectn_ Conect(Object A_Sorc,Object B_Sorc,
							   Conectn_Typ Typ)
		{
			StR A=Gar_StR_In(A_Sorc);

			return new Conectn_(A,
				A,
				Gar_StR_In(B_Sorc),
			Typ);
		}
			public Conectn_ Conect
			(Object A_Sorc,Object B_Sorc,
				Object Typ_Sorc)
			{return Conect(A_Sorc,B_Sorc,Gar_Conectn_Typ(Typ_Sorc));}
		public ArrayList<Conectn_> Conect(Conectn_Typ Typ,
										  Object[] StR_Sorcg)
		{
			ArrayList<Conectn_> List=new ArrayList<>();

			for(int IndX=0;IndX<StR_Sorcg.length;IndX+=2)
			{
				Object
					A=StR_Sorcg[IndX],
					B=StR_Sorcg[IndX+1];
				List.add(Conect(A,B,Typ));
			}

			return List;
		}
			public ArrayList<Conectn_> Conect(Object Typ_SOrc,
											  Object[] StR_SOrcg)
			{
				ArrayList<Conectn_> List=new ArrayList<>();

				for(int IndX=0;
						IndX<StR_SOrcg.length;
						IndX+=2)
				{
					Object A=StR_SOrcg[IndX	 ],
						   B=StR_SOrcg[IndX+1];
					List.add(Conect(A,B,Typ_SOrc));
				}

				return List;
			}
	//</editor-fold>

	public List<Object_PlAn> PlAng=new ArrayList<>();
		public Object_PlAn Gar_PlAn_In(Object_PlAn PlAn)
		{
			if(!PlAng.contains(PlAn))
			{PlAng.add(PlAn);}
			return PlAn;
		}
		public Object_PlAn Gar_PlAn_In(Object Sorc,RL_LOc_Havr Parnt,Object LOc_SOrc)
		{
			if(Sorc instanceof Object_PlAn PlAn)
			{return Gar_PlAn_In(PlAn);}
			else
			{return Gar_PlAn_In(Gar_PlAn(Sorc,Parnt,LOc_SOrc));}
		}
		public void UpdAt_PlAng()
		{
			out.println("PlAn_Num="+PlAng.size());
			for(int IndX=0;
					IndX<PlAng.size();
					IndX+=1)
			{
				Object_PlAn PlAn=PlAng.get(IndX);
				Itr_PlAc(PlAn,PlAng,IndX,PlAn.Get_Gom_PArnt(),4,4,1024);
			}
		}
		public StR Conect_To_PlAn(Object A_SOrc,Object B_SOrc,
								  Object_PlAn PlAn,Object PlAn_SOrc,
								  Object StR_Typ_Sorc,Object Conectn_Typ_SOrc)
		{
			StR_Typ StR_Typ=Gar_StR_Typ(StR_Typ_Sorc);
			Conectn_Typ Conectn_Typ=Gar_Conectn_Typ(Conectn_Typ_SOrc);
			StR A=Gar_StR_In(A_SOrc,StR_Typ);
			StR B=Gar_StR_In(A,B_SOrc,StR_Typ,Conectn_Typ,PlAn_SOrc);
			PlAn.Ad(B);
			new Conectn_(A,A,B,Conectn_Typ);

			return B;
		}
			public StR Conect_To_PlAn(Object A_SOrc,Object B_SOrc,
									  Object_PlAn PlAn,Object PlAn_SOrc,
									  Object Typ_SOrc)
			{
				ConstLatn_Typ Typ=Nul_Chek(Gar_ConstLatn_Typ(Typ_SOrc));

				return Conect_To_PlAn(A_SOrc,B_SOrc,
									  PlAn,PlAn_SOrc,
									  Typ.StR_Typ,Typ.Conectn_Typ);
			}

			public StR Conect_To_PlAn(Object Parnt_SOrc,Object PlAn_SOrc,
										  StR_Typ StR_Typ,Conectn_Typ Conectn_Typ,
									  Object[] StR_SOrcg)
			{
				StR Parnt=Gar_StR_In(Parnt_SOrc,StR_Typ);
				Object_PlAn PlAn=Gar_PlAn_In(PlAn_SOrc,Parnt,null);
				for(Object SOrc:StR_SOrcg)
				{
					Conect_To_PlAn(Parnt,SOrc,
								   PlAn,PlAn_SOrc,
								   StR_Typ,Conectn_Typ);
				}

				return Parnt;
			}
				public StR Conect_To_PlAn(Object Parnt_SOrc,Object  PlAn_SOrc ,
										  Object   Typ_SOrc,Object[] StR_SOrcg)
				{
					ConstLatn_Typ Typ=Nul_Chek(Gar_ConstLatn_Typ(Typ_SOrc));

					return Conect_To_PlAn(Parnt_SOrc,PlAn_SOrc,
										  Typ.	  StR_Typ,
										  Typ.Conectn_Typ,
										  StR_SOrcg);
				}
			public StR Ad_PlAn(Object PlAn_SOrc,
								  StR_Typ StR_Typ,Conectn_Typ Conectn_Typ,
							  Object[] Rgg)
			{
//				out.println("Ad_PlAn");

				Object Rg_A=Rgg[0],
					   Parnt_SOrc;
				Object[] StR_SOrcg;
				int Ofset;
				Handl_A:
				{
					switch(Rg_A)
					{
						case StR_Typ Typ->
						{
	//						out.println("StR_Typ");

							StR_Typ=Typ;
						}
						case Conectn_Typ Typ->
						{
	//						out.println("Conectn_Typ");

							Conectn_Typ=Typ;
						}
						case ConstLatn_Typ Typ->
						{
	//						out.println("ConstLatn_Typ");

							StR_Typ=Typ.StR_Typ;
							Conectn_Typ=Typ.Conectn_Typ;
						}
						case PlAn_MAkr MAkr->
						{
	//						out.println("PlAn_MAkr");

							PlAn_SOrc=MAkr.Managr;
							ConstLatn_Typ Typ=MAkr.Typ;
								StR_Typ=Typ.StR_Typ;
								Conectn_Typ=Typ.Conectn_Typ;
						}
						case null->
						{
							throw new NullPointerException("No Rg_A");
						}
						default->
						{
	//						out.println("Try StR");

							Parnt_SOrc=Rg_A;
							Ofset=1;

							break Handl_A;
						}
					}
					Parnt_SOrc=Rgg[1];
					Ofset=2;
				}
				try
				{StR_SOrcg=SlIc(Rgg,Ofset);}
				catch(NegativeArraySizeException X)
				{throw new NegativeArraySizeException(FEld$String("Rgg",Rgg));}
//				out.println("Ready to Connect");
				try
				{
					return Conect_To_PlAn(Parnt_SOrc,PlAn_SOrc,
						StR_Typ,Conectn_Typ,
					StR_SOrcg);
				}
				catch(ClassCastException X)
				{
					throw new RuntimeException(
						  "Problem calling w/ "+FEld$String("Rgg",Arrays.toString(Rgg),"Ofset",Ofset)+":"+
						"\nConect_To_PlAn("+FEld$String("Parnt_SOrc",Parnt_SOrc,"PlAn_SOrc",PlAn_SOrc,
						"\n\tStR_Typ",StR_Typ,"Conectn_Typ",Conectn_Typ,
						"\nStR_SOrcg",StR_SOrcg)+")",
					X);
				}
			}
				public StR Ad_PlAn(Object PlAn_SOrc,
					ConstLatn_Typ Typ_SOrc,
				Object[] Rgg)
				{
					ConstLatn_Typ Typ=Nul_Chek(Gar_ConstLatn_Typ(Typ_SOrc));

					return Ad_PlAn(PlAn_SOrc,
								   Typ.	   StR_Typ,
								   Typ.Conectn_Typ,
								   Rgg);
				}

	@Override
	public void UpdAt()
	{
		StRg.forEach((NAm,StR)->{StR.UpdAt();});
		super.UpdAt();
	}

	@Lin_DclAr
	public void MpT()
	{}

	public ConstLatn(Physc_SpAc SpAc,Object LOc_SOrc)
	{super(SpAc,LOc_SOrc);}
}