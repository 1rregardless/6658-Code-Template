// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.telnet;

import com.khubla.telnet.shell.basic.command.QuitCommand;
import com.khubla.telnet.shell.command.AbstractTelnetCommandRegistry;

import frc.robot.subsystems.ModePicker;

/** Add your docs here. */
public class ConfigCommandRegistry extends AbstractTelnetCommandRegistry {
    public static ConfigCommandRegistry currentRegistry = new ConfigCommandRegistry();
    public ConfigCommandRegistry () {
        addCommand(new QuitCommand());
    
        
    }

}
