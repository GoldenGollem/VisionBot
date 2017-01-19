/**
 * 
 * Code Inspired BY "Tower Track - FRC 3019"
 * 
 */

package org.usfirst.frc.team2509.robot;

import java.util.ArrayList;
import java.util.Iterator;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Vision{
	public static final UsbCamera 
		FrontCam = CameraServer.getInstance().startAutomaticCapture();
	public static final Scalar 
		//Thresholds values
		RED = new Scalar(0, 0, 255),
		BLUE = new Scalar(255, 0, 0),
		GREEN = new Scalar(0, 255, 0),
		BLACK = new Scalar(0,0,0),
		YELLOW = new Scalar(0, 255, 255),
		LOWER_BOUNDS = new Scalar(0,0,0), 
		UPPER_BOUNDS = new Scalar(0,0,0);
	public static final Size 
		RESIZE = new Size(320,240);
	public static final int
		BOILER_HEIGHT = 88,
		BOILER_WIDTH = 15,
		GEAR_PEG_HEIGHT =16,
		CAMERA_HEIGHT = 0;
	public static final double
		VERTICAL_FOV = 30.25,
		HORIZANTAL_FOV = 53.75,
		CAMERA_ANGLE = 15,
		CAMERA_OFFSET_FRONT = 0,
		CAMERA_OFFSET_CENTER = 0;
	public static final Mat
		matOriginal = new Mat(),
		matHSV = new Mat(),		
		matThresh = new Mat(),
		matHeirarchy = new Mat(),
		clusters = new Mat();
	public static final VideoCapture
		vidCapture = new VideoCapture();
	public static void processImg(){

		ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		
		
		double x,y,targetX,targetY,distance,azimuth;
		int FrameCount = 0;
		long before = System.currentTimeMillis();
		while(FrameCount <5){
			contours.clear();
			vidCapture.read(matOriginal);
			Imgproc.cvtColor(matOriginal, matHSV, Imgproc.COLOR_BGR2HSV);
			Core.inRange(matHSV, LOWER_BOUNDS, UPPER_BOUNDS, matThresh);
			Imgproc.findContours(matThresh, contours, matHeirarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
			for(MatOfPoint mop :contours){
				Rect rec = Imgproc.boundingRect(mop);
				Imgproc.rectangle(matOriginal, rec.br(), rec.tl(), RED);
			}
			for(Iterator<MatOfPoint> iterator = contours.iterator();iterator.hasNext();){
				MatOfPoint matOfPoint = (MatOfPoint) iterator.next();
				Rect rec = Imgproc.boundingRect(matOfPoint);
				if(rec.height < 15 || rec.width < 15){
					iterator.remove();
				continue;
				}
				float aspect = (float)rec.width/(float)rec.height;
				if(aspect < 1.0)
					iterator.remove();
			}
			if(contours.size() == 1){
				Rect rec = Imgproc.boundingRect(contours.get(0));
				y = rec.br().y + rec.height / 2.0;
				y= -((2 * (y / matOriginal.height())) - 1);
				distance = (GEAR_PEG_HEIGHT - CAMERA_HEIGHT) / 
						Math.tan((y * VERTICAL_FOV / 2.0 + CAMERA_ANGLE) * Math.PI / 180);
				targetX = rec.tl().x + rec.width / 2.0;
				targetX = (2 * (targetX / matOriginal.width())) - 1;
				azimuth = normalize360(targetX*HORIZANTAL_FOV /2.0 + 0);
				Point center = new Point(rec.br().x-rec.width / 2.0 - 15,rec.br().y - rec.height / 2.0);
				Point centerw = new Point(rec.br().x-rec.width / 2.0 - 15,rec.br().y - rec.height / 2.0 - 20);
				Imgproc.putText(matOriginal, ""+(int)distance, center, Core.FONT_HERSHEY_PLAIN, 1, BLACK);
				Imgproc.putText(matOriginal, ""+(int)azimuth, centerw, Core.FONT_HERSHEY_PLAIN, 1, BLACK);
			}
			
			Imgcodecs.imwrite("output.png", matOriginal);
		}
	}
	public static double normalize360(double angle){
		// Mod the angle by 360 to give a value between (0, 360]
		// Make it positive (by adding 360) if required
		return (angle < 0) ? angle % 360 + 360 : angle % 360;
	}
}