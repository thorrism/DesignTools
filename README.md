# Material Design Tools
A repository for tools commonly used in applications to save time in development. The purpose of this repo is mostly for me to avoid producing boilerplate code over and over again, but I decided to share for others who may be interested. All the views use Material Design standards and should work for apis as far back as api 7. 

(**This is a work in progress, mostly for myself but made public for others to enjoy :-). **)

# Tools:
**_RaisedButton_**: Material Design inspired button that uses elevation and appears to be raised above the base surface of a view. This is one of the two types of buttons Google's Material Design guidelines suggest to use. 

**fields:**

cornerRadius - How rounded the corners are

raisedElevation - thickness of shadow

innerPadding - inset padding of text to outside of button

backgroundColor - color of the button

contentColor - color of the text

content - text for button

**_FlatButton_**: The second Material Design inspired button that is inset, rather than raised above all other elements in a view. This type of button is used for dialogs and menus where you don't make the button to appear as though it is raised.

**_SquareImageView_**: Simple ImageView modified to use the width as the height value as well so that the image is conformed into a square.

**_LabelView_**: To make building menus easier, the LabelView allows you to add titles to sections where you have different types of items. The built in label view for a TextView from Android doesn't allow you to change colors to the line / text, this one does. Not found in the Material Design guidelines, but can still be useful.

**fields**:
lineThickness - the thickness of the line below the text for label

linePadding - padding between text and line

textPadding - inset padding for text from left side

**_MaterialLabelView_**: Similar to just the SimpleLabelView, this one has a colored background to indicate sections, or labels, and would fit right in for other Material Design features. This look is a little more modern than the classic LabelView.

**fields**:

labelColor - color the label

sidePadding - inset padding for text from left side

**_TextViewShadow_**: This view is just a TextView with a drop shadow drawn behind the text. This could be useful if for you need a raised TextView, and think it would look good. Not found in the Material Design guildines, but can still be useful.

**fields**:

text - text itself

textColor - color of text

textSize -  size of text

textElevation - thickness of shadow

**_MaterialDialog_**: A dialog box that uses Material Design principles in order to easily craft a dialog box when necessary. Also can provide a callback for when the user submits via submit button. The dialog is fully customizable as well with a simple programatic creation.

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

**_ShakeEditText_**: An EditText that incorporates a shaking animation when it is is submit with invalid input. The validation is done via a Validator that the developer must define. Supports setting an error message as well when invalid.

```
    //Define the validator.
    public class EmailValidator implements Validator {
        private AppCompatEditText mEditText;

    public EmailValidator(AppCompatEditText editText) {
        mEditText = editText;
    }

    @Override
    public boolean validate() {
        return mEditText.getText().toString().contains("@");
    }

    @Override
    public void setInvalidError() {
        mEditText.setError("Invalid Email");
    }
    
    //Attach validator to ShakeEditText in onCreate
    mShakeEdit = (ShakeEditText) findViewById(R.id.email_edit);
    mShakeEdit.setValidationListener(new EmailValidator(mShakeEdit));
```

Now when the user presses 'Done' on the keyboard the validator is checked for the if it is a valid input or not.

Also can attach the validation check to a button press:

```
    mButton.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick(){
            if(mEditText.checkValidInput(){
                //valid input, do something here.
            }
        }
    }
```
