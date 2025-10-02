# Introduction to Widgets in Android

**Widgets** are the building blocks of Android UI. They are interactive components that users can see and touch. Every button, text field, image, or piece of text is a widget.

*Basic Concept:* Widgets = Views = UI Components

---

## TextView

### **What is TextView?**
A widget used to display text to the user. Users can read the text but cannot edit it.

### **Key Attributes & Usage**

#### **1. Basic Text Display**
```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World!"/>
```
*Shows "Hello World!" text on screen*

#### **2. Text Styling**
```xml
<TextView
    android:text="Styled Text"
    android:textSize="24sp"          <!-- Bigger text -->
    android:textColor="#FF0000"      <!-- Red color -->
    android:textStyle="bold"         <!-- Bold text -->
    android:background="#CCCCCC"     <!-- Gray background -->
    android:padding="16dp"/>         <!-- Space around text -->
```

#### **3. Text from Resources (Best Practice)**
```xml
<!-- In strings.xml -->
<string name="welcome_message">Welcome to my app!</string>

<!-- In layout XML -->
<TextView
    android:text="@string/welcome_message"/>
```

#### **4. Multiline Text**
```xml
<TextView
    android:text="This is a long text that will wrap to multiple lines automatically"
    android:maxLines="3"             <!-- Maximum 3 lines -->
    android:ellipsize="end"          <!-- Show ... if too long -->
    android:lineSpacingExtra="8dp"/> <!-- Space between lines -->
```

#### **5. Advanced TextView Features**
```xml
<TextView
    android:text="Clickable Text"
    android:clickable="true"         <!-- Make text clickable -->
    android:linksClickable="true"    <!-- Make URLs clickable -->
    android:autoLink="web"           <!-- Auto-detect web links -->
    android:text="Visit https://www.example.com"/>
```


## EditText

### **What is EditText?**
A TextView that users can edit. Used for text input like forms, search boxes, etc.

### **Key Attributes & Usage**

#### **1. Basic Input Field**
```xml
<EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter your name"/>  <!-- Hint text -->
```
*Shows input field with placeholder text*

#### **2. Input Types (Keyboard Control)**
```xml
<!-- Text Password -->
<EditText
    android:inputType="textPassword"
    android:hint="Enter password"/>

<!-- Email Address -->
<EditText
    android:inputType="textEmailAddress"
    android:hint="Enter email"/>

<!-- Phone Number -->
<EditText
    android:inputType="phone"
    android:hint="Enter phone number"/>

<!-- Multi-line Text -->
<EditText
    android:inputType="textMultiLine"
    android:lines="4"
    android:hint="Enter description"/>
```

#### **3. Input Constraints & Validation**
```xml
<EditText
    android:maxLength="10"           <!-- Maximum 10 characters -->
    android:maxLines="1"             <!-- Single line -->
    android:singleLine="true"        <!-- Force single line -->
    android:ems="10"                 <!-- Approximately 10 characters wide -->
    android:hint="Username (max 10 chars)"/>
```

#### **4. Styling & Icons**
```xml
<EditText
    android:drawableStart="@drawable/ic_person"  <!-- Icon on left -->
    android:drawablePadding="8dp"    <!-- Space between icon and text -->
    android:background="@drawable/edittext_border" <!-- Custom background -->
    android:hint="With icon"/>
```

#### **5. Advanced EditText Features**
```xml
<EditText
    android:inputType="textCapWords"  <!-- Auto-capitalize each word -->
    android:imeOptions="actionDone"   <!-- Keyboard shows "Done" button -->
    android:selectAllOnFocus="true"   <!-- Select all text when focused -->
    android:hint="Advanced features"/>
```

## Button

### **What is Button?**
A widget that users can click/tap to perform an action. The most interactive widget.

### **Key Attributes & Usage**

#### **1. Basic Button**
```xml
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Click Me!"/>
```
*Shows a clickable button with text*

#### **2. Button Styling**
```xml
<Button
    android:text="Styled Button"
    android:textSize="18sp"
    android:textColor="#FFFFFF"       <!-- White text -->
    android:background="#2196F3"      <!-- Blue background -->
    android:padding="16dp"
    android:drawableStart="@drawable/ic_heart"  <!-- Icon on left -->
    android:drawablePadding="8dp"/>
```

#### **3. Different Button States**
```xml
<Button
    android:text="Press Me"
    android:clickable="true"          <!-- Allow clicking -->
    android:enabled="true"            <!-- Enable/disable button -->
    android:focusable="true"/>        <!-- Can receive focus -->
```

#### **4. Custom Background (Using Selector)**
```xml
<!-- Create button_states.xml in drawable folder -->
<selector>
    <item android:state_pressed="true" android:drawable="@color/button_pressed"/>
    <item android:state_focused="true" android:drawable="@color/button_focused"/>
    <item android:drawable="@color/button_normal"/>
</selector>

<!-- Use in Button -->
<Button
    android:background="@drawable/button_states"
    android:text="Button with States"/>
```

#### **5. ImageButton (Button with only image)**
```xml
<ImageButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/ic_settings"  <!-- Image instead of text -->
    android:background="?attr/selectableItemBackground" <!-- Ripple effect -->
    android:contentDescription="Settings"/> <!-- Accessibility -->
