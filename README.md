# Saluran

Saluran is an Android applications that shows a sectioned data of different transformational books/courses/series

### Tech

Below is a (non comprehensive) list of tools used in building this library:

* [Dagger Hilt](https://developer.android.com/training/dependency-injection) for dependencies injection!
* [RxJava](https://github.com/ReactiveX/RxJava) for asynchronous processes
* [Timber](https://github.com/JakeWharton/timber) for logs
* [Material Design](https://material.io/develop/android/) for views and theme
* [Retrofit](https://github.com/square/retrofit/) all network calls
* [Shimmer Frame Layout](http://facebook.github.io/shimmer-android/) for shimmering views
* [Room](https://developer.android.com/training/data-storage/room/) for offline/persistence
* [ViewModel and LiveData](https://developer.android.com/topic/libraries/architecture/lifecycle) for asynchronous delivery of data with lifecycle awareness
##### Testing 
* [JUnit](https://junit.org/junit4/)
* [Espresso](https://developer.android.com/training/testing/espresso)
* [MockK](https://github.com/mockk/mockk)
* [TestRule](https://developer.android.com/training/testing/junit-rules)

### Architecture
* Clean architecture
* MVVM

### Installation
Saluran requires a phone running on API 19 and above.
Clone the repository and run. 

### How to run
To run the project, you need Android Studio 4.2 ,any of the canary candidates will suffice. 
- Clone the project
- Import into Android Studio. 
- Get the [local.properties](https://drive.google.com/file/d/1xwS49TB57SxbEuSyiy0fdcA_9F2GXTv4/view?usp=sharing) file and add it to your local machine
- If you have any problem building because of kotlin modules, please check the StackOverflow answer [here](https://stackoverflow.com/questions/56607089/new-gradle-sync-is-not-supported-due-to-containing-kotlin-modules-using-an-unsup/56630152#56630152)


### TODO
 - Write MORE UI and unit tests
 - Add Night Mode
