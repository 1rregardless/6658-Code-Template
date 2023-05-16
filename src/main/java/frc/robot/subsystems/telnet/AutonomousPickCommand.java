// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.telnet;

import java.util.HashMap;

import com.khubla.telnet.TelnetException;
import com.khubla.telnet.nvt.NVT;
import com.khubla.telnet.shell.command.AbstractCommand;

/** Add your docs here. */


public class AutonomousPickCommand extends AbstractCommand{
    String[] names = {"auton", "autonomous", "set_autonomous", "set_auton"};
    int autonValue;

    public AutonomousPickCommand (int defaultVal, String name, String functions) {
        autonValue = defaultVal;
        HelpCommand.addInfo(name, functions);
        ConfigCommandRegistry.currentRegistry.addCommand(this);

    }
    
    @Override
    public boolean execute(NVT nvt, String line, HashMap<String, Object> sessionParameters) throws TelnetException {
        autonValue = Integer.parseInt(line);;
        return true;
    }

    @Override
    public String[] getNames() {
        return names;
    }

    public int getAutonomous () {
        return autonValue;

    }

}
