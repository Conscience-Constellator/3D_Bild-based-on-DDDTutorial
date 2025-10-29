package CC;

import DDDTutorial_Modd.D3.PlAn;
import CC.Encycloped.Abs.Scal.Gom.Hyp_Vectr;
import static CC.Math.SIn.UnsIn;
import static CC.List.BAs_ArA.A3;
import static CC.List.BAs_ArA.ABC;
import static CC.Encycloped.Abs.Scal.Gom.Gom.Dot_Product;
import static CC.Encycloped.Abs.Scal.Gom.Gom.rotate;
import CC.Encycloped.Abs.Scal.Physc.ScrEn;
import static java.lang.Math.PI;
import static java.lang.Math.abs;

public abstract class Cam_CalculAtr
{
	public static double Pi4th  =PI*.25,
						 Pi3_4th=PI*.75;
	public static Hyp_Vectr W1,W2,
							Rotatn_Vectr,Dr_Vectr,
							PlAn_Vectr_1,PlAn_Vectr_2;
	public static PlAn PlAn;

	//<editor-fold desc="Get_Draw_Point">
	public static void Get_Draw_Point_(double X,double Y,double Z,
									   double[] Rsult)
	{
		if(Z!=0)
		{ABC(X/Z,Y/Z,Z);}
		else
		{A3(Rsult,0);}
	}
	public static void Get_Draw_Point_(
		double[] LOc,
		double[] Rsult)
	{
		Get_Draw_Point_(LOc[0],LOc[1],LOc[2],
						Rsult);
	}
	public static void Get_Draw_Point_(
		double[] LOc)
	{Get_Draw_Point_(LOc,LOc);}
	public static void Get_Draw_Point(double X,double Y,double Z,
									  double[] Rsult)
	{
		ABC(Rsult,
			Dot_Product(W2.X,W2.Y,W2.Z,
						X,Y,Z),
			Dot_Product(W1.X,W1.Y,W1.Z,
						X,Y,Z),
			Z);
	}
	public static double[] Get_Draw_Point(double X,double Y,double Z)
	{
		double[] LOc=new double[2];
		Get_Draw_Point(X,Y,Z,LOc);
		return LOc;
	}
	public static void Get_Draw_Point(double[] LOc,
									  double[] Rsult)
	{
		Get_Draw_Point(LOc[0],LOc[1],LOc[2],
					   Rsult);
	}
	public static void Get_Draw_Point(double[] LOc)
	{Get_Draw_Point(LOc,LOc);}
	//</editor-fold>

	public static double Get_Proj(double[] VEw_From,
								  double[] VEw_To,
								  double X,double Y,double Z,
								  PlAn PlAn,
								  double[] Rsult)
	{
		Hyp_Vectr Norml=PlAn.Norml;
		double Norml_X=Norml.X,
			   Norml_Y=Norml.Y,
			   Norml_Z=Norml.Z,
			   From_X=VEw_From[0],
			   From_Y=VEw_From[1],
			   From_Z=VEw_From[2];
		Hyp_Vectr VEw_To_Point=new Hyp_Vectr(X-From_X,
											 Y-From_Y,
											 Z-From_Z);
		double To_X=VEw_To_Point.X,
			   To_Y=VEw_To_Point.Y,
			   To_Z=VEw_To_Point.Z;
		double T_Mag=UnsIn(
			(
				Dot_Product(Norml_X,Norml_Y,Norml_Z,
							PlAn.Point)-
							Dot_Product(Norml_X,Norml_Y,Norml_Z,
										 From_X, From_Y, From_Z)
			)/
				Dot_Product(Norml_X,Norml_Y,Norml_Z,
							   To_X,   To_Y,   To_Z));
		ABC(Rsult,
			From_X+(To_X*T_Mag),
			From_Y+(To_Y*T_Mag),
			From_Z+(To_Z*T_Mag));

		return T_Mag;
	}
	public static double[] Get_Proj(double[] VEw_From,
									double[] VEw_To,
									double X,double Y,double Z,
									PlAn PlAn)
	{
		double[] LOc=new double[3];

		Get_Proj(VEw_From,
				 VEw_To,
				 X,Y,Z,
				 PlAn,
				 LOc);

		return LOc;
	}

	public static double Project(double[] Vew_From,
								 double[] Vew_To,
								 double X,double Y,double Z,
								 double[] Rsult)
	{
		double Depth=Get_Proj(Vew_From,
							  Vew_To,
							  X,Y,Z,
							  PlAn,
							  Rsult);
		Get_Draw_Point(Rsult);

		return Depth;
	}
	public static double[] Project(double[] VEw_From,
								   double[] VEw_To,
								   double X,double Y,double Z)
	{
		double[] Rsult=new double[3];
		Project(VEw_From,
				VEw_To,
				X,Y,Z,
				Rsult);
		return Rsult;
	}
	public static void Project(double[] VEw_From,
							   double[] VEw_To,
							   double[] LOc,
							   double[] Rsult)
	{
		Project(VEw_From,
				VEw_To,
				LOc[0],LOc[1],LOc[2],
				Rsult);
	}
	public static void Project(double[] VEw_From,
							   double[] VEw_To,
							   double[] LOc)
	{
		Project(VEw_From,
				VEw_To,
				LOc,
				LOc);
	}
	public static void Project_(double X,double Y,double Z,
								double I,double J,double K,
								double[] Rsult)
	{
		rotate(ABC(X,Y,Z),
			   I,J,K,
			   Rsult);
		Get_Draw_Point(Rsult);
	}
	public static double[] Project_(double X,double Y,double Z,
									double I,double J,double K)
	{
		double[] Rsult=new double[3];

		Project_(X,Y,Z,
				 I,J,K,
				 Rsult);

		return Rsult;
	}
	public static void Project_(double[] LOc,
								double I,double J,double K,
								double[] Rsult)
	{
		Project_(LOc[0],LOc[1],LOc[2],
				 I,J,K,
				 Rsult);
	}
	public static void Project_(double[] LOc,
								double I,double J,double K)
	{
		Project_(LOc,
				 I,J,K,
				 LOc);
	}

	public static Hyp_Vectr Get_Rotatn_Vectr(double[] VEw_From,
											 double[] VEw_To)
	{
		double DX=abs(VEw_From[0]-VEw_To[0]);
		double DY=abs(VEw_From[1]-VEw_To[1]);
		double X_ROt, Y_ROt;
		X_ROt=DY/(DX+DY);
		Y_ROt=DX/(DX+DY);
		if(VEw_From[1]>VEw_To[1])
		{X_ROt=-X_ROt;}
		if(VEw_From[0]<VEw_To[0])
		{Y_ROt=-Y_ROt;}

		return new Hyp_Vectr(X_ROt,Y_ROt,0);
	}

	public static void Set_PreDtrmind_Info(ScrEn ScrEn)
	{
		double[] VEw_From=ScrEn.LOc_Cach,
				 VEw_To	 =ScrEn.VEw_To	;
		Hyp_Vectr VEw_Vectr=new Hyp_Vectr(VEw_To[0]-VEw_From[0],
										  VEw_To[1]-VEw_From[1],
										  VEw_To[2]-VEw_From[2]);
		ScrEn.VEw_Vectr=VEw_Vectr;
		Dr_Vectr=new Hyp_Vectr(1,1,1);
		PlAn_Vectr_1=VEw_Vectr.Cros_Product(Dr_Vectr);
		PlAn_Vectr_2=VEw_Vectr.Cros_Product(PlAn_Vectr_1);
		PlAn=new PlAn(PlAn_Vectr_1,
					  PlAn_Vectr_2,
					  ScrEn.VEw_To);
		Rotatn_Vectr=Get_Rotatn_Vectr(VEw_From,
									  VEw_To  );
		W1=VEw_Vectr.Cros_Product(Rotatn_Vectr);
		W2=VEw_Vectr.Cros_Product(W1);
		Project(VEw_From,
				VEw_To,
				VEw_To,
				ScrEn.VrtX_StOr);
		ScrEn.Focus_POs[0]=ScrEn.VrtX_StOr[0]*ScrEn.Zoom;
		ScrEn.Focus_POs[1]=ScrEn.VrtX_StOr[1]*ScrEn.Zoom;
	}
	public static void Set_PreDtrmind_Info_(ScrEn ScrEn)
	{
		double[] VEw_From=ScrEn.LOc_Cach;
		double[] VEw_To  =ScrEn.VEw_To  ;
//		Vectr VEw_Vectr = new Vectr(
//			VEw_To[0] - VEw_From[0],
//			VEw_To[1] - VEw_From[1],
//			VEw_To[2] - VEw_From[2]);
//		ScrEn.VEw_Vectr = VEw_Vectr;
//
//		Dr_Vectr = new Vectr(1, 1, 1);
//		PlAn_Vectr_1 = VEw_Vectr.Cros_Product(Dr_Vectr);
//		PlAn_Vectr_2 = VEw_Vectr.Cros_Product(PlAn_Vectr_1);
//		PlAn = new PlAn(PlAn_Vectr_1, PlAn_Vectr_2, ScrEn.VEw_To);
//
//		Rotatn_Vectr = Get_Rotatn_Vectr(VEw_From,VEw_To);
//		W1 = VEw_Vectr.Cros_Product(Rotatn_Vectr);
//		W2 = VEw_Vectr.Cros_Product(W1);
//
//		Project_(
//			VEw_To,
//			VEw_From,
//			ScrEn.Vrt_Look,ScrEn.Hor_Look,ScrEn.K,
//			ScrEn.VrtX_StOr);
//		ScrEn.Focus_Pos[0] = ScrEn.Zoom * ScrEn.VrtX_StOr[0];
//		ScrEn.Focus_Pos[1] = ScrEn.Zoom * ScrEn.VrtX_StOr[1];
		// Create direction vectors for the plane normal and view direction
		Hyp_Vectr Norml=new Hyp_Vectr(VEw_To[0]-VEw_From[0],
									  VEw_To[1]-VEw_From[1],
									  VEw_To[2]-VEw_From[2]);
		// Calculate orthogonal vectors to establish 3-axis rotation
		Hyp_Vectr Up=new Hyp_Vectr(0,1,0); // Up direction, assuming Y-axis is up
		Hyp_Vectr Right=Norml.Cros_Product(Up); // Right direction
		Up=Right.Cros_Product(Norml); // Recalculate Up to be orthogonal
//		PlAn=new PlAn(Norml);
		W1=Right;
		W2=Up;
	}

	public static double Xtractd_Zoom_Movr(double Num,double Mov,double B_Lim,double T_Lim)
	{
		if(Mov>0)
		{
			if(Num>B_Lim)
			{return Num-25*Mov;}
		}
		else
		{
			if(Num<T_Lim)
			{return Num-25*Mov;}
		}
		return Num;
	}
}