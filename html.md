# HyperText Markup Language (HTML)
* HTML is a standard markup language.
* HTML elements tell the web browser how to display the content & describes the structure of webpage.

> Execution Process
1. Write HTML code in Text Editor.
2. Save the file with the .html or htm extension.
3. open the file in web browser.

### What is an HTML element ?
* HTML element is defined by the start tag and some content followed by an end tag.
* < start tag> content < /end tag >
* Browser does not display the tags but it uses tags to display the content present in it.


**To write COMMENTS**
~~~
<!-- comment -->
~~~

# BASIC STRUCTURE OF HTML DOCUMENT
~~~
<!DOCTYPE html>                         It is a declaration that defines it is HTML 5 document
<html>                                  It is the root element of an HTML page
   <head>                               It contains meta information about the HTML page
       <title> Page title </title>      It specifies the title for the page 
                                        (shown in browsers title bar)
    </head>
    <body>           These element defines the documents body and it is the container for all                       
                     visible contents like headings ,para, images, hyperlinks ,table etc
        <h1> first height </h1>
        <p1> paragraph </p>
    </body>
</html>
~~~

>HTML HEADINGS

* These Headings are used to display the title or subtitle on web page

~~~
Syntax : 
<h1> heading 1 </h1>
<h2> heading 2 </h2>
 "    "         "
<h6> heading 6 </h6> 
~~~

* *style* attribute in Heading (by using css property font-size)
~~~
<h1 style = "font-size :60px;"> heading 1</h1>
~~~
>HTML Paragraphs
* Paragraphs are usually block of  text.
* It always start in a new line and browser will add some **white spaces** before and after a paragraph.
*  **< p > para < /p >** 
 *It will display the content like a para if you given spaces or lines It does not consider.*

* **< pre > para < /pre >**
*pre for "pre formatted text" It will consider the spaces, lines, font. It will display as you written in the block.*

> Basic **TEXT TAGS**
~~~
 Tags :
 <b>      ..    </b>      - make bold
 <u>      ..    </u>      - add underline
 <i>      ..    </i>      - make font style to italic 
 <mark>   ..    </mark>   - make font to mark like highlighter yellow by default
 <del>    ..    </del>    - horizontal croos line on text like reduce in price, offers.
 <ins>    ..    </ins>    - new price is written here & it will underline.
 <strong> ..    </strong> - similar to b tag make bold, but text written here is important.
 <small> ..     </small> make text smaller than usual.
 <em>    ..     </em> it will emphasize the text.
 
 ~~~
 
>EMPTY TAG

* **< hr >**   *It will give an thematic break in html page ( like separating content by a horizontal line )* 
* **< br >** *this element simply breaks the current line and goto new line*
~~~
<p> hai <br> hello <hr> kudos </p>

output :
hai
hello
-----------------------
kudos
~~~

>Anchor Tag < a > . . < /a>
* Anchor defines a hyperlink, which is used to link from one page to another.

      Attributes :
      >  href (destination link is stored in it)
      >  target
            * _blank (opens in new window)
            * _self  (opens in current window)
            * _parent (opens in parent frame)
            (In a page if 2 or 3 frames exists if i click the _parent in 3 frame, It will be opened in 2nd frame) like recursive boxes.
            * _top (" " " same as above but it will be opened on the top of all screens)
      
      Link colors :
           1. link  : unvisited.
           2. hover : when mouse over a link.
           3. active :when link is active or user clicks on it.
           4. visited : after clicking 
      To create bookmarks : links used to jump to specific parts of web page.


~~~
     Synatx :
     < !DOCTYPE html>
     < html>
     < head>
       < style>
        a:link { color: green; background-color: transparent;text-decoration: none;}
        a:visited { color: pink; background-color: transparent; text-decoration: none;}
        a:hover { color: red; background-color: transparent; text-decoration: underline;}
        a:active { color: yellow;background-color: transparent;text-decoration: underline;}
        h1 { color :red }
        p { color : green}
    < /style>
    < /head>
    < body>
        <p> <a href="#c4"> Jump to 4 th chapter </p>

        < h1> heading 1 < /h1>
        < p> para < /p>
        < a href="html_images.asp" target="_blank">HTML Images< /a> 
        
        <h4 id="c4"> chapter 4</h4>
    < /body>
< /html>

~~~ 
~~~
Syntax :
1. <a href="https://www.google.com" target ="_blank"> Go to google </a>

2. <a href="anotherPage.html", target ="_blank"> another page </a>

3. <a href="https://www.google.com" target = _parent >
     <img  border="0" alt ="W3Schools" src = "logo_w3s.gif" width ="100" height="100">
   </a>
~~~

>Image Tag < img ...... >
* It is a **open tag** 
* It is used to insert the image into webpage
    ~~~
    Attributes :
    1. src  (Specifies the URL path of the image)
    2. alt  (It specifies alternate text incase if image failed to display)
    3. title (when cursor moves over it, text written in title attribute will be displayed)
    4. height (Specifies image height)
    5. width  (Specifies image width)
    6. border (Specifies border width)
    ~~~

~~~
Syntax :
<img  
    src ="Images/pen.jpg" 
    alt ="unable to display pen image"
    title ="Pen"
    height ="500"
    width ="200"
    border ="0"
>
~~~

> List tags

    > Ordered List

    * < ol > .. </ol> - ordered list (ol) tag
    * < li > .. </li> - list item (li) tag
    types of ordering : It is defined by "type" attribute of ol tag. <ol types="1">..</ol>
     1. types = "1" - Numerical 1,2,3
     2. types = "A" - Uppercase A,B,C
     3. types = "a" - lowercase a,b,c
     4. types = "I" - uppercase Roman
     5. types = "i" - lowercase Roman.

    > Unordered list
    * < ul > .. </ul> - ordered list (ol) tag
    * < li > .. </li> - list item (li) tag
    types of Ordering : using type attribute of <ul> tag
    1. "disc"
    2. "circle"
    3. "square"
    4. "none"



~~~
Syntax :
<body>
    <h1> Ordered List </h1>
    <ol type = "1"> 
            <li> HTML </li>
            <li> CSS  </li>
            <li> JavaScript </li>
    </ol>

    <hr>

    <h2> Unordered List </h2>
    <ul type = "disk">
        <li> HTML </li>
        <li> CSS  </li>
        <li> JavaScript </li>
    </ul>
</body>
~~~


~~~ 
Neested list Syntax :
<ul type = "disk">
        <li> Web Development 

            <ol type = "1"> 

                <li> Frontend
                    <ol type = "i">

                        <li> HTML 

                            <ul type = "square">
                                <li>
                                    HTML 5
                                </li> 
                            </ul>

                        </li>

                        <li> CSS </li>

                        <li> JavaScript </li>
                    </ol>
                </li>

                <li>  Backend 
                </li>
            </ol>
        </li>
<ul
output :

Their indexes follows as shown in above type attribute

Web Development
    Frontend
        HTML
            HTML 5
        CSS
        JavaScript
    Backend
~~~

> Superscript **< sup>** &  Subscript **< sub>** & **meter** 

* a < sup> 2 < /sup> b  
   Output:
   
    > a <sup> 2 </sup> + b
* log < sub> 2 < /sub> a  
   Output:
   
    > log <sub> 2 </sub>  b
* meter tag is used to diplay the progress bar
    > < meter min = "0" max ="100" value="50" > 50 percent progress < /meter>


> Table Creation
    
    *All are closed tags
    > <table> - it defines the table
      <thead> - used to  group the head content
      <th>    - used to enter the table headings row (they are by default bold by using these tag)
      <tbody> - used to group the body content
      <tr>    - used to group the row content
      <td>    - used to enter the data in it

      Order of tags usage :
         * table --> thead --> tr --> th 
                 |-->tbody --> tr --> td 


~~~
syntax :
<h1> Table Representation </h1>
        <table border = "1" align="center">
            <thead>
                <tr>
                    <th> Item </th>
                    <th> Cost </th>
                    <th> Reastaurant Name </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> Chicken Biryani </td>
                    <td> 350/- </td>
                    <td> Bawarachi </td>
                </tr>
                <tr>
                    <td> Panner Butter Masala </td>
                    <td> 150/- </td>
                    <td> Mefel </td>
                </tr>
            </tbody>
        </table>
output :

|   Item	             |  Cost 	|  Reastaurant Name|
|---------------------   |--------- | ---------        |
|   Chicken Biryani      |	 350/-	|  Bawarachi       |
|   Panner Butter Masala |	 150/-	|  Mefel           |
~~~

> Table attributes
* **bgcolor**       - used to define the background color.
* **align**         - used to align the table at left, right, center.
* **border**        - specifes the border
* **cellspacing**   - specifies the space between the adjacent cells. *default is set to 2*
* **cellpadding**   - specifies the space between the cell edge and content. *default is set to 1*
* **width**         - specifies the width of the cell
* **height**        - specifes the height of the cell

~~~
Syntax :
<table bgcolor     = "blue" 
       align       = "right" 
       border      = "1" 
       cellspacing = "4" 
       cellpadding = "8" 
       height      = "50"
       width       = "400"
>
~~~


 * **< tr> .. < /tr>** 

        Attributes :
        1. bgcolor
        2. align


    



 * **< tr> .. < /tr> or < th> .. </ th>**
    
         Attributes :
         1.bgcolor 
         2.rowspan - Represents the number of columns to span extend across
         3.colspan - Represents the number of rows to span

> Forms 
* HTML form is used to collect user input and it sent to server for processing.
* **< form> ..elements..< /form>**
* It is a like a container, it contains the radio buttons, check boxes e.t.c

    > Enter Address:< textarea name="address" row ="100" col = "200"> </ textarea>

    > < Input > Element (open tag)
    * An < input> element can be displayed in many ways, depending on the type attribute.

    ~~~
    Attributes of input element :

    <label for ="id_and_these_should_same"> Full Name </label>
    <input type ="____" name ="___" value="___" id="id_and_these_should_same">

    1. for attribute in label & id attribute in input should be same.
        * In case of radiobuttons these are very small, So user has to click very accurately on it,
          To avoid these when user clicks on "Full Name" also then the cursor will be added to the box.  
        * It enables Screen-reader access.
    2. name attribute in input element, it will return the user entered answer with this name.
        * for ex: when user enters age  18 in box and the it's name attribute assighned with "age" 
          then "age&18" will returned to database;
    3. value attribute is the default value which needs to send to the database if user doesn't enters.
        Whatever we enters it is assighned to it and send to backend.
    
    4. type has different attributes.
        
        ex: type ="text"
            1. text
            2. radiobutton
            3. button
            4. checkbox
            5. email
            6. search
            7. file
            8. hidden
            9. password
           10. number
           11. month
           12. range
           13. url
           14. time
           15. submit
           16. reset

~~~
> select Tag

    * <select> element is used to create a drop-down list.

    Attributes of select tag:
    1. name & id (value will be in option tag)
    2. autofocus - focussed by thickborder
    3. disabled - light white color displayed(non - selectable)
    4. multiple - for selecting multiple
    5. required - value compulsary
    6. size - visible options

~~~ syntax :
    <label for="cars">Choose a car:</label>
        <select name="car" id="cars">
            <optgroup label="Swedish Cars">
                <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
            </optgroup>
            <optgroup label="German Cars">
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
            </optgroup>
        </select>
        
 output : car&audi

~~~
[About forms click here](https://drive.google.com/file/d/1R-tYr46kESiygL9MwKmWceRnQ57ucxJS/view?usp=sharing)

> Block & Inline elements

* A **block-level** element always starts on *new line* and takes *full width* available also it has a top and bottom margin.
* A **Inline element** does *not starts on a new line* and takes up *as much width as necessary* and does not have any margin.
* **Note** : *Inline elements cannot contain block level elements.*

~~~ 
Block level elements :
<form>, <table>, <h1>--<h6>, <header>, <hr>, <ol>, <li>, <ul>, <p>, <pre>, <div>

Inline elements :
<a>, <br>, <button>, <em>, <img>, <input>, <label>, <map>, <script>, <select>, <span>, <strong>,<sub>, <sup>, <textarea>, <time>
~~~

> <meta .. > Tag

* Defines metadata about an HTML document. (metadata) is information about other data.
* It is always go inside the head element and these metadata will not be displayed on the webpage.
* These is used to specify *character set*, *page description*, *keywords*, *author*, *viewport* settings.

~~~
 Define Keywords for Search engines:
 <meta name="keywords" content="HTML, CSS, JavaScript">

 Define a description of your web page:
 <meta name="description" content="Free tutorial for HTML and CSS">

 Define the author of a page :
 <meta name = "author" content="harish"

 Refresh document every 30 sec
 <meta http-equip="refresh content ="30">

 Setting the viewport to make website look good.
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

 initial-scale=1.0 sets the initial zoom level when the page is first loaded by browser.

 <meta charset="UTF-8"> specifies the charcter encoding for the HTML Document.
~~~
> Quotations and Citation Elements

  * **< blockquote cite="url">** *Defines a section that is quoted from another source* **</ blockquote>** these block of code will start from right of margin.

  * **< abbr title ="..">** *Defines a abbervation for a acronym* **</ abbr>** shows the abbervation when mouse pointer over it. 
    ~~~
    <blockquote cite= "www.javaTpoint.com"> stack follows <abbr title = "LAST IN FIRST OUT">LIFO</abbr>structure</blockquote>

    o/p:
    stack follows LIFO structure
    
  * **< address>** *Used to display the address, URL, phone number etc.* **</ address>** block level element= (newline) before after,they are italic by default.
  * **< cite>**  *used to write the title for creative work* **</ cite>** they are italic by default.
  * **< bdo dir="rtl">** *This text will be written from right to left* **< /bdo>** content will display "righttoleft"->rtl
  * **< q>** *is used for short line quotation* **< /q>** By default they are "" quoted.

> style Attributes :
 ~~~
    Property          |  Value
  1.text-align        : center
  2.background-color  :  blue
    background-image  :  url(copy image address)
  3.color             :  red   (font color)
  4.font-size         : larger
  5.font-family       : "Courier New",Courier, monospace;
  6.padding-left      : 400px; -(left,right,top,bottom)
  7.margin-left       : 100px;  -(left,right,top,bottom)    
  8.border-left       : 100px;  -(left,right,top,bottom)
      border-left-color : blue;   -"     "    "    "
      border-style    : solid double dashed dotted; clock wise these effects will apply. (groove, ridge,inset,outset)
~~~

> colors

* In HTML, colors can be specifed using:

     1. **rgb** (red,green,blue) ex:        *"background:color:rgb(0,255,90);"*
     2. **hex** --> ##rrggbb ex: ##ff0099
     3. **hsl** (hue,saturation%,brightness%) ex: *hsl(0 to 360,0 to 100%, 0 to 100%)*
     4. **rgba** (red, green, blue, opacity 0 to 1)
     5. **hsla** (9, 50%, 84%, 0.5)

~~~
    <div style="background-color: rgb(0,255,90);"> I have coloured using rgb</div>
    <div style="background-color: hsl(9,50%,60%);"> I have coloured using hsl </div>
    <div style="background-color: rgba(59, 99, 73, 0.5);"> I have coloured using rgba </div>
    <div style="background-color: hsla(9,50%,60%,0.5);"> I have coloured using hsla </div>
~~~
 
* **FAVICON** is a small image displayed on the title bar of browser.
~~~
<head>
  <title>My Page Title</title>
  <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
</head>
~~~

> **class and id** css file [.class_name{...} & #id_name{..}]

* The **class** attribute is often used to point to a class name in a style sheet.
* It is also used to access and manipulate data using JavaScript.
* These *class* name can be used multiple times but *id* cannot be used twice.
* Id attribute is used to specify a unique id for an HTML element.

> HTML file paths

* A file path describes the location of a file in a web site's folder.
~~~
1. <img src="p.jpg">    ->file is located in the same folder as the current page.
2. <img src="images/p.jpg">  -> " " " in the images folder in the current folder.
3. <img src="/images/p.jpg">" " " is located in the images folder at the root of the current web.
4. <img src="../p.jpg">" "  " is located in the folder one level upto the current folder.
~~~
> Computer codes
* < code> defined for writing programs.
* < kbd> defines keyboard input ex: ctrl+s save
* < var> used to define variables (by default italic)
* < samp> used to define computer output.(by default monospace font)

> Special Symbol by entity names
* &lt -> <
* &gt -> >
* &amp -> &
* &quot -> "
* &apos -> '