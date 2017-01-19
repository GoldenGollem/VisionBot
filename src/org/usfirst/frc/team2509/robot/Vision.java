package org.usfirst.frc.team2509.robot;

import org.opencv.core.Scalar;
import org.opencv.core.Size;

public class Vision{
	public static final Scalar 
		//Thresholds values
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
	public static void processImg(){
		
	}
}