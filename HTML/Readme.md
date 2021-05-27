# HTML 
Hypertext markup Language

### Required Tools:
- Visual Studio
   - Extentions 
     - Prettier 
     - Live server
- Browser (Chrome)

## I. Web Development Fundamentals 

- HTML (Hypertext Markup Language) is a markup language used to define the structure and contents of web pages.
- CSS (Cascading Stylesheets) are used for styling web pages.
JavaScript is a programming language used for making web pages interactive.
- To view a web page, we enter its URL (Uniform Resource Locator) into the browser’s address bar.
- To view the HTML behind a web page, we right-click on the page and select View Source or View Page Source.
- HTTP (Hypertext Transfer Protocol) is a set of rules that clients and servers use to communicate and exchange data.
- When you visit a website, your browser (client) sends an HTTP request to the server and receives an HTTP response. The response includes an HTML document that represents the page you’re visiting. The browser reads the HTML document to construct a Document Object Model (an in-memory representation of the elements on the page). Once the DOM is ready, the browser renders (displays) the target page.
- We can use the Network tab of Chrome DevTools to inspect HTTP requests and responses exchanged between the browser and the server.
- An HTML document consists of a DOCTYPE declaration that specifies the version of HTML being used followed by a tree (hierarchy) of elements that define the structure and content of the document.
- The root element in an HTML document is the html element which always includes a head and a body element. The head element contains information about the page such as its title. The body element includes the structure and content of the page.
- Most HTML elements include an opening and closing tag.
- We can use attributes to provide additional information about an element (like the source of an image). Attributes are coded as part of the opening tag.
- To style an element using CSS, we write a CSS rule which consists of a selector and one or more declarations.
- The selector is used to target one or more elements. We can select elements by their type, class, ID and so on.
- A declaration consists of a property, a colon, a value and is terminated by a semicolon. Prettier is the most popular VSCode extension for formatting code.
- Using validation services we can ensure that our HTML/CSS code is valid and follows the official rules. This helps us get better rankings in search engines.



> URL -  Uniform Resource Locator. 

Resources: 
- Webpages
- images
- video/ audio files
- fonts
- etc. 

> HTTP - Hypertext Transport Porotocal

>HTTPS - Hypertext Transport Protocal Secure (Entrypted)

>DOM - Document Object Model

>Delveloper Tools - alt + cmd + i

> ```! ``` tab to generate Html biolerplate 

> ```<head>``` tag have information about the webpage. 

We can add class to every tag then we can use that className in style/CSS. 

We can modify the CSS with developer tools in browser. 

Validator: validator.w3.org

ASCII - American Standard Code for Information Interchange
UTF-8  - Unicode Transformation format

```<em> ```is used to emphasise the content

```<strong> ```make the content bold.


Hyperlinks - Anchor Tag
- ```<a>  href="  "> </a> ```   
- href - Hypertext reference. 

- ``` <a href="about.html">About</a> ```    To navigate to another page. 
- ```<a href="/images/photo.jpeg" >image</a>``` Display an image. 
- ```<a href="#section-css">CSS</a> ``` Jump to the tag which id is ```#section-css```
- ``` <a href="https:google.com.au" target="_blank">Google</a>``` Redirect to google website. 
- ```<a href="mailto:sadamramanayudu@gmail.com">Email me</a>``` email. 
- ```<a href="#">Jump to top</a>``` jump to begining of the page. 

Code  | Defination 
------------- | ------------
``` <a href="about.html">About</a> ```| To navigate to another page.
```<a href="/images/photo.jpeg" >image</a>``` | Display an image.
```<a href="#section-css">CSS</a> ``` | Jump to the tag which id is ```#section-css``` 
```<a href="#">Jump to top</a>``` | jump to begining of the page.
``` <a href="https:google.com.au" target="_blank">Google</a>``` | Redirect to google website.
```<a href="mailto:sadamramanayudu@gmail.com"> Email me </a>```  | email
 


### HTML Basics  


- The ```<head>``` section is used to provide information about a webpage.
- The ```<p>``` element is used to represent a paragraph. A paragraph can be one or manylines of text.
- The ```<em>``` element is used to define emphasized text. By default, emphasized text is displayed in italic.
- The ```<strong>``` element is used to represent important content. Browsers, by default, render strong content in bold.
- The ```<i>``` and ``` <b> ``` elements are considered deprecated because HTML should not beused for styling. That’s the role of CSS.
- Headings are represented using ```<h1>, <h2>, <h3>, <h4>, <h5>, <h6> ```. Every web page should have one and only one ``` <h1>``` element. Headings should have a natural hierarchy and should not be skipped.
- Entities are used to display special characters such as angle brackets, copyright symbol, etc. The most important entities are: &nbsp; (non-breaking space), &lt; (less than sign), &gt; (greater than sign) and &copy; (copyright symbol).

- The ```<a>``` (anchor) element, with its href attribute, is used to create a hyperlink to web pages, locations in the same page, files and email addresses.
- A relative URL specifies the target resource relative to the current resource. An absolute URL specifies the location of a resource irrespective of the current resource. It can start with a / to indicate the root of the website or a protocol (eg http://) to represent a resource on a different website.
- The ```<img>``` element is used to display an image. It’s a common best practice to set the alt (alternative text) attribute. This helps visually impaired people understand the page content. Also, if the image cannot be loaded, the alternative text is displayed.
- The ```<video>``` and ```<audio>``` elements are used to display video and audio. These elements have boolean attributes such as controls, autoplay and loop.
- The ``<ul>`` element is used to represent a list where the order of items doesn’t matter. The ```<ol>``` element is used to represent an ordered list of items. The ```<dl>``` (description list) element is used to implement a glossary or to display metadata.
- The ```<table>``` element should only be used to represent tabular data. A table can have zero or more ```<tr>``` (table row) elements. Each ```<tr> ```element can have zero or more cells. Cells can be data cells (```<td>```) or header cells (```<th>```).
