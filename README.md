# TestProject
 
- The image provided above is to give an idea about the structure of the screen.
Features:
- The screen should scroll infinitely (vertically) by looping the albums, (ex. scrolling past the 4th album, should show the 1st album again).
- The images should scroll infinitely (horizontally) both left and right looping the images, (ex. scrolling past the 3rd image, should show the 1st album again).
  Requirements: Design:
 
- The albums should scroll from side to side independent from one another.
- Both horizontally for the images and vertically for the albums, the user should be able to scroll up and left from the initial point of the screen as it is opened.
- The app should be structured based on MVVM Clean architecture design
- The app should be written in Kotlin
- The app should support offline mode and use Room as a local database
- Once the app is reopened for the 2nd or for the 3rd time, the data should be visible immediately
- The apk file should be attached to the practical task
APIs:
URL -> https://jsonplaceholder.typicode.com Path -> /albums
Method -> Get
Photo API:
URL -> https://jsonplaceholder.typicode.com Path -> /photos
Required Params -> "albumId"
Method -> Get
