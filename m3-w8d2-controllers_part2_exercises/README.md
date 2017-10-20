# Product Review Exercise

![Squirrel Cigar Parties For Dummies](etc/forDummies.png)

You have been tasked with developing a promotional site for the best selling book, **"Squirrel Parties for Dummies"** by Craig Castelaz.

The home page of the site should provide some marketing copy for the book and also a list of product reviews submitted from the web.  The application should: 

1. Providing a page that allows a site user to submit a new review
2. Display previously submitted reviews on the home page

## Submitting a New Review

Users can navigate to a page on the web application that provides them with a form to submit a new review.

The page will provide the user with the form to submit:

* Username (required)
* Rating (required) [1-5 stars]
* Review Title  (required)
* Review Text  (required)

After the user's form submission passes server-side validation, the post can be submitted. Once the submission is processed, the user is redirected to the Home Page.

### Saving Reviews
 
Your project should utilize the provided `JdbcReviewDAO` for saving and retrieving reviews.

## Viewing Reviews

The Home Page allows users the ability to see any reviews that were previously submitted to the web application.

The page should display to the user all of the prior reviews. You can use any format you like, this is just an example:

---------

**Changed my life** (David W.)

6/2/2016

![star](etc/star.png)![star](etc/star.png)![star](etc/star.png)![star](etc/star.png)![star](etc/star.png)

Before reading this book, my squirrel parties were always lackluster (I never had enough cigars!).  Thanks to Craig's insightful advice, my squirrel parties are now at the top of everyone's social calendar!

-------

Any new reviews that are submitted from the Submit Review page should show up on the Home Page.
