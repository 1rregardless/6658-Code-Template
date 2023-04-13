// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.khubla.telnet.shell.command.AbstractCommand;

import frc.robot.subsystems.telnet.ConfigCommandRegistry;

import com.khubla.telnet.nvt.NVT;

import java.text.DecimalFormat;
import java.util.HashMap;
import com.khubla.telnet.TelnetException;

/** Add your docs here. */
public class ModePicker extends AbstractCommand {
    public int autonomousMode;
    private String[] name = new String[1];
    public ModePicker(String n, int defaultNum) {
        autonomousMode = defaultNum;
        name[0] = n;
        ConfigCommandRegistry.currentRegistry.addCommand(this);

    }
    @Override
    public boolean execute(NVT nvt, String line, HashMap<String, Object> parameters) throws TelnetException {
        try { DecimalFormat.getNumberInstance().parse(line).doubleValue(); } catch (Exception e) {e.printStackTrace();
        try {nvt.writeln("Invalid Number.");} catch (Exception f) {f.printStackTrace();}}
        return true;


    }
    @Override
    public String[] getNames() {
        return name;
    }

}
