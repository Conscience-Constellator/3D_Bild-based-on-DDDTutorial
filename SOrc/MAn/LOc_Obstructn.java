package MAn;

import CC.Encycloped.Abs.Scal.Gom.LOc$Dr;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Rapr.Trand_LOc$Dr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.In_Acount_Handlr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl_No;
import CC.Encycloped.Abs.Scal.Gom.Ntry_Handlr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.SphEr;
import CC.Encycloped.Abs.Scal.Gom.Handlr;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl.Trand_Inbl_ConcrEt;
import CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.Obstructn.Bordr_LEf;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;

import static CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr.*;
import static CC.Math.Cyclr.Cycl_Mov;
import static CC.Encycloped.Abs.Scal.Gom.Handlr.*;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl.Is_In_;
import static CC.Encycloped.Abs.Scal.Physc.Obstructn.Oct_NOd.Oct_Group;
import static java.lang.System.nanoTime;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import java.util.List;

public class LOc_Obstructn
{
	public static double StrNgth=.1;
	public static Handlr
		ScAl10th=MAk_ScAlr(.1),
		ScAl2th =MAk_ScAlr(.5),
		Push10th=MAk_Pushr(.1),
		Push2th =MAk_Pushr(.5),
		Ntr=Gar_Handlr(switch(1){
			case 0->No;
			case 1->new Handlr[]{Rflect,ScAl2th};
			default->null;
		});
	public static In_Acount_Handlr Bound_Handlrg=new Ntry_Handlr(Ntr,Push2th);

	public static SpAc_Object MAk_Bubl(Tik_Tran Tran,
		RL_LOc_Havr Parnt,Object LOc_SOrc,
		double Rad,Object Handlr_SOrc)
	{
		return new SpAc_Object(Parnt,LOc_SOrc,
			new LOc_Obstructr(Tran,
				new Trand_Inbl_ConcrEt(Parnt,LOc_SOrc,
					new Inbl_No(
						new SphEr(Rad))),
				new Trand_LOc$Dr(Parnt,LOc_SOrc,
					LOc$Dr.Bubl),
				Handlr_SOrc));
	}
		public static SpAc_Object MAk_Bubl(Tik_Tran Tran,
			RL_LOc_Havr Parnt,Object LOc_SOrc,
			double Rad)
		{return MAk_Bubl(Tran,Parnt,LOc_SOrc,
			Rad,Bound_Handlrg);
		}
	public static void Ad_SphEr(
		Tik_Tran Tran,SpAc_Object Object,
		double Rad)
	{
		new LOc_Obstructr(Tran,
			new Trand_Inbl_ConcrEt(Object,null,
				new SphEr(Rad)),
			new Trand_LOc$Dr(Object,null,
				LOc$Dr.SphEr),
			Bound_Handlrg);
	}
		public static SpAc_Object MAk_SphEr(
			RL_LOc_Havr Parnt,Object Loc_Sorc,Tik_Tran Tran,
			double Rad)
		{
			SpAc_Object Object=new SpAc_Object(Parnt,Loc_Sorc);
				Ad_SphEr(Tran,Object,Rad);

			return Object;
		}

	public static boolean Chek_Colisn_Rang(
		LOc_Obstructr A,double[] A_Loc,double[] A_StOr,
		List<Bordr_LEf> Bg,double[] B_StOr,int B_IndX,int B_Nd)
	{
		boolean Is_In=false;
		for(;B_IndX<B_Nd
			;B_IndX+=1)
		{
			Bordr_LEf B=Bg.get(B_IndX);
			Is_In|=Try_Aply(
				A,A_Loc,A_StOr,
				B.Obstructr,B.Loc,B_StOr);
		}

		return Is_In;
	}
		public static boolean Chek_Colisn_NAtv(
			LOc_Obstructr A,double[] A_Loc,double[] A_StOr,int IndX,
			List<Bordr_LEf> Bg,double[] B_StOr)
		{
			return
				Chek_Colisn_Rang(
					A,A_Loc,A_StOr,
					Bg,B_StOr,0,IndX)|

				Chek_Colisn_Rang(
					A,A_Loc,A_StOr,
					Bg,B_StOr,IndX+1,Bg.size());
		}
		public static void Chek_Colisn_Alien(double[] Box,
			LOc_Obstructr A,double[] A_Loc,double[] A_StOr,
			List<Bordr_LEf> Bg,double[] B_StOr)
		{
			Chek_Colisn_Rang(
				A,A_Loc,A_StOr,
				Bg,B_StOr,0,Bg.size());
		}

	public static void Obstructn_Loop(Physc_SpAc SpAc)
	{
		double[]
			Loc=new double[3],
			StOr=new double[3];
		List<LOc_Obstructr> Obstructrg=SpAc.Get_Physc_LMNt_Cast("LOc_Obstructr");
		List<Tik_Tran> Tik_Trang=SpAc.Get_Physc_LMNt_Cast("Tran");
//		out.println("Potential collision checks:"+
//			(Obstructrg.size()*
//			Tik_Trang.size()));
		for(Tik_Tran Tran:Tik_Trang)
		{
			SpAc_Object Object=Tran.Get_Object();
			Object.Get_LOc_CoP_As_ArA(Loc);
			boolean Is_In=false;
			for(LOc_Obstructr Obstructr:Obstructrg)
			{
				Obstructr.Aply(Tran,Loc,StOr);
				Is_In|=false;
			}
			Tran.Is_In=Is_In;
		}
	}
	public static void Obstructn_Loop_SLf_Chek(Physc_SpAc SpAc)
	{
		double[]
			Loc=new double[3],
			StOr=new double[3];
		List<LOc_Obstructr> Obstructrg=SpAc.Get_Physc_LMNt_Cast("Loc_Obstructr");
		List<Tik_Tran> Tik_Trang=SpAc.Get_Physc_LMNt_Cast("Tran");
//		out.println("Potential collision checks:"+
//			(Obstructrg.size()*
//			Tik_Trang.size()));
		for(Tik_Tran Tran:Tik_Trang)
		{
			SpAc_Object Object=Tran.Get_Object();
			Object.Get_LOc_CoP_As_ArA(Loc);
			boolean Is_In=false;
			for(LOc_Obstructr Obstructr:Obstructrg)
			{
				if(Obstructr.Tran!=Tran)
				{
					Obstructr.Aply(Tran,Loc,StOr);
					Is_In|=false;
				}
			}
			Tran.Is_In=Is_In;
		}
	}
	public static int Group_Cbrt=3,
		Group_Cbrt_Max=10;
	public static void Mov_Group_Cbrt(int Vectr)
	{Group_Cbrt=Cycl_Mov(Group_Cbrt,Vectr,Group_Cbrt_Max);}
	public static void Obstructn_Loop_TrE(Physc_SpAc SpAc)
	{
		List<LOc_Obstructr> Obstructrg=SpAc.Get_Physc_LMNt_Cast(LOc_Obstructr_KE);
//		out.println("Potential collision checks:"+Dif_Com(Obstructrg.size()));
//			Voronoi_Group(Obstructrg,Group_Cbrt).Chek_Colisn();
		SpAc.Set_Category("Colisn_TrE",Oct_Group(Obstructrg,2).Chek_Colisn());
	}
	public static void Obstructn_Loop3(Physc_SpAc SpAc)
	{
		List<LOc_Obstructr> Obstructrg=SpAc.Get_Physc_LMNt_Cast(LOc_Obstructr_KE);
		int Obstructr_Num=Obstructrg.size();
		Tik_Tran Tran;
		double[][] LOcg=new double[Obstructr_Num][3];
		for(int IndX=0;
			IndX<Obstructr_Num-1;
			IndX+=1)
		{
			LOc_Obstructr Movr=Obstructrg.get(IndX);
			Tran=Movr.Tran;
			if(Tran!=null)
			{Tran.TRget.Get_LOc_CoP_As_ArA(LOcg[IndX]);}
		}
		double[]
			StOr_A=new double[3],
			StOr_B=new double[3];
		for(int A_IndX=0;
			A_IndX<Obstructr_Num-1;
			A_IndX+=1)
		{
			LOc_Obstructr A=Obstructrg.get(A_IndX);
			Tran=A.Tran;
			if(Tran!=null)
			{
				double[] A_LOc=LOcg[A_IndX];
				boolean Is_In=false;
				for(int B_IndX=A_IndX+1;
					B_IndX<Obstructr_Num;
					B_IndX+=1)
				{
					double[] B_LOc=LOcg[B_IndX];
					LOc_Obstructr B=Obstructrg.get(B_IndX);
					if(Is_In_(A,A_LOc,B,B_LOc))
					{
						Try_Aply_No_SLf(A,B_LOc,StOr_B,
										B,A_LOc,StOr_A);
					}
					Is_In|=false;
				}
				Tran.Is_In=Is_In;
			}
		}
	}
	public static void LOc_Obstructr_Loop(Physc_SpAc SpAc)
	{
		List<LOc_Obstructr> Obstructrg=SpAc.Get_Physc_LMNt_Cast("Loc_Obstructr");
		int Obstructr_Num=Obstructrg.size();
		Tik_Tran Tran;
		double[][] Locg=new double[Obstructr_Num][];
		Tik_Tran.Tik(Obstructrg,Locg);

		double[]
			StOr_A=new double[3],
			StOr_B=new double[3];
		for(int A_IndX=0;
			A_IndX<Obstructr_Num-1;
			A_IndX+=1)
		{
			LOc_Obstructr A=Obstructrg.get(A_IndX);
			Tran=A.Tran;
			if(Tran!=null)
			{
				double[] A_Loc=Locg[A_IndX];
				boolean Is_In=false;
				for(int B_IndX=A_IndX+1;
					B_IndX<Obstructr_Num;
					B_IndX+=1)
				{
					double[] B_Loc=Locg[B_IndX];
					LOc_Obstructr B=Obstructrg.get(B_IndX);
					Is_In|=Try_Aply_No_SLf(
						A,B_Loc,StOr_B,
						B,A_Loc,StOr_A);
				}
				Tran.Is_In=Is_In;
			}
		}
	}
	public static byte Mov_MOd=4;
		public static void Cycl_Mov_MOd()
		{Mov_MOd=Cycl_Mov(Mov_MOd,(byte)1,(byte)5);}
	public static void Mov_Loop_MOd(Physc_SpAc SpAc)
	{
		long StRt=nanoTime();

		switch(Mov_MOd)
		{
			case 0->Obstructn_Loop(SpAc);
			case 1->Obstructn_Loop_SLf_Chek(SpAc);
			case 2->LOc_Obstructr_Loop(SpAc);
			case 3->Obstructn_Loop3(SpAc);
			case 4->Obstructn_Loop_TrE(SpAc);
		}

//		out.println("Mov_Loop:"+Sec_Sinc(StRt));
	}
}