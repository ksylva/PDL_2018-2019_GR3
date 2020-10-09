## INSTALL.md

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

## DESIGN.md

The results of extraction must not be upload on remote server. We have add the folder which contains the results of extarction in the ".gitignore"
The CSV files must be the same when we extract tables from html or wikitext. So, there are no reason to have two witness files : one for csv from html and one for wikitext. Only one witness file should be useful to test both extracted files. 
The number of errors differs depending on the operating system.


## JUNIT Tests

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
| testParseWikiTextNbLign4 | Failed => Assertion Error : <ul><li>Expected : 6 </li> <li>Actual : 0 </li></ul>  |
| testParseWikiTextNbLign5 | OK |
| testParseWikiTextNbLign6 | OK |
| testParseWikiTextNbCell1 | OK |
| testParseWikiTextNbCell2 | OK |
| testParseWikiTextNbCell3 | OK |
| testParseWikiTextNbCell4 | Failed => Assertion Error : <ul><li>Expected : 114 </li> <li>Actual : 0 </li></ul>  |
| testParseWikiTextNbCell5 | Failed => Assertion Error : <ul><li>Expected : 91 </li> <li>Actual : 0 </li></ul>  |
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
| testCheckNbRows| Failed => Assertion Error : <ul><li>Expected : 2709 </li> <li>Actual : 2683 </li></ul>  |
| testCheckNbColumn| Failed => Assertion Error : <ul><li>Expected : 2726 </li> <li>Actual : 2629 </li></ul>  |
| testCsvValid | Failed => Assertion Error : <ul><li>Expected : 2709 </li> <li>Actual : 1976 </li></ul>|
| **TestCSVTemoin**	| |
| testTemoinOneHtml  | Failed => Generated file does not correspond expected file |
| testTemoinTwoHtml  | Failed => Generated file does not correspond expected file |
| testTemoinTreeHtml | Failed => Generated file does not correspond expected file |
| testTemoinFourHtml | Failed => Generated file does not correspond expected file |
| testTemoinFiveHtml | Failed => Generated file does not correspond expected file |
| testTemoinSixHtml  | Failed => Generated file does not correspond expected file |
| testTemoinOneWikiText  | Failed => Generated file does not correspond expected file |
| testTemoinThreeWikiText | OK |
| testTemoinFourWikiText | Failed => Generated file does not correspond expected file |
| testTemoinFiveWikiText | Failed => Generated file does not correspond expected file |
| testTemoinSixWikiText  | Failed => Generated file does not correspond expected file |
  | **TestTable**	| |
| testGetTitleHtml | OK |
| testGetExtractionTypeHtml | OK |
| testGetNumTabHtml | OK |
| testGetTitleWikiText | OK |
| testGetExtractionTypeWikiText | OK |
| testGetNumTabWikiText | OK |
| testGetContentHtml | OK |
| testGetContentWikitext | OK |

**TestCSVTemoin Failed => Generated file does not correspond expected file**
  - The tests failed because the wikipedia pages where tables are extracted has been updated. So the whitness files was not up to date.
  - Under windows, in addition to the errors announced above, we also note the problem of special characters which are replaced by question marks in the extracted files 

**TestConverter => AssertionError : mismatch between what we expected and what we have**

There were 4 tests to be done. The result is estimated at 25% of success and 75% of failures.
The causes of the bugs were :

  - When we have a table with merged rows or columns we extract it as it is designed, then in this case it is not efficient to make a comparison between the    number of rows and columns of this table with its CSV format because for the conversion to CSV, collspans and rowspans are replaced by empty cells. So that comparison will alway return an error.
    
  - There is the ParserWikitext which has regular expressions allowing to capture separators, but, they do not capture all the cases which generates the 
    incompatibility  between the extracted table and its csv format.
    
The proposed resolution is that when you get the number of columns or rows of the table, you have to get the maximum among the columns/rows and you try to do the same for the csv in order to make the right comparisons.
And for ParserWikiText we're still looking for an improvement of regular expressions that will allow us to capture all cases.

  
  
