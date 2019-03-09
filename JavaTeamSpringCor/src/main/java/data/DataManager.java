package data;

import Model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

public class DataManager {


    {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Member> getMemberList() {
        String query = "select * from javateam where active=1";

        List<Member> members = jdbcTemplate.query(query, new BeanPropertyRowMapper(Member.class));
        return members;

    }

    public List<Member> getMemberListbysector(int sectorid) {
        String query = "select * from JAVATEAM where sectorid=? and active=1";
        List<Member> members = jdbcTemplate.query(query, new Object[]{sectorid}, new BeanPropertyRowMapper(Member.class));
        return members;
    }

    public Member getMember(int MemberId) {
        String query = "select * from JAVATEAM where id=? and active=1";

        Object[] data = new Object[]{MemberId};
        Member member = jdbcTemplate.queryForObject(query, data, new BeanPropertyRowMapper<>(Member.class));
        return member;

    }

    public void addMember(Member uzv) {
        String query = "insert into JAVATEAM values(JAVATEAM_SEQ.nextval,?,?,?,?,?)";
        Object[] data = {uzv.getName(), uzv.getSurname(),new Date(uzv.getDob().getTime()), Integer.parseInt(uzv.getSectorId()), uzv.getActive()};
        jdbcTemplate.update(query, data);

    }
}
