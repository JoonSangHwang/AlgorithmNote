package com.junsang._20210417_네이버.Problem;

public class _3_Third {


//    SELECT ret.*
//    FROM   (SELECT p.id,
//            p.title,
//            Coalesce(r.reserved_tickets, 0) AS reserved_tickets
//    FROM   plays p
//    left outer join (SELECT play_id,
//                     SUM(number_of_tickets) AS reserved_tickets
//    FROM   reservations
//    GROUP  BY play_id) AS r
//    ON ( p.id = r.play_id )) ret
//    ORDER  BY ret.reserved_tickets DESC, ret.id ASC

}
