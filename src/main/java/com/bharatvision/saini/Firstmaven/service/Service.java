package com.bharatvision.saini.Firstmaven.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.bharatvision.saini.Firstmaven.Mydatabase.Mydatabase;
import com.bharatvision.saini.Firstmaven.model.Profile;
import com.bharatvision.saini.Firstmaven.model.Massage;

public class Service {
	
	private Map<Long,Massage> massages=Mydatabase.getMassage();
	private Map<Long,Profile> profile = Mydatabase.getProfile();
	
	public Service(){
		/**
		 * Intilize massage data
		 */
		massages.put(1L, new Massage(1L,"fmsknjsg","wgsgwgg"));
		massages.put(2L, new Massage(2L,"fsuresh","makhahf"));
		massages.put(3L, new Massage(3L,"Manish","Kumawt"));
		
		/**
		 * Initilize profile
		 */
		profile.put(1L, new Profile(1L,"myprofile","suresh","kumar"));
	}
	
	public List<Massage> getAllMassage(){
//		Massage m1= new Massage(1L, "heoow" ,"suresh");
//		Massage m2 = new Massage(2L,"hhfsjd", "mahedj");
//		List<Massage> list = new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		return list;
		
		return new ArrayList<Massage>(massages.values());
	}
	
	/**
	 * Method getMassageForYear for query parammer
	 * @param year
	 * @return
	 */
	public List<Massage> getAllMassageForYear(int year){
		List<Massage> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Massage massage : massages.values()){
			cal.setTime(massage.getCreated());
			if (cal.get(Calendar.YEAR)==year){
				messageForYear.add(massage);
			}
		}
		return messageForYear;
	}
	
	/**
	 * List of massasge with size
	 * @param start
	 * @param size
	 * @return
	 */
	
	public List<Massage> getAllMessagePaginated(int start, int size){
		ArrayList<Massage> list = new ArrayList<Massage>(massages.values());
		if(start + size > list.size()) return new ArrayList<Massage>();
		return list.subList(start, start+size);
		
	}
	
	public Massage getMassage(long id){
		return massages.get(id);
	}
	
	public Massage addMassage(Massage massage){
		massage.setId(massages.size()+1);
		massages.put(massage.getId(), massage);
		return massage;
	}
	
	public Massage updateMassage(Massage massage){
		if(massage.getId()<=0){
			return null;
		}
		massages.put(massage.getId(), massage);
		return massage;
	}
	
	public Massage removeMassage(long id){
		return massages.remove(id);
	}

}
