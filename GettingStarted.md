#SW Team member's instructions for setting up their development environment.

# Introduction #

This page provides general FRC setup instructions, plus team-specific setup steps.


# General Setup #
[2014 FRC Technical Resources Reference](http://wpilib.screenstepslive.com/s/3120/m/7885)
[2015 Java Programming Tech Refs](http://wpilib.screenstepslive.com/s/4485/m/13809)
## Install Java/Netbeans Bundle ##
  * You can install the latest Java JDK and Netbeans as a bundle from [HERE](http://www.oracle.com/technetwork/java/javase/downloads/jdk-7-netbeans-download-432126.html).
  * [Linux install instructions](LinuxInstallInstructions.md)
  * [Windows install instructions](WindowsInstallInstructions.md)
## Install NetBeans ##
_Need to fill this section out as someone installs JDK and Netbeans individually._
## Add FRC Plugins ##
  1. Open Netbeans
  1. Select Tools->Plugins from the top menu bar
  1. Select the Settings tab
  1. Hit the Add button
  1. Enter a name for the FRC plugin repository such as "FRC Plugins"
  1. Enter the URL for the service: http://first.wpi.edu/FRC/java/netbeans/update/Release/updates.xml
  1. Hit the OK button
  1. Select the Available Plugins tab. Now the FRC plugins should listed.
  1. Select the 6 listed plugins whose names begin with "FRC".
  1. Select the Install button and follow prompts.
  1. After the plugins have installed, set the Team number. In Netbeans,  goto the **Tools->Options** from the menu. Then select the **Miscellaneous**  tab and **FRC Configuration** subtab in the Options popup window. Set the team number to 2421 hit the OK button.
# Team Repository Setup #
The Subversion (SVN) client plugin was installed as part of Netbeans. This is the protocol we will use to access the team's source code repository in [Google Code](http://code.google.com/p/rtr-team-robotics/).

[SVNConnectingFromNetbeans](SVNConnectingFromNetbeans.md) follow these instructions to connect and checkout the team projects.

You can also connect via a command line client as well as clients that integrate with your file browsers. [See here for more details.](SVNBasics.md)