# Material Design Skeleton
A repository for tools commonly used in applications to save time in development. All the views use Material Design standards and should work for apis as far back as api 7.

# Tools:
**_RaisedButton_**: Material Design inspired button that uses elevation and appears to be raised above the base surface of a view. This is one of the two types of buttons Google's Material Design guidelines suggest to use. 

**_FlatButton_**: The second Material Design inspired button that is inset, rather than raised above all other elements in a view. This type of button is used for dialogs and menus where you don't make the button to appear as though it is raised.

**_SquareImageView_**: Simple ImageView modified to use the width as the height value as well so that the image is conformed into a square.

**_LabelView_**: To make building menus easier, the LabelView allows you to add titles to sections where you have different types of items. The built in label view for a TextView from Android doesn't allow you to change colors to the line / text, this one does. Not found in the Material Design guidelines, but can still be useful.

**_TextViewShadow_**: This view is just a TextView with a drop shadow drawn behind the text. This could be useful if for you need a raised TextView, and think it would look good. Not found in the Material Design guildines, but can still be useful.

**_MaterialDialog_**: A dialog box that uses Material Design principles in order to easily craft a dialog box when necessary. Allows provides a callback for when the user accepts the dialog box message. The dialog is fully customizable as well with a simple programatic creation.

```
MaterialDialog.with(MyActivity.this)
              .setTitle(R.string.dialog_title)
              .setBody(R.string.dialog_body)
              .setSubmitListener(new MaterialDialog.OnSubmitListener(){
                  @Override
                  public void onSubmit(){
                      //do something here, user has submit.
                  }
              }).show(getSupportFragmentManager(), "material_dialog");
```
