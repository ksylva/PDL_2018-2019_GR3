**INSTALL.md**

Start by opening IntelliJ and close all opened projects. Then get the project with the HTTPS link : 
* Click "Check out from Version Control" on IntelliJ 
* Select "GitHub"
* On "Git Repository URL" put the HTTPS link of this project 
* Set your project directory and parent directory as you wish 
* Click "Clone" when you are ready 
* Open the project 
* Open the Maven panel (on the right) and click the refresh button if no project is shown in 
* Unfold the project in the Maven panel 
* In “LifeCycle” double clic on “install” to build, run and throw the tests. 

**DESIGN.md**

The results of extraction must not be upload on remote server. We have add the folder which contains the results of extarction in the .gitignore
The CSV files must be the same when we extract tables from html or wikitext. So, there are no reason to have two witness files : one for csv from html and one for wikitext. Only one witness file should be useful to test both extracted files. 


**JUNIT Tests**

***TestCSVTemoin Failed => Generated file does not correspond expected file**
  - The tests failed because the wikipedia pages where tables are extracted has been updated. So the whitness files was not up to date.
  
