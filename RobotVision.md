# Introduction #

Research, notes, design, candidate frameworks.


# Details #

## Robot Vision Architecture ##
Beside off-loading the processing burden of vision processing, there are significant logistical advantages to using an adjunct processor. This approach allows the vision code to be developed independently of the control code, permitting division of labor within the programming team. It also enables the vision processing team to work in an independent environment. i.e. As long as they have a laptop to run the code and access via the network to a web cam, they can continue to work and test.

![http://rtr-team-robotics.googlecode.com/svn/wiki/images/RobotVisionArchitecture.jpg](http://rtr-team-robotics.googlecode.com/svn/wiki/images/RobotVisionArchitecture.jpg)

## Useful Links ##

  * https://github.com/bytedeco/javacv
  * http://stackoverflow.com/questions/276292/capturing-image-from-webcam-in-java