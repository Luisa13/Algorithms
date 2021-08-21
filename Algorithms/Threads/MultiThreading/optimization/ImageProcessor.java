package MultiThreading.optimization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * 
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class ImageProcessor {
	private static final String SOURCE_IMG = "Algorithms/resources/img/";
	private static final String OUTPUT_IMG = "Algorithms/resources/output/violetFlowerImageProcessing.jpg";

	public static void main(String[] args) {
		try {
			BufferedImage originalImage = ImageIO.read(new File(SOURCE_IMG));
			BufferedImage resultImage = new BufferedImage(originalImage.getHeight(), originalImage.getWidth(),
					BufferedImage.TYPE_INT_RGB);
			
			recolorImage(originalImage, resultImage);
			
			File outputImage = new File(OUTPUT_IMG);
			ImageIO.write(resultImage, "jpg", outputImage);
			
		} catch (IOException e) {
			System.out.print("An error took place trying to open the image: " + e.getMessage());
		}

	}
	
	
	/**
	 * Changes the color of all the gray shaded pixels of an image to violet. 
	 * Single Thread process.
	 * 
	 * @param BufferedImage Original image
	 * @param BufferedImage Resulting image
	 * */
	public static void recolorImage(BufferedImage imageIn, BufferedImage imageOut) {
		recolorImage(imageIn, imageOut, 0, 0, imageIn.getHeight(), imageIn.getWidth());
	}
	
	/**
	 * Changes the color of all the gray shaded pixels of an image to violet.
	 * 
	 * @param BufferedImage Original image
	 * @param BufferedImage Resulting image
	 * @param int 			First column of all the pixels within the image
	 * @param int 			Top row of all the pixels within the image
	 * @param int 			Height of the image
	 * @param int 			Width of the image
	 * */
	public static void recolorImage(BufferedImage imageIn, BufferedImage imageOut, int xTop, int yTop, int height, int width) {

		for(int x = xTop; x < yTop + width && x < imageIn.getWidth(); x++) {
			for(int y = yTop; y < xTop + height && y < imageIn.getHeight(); y++) {
				recolorPixel(imageIn, imageOut, x, y);
			}
		}
	}

	/**
	 * Changes the color of a gray shaded pixel to violet. For that purpose, it
	 * reduces the green value significantly.
	 * 
	 * @param BufferedImage Original image to be changed.
	 * 
	 * @param BufferedImage Resulting image with the changes applied.
	 * @param int           X value of the pixel
	 * @param int           Y value of the pixel
	 */
	public static void recolorPixel(BufferedImage imageIn, BufferedImage imageOut, int x, int y) {
		int rgb = imageIn.getRGB(x, y);
		int red = getRed(rgb);
		int blue = getBlue(rgb);
		int green = getGreen(rgb);

		int newRed = red;
		int newBlue = blue;
		int newGreen = green;

		if (isShadeOfGray(red, blue, green)) {
			newRed = Math.min(255, red + 10);
			newBlue = Math.max(0, blue - 20);
			newGreen = Math.max(0, green - 80);

		}

		int newRGB = getRBGFromColor(newRed, newBlue, newGreen);
		setRGB(imageOut, x, y, newRGB);
	}

	/**
	 * 
	 * */
	public static void setRGB(BufferedImage image, int x, int y, int rgb) {
		image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
	}

	/**
	 * Returns true if the mix of the colors in the parameters is a shade of grey.
	 * To do so, it checks if all the three color channels has the same color
	 * intensity.
	 * 
	 * @param int Value corresponding to red color
	 * @param int Value corresponding to blue color
	 * @param int Value corresponding to green color
	 * @return boolean
	 */
	public static boolean isShadeOfGray(int red, int blue, int green) {
		int distance = 30;

		return Math.abs(red - green) < distance && Math.abs(red - blue) < distance && Math.abs(green - blue) < distance;
	}

	/**
	 * Returns the integer value corresponding to a RGB pixel, from the three
	 * different colors.
	 * 
	 * @param int Value corresponding to red color
	 * @param int Value corresponding to blue color
	 * @param int Value corresponding to green color
	 * @return int
	 */
	public static int getRBGFromColor(int red, int blue, int green) {
		int rgb = 0;

		rgb |= blue;
		rgb |= green << 8;
		rgb |= red << 16;

		return rgb;
	}

	/**
	 * Get the red value from a rgb value
	 * @param int RGB value
	 * @return int
	 * */
	public static int getRed(int rgb) {
		return (rgb & 0x00FF0000) >> 16;
	}
	
	/**
	 * Get the red value from a blue value
	 * @param int RGB value
	 * @return int
	 * */
	public static int getBlue(int rgb) {
		return (rgb & 0x0000FF00) >> 8;
	}
	
	/**
	 * Get the red value from a green value
	 * @param int RGB value
	 * @return int
	 * */
	public static int getGreen(int rgb) {
		return rgb & 0x000000FF;
	}

}
