// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.telnet;

import com.khubla.telnet.nvt.NVT;
import com.khubla.telnet.nvt.spy.NVTSpy;
import com.khubla.telnet.nvt.spy.impl.LoggingNVTSpyImpl;
import com.khubla.telnet.shell.Shell;
import com.khubla.telnet.shell.ShellFactory;

/** Add your docs here. */
public class ConfigShellFactory implements ShellFactory {
    @Override
    public Shell createShell (NVT nvt) {
        return new ConfigShell(nvt, ConfigCommandRegistry.currentRegistry, null);
    }
    @Override
    public NVTSpy getNVTSpy() {
        return new LoggingNVTSpyImpl();

    }

}
