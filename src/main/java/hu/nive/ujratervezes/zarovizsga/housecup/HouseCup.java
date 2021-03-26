package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String house) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT points_earned FROM house_points WHERE house_name = ?");
        ) {
            stmt.setString(1, house);
            return sumPoints(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot select!", sqle);
        }
    }

    private int sumPoints(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            int sum = 0;
            while (rs.next()) {
                sum += rs.getInt("points_earned");
            }
            return sum;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot select!", sqle);
        }
    }
}
