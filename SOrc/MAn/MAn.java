package MAn;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import CC.Bool.Trn.Task_On_Trnbl_Runbl;
import CC.$.Q$Q.Point1$1;
import CC.ConstL.Material;
import CC.Encycloped.Abs.Scal.Gom.ArA_LOcg;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import CC.Encycloped.Abs.Scal.Physc.Tik_Tran;
import CC.List.NOd.TrE_NOd;
import DDDTutorial_Modd.ConstL.*;
import CC.Encycloped.Abs.Scal.Gom.DialAtr.Print_DialAtr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.RL_LOc_Havr_ConcrEt;
import CC.Encycloped.Abs.Scal.Gom.ShAp.*;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl.Trand_Inbl_ConcrEt;
import static CC.Encycloped.Abs.Scal.Gom.Gom.LOc_Shuflr.Box_Shuflr;
import CC.Encycloped.Abs.Scal.Physc.SIt.Img_Clip;
import DDDTutorial_Modd.D3.*;
import CC.Encycloped.Abs.Scal.Gom.ShAp.Inbl_No;
import CC.Encycloped.Abs.Scal.Gom.Trand_Inbl;
import CC.Encycloped.Abs.Scal.Physc.SIt.Int1$1_Rap_Op;
import CC.Encycloped.Abs.Scal.Physc.SIt.Op;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import DDDTutorial_Modd.Gom.SpAc_Soterc;
import DDDTutorial_Modd.Tool;
import CC.Encycloped.Abs.Scal.Physc.Obstructn.Bordr_NOd;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static CC.Encycloped.Abs.Scal.Physc.Obstructn.LOc_Obstructr.LOc_Obstructr_KE;
import static CC.List.BAs_ArA.AB;
import static CC.List.ArA_X.Rvrs;
import static CC.Thred.Thred.Branch;
import static CC.UI.Sig.Input_Havr.KE_AccSr;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.No_Filr;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.*;
import static DDDTutorial_Modd.D3.TXtrd_Polygon_.TSt_Img;
import static MAn.LOc_Obstructn.*;
import static MAn.OriNtatn.Ad_OriNtatn_Objectg;
import static CC.Util.Fun.V.V;
import static MAn.Physc_.*;
import static java.awt.Color.*;
import static java.awt.event.KeyEvent.VK_0;
import static java.util.concurrent.ThreadLocalRandom.current;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static CC.$.Q$Q_Grup.Num_A$A.NegAt;

public class MAn
{
	public static Dimension Dfalt_Win_SIz=new Dimension(800,800);
	public static JTextField TXt;

	public static Tool MAk_Tool(Physc_SpAc SpAc)
	{
		Tool Tool=new Tool(SpAc,new double[]{15,5,100});
			Tik_Tran Tran=new Tik_Tran(Tool,1);
			Tool.Ad_Physc(Tran);
			SpAc.Ad_Sortd_Item(Tran,"GraviT_Efectbl");
			ScrEn ScrEn=new ScrEn(Tool,null);
			Tool.Ad_Physc(ScrEn);

		JFrame FrAm=new JFrame();
		FrAm.add(ScrEn);
		FrAm.setSize(Dfalt_Win_SIz);
		FrAm.setVisible(true);
		FrAm.setDefaultCloseOperation(
			DISPOSE_ON_CLOSE
//			EXIT_ON_CLOSE
		);

		return Tool;
	}
	public static boolean Evr_Ad_Dfalt_Object=true,
						   Do_Ad_Dfalt_Object=true;
	public static void MAk_TSt_SpAc()
	{
		Physc_SpAc SpAc=new SpAc_Soterc();
		ScrEn ScrEn=(ScrEn)MAk_Tool(SpAc).Get_Physc_LMNt_Cast("SEs");
		ScrEn.Box_DialAtr=new Print_DialAtr(new Box_DialAtr(Ad_Boundng_Box(SpAc,Bound_Rad)));
		ScrEn.SphEr_DialAtr=new Print_DialAtr(new SphEr_DialAtr(Ad_Boundng_Bal(SpAc,Bound_Rad)));
		if(Evr_Ad_Dfalt_Object)
		{
			if(Do_Ad_Dfalt_Object)
			{Ad_Dfalt_Objectg(SpAc,ScrEn);}
			Do_Ad_Dfalt_Object=!Do_Ad_Dfalt_Object;
		}
	}
	public static void MAk_Control_Panl()
	{
		JFrame FrAm=new JFrame();
		Control_Panl PAn=new Control_Panl();
		FrAm.setContentPane(PAn);
		FrAm.setSize(400,400);
		FrAm.setVisible(true);
	}
	public static void main(String[] Rgg)
	{
		Branch(MAn::MAk_Control_Panl);
		MAk_TSt_SpAc();
//		MAk_TSt_SpAc();
	}
	public static RL_LOc_Havr[] Ad_Boundng_Box(Physc_SpAc SpAc,double Rad)
	{
		Tik_Tran Tran=null;

		RL_LOc_Havr
			abc=new RL_LOc_Havr_ConcrEt(SpAc,-Rad,-Rad,-Rad),
			Abc=new RL_LOc_Havr_ConcrEt(SpAc,Rad,-Rad,-Rad),
			aBc=new RL_LOc_Havr_ConcrEt(SpAc,-Rad,Rad,-Rad),
			ABc=new RL_LOc_Havr_ConcrEt(SpAc,Rad,Rad,-Rad),
			abC=new RL_LOc_Havr_ConcrEt(SpAc,-Rad,-Rad,Rad),
			AbC=new RL_LOc_Havr_ConcrEt(SpAc,Rad,-Rad,Rad),
			aBC=new RL_LOc_Havr_ConcrEt(SpAc,-Rad,Rad,Rad),
			ABC=new RL_LOc_Havr_ConcrEt(SpAc,Rad,Rad,Rad);
		RL_LOc_Havr[] Boundng_VrtXg=new RL_LOc_Havr[]{
			abc,Abc,
			aBc,ABc,
			abC,AbC,
			aBC,ABC};
		SpAc_Object Flor=MAk_Polygon(Tran,SpAc,StrNgth,aBc,ABc,Abc,abc);
		MAk_Polygon(Tran,SpAc,StrNgth,abC,AbC,ABC,aBC);
		MAk_Polygon(Tran,SpAc,StrNgth,abc,Abc,AbC,abC);
		MAk_Polygon(Tran,SpAc,StrNgth,aBC,ABC,ABc,aBc);
		MAk_Polygon(Tran,SpAc,StrNgth,abC,aBC,aBc,abc);
		MAk_Polygon(Tran,SpAc,StrNgth,Abc,ABc,ABC,AbC);
		SpAc_Object Down=new SpAc_Object(SpAc,null);
		/*
		Ad_GraviT(Down,null,Dfalt_Atractn/
				1000
//				-10000
//				4600
			,((D3_Polygon)
				((Polyhedron)Flor.Get_Physc_LMNt("SEn")).Drawbl_Atomg[0])
			.Polygon,
			(Distnc)->{return 1;});
		/**/
		Tik_Tran Tran_=Ad_Tran(Down,1);
//		Ad_Cub(Down,null,4,white);
		Ad_Lit(Down,null,1);

		return Boundng_VrtXg;
	}
	public static SphEr Ad_Boundng_Bal(Physc_SpAc SpAc,double Rad)
	{
		SphEr Boundng_SphEr=
			((Trand_Inbl<?,Inbl_No<SphEr>>)
				((LOc_Obstructr)MAk_Bubl(null,
					new RL_LOc_Havr_ConcrEt(SpAc,0,0,0),null,
					Rad,Bound_Handlrg).Get_Physc_LMNt(LOc_Obstructr_KE)
				).Get_Rapd_Inbl()
			).Get_Rapd_Inbl().Rapd_Inbl;

		return Boundng_SphEr;
	}
	public static void Ad_Dfalt_Objectg(Physc_SpAc SpAc,ScrEn ScrEn)
	{
		Ad_OriNtatn_Objectg(SpAc);

//		Ad_ConstLatn(SpAc,ScrEn);

//		Ad_Grid(SpAc,null);

		Ad_Dfalt_Litng(SpAc);
		Ad_Dfalt_GraviT(SpAc);
//		Ad_Dfalt_Magnetsm(SpAc);
		ThreadLocalRandom Shuflr=current();
		HOl_PAr(SpAc,
			Box_Shuflr.Shufl(Shuflr,Bound_Rad),
			Box_Shuflr.Shufl(Shuflr,Bound_Rad),
		Dfalt_Atractn);

//		MAk_Bubl(SpAc,null,Bound);
//		MAk_SphEr(SpAc,null,64);

//		Ad_Draw_TSt(SpAc);

//		Ad_Originl_Objectg(SpAc);
	}

	public static double
		Bound=switch(0){
			case 0->1024;
			case 1->128;
			default->throw new IllegalStateException("Unexpected value: "+0);
		},
		Hit_Rad=512,Bound_Rad=switch(0){
			case 0->1024;
			case 1->100;
			default->throw new IllegalStateException("Unexpected value: "+0);
		};
	@Finishd(Is_Finishd=false)
	public static SpAc_Object MAk_Polygon(Tik_Tran Tran,
		RL_LOc_Havr Parnt,
		double StrNgth,RL_LOc_Havr... VrtXg)
	{
		D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>> Polygon=new D3_Polygon<>(VrtXg);
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Polygon_=new Drawbl_D3_Polygon<>(Polygon,Set_A(black,64));
		Polygon_.Set_Is_TRgetbl(false);
		return new SpAc_Object(Parnt,null,
			new LOc_Obstructr(Tran,
				new Trand_Inbl_ConcrEt(Parnt,null,new Mag_Inbl(Polygon)),
				Polygon,
				Bound_Handlrg),
			new Polyhedron(Parnt,null,
				Polygon_));
	}
		@Finishd(Is_Finishd=false)
		public static SpAc_Object[] MAk_Polygon_Oposits(
			Tik_Tran Tran ,RL_LOc_Havr Parnt,
			double StrNgth,RL_LOc_Havr... VrtXg)
		{
			return new SpAc_Object[]{
				MAk_Polygon(Tran,Parnt,StrNgth,VrtXg),
				MAk_Polygon(Tran,Parnt,StrNgth,Rvrs(VrtXg,RL_LOc_Havr.class))};
		}

	@Finishd(Is_Finishd=false)
	public static int Crcumfrnc(int Diam)
	{return (Diam-1)*4;}

	public static Op Invrt_Op=new Int1$1_Rap_Op(NegAt);
	@Finishd(Is_Finishd=false)
	public static void Ad_Draw_TSt(Physc_SpAc SpAc)
	{
		int X=0;
		double X_SpAc=10;

		Color TSt_Colr=new Color(255,255,255);
		Polyhedron Polyhedron_=new Polyhedron(SpAc,null);
		D3_Drawbl_Atom Atom=
//			new VrtX_Polygon(Polyhedron_,
//				TSt_Colr,
//				new RL_Loc_Havr_ConcrEt(SpAc,0,0,0),
//				new RL_Loc_Havr_ConcrEt(SpAc,0,10,20),
//				new RL_Loc_Havr_ConcrEt(SpAc,0,20,10)
			new Drawbl_D3_Polygon<>(
				new D3_Polygon(new ArA_LOcg(SpAc,
					new double[]{X,X,X},
					new double[]{0,10,20},
					new double[]{0,20,10})),
				new Img_Clip(TSt_Img,
					new double[]{0,100,200},
					new double[]{0,200,100})
			);
			Atom.Ad_Efect(((Drawbl_D3_Polygon<?>)Atom).LItng_Op());
			X+=X_SpAc;
		D3_Drawbl_Atom NegAt=
			new Drawbl_D3_Polygon<>(
				new D3_Polygon(new ArA_LOcg(SpAc,
					new double[]{X,X,X},
					new double[]{0,10,20},
					new double[]{0,20,10})),
				No_Filr
			);
			NegAt.Ad_Efect(Invrt_Op);
			X+=X_SpAc;
		D3_Drawbl_Atom[] Atomg={
			Atom,
//			NegAt,
		};
		Polyhedron_.Set_Drawbl_Atomg(Atomg);
	}

	//<editor-fold desc="Tryng to mAk bordr trE">
	public interface StRfyr<StRfybl> extends Point1$1<StRfybl,StR>
	{
		@Lin_DclAr
		StR StRfy(StRfybl StRfybl);
			@Override
			default StR Point1$1(StRfybl StRfybl)
			{return StRfy(StRfybl);}
	}
	public interface Branch_Getr
	{
		@Lin_DclAr @Finishd(Is_Finishd=false)
		void Get(List<StR> StR);
	}
//	public static final Branch_Getr TrE_Branch_Getr=(List<StR> StRg)->{StRg.addAll();};
	public static ConstLatn_Typ Bordr_Typ=new ConstLatn_Typ("Bordr_NOd",new Material("Bordr_NOd",Set_A(red,64)));
	public static <NOd_Typ extends TrE_NOd>Object[] TrE_To_ConstL_NOd(NOd_Typ NOd,String NAm,
		Point1$1<NOd_Typ,String> NAm_SOrc)
	{
		NOd_Typ[] Branchg=(NOd_Typ[])NOd.Branchg;
		if(Branchg!=null)
		{
			int Branch_Num=Branchg.length;
			Object[] ArA=new Object[1+Branch_Num];
			ArA[0]=NAm;
			for(int IndX=0,NXt_IndX;
				IndX<Branch_Num;
				IndX=NXt_IndX)
			{
				NXt_IndX=IndX+1;
				NOd_Typ Branch=Branchg[IndX];
				ArA[NXt_IndX]=TrE_To_ConstL_NOd(Branch,NAm_SOrc);
			}

			return ArA;
		}
		else
		{return new Object[]{NAm};}
	}
		public static <NOd_Typ extends TrE_NOd>Object[] TrE_To_ConstL_NOd(NOd_Typ NOd,Point1$1<NOd_Typ,String> NAm_SOrc)
		{return TrE_To_ConstL_NOd(NOd,NAm_SOrc.Point1$1(NOd),NAm_SOrc);}
	public static void Pop_Bordr_TrE(ConstLatn ConstLatn,Bordr_NOd NOd)
	{
		PlAn_MAkr.MAk("Bordr_NOd",
			ConstLatn,TrE_To_ConstL_NOd(NOd,"Bordr_TrE",(NOd_)->{return NOd_.Get_IndX_In_StM()+","+NOd_.NOd_Num;}));
	}
		public static Runnable Bordr_TrE_MAkr(Physc_SpAc In,Physc_SpAc Of)
		{
			ConstLatn ConstLatn=new ConstLatn(In,null);

			return ()->
				   {Pop_Bordr_TrE(ConstLatn,(Bordr_NOd)Of.Gar_Category("Colisn_TrE").get(0));};
		}
	public static Physc_SpAc MAk_Dbug_SpAc(Physc_SpAc SpAc)
	{
		Physc_SpAc Dbug=new Physc_SpAc();
		SpAc_Object Tool=MAk_Tool(Dbug);
		Runnable Bordr_TrE_MAkr=Bordr_TrE_MAkr(Dbug,SpAc);
		Bordr_TrE_MAkr.run();
		KE_AccSr.Set(((ScrEn)Tool.Get_Physc_LMNt_Cast("SEs")),
			VK_0,new Task_On_Trnbl_Runbl(Bordr_TrE_MAkr));

		return Dbug;
	}
	//</editor-fold>

	public static Color Warnng_Colr=Set_A(red,64);
}