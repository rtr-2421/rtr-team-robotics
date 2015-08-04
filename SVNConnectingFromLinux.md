# Introduction #

Directions for using command line interface to SVN, commonly used for Linux platforms. This is useful for getting around things you cannot figure out how to do using the Netbeans/Eclipse UI. Much of the information here was taken from [this page](http://data.agaric.com/subversion-client-ubuntu-anything-tortoisesvn).

# Details #
## Client Installation ##
If "which svn" returns nothing or not found, install the Subversion command line client.
```
apt-get install subversion
```
## Common Commands ##
In Subversion parlance, "checkout" means to make a copy of the repository on the local filesystem. "Commit" means to push a modification up to the repository.
```
svn checkout https://server.example.com/srv/svn/agaric myworkingcopyfolder
svn status
svn update
svn add yournewfilehere
svn add yournewdirectoryincludingfiles/
svn commit -m "I made changes.  Woohoo."
```
## Common Scenarios ##
### Copy a local project into the repository ###
  1. Create a local copy of the repository.
```
svn checkout https://rtr-team-robotics.googlecode.com/svn/ rtr-team-robotics --username barnaclekarl@gmail.com
```
  1. Change directory to the playground.
```
cd ~/RTR-SVN/rtr-team-robotics/rtr2015/playground
```
  1. Copy your project to the playground.
```
cp -r ~/eclipse_workspace/HelloWorld/ .
```
  1. Add your project to the repository
```
svn add HelloWorld/
```
  1. Commit the project to the repository
```
svn commit HelloWorld --username barnaclekarl@gmail.com
```