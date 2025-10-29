import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import static CC.Encycloped.Abs.Org.Comput.Bi.Bi.Count1;
import static CC.Encycloped.Abs.Org.Comput.Bi.Shiftr.Shift_Cycl_RIt;

public class BitwIs_CL
{
	public interface Adjacnt_Countr
	{
		@Lin_DclAr @Finishd(Is_Finishd=true)
		int Count(
			byte A,
			byte B,
			byte C,
			byte D,
			byte Cord_A,
			byte Cord_B);
	}
	public static class Cyclcl_Adjacnt_Countr implements Adjacnt_Countr
	{
		public static final byte
			On=(byte)0b1000_0000,
			Ab=0b0100_0001;
		@Finishd(Is_Finishd=false)
		public static int Count_Adjacnt_In_ARO(
			byte RO,
			byte Cord)
		{return Count1(Shift_Cycl_RIt(Ab,Cord)&RO);}
		@Finishd(Is_Finishd=false)
		public static int Count_Adjacnt_In_BRO(
			byte A,
			byte B,
			byte Cord)
		{
			byte Shiftd=Shift_Cycl_RIt(On,Cord);
			return Count1(Shiftd&A)+Count1(Shiftd&B);
		}
		@Finishd(Is_Finishd=false)
		public static int Count_Adjacnt_In_ABRO(
			byte A,
			byte B,
			byte C,
			byte Cord_A)
		{
			return
				Count_Adjacnt_In_ARO(B,Cord_A)+
				Count_Adjacnt_In_BRO(A,C,Cord_A);
		}
		@Finishd(Is_Finishd=false)
		public static int Count_(
			byte A,byte B,
			byte C,byte D,
			byte Cord_A,byte Cord_B)
		{
			return switch(Cord_B)
			{
				case 0->Count_Adjacnt_In_ABRO(D,A,B,Cord_A);
				case 1->Count_Adjacnt_In_ABRO(A,B,C,Cord_A);
				case 2->Count_Adjacnt_In_ABRO(B,C,D,Cord_A);
				case 3->Count_Adjacnt_In_ABRO(C,D,A,Cord_A);
				default->throw new IllegalStateException("Cord_B out of bounds: "+Cord_B);
			};
		}
		@Override @Finishd(Is_Finishd=false)
		public int Count(
			byte A,byte B,
			byte C,byte D,
			byte Cord_A,byte Cord_B)
		{
			return Count(
				A,B,
				C,D,
				Cord_A,Cord_B);
		}
	}
}