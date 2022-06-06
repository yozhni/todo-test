#   todo-test

Hi! this is simple tests project Cucumber+Java.
Test will be run **on Chrome browser**

## prepare

- imstall chrome browser

### If you happily use IntelliJ IDEA: 
- just choose in menu File - > New -> Open a new project from version control 
- sync all of dependencies
- choose  in menu File -> Project structure
- navigate to SDKs and choose ‘openjdk-18’
- if  there is no ‘openjdk-18’ press ‘+’ and download 
- choose File -> Settings -> Plugins and install gherkin and cucumber plugins


### If you don't have IntelliJ IDEA, 
- don't worry it's easy to install.
- open project as described above 

### If it's not your option - there is the way:
- install maven and don’t forget about java jdk 18
- download and put project in folder

## run
All you need is just execute in IntelliJ IDEA or Command Prompt
```
mvn compile
mvn test
```
But in Command Prompt you first need to change dirrectory  to the project folder by 

``` cd <path to the project folder>```

First time compile can take quite a long time as it wil be downloading all of dependencies


## view report

after execute mvn test you'll see the link to the report

![cucumberReportLink](https://user-images.githubusercontent.com/85211615/169688236-b5880dc2-c4f0-4126-a857-d9cb1e30cfdb.png)

copy link and open in the browser

Report looks like this

![cucumberReportView](https://user-images.githubusercontent.com/85211615/169688254-424e9913-840a-455b-894a-727aafcfc3be.png)

## things to improve
- [ ] Implement Dependency Injection insted of test state
- [ ] Add browser customization
- [ ] Add test scenarios, for example: test "item(s) left", test button "Clear all completed"

