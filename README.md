# Introduction

Java-based on-screen display (OSD) for keyboard and mouse events.

This program displays keyboard and mouse events for the purpose of screencasting. While such software already exists, none meet all the following criteria:

* custom display size;
* easily positioned;
* show single events;
* show all mouse clicks;
* show scrolling;
* accurate modifier key states; and
* works with emulation software (e.g., [Sikuli](http://sikulix.com/)).

## Alternatives

* [QKeysOnScreen](https://github.com/ctrlcctrlv/QKeysOnScreen)
* [screenkey](https://www.thregr.org/~wavexx/software/screenkey)

# Comparison

The following video compares KmCaster to [key-mon](https://github.com/critiqjo/key-mon):

![KmCaster Demo](images/kmcaster-01.gif "Comparison Video")

# Requirements

[OpenJDK](https://bell-sw.com/pages/downloads/#/java-14-current) version 14.0.1 or newer.

## Linux Java Version

Depending on the Linux distribution, Java 14 can be installed by issuing one of the following commands in a terminal:

```
sudo apt install openjdk-14-jdk
sudo pacman -S jdk-openjdk
```

Switching from earlier versions of Java to Java 14 can be accomplished by issuing one of the following commands in a terminal:

```
sudo update-alternatives --config java
sudo archlinux-java set java-14-openjdk
```

Note: on some Linux operating systems you may need to add a repository.
On Ubuntu 18.04 run the following commands before trying to install Java 15, for example ([source](http://ubuntuhandbook.org/index.php/2020/03/install-oracle-java-14-ubuntu-18-04-20-04/)):

```
sudo add-apt-repository ppa:linuxuprising/java
sudo apt install openjdk-15-jdk
```



# Download

Download the latest Java Archive file:

[Download](https://gitreleases.dev/gh/DaveJarvis/kmcaster/latest/kmcaster.jar)

Linux easy installation:

[![Download On Flathub](https://flathub.org/assets/badges/flathub-badge-en.png)](https://flathub.org/apps/details/com.whitemagicsoftware.kmcaster)

# Running

After installing Java, run the program as follows:

``` bash
java -jar kmcaster.jar
```

To see the configuration options, run the program as follows:

``` bash
java -jar kmcaster.jar -h
```

To quit the application:

1. Click the application to give it focus.
1. Press `Alt+F4` to exit.

## Error Messages

Java version 14 is required; earlier versions will display the following
message:

> Error: A JNI error has occurred, please check your installation and try again.

