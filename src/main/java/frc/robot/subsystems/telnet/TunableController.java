// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.telnet;

import java.text.DecimalFormat;
import java.util.HashMap;

import com.khubla.telnet.TelnetException;
import com.khubla.telnet.shell.command.AbstractCommand;
import com.khubla.telnet.nvt.*;

import edu.wpi.first.wpilibj.PIDController;

enum PIDConstant {
    Position,
    Integral,
    Derivative,

}

/** Add your docs here. */
class TuneCommand extends AbstractCommand {
    private String[] names = new String[3];
    private PIDConstant type;
    private TunableController parent;

    public TuneCommand (String name, TunableController p, PIDConstant t) {
        names[0] = name;
        parent = p;
        type = t;


    }
    @Override
    public boolean execute(NVT nvt, String line, HashMap<String, Object> parameters) throws TelnetException {
        switch (type) {
            case Position:
                try { parent.setP(DecimalFormat.getNumberInstance().parse(line).doubleValue()); } catch(Exception e) {e.printStackTrace();}
            case Integral:
                 try { parent.setI(DecimalFormat.getNumberInstance().parse(line).doubleValue()); } catch(Exception e) {e.printStackTrace();}
            case Derivative:
                try { parent.setD(DecimalFormat.getNumberInstance().parse(line).doubleValue()); } catch(Exception e) {e.printStackTrace();} 
        } 
        return true;
    }
    @Override
    public String[] getNames() {
        return names;

    }

}

public class TunableController extends edu.wpi.first.wpilibj.controller.PIDController {
    private TuneCommand[] commands = new TuneCommand[3];
    public TunableController(double kP, double kI, double kD, String name) {
        super(kP, kI, kD);
        commands[0] = new TuneCommand(name + "P", this, PIDConstant.Position);
        commands[1] = new TuneCommand(name + "I", this, PIDConstant.Integral);
        commands[2] = new TuneCommand(name + "D", this, PIDConstant.Derivative);
        for (TuneCommand command : commands) {
            ConfigCommandRegistry.currentRegistry.addCommand(command);

        }

    }
}
