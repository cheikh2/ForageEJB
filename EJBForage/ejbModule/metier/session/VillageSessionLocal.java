package metier.session;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Village;

@Local
public interface VillageSessionLocal {
	public int insertVillage(Village V);
	public void deleteVillage(int id);
	public void updateVillage(Village V);
	public Village getVillage(int id);
	public List<Village> allVillages();
}
