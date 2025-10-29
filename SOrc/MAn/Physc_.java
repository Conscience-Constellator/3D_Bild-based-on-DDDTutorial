package MAn;

import CC.$.Q$Q.Dubl1$1;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag;
import CC.Encycloped.Abs.Scal.Physc.*;
import CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr;
import CC.Encycloped.TIm.UpdAtbl;
import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import DDDTutorial_Modd.D2.Drawbl_Crcl_TMplat;
import DDDTutorial_Modd.D3.Cub;
import DDDTutorial_Modd.D3.D2$3;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Rapr.LOc$Dr_Neg;
import CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Rapr.Trand_LOc$Dr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl_No;
import CC.Encycloped.Abs.Scal.Gom.ShAp.SphEr;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl.Trand_Inbl_ConcrEt;
import CC.Encycloped.Abs.Scal.Physc.SIt.Efect;
import CC.Encycloped.Abs.Scal.Physc.GraviT.GraviT_Sorc;
import CC.Encycloped.Abs.Scal.Physc.GraviT.GraviT_Sorc_Threshold;
import static CC.Util.Shufl.Shufl.Rol;
import static CC.List.BAs_ArA.ABC;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Invrs_SqAr;
import static CC.Encycloped.Abs.Scal.Gom.Gom.LOc_Shuflr.Box_Shuflr;
import static CC.Encycloped.Abs.Scal.Gom.LOc$Dr_Mag.Hyp;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.Set_A;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Img.Litng;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Op.No_Op;
import static MAn.LOc_Obstructn.Bound_Handlrg;
import static MAn.MAn.Bound_Rad;
import static java.awt.Color.*;
import static java.lang.System.out;
import static java.util.concurrent.ThreadLocalRandom.current;
import CC.Encycloped.Abs.Scal.Physc.Lit.LIt_SOrc;
import CC.Encycloped.Abs.Scal.Physc.Lit.LIt_SOrc_Dr;
import CC.Encycloped.Abs.Scal.Physc.Magnetsm.Magnetsm_SOrc;
import CC.Encycloped.Abs.Scal.Physc.Magnetsm.Reactv_Magnetc_LMNt;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Physc_
{
	public static Tik_Tran Ad_Tran(SpAc_Object Object,double X,double Y,double Z,double Weit)
	{
		Tik_Tran Tran=new Tik_Tran(Object,Weit,ABC(X,Y,Z));

		Object.Ad_Physc(Tran);
		return Tran;
	}
		public static Tik_Tran Ad_Tran(SpAc_Object Object,double Weit)
		{return Ad_Tran(Object,Weit,0,0,0);}
	public static void Ad_Cub(
		SpAc_Object Object,Object LOc_SOrc,
		double LNg,Color Colr)
	{
		Cub Cub=new Cub(Object,LOc_SOrc,LNg,Colr);
		Cub.Ad_Efect(Litng_Efect);
		Object.Ad_Physc(Cub);
	}
		public static void Ad_Cub(SpAc_Object Object,Object Loc_Sorc)
		{Ad_Cub(Object,Loc_Sorc,1,white);}
	public static D2$3 SphEr_Atom(Polyhedron Polyhedron,double Rad,Color Colr)
	{
		return new D2$3(
			new Drawbl_Crcl_TMplat((int)(Rad*2),new Bound_Colr_Filr(Colr)),
			Polyhedron);
	}
	public static void Ad_Graphc_SphEr(
		SpAc_Object Object,Object Loc_Sorc,double Rad,
		Color Colr)
	{
		Polyhedron Graphc=new Polyhedron(Object,Loc_Sorc);
		Graphc.Set_Drawbl_Atomg(SphEr_Atom(Graphc,(int)Rad*2,Colr));
		Object.Ad_Physc(Graphc);
	}
	public static void Ad_Visbl_SphEr(
		SpAc_Object Object,Object Loc_Sorc,double Rad,
		Color Colr)
	{
		Ad_Graphc_SphEr(Object,Loc_Sorc,Rad,Colr);
		Object.Ad_Physc(new LOc_Obstructr((Tik_Tran)Object.Get_Physc_LMNt("Tran"),
			new Trand_Inbl_ConcrEt(Object,null,
				new SphEr(Rad)),
			new Trand_LOc$Dr(Object,null,
				LOc$Dr.SphEr),
			Bound_Handlrg));
	}
		public static void Ad_Visbl_SphEr(SpAc_Object Object,Object Loc_Sorc,
			double Rad)
		{Ad_Visbl_SphEr(Object,Loc_Sorc,Rad,white);}
			public static void Ad_Visbl_SphEr(SpAc_Object Object,Object Loc_Sorc)
			{Ad_Visbl_SphEr(Object,Loc_Sorc,1);}
	public static final Efect Litng_Efect=(Projectn)->{
			return (Projectn.Get_Projectd() instanceof Drawbl_D3_Polygon<?> Atom)?
				Litng(
					Atom.Get_LItng_R(),
					Atom.Get_LItng_G(),
					Atom.Get_LItng_B()):
				No_Op;
		};
	public static void Ad_Lit(
		SpAc_Object Object,Object Loc_Sorc,
		Color Colr,double Britnes)
	{Object.Ad_Physc(new LIt_SOrc(Object,Loc_Sorc,Colr,Britnes));}
		public static void Ad_Lit(
			SpAc_Object Object,Object Loc_Sorc,
			double Britnes)
		{Ad_Lit(Object,Loc_Sorc,white,Britnes);}
		public static void Shufl_Litng(SpAc_Object Object,Object Loc_Sorc,ThreadLocalRandom Shuflr,double Britnes)
		{Ad_Lit(Object,Loc_Sorc,new Color(Shuflr.nextInt()),Shuflr.nextDouble(Britnes));}
			public static void Ad_Dfalt_Litng(Physc_SpAc SpAc)
			{
				double LNg=30,Hit=10;
				SpAc_Object
					BAs=new SpAc_Object(SpAc,null),
					W=new SpAc_Object(SpAc,ABC(0,0,Hit)),
					R=new SpAc_Object(SpAc,ABC(LNg,LNg,Hit)),
					G=new SpAc_Object(SpAc,ABC(LNg,0,Hit)),
					B=new SpAc_Object(SpAc,ABC(0,LNg,Hit));
				BAs.Ad_Physc(new LIt_SOrc_Dr(BAs,null,white,.001,ABC(1D/3D,1D/3,-1D/3)));
				Ad_Lit(W,null,
					2);
				Ad_Cub(W,null);
				Ad_Lit(R,null,
					red,1);
				Ad_Cub(R,null);
				Ad_Lit(G,null,
					green,1);
				Ad_Cub(G,null);
				Ad_Lit(B,null,
					blue,1);
				Ad_Cub(B,null);
				double Rad=LNg/2;
				SpAc_Object Physc_TSt=new SpAc_Object(SpAc,ABC(Rad,Rad,Hit/2));
				Tik_Tran Tran=Ad_Tran(Physc_TSt,1);
				Ad_Cub(Physc_TSt,null,4,white);
//				((Polyhedron)new StR(Physc_TSt,null,"Dfalt","Test").Get_Physc_LMNt("SEn")).Ad_Drawbl_Atom(new );
				SpAc.Ad_Sortd_Item(Tran,"GraviT_Efectbl");
				double Spring_StrNth=.00000000001;
				R.Ad_Physc(new Spring(R,Physc_TSt,Spring_StrNth,5));
				G.Ad_Physc(new Spring(G,Physc_TSt,Spring_StrNth,5));
				B.Ad_Physc(new Spring(B,Physc_TSt,Spring_StrNth,5));
//				Ad_Lit(Physc_TSt,null,1);
				Physc_TSt.Get_UpdAt_Lisnrg().add(
					(UpdAtbl)()->{out.println("Physc_TSt"+Arrays.toString(Physc_TSt.Get_LOc_CoP_As_ArA()));});
			}
	public static double Dfalt_Atractn=160;
	public static GraviT_Sorc Ad_GraviT(
		SpAc_Object Object,Object LOc_SOrc,
		double StrNgth,LOc$Dr_Mag LOc$Dr_Mag,Dubl1$1 ScAl)
	{
		GraviT_Sorc Sorc=new GraviT_Sorc(
			Object,LOc_SOrc,
			StrNgth,LOc$Dr_Mag,ScAl);
		Object.Ad_Physc(Sorc);

		return Sorc;
	}
	public static GraviT_Sorc_Threshold Ad_GraviT_(
		SpAc_Object Object,Object LOc_SOrc,
		double StrNgth,double Altitud)
	{
		GraviT_Sorc_Threshold SOrc=new GraviT_Sorc_Threshold(Object,LOc_SOrc,StrNgth,Altitud);
		Object.Ad_Physc(SOrc);

		return SOrc;
	}

	public static void Ad_Lit_GraviT_Bal(SpAc_Object Object,
		double Rad,
		double GraviT,
		double Lit)
	{
		Ad_GraviT(Object,null,
			GraviT,Hyp,Invrs_SqAr);
		Ad_Lit(Object,null,Lit);
		Ad_Visbl_SphEr(Object,null,Rad,Set_A(white,64));
	}
		public static void Ad_Dfalt_GraviT(Physc_SpAc SpAc)
		{
			double A_GraviT=Dfalt_Atractn*8,
				   C_GraviT=Dfalt_Atractn;
			SpAc_Object
				A=new SpAc_Object(SpAc,null),
				C=new SpAc_Object(SpAc,Box_Shuflr.Shufl(current(),Bound_Rad));
				Tik_Tran Tran=Ad_Tran(A,A_GraviT);
				Ad_Lit_GraviT_Bal(A,128,A_GraviT,8);
				SpAc.Ad_Sortd_Item(Tran,"GraviT_Efectbl");
				Tran=Ad_Tran(C,C_GraviT);
				SpAc.Ad_Sortd_Item(Tran,"GraviT_Efectbl");
				Ad_Lit_GraviT_Bal(C,64,C_GraviT,1);
			if(false)
			{
				SpAc_Object B=new SpAc_Object(SpAc,new double[]{30,30,30});
					Ad_GraviT_(B,null,
						Dfalt_Atractn+12,20);
					Tran=Ad_Tran(B,1);
					Ad_Cub(B,null);
					Ad_Lit(B,null,1);
					SpAc.Ad_Sortd_Item(Tran,"GraviT_Efectbl");
			}
		}
	public static Magnetsm_SOrc Ad_Magnetsm(
		SpAc_Object Object,Object Loc_Sorc,
		double StrNgth,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl,int Is_Efectbl)
	{
		Magnetsm_SOrc Sorc=new Magnetsm_SOrc(Object,Loc_Sorc,
			StrNgth,Loc$Dr_Mag,ScAl,Is_Efectbl);
		Object.Ad_Physc(Sorc);

		return Sorc;
	}
	public static Reactv_Magnetc_LMNt Ad_Magnetsm_(
		SpAc_Object Object,Object Loc_Sorc,
		double Stim,LOc$Dr_Mag Loc$Dr_Mag,Dubl1$1 ScAl,int Is_Efectbl)
	{
		Reactv_Magnetc_LMNt Sorc=new Reactv_Magnetc_LMNt(Object,Loc_Sorc,
			Stim,Loc$Dr_Mag,ScAl,Is_Efectbl);
		Object.Ad_Physc(Sorc);

		return Sorc;
	}
	public static void Ad_Dfalt_Magnetsm(Physc_SpAc SpAc)
	{
		int Is_Efectbl=1;
		SpAc_Object
			A=new SpAc_Object(SpAc,ABC(60D,60,60));
		Ad_Tran(A,16);
		Ad_Magnetsm(A,null,
			Dfalt_Atractn,Hyp,Invrs_SqAr,Is_Efectbl);
		Ad_Cub(A,null);
		Ad_Lit(A,null,1);
		Ad_Lit(A,null,1);
		SpAc_Object
			B=new SpAc_Object(SpAc,ABC(70D,70,70));
		Ad_Tran(B,16);
		Ad_Magnetsm_(B,null,
			.01,Hyp,Invrs_SqAr,Is_Efectbl);
		Ad_Cub(B,null);
		Ad_Lit(B,null,1);
	}

	public static void HOl_PAr(Physc_SpAc SpAc,
		double[] In_Loc,
		double[] Out_Loc,
		double StrNgth)
	{
		SpAc_Object
			In=new SpAc_Object(SpAc,In_Loc),
			Out=new SpAc_Object(SpAc,Out_Loc);
		Ad_GraviT(In,null,StrNgth,Hyp,Invrs_SqAr);
		In.Ad_Physc(new TLeportr(Out,new Trand_Inbl_ConcrEt(In,null,new SphEr(16))));
		Ad_GraviT(Out,null,-StrNgth,Hyp,Invrs_SqAr);
	}

	public static void Shufl_GraviT(SpAc_Object Object,ThreadLocalRandom Shuflr)
	{
		Object.Ad_Physc((Rol(Shuflr,2))?
			new GraviT_Sorc(Object,null,Shuflr.nextDouble(16),LOc$Dr_Mag.Hyp,Invrs_SqAr):
			new GraviT_Sorc_Threshold(Object,null,Shuflr.nextDouble(16),Shuflr.nextDouble(16)));
	}
		public static void Shufl_GraviT(SpAc_Object Object,ThreadLocalRandom Shuflr,int SId)
		{
			if(Rol(Shuflr,SId))
			{Shufl_GraviT(Object,Shuflr);}
		}
	public static void Shufl_Magnetsm(SpAc_Object Object,ThreadLocalRandom Shuflr)
	{
		Magnetsm_SOrc Sorc=(Shuflr.nextBoolean())?
			Ad_Magnetsm(Object,null,
				Shuflr.nextDouble(16),LOc$Dr_Mag.Hyp,Invrs_SqAr,1):
			Ad_Magnetsm_(Object,null,
				Shuflr.nextDouble(.1),LOc$Dr_Mag.Hyp,Invrs_SqAr,1);
//			if(Shuflr.nextBoolean())
		{Object.Get_SpAc().Ad_Sortd_Item(Sorc,"Magnetsm_Efectbl");}
	}
		public static void Shufl_Magnetsm(SpAc_Object Object,ThreadLocalRandom Shuflr,int SId)
		{
			if(Rol(Shuflr,SId))
			{Shufl_Magnetsm(Object,Shuflr);}
		}


	public static Color Planet_Colr=Set_A(white,64);
	public static SpAc_Object Shufl_Planet(Physc_SpAc SpAc,Object Loc_Sorc,ThreadLocalRandom Shuflr)
	{
		SpAc_Object Planet=new SpAc_Object(SpAc,Loc_Sorc);
		Shufl_GraviT(Planet,Shuflr,16);
		Shufl_Magnetsm(Planet,Shuflr,16);
		Ad_Tran(Planet,1);
		Shufl_Litng(Planet,Loc_Sorc,Shuflr,16);
		Ad_Visbl_SphEr(Planet,null,Shuflr.nextDouble(16),Planet_Colr);

		return Planet;
	}

	public static double Dfalt_Predatr_Rad=16;
	public static SpAc_Object MAk_Predatr(
		Physc_SpAc SpAc,Object Loc_Sorc,
		ThreadLocalRandom Shuflr)
	{
		SpAc_Object Predatr=new SpAc_Object(SpAc,Loc_Sorc);
		Ad_Tran(Predatr,1);
		Ad_Visbl_SphEr(
			Predatr,Loc_Sorc,
			16,Set_A(red,64));

		return Predatr;
	}

	public static void Invrt(
		LOc_Obstructr Old,
		LOc_Obstructr New)
	{
		New.Norml_SOrc=new LOc$Dr_Neg(Old.Norml_SOrc);
		New.Get_Rapd_Inbl().Set_Rapd_Inbl(new Inbl_No<>(Old.Get_Rapd_Inbl()));
	}
		public static void Invrt(LOc_Obstructr Obstructr)
		{Invrt(Obstructr,Obstructr);}

	public static String[] Physcg_To_Ad={"SX","Colr","Strong_Nuclear"};
}