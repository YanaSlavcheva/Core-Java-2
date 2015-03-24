import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ConvertToGrayscale {
    public static void main(String args[]) throws IOException {
        BufferedImage coloredImage = null;
        File inputFile = null;

        try {
            inputFile = new File("W:\\_HackBulgaria\\JavaCoreV2.0\\TestFolderForListingFiles\\apply.jpg");
            coloredImage = ImageIO.read(inputFile);
        } catch(IOException e) {
            System.out.println(e);
        }

        int width = coloredImage.getWidth();
        int height = coloredImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = coloredImage.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int avg = (r + g + b) / 3;

                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                coloredImage.setRGB(x, y, p);
            }
        }

        try{
            inputFile = new File("W:\\_HackBulgaria\\JavaCoreV2.0\\TestFolderForListingFiles\\applyGrayscale2.jpg");
            ImageIO.write(coloredImage, "jpg", inputFile);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}