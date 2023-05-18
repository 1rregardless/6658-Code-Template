// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.telnet;

import java.io.IOException;
import java.util.ArrayList;

import com.khubla.telnet.shell.command.AbstractCommand;
import com.khubla.telnet.nvt.NVT;
import java.util.HashMap;
import com.khubla.telnet.TelnetException;

/** Add your docs here. */
class HelpInfo {
    public String name;
    public String info;

}
public class HelpCommand extends AbstractCommand{
        private static ArrayList<HelpInfo> info = new ArrayList<HelpInfo>();
        private final String [] names = { "help" };
        
        @Override
        public boolean execute(NVT nvt, String line, HashMap<String, Object> parameters) throws TelnetException {
            for (HelpInfo curInfo: info) {
                try { nvt.writeln(curInfo.name + " - " + curInfo.info); }
                catch (Exception e) { e.printStackTrace();}

            }
        return true;
        }

    @Override
    public String[] getNames() {
        return names;


    }
    public static void addInfo(String name, String inf) {
        HelpInfo newInfo = new HelpInfo();
        newInfo.name = name;
        newInfo.info = inf;
        info.add(newInfo);


    }

}
