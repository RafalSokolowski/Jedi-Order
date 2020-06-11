//package pl.rav.jediorder.warrior.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import pl.rav.jediorder.warrior.Warrior;
//import pl.rav.jediorder.warrior.types.*;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class JdbcWarriorRepo implements WarriorRepo {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcWarriorRepo(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Iterable<Warrior> findAll() {
//        return jdbcTemplate.query("SELECT * FROM warrior", this::mapRowToWarrior);
//    }
//
//    @Override
//    public Warrior findById(String name) {
//        return jdbcTemplate.queryForObject("SELECT * FROM warrior WHERE name = ?", this::mapRowToWarrior, name);
//    }
//
//    @Override
//    public Warrior save(Warrior warrior) {
//        jdbcTemplate.update(
//                "INSERT INTO warrior (name, side, orderName, grade, lightsaber, strength, appearance, homeWorld, species, gender, master) " +
//                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
//                warrior.getName(),
//                warrior.getSide(),
//                warrior.getOrderName(),
//                warrior.getGrade(),
//                warrior.getLightsaber(),
//                warrior.getStrength(),
//                warrior.getAppearance(),
//                warrior.getHomeWorld(),
//                warrior.getSpecies(),
//                warrior.getGender(),
//                warrior.getMaster()
//        );
//
//        return warrior;
//    }
//
//
//    private Warrior mapRowToWarrior(ResultSet resultSet, int rows) throws SQLException {
//        return new Warrior(
//                resultSet.getString("name"),
//                Side.valueOf(resultSet.getString("side")),
//                OrderName.valueOf(resultSet.getString("orderName")),
//                Grade.valueOf(resultSet.getString("grade")),
//                Lightsaber.valueOf(resultSet.getString("lightsaber")),
//                resultSet.getInt("strength"),
//                Appearance.valueOf(resultSet.getString("appearance")),
//                Planet.valueOf(resultSet.getString("homeWorld")),
//                Species.valueOf(resultSet.getString("species")),
//                Gender.valueOf(resultSet.getString("gender")),
//                Master.valueOf(resultSet.getString("master"))
//        );
//    }
//
//}
