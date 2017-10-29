#Development Manual

##Introduction
This report will guide you through the steps required to setup our Tic-Toe-Toe game, fetching and accessing the code and running the server.

##Installation steps
###Install Google Chrome
It is a requirement to have the google chrome browser installed for this project. You can do so by visiting this [site](https://www.google.com/chrome/browser/desktop/index.html).We will later use the Google Chrome driver which runs on the browser. 

###Downloading git (Windows only)
Head over to [git](https://git-scm.com/downloads) and download git. We also reccomend getting the Git-Bash command shell during the installation process.

###Clone the repository
Now go to [Our repository](https://github.com/titanicfloatnone/ticTac). Clone the repository into a new folder on your system.

###Java installation
Check your Java version by opening your bash shell/termninal and writing "Java -version". If 
If you don't have a Java development kit, go to [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and download the Java development kit.

###Install Gradle (optional)
Visit the download [site](gradle.org/install) and follow the instructions there. If you´re on Mac we reccomend using Homebrew. 
If you don't want to install gradle you can avoid it by always using the "./gradlew" script to run your gradle commands.


###Download Google Chrome driver
Install chromedriver through brew by writing "brew install chromedriver" in your shell. If that does not work, follow the instructions on the [download page for chrome driver](https://sites.google.com/a/chromium.org/chromedriver/getting-started) and add the location of your .exe file in the path of your computer.

###Build the project
At this stage you can simply write "Gradle build" in your shell while inside the project directory to build the project.

##Writing new code
###Writing
Create a new branch on git and work on your code and commit from there. Everytime you write "gradle build" all the unit tests for the project are run and the project is built locally. You can access the application on "localhost:4567" in any browser.

###Pull request
When it is time to merge your new branch with the master create a pull request on GitHub. This causes Travis to build the project on a fresh machine and generates feedback after success or failure. Selenium 
end to end tests are run on Heroku by executing "gradle selenium", this however may take up to 2 minutes. If Travis ran the project succesfully your fellow programmer can safely review and accept your pull request.

###Updating the application
After a pull request has merged with the master branch the updated application is deployed on the Heroku [server](http://mighty-brushlands-46890.herokuapp.com) automatically.





