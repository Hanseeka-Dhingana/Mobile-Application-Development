# LinearLayout  
LinearLayout arranges its child views in a single direction either vertically or horizontally. It is one of the simplest and oldest layouts in Android.  
**Why We Use It**  
- For simple screens where items are displayed one after another (e.g., login form).
- Best when the number of elements is small and in a line.

## Esential attributes of LinearLayout

| Attribute                 | Description                                                          |
| ------------------------- | -------------------------------------------------------------------- |
| `android:id`              | Assigns a `unique id` to the layout.                                 |
| `android:orientation`     | Defines layout direction: `"vertical"` or `"horizontal"`.            |
| `android:layout_weight`   | Defines how much space each child should take relative to others.    |
| `android:gravity`         | Positions all child views inside layout (e.g., center, left, right). |
| `android:layout_gravity`  | Positions a **single child** inside parent layout.                   |
| `android:divider`         | Adds divider lines between children.                                 |
| `android:baselineAligned` | Controls text alignment for better UI.                               |       


## Advantages and Disdavantages   

### Advantages:
- **Simple to use:** Easy to understand and implement
- **Predictable layout:** Children appear in the order they're defined
- **Weight distribution:** Excellent for proportional space allocation
- **Low complexity:** Less computational overhead than RelativeLayout
### Disadvantages:

- **Limited flexibility:** Can only arrange in one direction
-**Nesting issues:** Complex layouts require multiple nested LinearLayouts
- **Performance impact:** Deep nesting can slow down UI rendering


## Practical example using essential attributes    

``` xml
<LinearLayout
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:baselineAligned="true"
    android:padding="16dp"
    android:divider="?android:attr/dividerHorizontal"
    android:showDividers="middle">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Username"
        android:layout_gravity="center"
        android:layout_marginBottom="8dp" />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter username"
        android:layout_weight="1"
        android:layout_marginBottom="12dp" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Login"
        android:layout_gravity="center"
        android:layout_weight="0" />
</LinearLayout>

```

