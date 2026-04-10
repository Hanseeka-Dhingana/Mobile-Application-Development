## What is the intent ?

In Android, an app is made up of different components. The most common components are Activities (which are like screens), Services (which can do background tasks),  and Content Providers (which manage data sharing between apps).

- An Intent is a tool that these components use to talk to each other

**Example:** Now, imagine you are in a large office building and you want to send a message to another room or department. You could either walk over yourself or use the building’s internal messaging system to send instructions. In Android, Intents act like these messages. They are a way for one component of an app to tell another component, or even another app, “Hey, I want to do this action. Can you handle it?”

**1. An Intent** can request something as simple as moving from one screen to another inside the same app. 

- **For example,** if you click a button to open a new screen, that button triggers an intent to start that new Activity.

**2. Intents** are also used to interact with other apps.  

- **For example,** if you want to open a website from your app, you create an intent that tells Android, “I want to view this URL,” and Android will figure out which app (usually a browser) can handle that action.

### Two types of intents
#### Explicit Intent:    

This is when you know exactly which component you want to start. For example, if you are in MainActivity and want to go to ProfileActivity, you create an explicit intent pointing directly to ProfileActivity. Android does not need to check anything because you have specified the exact target.  

#### Implicit Intent:   
This is when you only say what you want to do, not who should do it. For example, if you want to share a photo or open a web page, you create an implicit intent with the action (like VIEW or SEND) and optionally provide the data. Android will then search for all components (even in other apps) that can handle this action and data, and either automatically pick the best one or ask the user to choose.


## What is the Intent Filter in Android? 
Now that we understand intents, let’s see what happens on the receiving side. Not every app or component can respond to every request. 

**Example:** If we go back to the office analogy, imagine if every room in the building had a sign outside saying what type of requests they handle. One room handles “printing requests,” another handles “meeting room booking,” and another handles “sending emails.” This is exactly what an Intent Filter does. 

An **Intent Filter** is a declaration that a component (like an Activity, Service, or Broadcast Receiver) includes in the AndroidManifest.xml file, which tells Android, “I can handle these types of intents.” When an implicit intent is sent, Android looks at all intent filters to find a component that matches the requested **action, category, and data type.** The filter acts as a **rulebook,** letting the system know which component is capable of handling which type of request. 

### An intent filter has three main parts:
**1. Action:** what action it can perform (like VIEW, SEND, MAIN).

**2. Category:** additional information about where or how it can be used (like LAUNCHER(appear in app launcher), DEFAULT(used for implicit intent), BROWSABLE(allow app to open from a web link)). 

**3. Data:** what type of data it can handle (like a website link, image,text, or phone number). 

- This ensures that even if the action matches, the intent is only delivered to components capable of handling the actual data.


### How Intent Filters Work with Implicit Intents
When you create an implicit intent, you might say something like, “I want to view a web page at https://google.com.” 
Android looks through all installed apps and their intent filters. It matches the action (VIEW), checks if the category allows it (DEFAULT and BROWSABLE), and looks for a data match (https scheme). The system then decides which component to launch. If multiple apps match, Android shows the user a chooser dialog to pick the preferred app.


- This is why intent filters are so important for interoperability. They allow apps to respond to requests from other apps without directly knowing each other.


### A Real Example: Opening a Link in Your App

Imagine you want your app to open whenever a user clicks a link to https://myapp.com. You would write an intent filter in your AndroidManifest.xml like this:

``` kt
<intent-filter>
    <action android:name="android.intent.action.VIEW"/>
    <category android:name="android.intent.category.DEFAULT"/>
    <category android:name="android.intent.category.BROWSABLE"/>
    <data android:scheme="https" android:host="myapp.com"/>
</intent-filter>

```

When a user clicks such a link, Android will check all apps with intent filters. Your app will be offered as an option to open the link.


### Why Intent Filters are Important

- Without intent filters, implicit intents cannot work. Your app wouldn’t be able to respond to links, share actions, or other app-to-app communication. On the other hand, explicit intents don’t need intent filters because you are directly pointing to a component.

- Intent filters also allow your app to integrate with the system. For example, the Android launcher knows which app to show because the main activity has a filter with MAIN and LAUNCHER. Similarly, if you want your app to respond to a specific file type (like PDFs), you can set a data filter for that **MIME** type.  

Intent is also used for the notification (like battry saver)