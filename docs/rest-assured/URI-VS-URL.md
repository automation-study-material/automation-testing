# URI vs URL vs URN

------------------------------------------------------------------------

## 🔹 URI (Uniform Resource Identifier)

A URI is a generic identifier used to identify a resource.

It can identify:

-   A web page
-   A file
-   An image
-   An API endpoint
-   Even a book (via ISBN)

👉 URI can be of two types:

-   URL
-   URN

------------------------------------------------------------------------

## 🔹 URL (Uniform Resource Locator)

A URL is a type of URI that tells:

-   Where the resource is located
-   How to access it (protocol)

### Example:

    https://example.com/products?id=10

It contains:

-   Protocol → https\
-   Domain → example.com\
-   Path → /products\
-   Query → ?id=10

So it tells **location + access method**.

------------------------------------------------------------------------

## 🔹 URN (Uniform Resource Name)

A URN identifies a resource by name only, not location.

### Example:

    urn:isbn:9780132350884

It identifies a book using ISBN, but doesn't tell where it is.

------------------------------------------------------------------------

## 🔥 Key Difference Table

  Feature              URI                           URL
  -------------------- ----------------------------- -------------------------------
  Full Form            Uniform Resource Identifier   Uniform Resource Locator
  Purpose              Identifies a resource         Identifies + Locates resource
  Includes protocol?   Not always                    Yes
  Includes location?   Not always                    Yes
  Type                 Parent concept                Subtype of URI

------------------------------------------------------------------------
