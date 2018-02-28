package SQLBLOB;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/Test";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE Books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, img BLOB, PRIMARY KEY (id))");
//            statement.executeUpdate("INSERT INTO  Books (name) VALUE('Inferno')");
//            statement.executeUpdate("INSERT INTO Books SET NAME = 'Solomon Key'");

            BufferedImage bufferedImage = ImageIO.read(new File("D:\\JavaRushHomeWork\\project\\JavaRushTasks\\JavaRushTasks\\XML\\smile.jpg"));
            Blob blob = connection.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(bufferedImage, "jpg", outputStream);
            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (name, img) VALUE (? , ?)");
            preparedStatement.setString(1, "Inferno");
            preparedStatement.setBlob(2, blob);
            preparedStatement.executeUpdate();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
            while (resultSet.next()) {
                Blob blob1 = resultSet.getBlob("img");
                BufferedImage image = ImageIO.read(blob1.getBinaryStream());
                File Output = new File("D:\\JavaRushHomeWork\\project\\JavaRushTasks\\JavaRushTasks\\XML\\saved.png");
                ImageIO.write(image, "png", Output);
            }

        }

    }
}
