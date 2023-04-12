// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.telnet;

import java.io.IOException;

import com.khubla.telnet.auth.AuthenticationHandler;
import com.khubla.telnet.shell.command.CommandOrientedShellImpl;
import com.khubla.telnet.shell.command.TelnetCommand;
import com.khubla.telnet.shell.command.TelnetCommandRegistry;
import com.khubla.telnet.nvt.NVT;

/** Add your docs here. */
public class ConfigShell extends CommandOrientedShellImpl {
    public ConfigShell (NVT nvt, TelnetCommandRegistry reg, AuthenticationHandler handler) {
        super(nvt, reg, handler);


    }
    @Override
    public void onConnect() throws IOException {
        //getNvt().getNvtStream().writeln("Welcome to the 6658 Robot Configuration Shell.");

    }
    @Override
    public void onDisconnect () {


    }



 }
