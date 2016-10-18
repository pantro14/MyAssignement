In this project the Author: David Pardo has solved the following assignement:

Create an app that is capable of visualizing the attached csv file on the screen. parse it on a background thread.

The Application contains a principal package called: com.rabobank.davidpardo.myassignement
this package is splitted in 3 different subpackages called:
- Model
- Presenter
- View
This package organisation was designed by using the MVP pattern of development of software.

In the View package we have the Activity itself in charge of manipulate the User Interface objects,
their performance and features.

The Presenter is represented by the IssueListAdapter class and the AsynkTask in charge of retrieve
the csv file in background.
It's important to clarify that despite the fact that the class IssueListAdapter has objects from the
user interface, the Adapter should be the P component in an MVP pattern. In fact ListViews are pretty
much written as MVP- the getView() function needs to set all the values of the view each time its called,
that's almost the definition of what a presenter must do. Although it's also easy to use it in an MVC
type way- simply have getView call functions on the View that pass it the model and do that work in the Views.

In the Model package we see the Issue class which abstract the issue description.

