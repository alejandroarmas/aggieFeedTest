
## Simple App for Aggie Feed API Data Retrieval


A simple service to access the AggieFeed REST API and display a Main Activity which lists all posts in a ViewList.
- Uses Request Queue for multiple API requests
- Uses Callback to handle background execution thread  

![Main Activity](images/MainActivity.png "Main Activity")

Each item has a on click handler to send the user to an Activity showing a more detailed View of the data.

![Aggie Post Activity](images/DisplayAggiePostActivity.png "Aggie Post Activity")
