# imdb-web-automation

##Prerequisites
- Install Chromedriver version 87.0.4280.xx because the chromedriver supplied in the repo is for that version
- Run on a Mac device. I don't have code that will detect a windows device as I don't have a windows machine with me. I set platform type to Mac
- Install Java on the machine to help compile and run the tests


## How To Compile
1. clone this repository
2. go to the directory - imdb-web-automation
3. ```mvn clean install -DskipTests=true```. This command with compile the project

## How To run the tests
1. To run all tests form commandline - ```mvn clean install```
2. You can alternatively import pom.xml in IntelliJ Idea or eclipse and run individual tests from there by right clicking them


## NOTES:
1. I ran into issues creating a new user because imdb showed a captcha screen
2. Even when I did a manual verification for Captcha, I was presented with a 2 FA screen
3. For top movies and watch list tests, I have used a test account I created




