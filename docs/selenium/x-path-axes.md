# 📌 What Are XPath Axes?

XPath Axes define the relationship between the current node and other
nodes in the DOM.

They help you navigate:

-   Parent
-   Child
-   Siblings
-   Ancestors
-   Descendants

Instead of writing long absolute XPath, axes make it powerful and
dynamic.

------------------------------------------------------------------------

# 🌳 Sample DOM Structure (Understand This First)

## Consider this HTML:

``` html
<html>
  <body>
    <div id="main">
      <h1>Title</h1>
      <div class="container">
        <label>Email</label>
        <input type="text" id="email"/>
        <button>Submit</button>
      </div>
    </div>
  </body>
</html>
```

------------------------------------------------------------------------

## DOM Tree Representation:

    html
     └── body
          └── div (id=main)
               ├── h1
               └── div (class=container)
                    ├── label
                    ├── input (id=email)
                    └── button

Assume we start from:

``` xpath
//input[@id='email']
```

Now let's see axes.

------------------------------------------------------------------------

# 🚀 1️⃣ parent

## 🔹 Description:

Selects the parent of the current node.

## 🔹 Syntax:

    xpath/parent::tagname

## 🔹 Example:

``` xpath
//input[@id='email']/parent::div
```

👉 Selects `<div class="container">`

------------------------------------------------------------------------

# 🚀 2️⃣ child

## 🔹 Description:

Selects child elements of current node.

## 🔹 Syntax:

    xpath/child::tagname

## 🔹 Example:

``` xpath
//div[@class='container']/child::input
```

👉 Selects `<input id="email">`

------------------------------------------------------------------------

# 🚀 3️⃣ following-sibling

## 🔹 Description:

Selects siblings that come AFTER the current node.

## 🔹 Syntax:

    xpath/following-sibling::tagname

## 🔹 Example:

``` xpath
//label[text()='Email']/following-sibling::input
```

👉 Selects input next to label.

------------------------------------------------------------------------

# 🚀 4️⃣ preceding-sibling

## 🔹 Description:

Selects siblings BEFORE the current node.

## 🔹 Syntax:

    xpath/preceding-sibling::tagname

## 🔹 Example:

``` xpath
//button/preceding-sibling::input
```

👉 Selects input before button.

------------------------------------------------------------------------

# 🚀 5️⃣ ancestor

## 🔹 Description:

Selects ALL ancestors (parent, grandparent, etc.)

## 🔹 Syntax:

    xpath/ancestor::tagname

## 🔹 Example:

``` xpath
//input[@id='email']/ancestor::div
```

👉 Selects both container div and main div.

------------------------------------------------------------------------

# 🚀 6️⃣ descendant

## 🔹 Description:

Selects all children, grandchildren, etc.

## 🔹 Syntax:

    xpath/descendant::tagname

## 🔹 Example:

``` xpath
//div[@id='main']/descendant::input
```

👉 Selects input inside main div.

------------------------------------------------------------------------

# 🚀 7️⃣ following

## 🔹 Description:

Selects everything AFTER the closing tag of current node in DOM.

## 🔹 Syntax:

    xpath/following::tagname

## 🔹 Example:

``` xpath
//label/following::button
```

------------------------------------------------------------------------

# 🚀 8️⃣ preceding

## 🔹 Description:

Selects everything BEFORE current node in DOM.

## 🔹 Syntax:

    xpath/preceding::tagname

------------------------------------------------------------------------

# 🚀 9️⃣ self

## 🔹 Description:

Selects current node.

## 🔹 Syntax:

    xpath/self::tagname

## Example:

``` xpath
//input/self::input
```

------------------------------------------------------------------------

# 🚀 1️⃣0️⃣ ancestor-or-self

Includes current node + ancestors.

------------------------------------------------------------------------

# 🚀 1️⃣1️⃣ descendant-or-self

Includes current node + all descendants.

------------------------------------------------------------------------

# 🎯 Most Used Axes in Selenium (Practical)

-   🔥 parent
-   🔥 following-sibling
-   🔥 preceding-sibling
-   🔥 ancestor
-   🔥 descendant

These 5 are most commonly used in real projects.

------------------------------------------------------------------------

# 🧠 Real Interview Example

## Question:

Click Submit button using Email label.

## Answer:

``` xpath
//label[text()='Email']/following-sibling::button
```

OR safer:

``` xpath
//label[text()='Email']/parent::div//button
```

------------------------------------------------------------------------

# 📊 Axis Summary Table

| Axis              | Meaning            |
| ----------------- | ------------------ |
| parent            | Immediate parent   |
| child             | Immediate children |
| ancestor          | All parents        |
| descendant        | All children       |
| following-sibling | Next siblings      |
| preceding-sibling | Previous siblings  |
| following         | All nodes after    |
| preceding         | All nodes before   |
| self              | Current node       |


------------------------------------------------------------------------

# 💡 Important Difference

## following vs following-sibling

-   following-sibling → Same parent only
-   following → Entire DOM after node

Interviewers love this question 🔥

------------------------------------------------------------------------

# 🏁 Final Memory Trick

Think of DOM like a family tree:

-   Parent
-   Child
-   Sibling
-   Grandparent
-   Cousins (following/preceding)

------------------------------------------------------------------------

End of Document
