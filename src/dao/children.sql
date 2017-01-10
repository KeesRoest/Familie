select
       p.id
,      p.roepnaam
,      p.tussenvoegsel
,      p.achternaam
,      r2.id            as partnerId
,      r2.roepnaam      as partnerRoepnaam
,      r2.tussenvoegsel as partnerTussenvoegsel
,      r2.achternaam    as partnerAchternaam
,      r.person2_id     as parentId
from
       person   p
inner join
       relation r
on
       r.person1_id  = p.id
and    r.relatietype = 'Is kind van'
and    r.person2_id  in (1001)
left join
       (
        select
               r.person1_id
        ,      r.partner
        ,      p.id
        ,      p.roepnaam
        ,      p.tussenvoegsel
        ,      p.achternaam
        from
               relation r
        ,      person   p
        where
               p.id = r.person2_id
       ) r2
on
       r2.person1_id = p.id
and    r2.partner    = true
;

