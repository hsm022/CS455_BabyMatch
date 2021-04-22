
<img src="app/src/main/res/mipmap-xxxhdpi/ic_baby_round.png" align="right" />

# Baby Match
Baby Match is an android application that I built as a final project for my CS455 course. The application is built by Harpinder Minhas (myself). Baby Match is a memory game application. A grid of cards is shown to the player. Each card in the grid contains a photo of a baby on its flip side.
The player flips cards one by one and tries to match the photos of babies within the alloted time.

## System Requirements
Baby Match runs on devices with Android Operating System. The minimum SDK version required for this application is SDK version 22. The application will run on any android phone or tablet that has SDK version 22 or higher.
According to Android Studio more than 92% of all android phones that are connected to the Google Play Store are capable of running Baby Match.
Anyone running Android Operating System 5.1 (Android Lollipop) or higher on their device can install the application.

## Installation Instructions
The application is not available on the Google Play Store therefore the user must install the application through a manual method.
The android application pacakage(APK) installation file for this application can be downloaded from the following link:

[Download Baby Match Application](https://drive.google.com/drive/folders/1P4EVQJOAUf1mq2EG9dGYuEnfTw5EU_mj?usp=sharing)

**Following are step by step instructions on how to install Baby Match on your phone:**
- #### Allow installation of unknown applications
  By default, installing unknown apps are not allowed to be installed on android phones because of security reasons.
  You will need to allow an application such as a browser to download and initiate the installation of unknown apps in order to successfully install Baby Match on your phone.
  The following steps were completed on a Samsung phone running Android 10 but these steps should be similar on other devices as well.
  
  * Go to Settings and click on Biometrics and security.
    
    <img src="images/settings.jpg" height="500" />
  
  * Click on Install unkown apps.

    <img src="images/security.jpg" height="500" />
    
  * Select the browser you will be using to download the APK installation file. For example: Samsung Internet.
    
    <img src="images/browser.jpg" height="500" />
    
  * Click on Allow from this source to enable installtion of unknown applications from the selceted browser.
    
    <img src="images/allow app.jpg" height="250" />
    
- #### Download and Install the APK installation file.
  Now you need to use the same browser to download the APK installation file.
  * Open the link and click on the baby_match.apk to start downloading the file.

    <img src="images/link.jpg" height="250" />
  
  * If a warning is given by Google Drive, please click Download anyway.
  
    <img src="images/acceptRisk.jpg" height="250" /> 
   
  * Once downloading is complete, open the installation file and click Install.

    <img src="images/install.jpg" height="250" />
   
  * If a warning is given by Play Store, please click INSTALL ANYWAY.
  
    <img src="images/playStoreRisk.jpg" height="250" />
  
  * The application will finish installation and you will be given an option to open the application right away or just close with the application for now. The application has been successfully installed.
   
    <img src="images/InstallationDone.jpg" height="250" />
    
## Operating/Playing Instructions
Upon opening the app, the user is greeted with a welcome screen and a few options to select before playing the game.

#### Welcome Screen
A player needs to select two things before he/she can play the game: Difficulty and Level.

There are three difficulties to choose from: Easy, Medium and Hard. Depending on the selection, the player gets a time limit to complete the round. 

There are three level to select from: One, Two and Three. Levels decide the amount of cards the player will get on a grid. Level one shows 8 cards, level two presents 12 cards and level three gives the user 16 cards.

The default values for difficulty and level are easy and one respectively. Once the play button is pressed the game begins.

<img src="images/welcome.jpg" align="center" height="300"/>

#### Game Screen
When the play button is clicked the player is shown a grid of cards and a count down timer with the amount of seconds left. All the cards initially face down waiting to be flipped. The player clicks on a card at a time to reveal a photo of a baby on the other side of the card. The player then clicks on a second card to reveal another photo. If the second card has the same photo as the first card, both the cards stay uncovered and the photos fade a little bit to indicate a match has been found, otherwise both cards go back to their original state with their photo sides facing down when the player clicks on a third card.

<img src="images/game page.jpg" align="center" height="300"/>

#### Result Screen
Once the player finds all the matches or runs out of the given time, the game ends and the player sees a message indicating if he/she won or lost.

<p float="left">
<img src="images/lost.jpg"  height="220"/>
<img src="images/won.jpg" height="220"/>
</p>
<p>
<br />The user needs to click OK to move to another screen.
</p>

#### Back to Welcome Screen
Once the player clicks OK on the result screen, he/she goes back to the welcome screen again. This time their previous selection is the default value for difficulty and level. The player can either play the same round again or choose a different difficulty or level to play a different round.

<p float="left">
<img src="images/goodJob.jpg" height="220"/>
<img src="images/tryAgain.jpg" height="220"/>
</p>

## Bug List
- #### Enlarged images
The images of babies are becoming large at the run time. A part of the face such as nose, eyes etc are shown instead of the full face of a baby. The photos are zoomed in.

- #### Pressing back button before the game ends
If the back button is pressed before the game ends and the user starts a new game. The previous activity kicks the user out when the game ends. For example: If a user starts a game and presses the back button while 20 seconds are left in the game. When the 20 seconds are up the app will force the user out of the current activity.

## Contact Information
If there are any issues with the game or troubleshooting is needed please contact me through email: hminhas11@gmail.com

## License and Copyright Information
BabyMatch is licensed under the GNU General Public License v3.0 and is available for free.

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)

## References
#### Kotlin documentation
https://kotlinlang.org/docs/android-overview.html

#### Android Studio documentation
https://developer.android.com/docs

#### Code inspiration
https://www.youtube.com/watch?v=U4Wtjewy7EY

https://www.youtube.com/watch?v=E11hTgfsJVY

#### Baby images, card image and license badge
https://i.pinimg.com/originals/18/f2/f7/18f2f7ac0a5a947ac58dc6e77f3e72cb.png

https://i.pinimg.com/originals/36/b1/e9/36b1e90a770ac7c6bdb7617358fa5a21.jpg

https://i2-prod.dailyrecord.co.uk/incoming/article9790424.ece/ALTERNATES/s1227b/Screen-Shot-2017-02-10-at-073529.png

http://clipart-library.com/clip-art/59-592317_faded-spade-100-plastic-poker-playing-cards.htm

https://img.shields.io/badge/License-GPLv3-blue.svg


