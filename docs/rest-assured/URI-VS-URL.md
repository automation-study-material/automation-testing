# URL vs URI -- Complete Guide

------------------------------------------------------------------------

# 1️⃣ Basic Definitions

## URI (Uniform Resource Identifier)

A URI is a generic identifier used to identify a resource. It can
identify: - A web page - An API endpoint - A file - An image - A book
(via ISBN)

URI = Parent Concept

------------------------------------------------------------------------

## URL (Uniform Resource Locator)

A URL is a type of URI that: - Identifies the resource - Provides its
location - Specifies how to access it (protocol)

Example: https://example.com/products?id=10

It contains: - Protocol → https - Domain → example.com - Path →
/products - Query → ?id=10

------------------------------------------------------------------------

## URN (Uniform Resource Name)

A URN identifies a resource by name only (not location).

Example: urn:isbn:9780132350884

------------------------------------------------------------------------

# 2️⃣ Diagram Explanation

                URI
               /                 /                URL       URN

URI = Identifier\
URL = Identifier + Location\
URN = Identifier by Name

Simple Memory Trick: All URLs are URIs\
But not all URIs are URLs

------------------------------------------------------------------------

# 3️⃣ Key Differences Table

  Feature              URI                           URL
  -------------------- ----------------------------- -------------------------------
  Full Form            Uniform Resource Identifier   Uniform Resource Locator
  Purpose              Identifies a resource         Identifies + Locates resource
  Includes protocol?   Not always                    Yes
  Includes location?   Not always                    Yes
  Type                 Parent concept                Subtype of URI

------------------------------------------------------------------------

# 4️⃣ Tricky Interview Questions

Q1: Is every URI a URL?\
Answer: No. URL is a subtype of URI.

Q2: Is every URL a URI?\
Answer: Yes.

Q3: Is HTTPS mandatory for a URL?\
Answer: No. URL can use HTTP, FTP, etc.

Q4: Is "mailto:abc@gmail.com" a URL?\
Answer: Yes. It is a URL because it specifies a scheme.

Q5: What is the difference between URI and endpoint in REST?\
Answer: Endpoint refers to a specific URI that accepts client requests.

------------------------------------------------------------------------

# 5️⃣ How It Relates to REST API Design

In REST APIs:

Example: https://api.company.com/users/101

This is both: - URI (because it identifies a resource) - URL (because it
provides location + protocol)

Best Practices in REST:

1.  Use nouns, not verbs Good: /users Bad: /getUsers

2.  Use hierarchical structure /users/101/orders

3.  Keep URIs consistent and predictable

4.  Use query parameters for filtering /users?status=active

------------------------------------------------------------------------

# 6️⃣ Interview Short Answer

URI is a general identifier of a resource. URL is a type of URI that
also tells where the resource is located and how to access it. All URLs
are URIs, but not all URIs are URLs.

------------------------------------------------------------------------

End of Document
