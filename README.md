# Advanced UI Navigation App
 
## Features Implemented
- ✅ Bottom Navigation between Home, Profile, Settings
- ✅ Tabbed Layout in Profile (Info & Gallery tabs)
- ✅ Adaptive UI with responsive layouts
 
## Reflection Questions
 
### ❓ What did you learn about using fragments and navigation components?
I learned that instead of using old XML fragments, modern Android uses Compose functions for screens. The Navigation Component makes it easy to switch between screens - it automatically handles the back button and remembers where you've been.

### ❓ How did you make your UI adaptive to screen size or orientation?
I used Compose's built-in responsive layouts like Column and Row that automatically adjust to different screen sizes. It automatically reorganizes components when the phone is rotated, 
making responsive design implementation smooth.

### ❓ What challenges did you face when combining Bottom Navigation and Tabs?
Keeping track of two different navigation systems - the bottom navigation switches between main screens (Home, Profile, Settings), while the tabs switch within the Profile screen. Basically a nested navigation system. I had to make sure that when you leave the Profile screen and come back, the tabs remember which one you were on. It took some work to make both navigation systems work together smoothly.
