package dao;


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
				   + ",      s.partnerAchternaam"
				   + ",      0 as parentId"
				   + ",      1 as level "
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
		@SuppressWarnings("unchecked")
		List<Stamboom> stamboom = em.createNativeQuery(sql, Stamboom.class).getResultList();
		return stamboom;
	}
	
	public List<Stamboom> getKinderen(List<Stamboom> ouders) {
		StringBuilder sbOuderIds = new StringBuilder();
		for (Stamboom ouder : ouders) {
			sbOuderIds.append(ouder.getId() + " ");
		}
		Long level = ouders.get(0).getLevel() + 1;
		String ouderIds = sbOuderIds.toString().trim().replaceAll(" ", ", ");
		String sql = "select "
				   + "       p.id"
				   + ",      p.roepnaam"
				   + ",      p.tussenvoegsel"
				   + ",      p.achternaam"
				   + ",      r2.id                          as partnerId"
				   + ",      coalesce(r2.roepnaam, '')      as partnerRoepnaam"
				   + ",      coalesce(r2.tussenvoegsel, '') as partnerTussenvoegsel"
				   + ",      coalesce(r2.achternaam, '')    as partnerAchternaam"
				   + ",      r.person2_id                   as parentId"
				   + ",      " + level +                  " as level " 
				   + "from"
				   + "       person   p "
				   + "inner join"
				   + "       relation r "
				   + "on"
				   + "       r.person1_id  = p.id "
				   + "and    r.relatietype = 'Is kind van' "
				   + "and    r.person2_id  in (" + ouderIds + ") "
				   + "left join"
				   + "       ("
				   + "        select"
				   + "               r.person1_id"
				   + "        ,      r.partner"
				   + "        ,      p.id"
				   + "        ,      p.roepnaam"
				   + "        ,      p.tussenvoegsel"
				   + "        ,      p.achternaam"
				   + "        from"
				   + "               relation r"
				   + "        ,      person   p"
				   + "        where"
				   + "               p.id = r.person2_id"
				   + "       ) r2 "
				   + "on"
				   + "       r2.person1_id = p.id "
				   + "and    r2.partner    = true "
				   + "order by"
				   + "       r.person2_id "
				   + ",      p.id";
		@SuppressWarnings("unchecked")
		List<Stamboom> stamboom = em.createNativeQuery(sql, Stamboom.class).getResultList();
		return stamboom;
	}

}
