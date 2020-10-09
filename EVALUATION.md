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

The results of extraction must not be upload on remote server. We have add the folder which contains the results of extarction in the ".gitignore"
The CSV files must be the same when we extract tables from html or wikitext. So, there are no reason to have two witness files : one for csv from html and one for wikitext. Only one witness file should be useful to test both extracted files. 


**JUNIT Tests**

## Tests results

| Test name | Final Result |
|:------:|-----|
| **BenchTest**	| |
| testBenchExtractors | OK |
| **TestWikiUrl**	| |
| testChineseUrl	| OK	|
| testValidUrl	| OK|
| testInvalidUrl	| OK	|
| testNullUrl	| OK	|
| testEmptyUrl | OK |
| **TestParserComparaison**	| |
| testCompareNbTabHTML | Failed => Assertion Error : <ul><li>Expected : 100 </li> <li>Actual : 80 |
| testCompareNbTabWikiText |Failed => Assertion Error : <ul><li>Expected : 100 </li> <li>Actual : 59 </li></ul> |
| **TestParserHTML**	| |
| testParseHtml | OK |
| testParseHtmlTree | OK |
| testGetTablesFromPage2 | OK |
| testGetTablesFromPage3 | OK |
| testEscapeComasAndQuotes | OK |
| testGetRowsFromTable | OK |
| testGetCellsFromRow | OK |
| testEscapeComasAndQuotes | OK |
| **TestParserWikiText**	| |
| testParseWikiTextNoTab | OK |
| testParseWikiTextNotWikitable | OK |
| testParseWikiText1Tab | OK |
| testParseWikiText8Tab | OK |
| testParseWikiTextNbLign1 | OK |
| testParseWikiTextNbLign2| OK |
| testParseWikiTextNbLign3 | OK |
| testParseWikiTextNbLign4 | OK |
| testParseWikiTextNbLign5 | OK |
| testParseWikiTextNbLign6 | OK |
| testParseWikiTextNbCell1 | OK |
| testParseWikiTextNbCell2 | OK |
| testParseWikiTextNbCell3 | OK |
| testParseWikiTextNbCell4 | OK |
| testParseWikiTextNbCell5 | OK |
| testParseWikiTextNbCell6 | OK |
| **TestProcessWikiUrl**	| |
| testAddWikiUrlFromFileValid | OK |
| testAddWikiUrlFromFileInvalid | OK |
| testAddWikiUrl | OK|
| testAddWikiUrlInvalid | OK |
| testParseHTML | OK |
| testParseWikiText | OK |
| **TestConverter**	| |
| testFileIsCreated | OK  |
| testCheckNbRows| OK  |
| testCheckNbColumn| Failed => Assertion Error : <ul><li>Expected : 2726 </li> <li>Actual : 2614 </li></ul>  |
| testCsvValid | Failed => Assertion Error : <ul><li>Expected : 2726 </li> <li>Actual : 1862 </li></ul>|
| **TestCSVTemoin**	| |
| testTemoinOneHtml  | OK |
| testTemoinTwoHtml  | OK |
| testTemoinTreeHtml | OK |
| testTemoinFourHtml | OK |
| testTemoinFiveHtml | OK |
| testTemoinSixHtml  | OK |
| testTemoinOneWikiText  | OK |
| testTemoinTreeWikiText | OK |
| testTemoinFourWikiText | OK |
| testTemoinFiveWikiText | OK |
| testTemoinSixWikiText  | OK |
  | **TestTable**	| |
| testGetTitleHtml | OK |
| testGetExtractionTypeHtml | OK |
| testGetNumTabHtml | OK |
| testGetTitleWikiText | OK |
| testGetExtractionTypeWikiText | OK |
| testGetNumTabWikiText | OK |
| testGetContentHtml | OK |
| testGetContentWikitext | OK |

***TestCSVTemoin Failed => Generated file does not correspond expected file**
  - The tests failed because the wikipedia pages where tables are extracted has been updated. So the whitness files was not up to date.
  -Under windows, in addition to the errors announced above, we also note the problem of special characters which are replaced by question marks in the extracted files 
  
