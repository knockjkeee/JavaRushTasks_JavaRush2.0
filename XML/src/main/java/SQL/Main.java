package SQL;

        public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/Test";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
            System.out.println("We`re connected");

            Statement statement = connection.createStatement();
//            statement.executeUpdate("DROP TABLE Bookss");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            statement.executeUpdate("INSERT INTO  Books (name) VALUE('Inferno')");
            statement.executeUpdate("INSERT INTO Books SET NAME = 'Solomon Key'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");

            while (resultSet.next()) {
                System.out.print (resultSet.getInt(1) + " ");
                System.out.println(resultSet.getString(2));
            }

        }
    }
}
