package dao;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StamboomDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Long getFamilieOudste() {
		String sql = "select "
				   + "       s.persoon_id "
				   + "from "
				   + "       ("
				   + "        select "
				   + "               p.id         as persoon_id"
				   + "        ,      r.person2_id as partner_id"
				   + "        from"
				   + "               person   p"
				   + "        ,      relation r "
				   + "        where"
				   + "               r.person1_id = p.id"
				   + "        and    r.partner    = true"
				   + "        and    p.geslacht   = 'man'"
				   + "       ) as s "
				   + "left join"
				   + "       relation r "
				   + "on"
				   + "       ("
				   + "           r.person1_id = s.persoon_id"
				   + "        or r.person1_id = s.partner_id"
				   + "       ) "
				   + "and    r.relatietype = 'Is kind van' "
				   + "where  r.id is null";
		System.out.println("DAO");
		BigInteger hulp = (BigInteger) em.createNativeQuery(sql).getSingleResult();
		System.out.println(hulp);
		Long result = hulp.longValue();
		System.out.println(result);
		return result;
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
