package DDDTutorial_Modd;

import CC.COd.Lin_DclAr;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.Voxl.*;
import java.util.HashMap;
import java.util.Map;
import static CC.List.List_X.Init_Map_;

public interface Grid_MAkr
{
	@Lin_DclAr
	Voxl_Grid MAk(Physc_SpAc SpAc,Object Loc_Sorc,
		double Voxl_SIz,byte[][][] IDg);

	Map<String,Grid_MAkr> Grid_MAkrg=Init_Map_(new HashMap<>(),
		new String[]{
			"Cub",
			"Cub_",
			"HXagon",
			"Triangl",
			"Brik",
		},new Grid_MAkr[]{
			Cub_Grid_::new,
			Cub_VrtX_Grid::new,
			SqAr_HXagon_Grid::new,
			Triangl_Grid::new,
			Brik_Grid::new,
		});
}