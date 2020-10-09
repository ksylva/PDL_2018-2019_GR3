# Wikipedia Matrix : The Truth (2019 - 2020)

This project is held at the University of Rennes 1, ISTIC, in Master 1 MIAGE.

## Project context

This project is a fork of « Wikipedia Matrix » started by the last group of M1 MIAGE (2018 - 2019). We have to correct it and improve it. 

### What is the project « Wikipedia Matrix » ?

The goal of "Wikipedia Matrix" is to collect and extract Wikipedia's tables. These tables are on several Wikipedia pages retrieved by their url. The content of these tables will be returned in files using CSV format.

We read and analyze two Wikipedia page formats :
* HTML
* Wikitext


## Objectives

3 expected results :
* Improvement of extractors. (source code, documentation, tests, continuous integration...)
* Tools which allow us to evaluate our extractors.
* Make the project easy to use by anyone. (with a complete and functional dataset)


## Actual functionality

The software takes a file with a list of wikipedia's pages title (taken from the page URL : with "\_" in place of " ") and process each  one to get the HTML and WikiText URL of the page.
After testing the URL: it treats all the HTML code of each page and try to extract as much table as it can in CSV and then do the same for WikiText.

Right now, the HTML treatment converts 80% of the pages correctly, and the WikiText part is at 59% of pages converted. But some tables seem too complicated to convert to CSV reliably du to different things :
- We only treat table that are marked as "class="wikitable"".
- Some page are redirected correctly in HTML, but in wikitext that give us a blanck text just telling us that the page is redirected.  But to manage thoses, it would need us to remake entierly our handling of URLs (we spot this problem too late).
- When one cell is concerned with a collspan AND a rowspan at the same time, we did not managed to convert the table the cell is in.
- For the Wikitext, the result returned is not 100% because, in wikitext, there is a particular syntax allowing to form an array. There are characters to separate cells, lines ... However, the implementation differs depending on the Wikipedia pages and the contributor. ParserWikitext has regular expressions allowing to capture separators, but, they do not capture all cases.

Note : In HTML, any link in a table is not gathered, we just keep the title linked to the link. In wikitext, we keep the link and the title. Also, for each image in a table, we gather the link of the image to put it in the concerned cell (at the place of the image).


## Functionnality to develop

Manage to parse correctly all tables by improving parsers.

Improve the software itself for it to run with better performances.


## Project license

This project is licensed under the MIT License.


## Technologies used

* Git – The distributed version-control system used.
* IntelliJ IDEA - The IDE mainly used by our crew.
* Maven - Dependency Management. 
* Jsoup - The java based HTML Parser.
* JUnit - The unit testing framework used.
* starUML and GenMyModel - UML editors. 
* Word - The document editor used to create the specifications. 


## Authors

Sylvanus KONAN, Jean-Théodore ESSOH, Mariama TAHA, Ange SIBOMANA, Bénédicte AHOUA
