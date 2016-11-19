package dao;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pojo.Stamboom;

@Stateless
public class StamboomDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Stamboom> getFamilieOudste() {
		String sql = "select "
				   + "       s.id"
				   + ",      s.roepnaam"
				   + ",      s.tussenvoegsel"
				   + ",      s.achternaam "
				   + ",      s.partnerId"
				   + ",      s.partnerRoepnaam"
				   + ",      s.partnerTussenvoegsel"
				   + ",      s.partnerAchternaam "
				   + "from "
				   + "       ("
				   + "        select "
				   + "               p.id"
				   + "        ,      p.roepnaam"
				   + "        ,      p.tussenvoegsel"
				   + "        ,      p.achternaam "
				   + "        ,      r.person2_id     as partnerId"
				   + "        ,      p2.roepnaam      as partnerRoepnaam"
				   + "        ,      p2.tussenvoegsel as partnerTussenvoegsel"
				   + "        ,      p2.achternaam    as partnerAchternaam"
				   + "        from"
				   + "               person   p"
				   + "        ,      relation r "
				   + "        ,      person   p2"
				   + "        where"
				   + "               r.person1_id = p.id"
				   + "        and    r.partner    = true"
				   + "        and    p.geslacht   = 'man'"
				   + "        and    p2.id        = r.person2_id"
				   + "       ) as s "
				   + "left join"
				   + "       relation r "
				   + "on"
				   + "       ("
				   + "           r.person1_id = s.id"
				   + "        or r.person1_id = s.partnerId"
				   + "       ) "
				   + "and    r.relatietype = 'Is kind van' "
				   + "where  r.id is null";
		System.out.println("DAO");
		List<Stamboom> stamboom = em.createNativeQuery(sql, Stamboom.class).getResultList();
/*
		BigInteger hulp = (BigInteger) em.createNativeQuery(sql).getSingleResult();
		System.out.println(hulp);
		Long result = hulp.longValue();
		System.out.println(result);
*/
		return stamboom;
	}
	
	public List<Long> getKinderen(Long ouder) {
		String sql = "select r.person1_id from relation r where r.person2_id = "
				   + ouder
				   + " and r.relatietype = 'Is kind van'";
		List<BigInteger> hulp = (List<BigInteger>) em.createNativeQuery(sql).getResultList();
		List<Long> result = new ArrayList<Long>();
		Long waarde;
		for (BigInteger id : hulp) {
			waarde = id.longValue();
			result.add(waarde);
		}
		for (Long id : result) {
			System.out.println(id);
		}
		return result;
	}

}
