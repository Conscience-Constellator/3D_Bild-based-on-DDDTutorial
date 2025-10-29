package DDDTutorial_Modd.ConstL;

import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.QOt;

public class PlAn_DFinitn
{
	public PlAn_MAkr MAkr;
	public Object[] Rgg;
	public StR MAk(ConstLatn ConstLatn)
	{return MAkr.MAk(ConstLatn,Rgg);}

	public static String Gar_NAm(Object Sorc)
	{
		if(Sorc instanceof String NAm)
		{return NAm;}
		else if(Sorc instanceof StR StR)
		{return StR.AdrS;}
		else if(Sorc instanceof Child_MAkr MAkr)
		{return MAkr.toString();}
		else if(Sorc instanceof PlAn_DFinitn DFinitn)
		{return DFinitn.toString();}
		else
		{throw new RuntimeException("Invalid Sorc "+QOt(Sorc));}
	}
	@Override
	public String toString()
	{return Gar_NAm(Rgg[0]);}

	public PlAn_DFinitn(Object MAkr_Sorc,Object[] Rgg)
	{
		this.MAkr=PlAn_MAkr.Gar_PlAn_MAkr(MAkr_Sorc);
		this.Rgg=Rgg;
	}
}