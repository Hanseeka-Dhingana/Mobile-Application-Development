#Layout
A Layout in Android defines how UI elements (Views) are arranged on the screen. It acts as a container that holds and organizes widgets like TextView, Button, EditText, ImageView, etc.
We can nest the layouts, and therefore we can create arbitrarily complex UIs using a combination of layouts. You can display your contents effectively by using the right combination of layouts.   

> Layout = Structure + Arrangement of UI elements in an Activity or Fragment.

**Layout Inflation**  
Converting XML layout into View objects in Java/Kotlin using setContentView(R.layout.layout_name)   

## Types of Layouts  
### 1. LinearLayout  
- Arranges views in a single row or column (vertically or horizontally).
- Children are placed one after another.


### 2. RelativeLayout
- Positions views relative to each other or to the parent layout.
- Allows flexible design without nested layouts.

### 3. ConstraintLayout 
- The most flexible and powerful layout.
- Positions elements using constraints (relationships) to other elements or parent.
- Reduces nested layouts and improves performance.


### 4.  FrameLayout
- Designed to hold a single child view, though multiple can overlap.
- Useful for fragments, images, or stack-like UIs.
### 5. TableLayout
- Organizes views into rows and columns, like an HTML table.
- Each row is a TableRow.


### 6. GridLayout 
- Arranges items in a grid form (rows × columns).
- Useful for calculator apps or image grids.

