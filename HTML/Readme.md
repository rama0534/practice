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
----------------

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


### CSS Basics
----------------- 

- CSS styles can be embedded in an HTML document, written in a separate file (as an
external stylesheet) or written inline in an HTML element using the style attribute.
- Inline styles overwrite embedded styles which in turn overwrite external styles.
- External stylesheets provide the best separation of HTML and CSS code and result in more maintainable code. Plus, an external stylesheet can be used in many HTML documents
We can select elements by their type, class, attribute or ID.
- Relational selectors help us select elements without the need to assign them a specific ID
or class. This, however, can result in fragile styles. If we move elements around, our CSS
rules may break. We can still use them in situations where we are certain about the
location of elements.
- We can take advantage of pseudo-classes to target elements without the need to give
them a specific class. The most common pseudo-classes are: first-child, firstof-type, last-child, last-of-type and nth-child. Pseudo-classes start with
a single colon.
- With pseudo-elements we can style a part of an element. The most common pseudoelements are: first-letter, first-line, selection, before and after.
Pseudo-elements start with double colons.
- Selectors specificity determines the weight of a selector. When multiple selectors target
the same element, the browser applies the selector with the higher specificity (weight). If
two selectors have the same specificity, the one that comes last is the winner.
- ID selectors are the most specific selectors because we cannot have multiple elements
with the same ID. Class and attribute selectors are less specific because we can have
many elements with the same class and/or attributes. Element selectors are the least
specific selectors.
- In VSCode, we can see the specificity of a rule by hovering our mouse over it. The
specificity is represented using three numbers (x, y, z) where x represents the number of
ID selectors, y represents the number of class/attribute selectors and z represents the
number of element selectors.
- Some CSS properties inherit their value from their parent element. Typically, properties
that are used for styling text such as text color, font, font size, etc are inherited. We can
stop the inheritance by setting the value of a property to initial. To enforce
inheritance, we should set the value of a property to inherit.
- We can specify colors by their name, hexadecimal value, RGB/RGBA value or HSL/ HSLA value.
- RGBA and HSLA values include an alpha channel used for transparency. The value for
the alpha channel is a decimal point number between 0 (completely transparent) and 1
(completely opaque).
- Using the linear-gradient() and radial-gradient() functions we can create
gradients in CSS. Gradients are images so they cannot be used as the value of
background-color property. We can use them as the value of background-image
or background properties.
- The border property is a shorthand property for border-top, border-right,
border-bottom and border-left. It takes three values: the thickness of the border,
its style and its color.
- We also have specific properties like border-width, border-style and bordercolor. These properties take four values for the top, right, bottom and left borders.
- Using the box-shadow and text-shadow properties we can apply a shadow to
elements and text. These properties take a few values. The first two values determine the
horizontal and vertical distance of the shadow from the element. The third value (called
blur radius) determines the softness of the border. We can specify the color as the fourth
value

 Basic Selectors
----------
Selectors | Description 
------- | -------
article | All article elements
.product | Elements with the product class
#products | The element with the ID of products
a[href=“…”] | Anchors with the given href
a[href*=“google”] | Anchors whose href contains google
a[href^=“https”] | Anchors whose href starts with https
a[href$=“.com”] | Anchors whose href ends with .com

---------------
Relational Selectors
-----------

Selectors | Description 
------------- | ------------------
#products p  | All p elements inside #products
#products > p | All p elements that are direct children of #products
#products + p | The p element immediately after #products (sibling)
#products ~ p | All p elements after #products (siblings)

-----------
Pseudo-class Selectors
----

Selector | Description 
-------- | -------------
article :first-child | The first child of article elements 
article :first-of-type | The first occurrence of elements of different type 
article p:first-of-type | The first p element inside article elements 
article :last-child | The last child of article elements 
article :last-of-type | The last  occurrence of elements of different type
article :nth-child(odd) | Every odd child
article :nth-child(even) | Every even child

---------
Pseudo-element Selectors
-----

Selector | Description
------ | ---------
p::first-letter  | The first letter of every p element
p::first-line | The first line of every p element 
::selection | Any selected element 
p::before  | To insert content before the content of p elements
p::after | To insert content after the content of p elements

-------
Colors 
------
 Code | Type 
 ------ | ------
 #fcba03 | Hexadecimal value
rgb(252, 186, 3) | RGB value
rgba(252, 186, 3, 0.5) | Semi-transparent RGB value
hsl(44, 98%, 50%) | HSL value
hsla(44, 98%, 50%, 0.5) | Semi-transparent HSL value


--------- 
Gradients
---------
```background: linear-gradient(blue, yellow);
  background: linear-gradient(to bottom right, blue, yellow);
  background: linear-gradient(45deg, blue, yellow);
  background: linear-gradient(45deg, blue, yellow 30%);
  background: radial-gradient(white, yellow);
  background: radial-gradient(circle, white, yellow);
  background: radial-gradient(circle at top left, white, yellow);
```


------
Borders
----- 

```border: 10px solid blue;
border-width: 10px 20px 30px 40px; /* top right bottom left */
border-radius: 5px;
border-radius: 100%; /* full circle */
```

---------
Shadows
----

```box-shadow: 10px 10px;
box-shadow: 10px 10px grey;
box-shadow: 10px 10px 5px grey;
text-shadow: 3px 3px 5px rgba(0, 0, 0, 0.2);
```


### Layout  
------------
Terms

- Absolute positioning     
- Absolute units
- Box model 
- Breakpoints 
- Collapsing parent 
- Fixed positioning 
- FlexBox (Flexible box layout)
- Floating elements 
- Grid layout
- Margin collapsing
- Media queries 
- Mobile-first approach 
- Overflowing 
- Relative positioning 
- Relative units 
- Responsive web design 

#### Summary 
- When rendering an HTML document, the browser puts each element inside a box. The box contains four areas: the content area, the padding area, the border area and the margin area. 
- Padding is the space between the border and the content area. Margin is the space outside of an element and should be used to separate elements from each other. 
- Margin collapsing happens when the top and bottom margins of elements are combined into a single margin. The size of the margin is equal to the largest of the two margins. 
- There are two types of HTML elements: block-level and inline. 
- Block-level elements always start on a new line and take up the entire available horizontal space. The ``<p>`` and ``<div>`` elements are examples of block-level elements. 
- Inline elements don’t start on a new line. They take up as much width as necessary. The ``<span>``,`` <a>`` and ``<img>`` are a few examples of inline elements.  
-We can size elements by setting their width and height properties. These properties have no effect on inline elements. To size an inline element, we need to set its displayproperty to inline-block. 
- By default, the width and height properties are applied to the content box. So paddings and borders increase the size of the visible box. This behavior can be changed by setting the box-sizing property to border-box. 
- Overflow occurs when an element’s content is too large to fit. Using the overflowproperty we can specify what should happen when overflow occurs.
- Measurement units in CSS fall into two categories: absolute and relative units. Examples of absolute units are px, pt, in, cm, etc. Examples of relative units are %, vw, vh, em and rem. 
-Using the position property we can precisely position an element. The default value of this property is static. If we change the value of this property, the element is considered positioned. 
- By setting the position to relative, we can position an element relative to its normal position. By setting it to absolute, we can position it relative to its positioned parent. That means, the parent (or ancestor) should be a positioned element. By setting the position to fixed, we can position the element relative to the viewport. 
- By setting the float property, we can push an element to the left or right side of its container. Other elements will flow around the floated element and fill the available space. 
- Floated elements are invisible to their parent. This behavior is called collapsing parent and often causes layout issues. To fix this, we have to clear the floated elements. 
- The Flexible Box Layout (or FlexBox or just Flex) is used for laying out elements in one direction (in a row or column). A common application of Flex is in building navigation menus.
- The Grid Layout is a two-dimensional grid system. It’s often used to lay out major page areas, photo galleries, etc. 
- With media queries we can provide different styles for different devices depending on their features such as screen size, orientation, etc. The most common application of media queries is in providing different styles based on the viewport width. 
- By using media queries and relative measurement units we can build responsive web sites that adjust smoothly to various screen sizes.

 CSS Cheat Sheet
--------

### Box Model 

```padding: 10px 20px; 
padding-top: 30px;
margin: 1px 2px 3px 4px;
margin-top: 5px;
border: 1px solid black;
border-top: 1px solid black;
```

### Sizing Elements 
```
width: 5rem;
height: 20%;
box-sizing: border-box;  (To prevent paddings/borders from increasing the size of the visible box.)
```
### Overflowing
```
overflow: hidden;        Hides the overflown content 
overflow: scroll;        Always shows scroll bars 
overflow: auto;          Shows scroll bars
only if content overflows 
 ```

 ### Positioning
 
 ```
 position: static;      The default value
 position: relative;    To position relative to the element’s normal position
 position: absolute;    To position relative to the element’s positioned parent
 position: fixed;       To position relative to the viewport
 z-index: 1;            To change the stacking order of an element 
 ```
### Floating
```
 float: left;
 float: right; 
 clear: both;
 ```
  ### FlexBox - Container properties
  ```
  display: flex;            To enable the flex layout on a container
  flex-direction: column;   Direction (row, column)
  justify-content: center;  To align items along the main axis
  align-items: center;      To align items along the cross axis
  flex-wrap: wrap;          To enable wrapping
  align-content: center;    To align flex lines along the cross axis
  ```
 ### FlexBox - Item properties
  ```
  align-self: center;    To overwrite the alignment
  flex-basis:            10rem;The initial size of an item
  flex-grow: 1;          The growth factor
  flex-shrink: 0;        The shrink factor
  flex: 0 1 10rem;       Shorthand (grow shrink basis)
  ```
  
  ### Grid - Defining a grid
  ```
  display: grid;
  grid-template-rows: repeat(3, 100px);
  grid-template-columns: repeat(2, 100px);
  grid-template: repeat(3, 100px) / repeat(2, 100px);
  grid-template-areas:   
           “header   header”  
           “sidebar  main”  
           “footer   footer”;
  ```
  ### Gaps
  ```
  row-gap: 10px;
  column-gap: 20px;
  gap: 10px 20px; Shorthand (row column)
  ```
  
  ### Alignment
  ``` 
  justify-items: center;       Align the items horizontally within their cell
  align-items: center;         Align the items vertically within their cell 
  justify-content: center;     Align the grid horizontally within its container 
  align-content: center;       Align the grid vertically within its container
  ```
### Placing Items
```
grid-column: 2;
grid-column: 1 / 3; 
grid-column: 1 / -1;
grid-column: 1 / span 2;
grid-row: 2 / 4; grid-area: header; 
```  
### Hiding elements 
```
display: none;        Hides the element
visibility: hidden;   Hides the element but keeps the reserved space
```
### Media queries
```
@media screen and (min-width: 500px) { } 
@media screen and (min-width: 500px) and (max-width: 700px) { }
@media print { }
 
```
  
### Typography 
-----
#### Summary 
- Typography is the art of creating beautiful and easy-to-read text. Given that 95% of the content on the web is text, as a front-end developer, you must ensure that the text on your web pages is easy to read and visually appealing on various screen sizes.
- Fonts fall into three main categories: Serif, Sans-serif and Monospace. Serif fonts have a line/stroke at the edges of their characters. They’re more professional and serious. Sans-serif fonts don’t have those edges. They’re more modern, warm and friendly. Monospace fonts have equal-width characters. They’re often used in displaying code.
- The default color for the body text is pure black (#000). It’s best to change it to dark grey. 
- We can use the font-family property to set the font for an element. We should set this property to a font stack which contains multiple fonts as fallbacks. 
- In the past, we used web safe fonts because they’re available on almost all computers. These days, however, we can easily embed custom fonts. 
- Font files come in a variety of different formats: TTF, OTF, EOT, WOFF and WOFF 2.0. Out of these, WOFF and WOFF 2.0 are recommended for the web because they’re more compressed and can be downloaded in less time. 
- We can convert any font file to a WOFF file on fontsquirrel.com.
- To embed a custom font, we should first register it using the @font-face rule. 
- When using a custom font, the user may experience a flash of unstyled text (FOUT). Some browsers display text using a fallback font while downloading the custom font and swap it once the custom font is available. This may cause a layout shift depending on how the content is structured. Some browsers hide the text initially while downloading the custom font. This causes a flash of invisible text (FOIT). Using the font-display property we can tell the browser how to handle this situation.
- Using font services we can get access to thousands of beautiful fonts with zero or minimal cost. Google Web Fonts is the most popular and free font service. When using these services, fonts and @font-face rules are served from the provider’s servers. 
- A common practice for content-heavy websites is to use the system font stack which represents the default font used by an operating system. With the system font stack, we achieve a better performance because no fonts need to be downloaded and the FOUT/FOIT doesn’t happen either. Plus, the page looks more familiar to the user because they see the same default font used by their device. On the flip side, the default font varies from one device to another. - It’s best to size fonts using the rem unit. This will set the font size relative to the font size of the root (html) element. Using media queries, we can resize the base font size, and as a result, the font size for all elements will be re-calculated with no extra code. 
- It’s best to use the rem unit for vertical margins. For headings, the top margin should be noticeably greater than the bottom margin so the heading gets separated from the text before and gets connected to the text after. 
- The law of proximity describes how humans perceive the connection between objects. Objects that are closer are perceived to be related. 
- Using the line-height property we can specify the height of lines. It’s best to set this property to a unitless value around 1.5. This value will be multiplied by the font size of the current element so we don’t need to remember to change the line height if we modify the font size.
- The three properties used for horizontal spacing are: letter-spacing, word-spacing, and width. It’s often better to apply a negative letter spacing to headings so they look more compact. 
- The ideal line length is about 60-70 characters. We can achieve that by applying a width of 50ch. The ch unit represents the width of the 0. 50 zeroes roughly represents 60-70 characters because some characters (like i and 1) are more narrow than 0. 
- Using the Network tab in Chrome DevTools, we can simulate a slow connection. This is called Network Throttling. 
- Browsers store some assets behind web pages in a permanent storage called cache. It’s essentially somewhere on the disk. The cache can always be cleared.

#### CSS Cheat Sheet
### Styling Fonts

```
font-family: Arial, Helvetica, sans-serif; 
font-size: 1rem;
font-weight: bold; 
font-style: italic; 
```
### Vertical Spacing
```
margin: 3rem 0 1rem; 
line-height: 1.5;
```
### Horizontal Spacing
```
letter-spacing: -1px;
word-spacing: 2px;
width: 50ch; 
```
 ### Formatting Text
 ```
 text-align: center;
 text-indent: 1rem;
 text-decoration: underline; 
 text-transform: uppercase;
 white-space: nowrap;
 direction: rtl;
 ``` 
   
### Multi-column Text
``` 
column-count: 2;
column-gap: 2rem;
column-rule: 3px dotted #999;
```

## Images
-------
#### Terms

Art direction 
Clipping 
CSS sprites
Data URLs
Device Pixel Ratio (DPR) 
Filters
High-density screens 
Icon fonts 
Logical resolution 
Physical resolution
Raster images
Resolution switching 
Retina displays 
Scalable Vector Graphics (SVG)
Vector images 

### Summary
-------
- Images fall into two categories: raster and vector. Raster images are made up of pixels. Vector graphics are defined by a set of mathematical vectors (eg lines and curves).
- Raster images often come from cameras and scanners but they can also be produced in software. Any file with the extension of JPG, PNG, GIF is a raster image. We use these images for displaying photos.
- Vector images are exported from drawing tools like Adobe Illustrator. Files with the SVG extension represent vector graphics. 
- We use the img element to display content images. Content images can represent meaningful content or be used for decorative purposes. If used for decoration, we should set the alt attribute to an empty string; otherwise, screen readers will read out the name of the file which may be distracting to the user. 
- Using CSS sprites we can combine multiple images into a single image (sprite) and reduce the number of HTTP requests. The problem with CSS sprites is that every time we need to change one of the images in the sprite, we have to re-generate the sprite. So, use this technique for small images that don’t change often. You can generate a sprite using https://cssspritestool.com. 
- Data URLs allow us to embed an image data directly in an HTML document or a stylesheet. The embedded code is always greater than the size of the original resource and makes the document convoluted and hard to maintain. Use this technique only if you know what you’re doing!
- We can clip an image using the clip-path property in CSS. To generate a clip path from basic templates, visithttps://bennettfeely.com/clippy 
- Using the filter property in CSS, we can apply filters such as grayscale, blur, saturate, brightness and so on.
- High-density screens like Apple’s Retina displays contain more pixels than standard-density screens. The pixels on these screens are smaller than the pixels on standard-density screens. So when displaying an image, the screen uses a scale factor (1.5 or greater) to scale up the image. As a result, raster images may look a bit blurry when shown on these screens. To solve this problem, we can supply 2x or 3x versions of an image using the srcset attribute of the img element. 
- For flexible-sized images, we need to supply the image in various sizes for different devices like mobiles, tablets and desktop computers. If we supply a single image, the browser on each device has to resize the image which can be a costly operation. The larger the image, the more memory is needed and the more costly the resizing operation will be. Plus, the extra bytes used to download the image will be wasted. This is the resolution switching problem. To address this, we should give the img element a few image sources and the size of the image for various viewports. The browser will take the screen resolution and pixel density into account and download the image that best fits the final size.
- We can use https://responsivebreakpoints.com to generate our image assets for various screen sizes. 
- WebP is a modern image format created by Google and is widely supported except in Internet Explorer. To support modern image formats, we can use the picture element with multiple sources. The picture element should always contain an img element otherwise the image is not shown. 
- Sometimes we need to show a zoomed in or a cropped version of an image for certain viewport sizes. This is the art direction problem. To handle this, we use the picture element with multiple sources. Each source should contain a media condition and a srcset. The browser will pick the first source whose media condition matches. 
- Scalable Vector Graphics (SVG) files are great for logos, icons, simple graphics and backgrounds with patterns. They are often very small and can scale without losing quality. You can get find plenty of beautiful SVG backgrounds on https://svgbackgrounds.com 
- We can also use icon fonts for displaying icons. The most popular icon fonts are Font Awesome, Ionicons and Material Design Icons.

### CSS Cheat Sheet
----- 
Background Images

```
background: url(../images/bg.jpg);
background-repeat: no-repeat;
background-position: 100px 100px; 
background-size: cover;
background-attachment: fixed;
```

 Clipping
 
 ```
 clip-path: polygon(50% 0%, ...); 
 ``` 

 Filters
 ```
 filter: grayscale(70%);
 filter: blur(3px);
 filter: brightness(0.5);
 filter: contrast(200%);
 filter: drop-shadow(10px 10px 10px grey);
 filter: hue-rotate(90deg);
 filter: invert(50%);
 filter: saturate(25%);
 filter: sepia(50%);
 filter: opacity(50%);
 filter: grayscale(70%) blur(3px);
 ```
 Supporting High-density Screens

Tag | Description 
-------- | ---------
```<img srcset=“images/meal.jpg 1x, images/meal@2x.jpg 2x, images/meal@3x.jpg 3x” src=“images/meal.jpg”/>```  | Use this for fixed-size images. The browser will download the best image based on the pixel ratio of the device. 
 
 
 Resolution Switching

Tag | Description 
-------- | ---------
```<img    srcset=“      images/meal.jpg    400w,      images/meal@2x.jpg 800w,      images/meal@3x.jpg 1200w   “sizes=“      (max-width: 500px) 100vw,      (max-width: 700px) 50vw,      33vw   “   src=“images/meal.jpg”/>```  | Use this for flexible-size images. The browser will download the best image that requires less resizing based on the pixel ratio and screen resolution of the device.


Supporting Modern Image Formats

```
<picture>     
    <source type=“image/webp” srcset=“...” />  
    <source type=“image/jpeg” srcset=“...” />   
    <img src=“...” alt=“...” />
</picture>
```
Art Direction
```
<picture> 
    <source media=“(max-width: 500px)” srcset=“...” />  
    <source media=“(min-width: 501px)” srcset=“...” />    
    <img src=“...” alt=“...” />
</picture>
```






