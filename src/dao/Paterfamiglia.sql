select
       s.persoon_id
from
       (
        select
               p.id         as persoon_id
        ,      r.person2_id as partner_id
        from
               person   p
        ,      relation r
        where
               r.person1_id = p.id
        and    r.partner    = true
        and    p.geslacht   = 'man'
       ) as s
left join
       relation r
on
       (r.person1_id = s.persoon_id or r.person1_id = s.partner_id)
and    r.relatietype = 'Is kind van'
where  r.id is null
;
