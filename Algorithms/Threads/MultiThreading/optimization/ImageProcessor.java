package MultiThreading.optimization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Processes an image in order to change the color of a specific shade into another one.
 * In this case, we have replaced the gray color spectrum (white flowers in the picture) 
 * for the violet one. The example consists in two parts: the first one corresponds to the 
 * method recolorImageSingleThread which is the set up for the initial problem as a single
 * thread solution. The second one, is a multithread solution by partitioning the image into 
 * as many pieces as we have threads. 
 * It can be observed the amount of time a single thread approach takes in comparison with the 
 * multithread solution showing that the last one, is more efficient.
 * 
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class ImageProcessor {
	private static final String SOURCE_IMG = "./resources/img/many-flowers.jpg";
	private static final String OUTPUT_IMG = "./resources/output/violetFlowerImageProcessing.jpg";

	public static void main(String[] args) {
		try {
			BufferedImage originalImage = ImageIO.read(new File(SOURCE_IMG));
			BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			
			Timestamp start = new Timestamp(System.currentTimeMillis());
			//recolorImageSingleThread(originalImage, resultImage);
			recolorImageMultiThread(originalImage, resultImage, 4);
			Timestamp end = new Timestamp(System.currentTimeMillis());
			System.out.println("Total amount of time: " + (end.getTime() - start.getTime()) );
			
			
			
			File outputImage = new File(OUTPUT_IMG);
			ImageIO.write(resultImage, "jpg", outputImage);
			
		} catch (IOException e) {
			System.out.println("An error took place trying to open the image: " + e.getMessage());
		}
		
		System.out.print("The process has finished! The image is at: " + OUTPUT_IMG);

	}

	
	/**
	 * Changes the color of all the gray shaded pixels of an image to violet, following 
	 * a multithread approach. To do so, it breaks down the image and run each chunk by 
	 * a single thread.  
	 * 
	 * @param BufferedImage Original image
	 * @param BufferedImage Resulting image
	 * @param int 			Number of threads
	 * */
	public static void recolorImageMultiThread(BufferedImage imageIn, BufferedImage imageOut, int numThreads)  {
		if(numThreads <= 0) {
			System.out.println("Number of threads must be above 0");
			return;
		}
		
		List<Thread> threads = new ArrayList<Thread>();
		int width = imageIn.getWidth();
		int height = imageIn.getHeight() / numThreads;
		
		for(int i = 0; i < numThreads; i++) {
			final int threadMultiplier = i;
			Thread thread = new Thread(()  ->{
				int xTop = 0;
				int yTop = height * threadMultiplier;
				recolorImage(imageIn, imageOut, xTop, yTop, height, width);
			});
			threads.add(thread);
		}
		
		for(Thread thread: threads) {
			thread.start();
		}
		
		for(Thread thread: threads) {
			try {
				thread.join();
			}catch(InterruptedException ex) {
				System.out.println("Error at joining thread " + thread.getId() + " : " + ex.getMessage());
			}
		}
	} 
	
	
	/**
	 * Changes the color of all the gray shaded pixels of an image to violet. 
	 * Single Thread process.
	 * 
	 * @param BufferedImage Original image
	 * @param BufferedImage Resulting image
	 * */
	public static void recolorImageSingleThread(BufferedImage imageIn, BufferedImage imageOut) {
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
		for(int x = xTop; x < xTop + width && x < imageIn.getWidth() ; x++) {
			for(int y = yTop; y < yTop + height && y < imageIn.getHeight(); y++) {
				recolorPixel(imageIn, imageOut, x, y);
			}
		}
	}

	/**
	 * Changes the color of a gray shaded pixel to violet. For that purpose, it
	 * reduces the green value significantly).
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
	 * Sets the RGB value to a given pixels.
	 * 
	 * @param int X coordinate
	 * @param int Y coordinate
	 * @param int RGB value to set
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
	 * 
	 * @param int RGB value
	 * @return int
	 * */
	public static int getRed(int rgb) {
		return (rgb & 0x00FF0000) >> 16;
	}
	
	/**
	 * Get the blue value from a rgb value
	 * 
	 * @param int RGB value
	 * @return int
	 * */
	public static int getBlue(int rgb) {
		return (rgb & 0x0000FF00) >> 8;
	}
	
	/**
	 * Get the green value from a rgb value
	 * 
	 * @param int RGB value
	 * @return int
	 * */
	public static int getGreen(int rgb) {
		return rgb & 0x000000FF;
	}

}
