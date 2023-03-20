# mUtils
###### Work In Progress
[![](https://jitpack.io/v/thewolfprod/mUtils.svg)](https://jitpack.io/#thewolfprod/mUtils)

**Simple kotlin tools used by me**

- Internet
  - Check if device is connected to internet
  - Check if device have mobile data or Wi-Fi enabled
  
- Clipboard
  - Copy text
  - Copy text, show toast
  - Copy text, show toast, vibrate
  
- String
  - UID Generator with different length and characters
  
- Time
  - Current time to long
  - Long to date
  - Date (String) to long

- Vibrator
  - Vibrate

**Add it in your root build.gradle at the end of repositories:**
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Add the dependency:**
```
dependencies {
	        implementation 'com.github.thewolfprod:mUtils:x.x.x'
	}
```
