
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// TODO: Rework with hibernate
public class FillDatabase {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_NAME = "diplom";
    private static final String USERNAME = "diplom";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + DB_NAME;


    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement statement;

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "insert into \"Training_data\" (age,gender,education,country,ethnicity,nscore,escore,oscore,ascore,cscore,impulsive,ss,alcohol,amphetamin,amyl,benzodiazepine,caffein,canabis,chocolate,cocain,crack,ecstasy,heroin,ketamin,legal_highs,lsd,methadone,mushrooms,nicotine,semer,vsa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            statement = con.prepareStatement(sql);

            String filePath = "/home/Jasow/diplom/drug_consumption.data";

            try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath), StandardCharsets.UTF_8))) {

                // Some shit
                String rawLine;
                while ((rawLine = reader.readLine()) != null) {
                    String[] splitedLine = rawLine.split(",");

                    // Fill prepared statement parameters
                    for (int i = 1; i < 32; i++) {
                        if (i < 13) {
                            //System.out.println(splitedLine[i]);
                            statement.setDouble(i, Double.parseDouble(splitedLine[i]));
                        } else {
                            statement.setString(i, splitedLine[i]);
                        }
                    }
                    statement.executeUpdate();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
