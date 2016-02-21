
package org.usfirst.frc.team3603.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3603.robot.commands.ExampleCommand;
import org.usfirst.frc.team3603.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}


/**
* SAMPLE CODE FROM TEAM 5505
*/

package org.usfirst.frc.team3603.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
    RobotDrive Rando;
    Joystick XboxController;
    DoubleSolenoid DoubleSolenoid;
    Solenoid Solenoid;
    TalonSRX Motor1;
    TalonSRX Motor2;
    TalonSRX Motor3;
    TalonSRX Motor4;
    TalonSRX Motor5;

    public Robot() {
        Rando = new RobotDrive (0, 1);
        Rando.setExpiration(0.1);
        XboxController = new Joystick (0);
        DoubleSolenoid = new DoubleSolenoid (1,2);
        Solenoid = new Solenoid (1);
        Motor1 = new TalonSRX (2);
        Motor2 = new TalonSRX (3);
        Motor3 = new TalonSRX (4);
        Motor4 = new TalonSRX (5);
        Motor5 = new TalonSRX (6);
    }
    
    public void robotInit() {

    }
    
    public void autonomous() {
    
        
    }

    public void operatorControl() {
        Rando.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            Rando.tankDrive(XboxController.getRawAxis(1), XboxController.getRawAxis(5));
            
            if(XboxController.getRawButton(/*Insert Button #*/)) {
            	Motor1.set(1);
            }
            if(XboxController.getRawButton(/*Insert Button #*/)) {
            	Motor2.set(1);
            }
            if(XboxController.getRawButton(/*Insert Button #*/)) {
            	Motor3.set(1);
            }
            if(XboxController.getRawButton(/*Insert Button #*/)) {
            	Motor4.set(1);
            }
            if(XboxController.getRawButton(/*Insert Button #*/)) {
            	Motor5.set(1);
            }
            
            
            if(XboxController.getRawButton(/*Insert BUtton #*/)) {
            	Solenoid.set(true);
            }
            else if(XboxController.getRawButton(/*Insert Button #*/)) {
            	Solenoid.set(false);
            }
            
            if(XboxController.getRawButton(/*Insert BUtton #*/)) {
            	DoubleSolenoid.set(DoubleSolenoid.Value.kOff);
            }
            else if(XboxController.getRawButton(/*Insert Button #*/)) {
            	DoubleSolenoid.set(DoubleSolenoid.Value.kOn);
            }
            // If you want a motor to be controlled  by a trigger, you can do:
            /* Motor2.set(XboxController.getRawAxis(Insert Axis #); */
        	
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}