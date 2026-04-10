# What is the Deep Linking? 


Deep linking is used in Android (and mobile apps in general) to **take the user directly to a specific screen inside an app instead of just opening the app’s home screen**. Normally, when you tap an app icon, the app opens from the beginning. But many times, users don’t want to start from the beginning—they want to go directly to a product page, a message, a profile, or an offer. Deep linking solves this problem by allowing a **link (like a URL)** to open a **particular screen inside the app**.

**For example:** imagine you receive a message that says: *“Your order has been shipped. Track it here.”* If deep linking is **not used**, tapping the link might only open the app’s home screen, and then the user has to search for the order manually. This feels slow and frustrating. When deep linking **is used**, the link opens the app and takes the user **directly to the order tracking screen**. This saves time and makes the app feel smarter and more helpful.

## Importance of Deep Linking
- Deep linking also improves the experience when users come from **outside the app**, such as from emails, SMS, notifications, or social media. When a user clicks a link from these places, deep linking ensures that the app opens at the **exact content related to the link**, not somewhere random. This makes the transition smooth and natural, so users feel like the app understands what they want.

- Another important benefit of deep linking is that it helps **new users**. If someone does not have the app installed and clicks a deep link, the system can first take them to the **Play Store to install the app**, and then open the specific screen once the app is installed. This reduces confusion and increases the chances that users will actually use the app after installing it.

- Deep linking also makes apps feel **faster and more user-friendly**. Users don’t like extra steps. When an app opens exactly where they expect, it feels responsive and well-designed. This builds trust and increases user satisfaction, which can lead to higher engagement and retention.






I’ll explain **how deep linking is used in Android code** in a **very simple, beginner-friendly way**, step by step, using **intent filters and basic Activity code**, and mostly in **paragraph form** as you prefer.

---

### **How deep linking works in code (big picture)**

Deep linking in Android works using **intents and intent filters**. When a user clicks a link (for example, from a browser, email, or notification), Android creates an **implicit intent**. Android then looks at all installed apps and checks their **intent filters** to see which app says, *“I can open this type of link.”* If your app has a matching intent filter, Android opens your app and sends the link data to your Activity. Your Activity then reads that data and opens the correct screen.

So, deep linking has **two main parts in code**:

1. Declaring the deep link in **AndroidManifest.xml**
2. Handling the link inside the **Activity code**

---

### **Step 1: Add deep link intent filter in AndroidManifest.xml**

First, you tell Android that your Activity can open a specific link. This is done using an **intent filter**.

Example: You want your app to open when someone clicks
`https://myapp.com/profile`

```xml
<activity android:name=".ProfileActivity">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />

        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />

        <data
            android:scheme="https"
            android:host="myapp.com"
            android:pathPrefix="/profile" />
    </intent-filter>
</activity>
```

What this means in simple words:
You are telling Android, *“If someone clicks an HTTPS link from myapp.com that starts with /profile, my ProfileActivity can open it.”*

At this point, deep linking is **registered** in the system.

---

### **Step 2: Receive the link inside your Activity**

When the user clicks the link, Android opens your app and launches `ProfileActivity`. The link data is passed to the Activity through the **Intent**.

Inside your Activity, you read the link like this:

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

    Intent intent = getIntent();
    Uri data = intent.getData();

    if (data != null) {
        String fullLink = data.toString();
        // Example: https://myapp.com/profile?id=123
    }
}
```

Here, `getIntent()` gives you the intent that opened the Activity, and `getData()` gives you the link that was clicked.

---

### **Step 3: Use the link data to open correct content**

Now suppose the link is:
`https://myapp.com/profile?id=123`

You can extract the ID like this:

```java
String userId = data.getQueryParameter("id");
```

Then you can load the correct profile based on that ID.

In simple terms, this means:
*“User clicked a link for profile 123, so open profile 123 inside the app.”*

---

### **What happens if the app is not installed?**

If the app is **not installed**, normal deep links will just open in the browser. To solve this, Android provides **App Links** (verified deep links), which automatically open the app if installed, or send the user to the Play Store if not. This is an advanced version of deep linking, but the basic idea remains the same.

---

### **Why this improves user experience**

Because of this code:

* The user taps a link
* The app opens directly to the exact screen
* No extra navigation
* No confusion

The app feels **fast, smart, and connected**.

---

### **Very simple summary**

Deep linking in code means:

* You declare a link pattern using **intent filters**
* Android sends the clicked link to your Activity
* Your Activity reads the link and opens the correct screen

---

If you want next, I can explain:

* **Deep link vs App link**
* **Deep linking using Firebase Dynamic Links**
* **A full real-world example (login → profile → product page)**

Just tell me 👍


