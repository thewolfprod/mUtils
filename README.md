# mUtils
###### Work In Progress
[![](https://jitpack.io/v/thewolfprod/mUtils.svg)](https://jitpack.io/#thewolfprod/mUtils)

**Simple kotlin tools used by me**

## Main
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

## Examples
Internet:
```
// Check if device is connected to internet
if (mNetwork.isInternetAvailable(applicationContext)) {
   // Device is connected to internet
} else {
   // Device is not connected to internet
}

// Check if Wi-Fi or mobile data is enabled
if (mNetwork.isNetworkEnabled(applicationContext)) {
   // Wi-Fi or mobile data is enabled
} else {
   // Wi-Fi or mobile data is disabled
}
```

Clipboard:
```
val text = "Hello World!"

mClipboard.Copy(
    context = ctx,
    textToCopy = text
)
	
// or
	
mClipboard.Copy(
    context = ctx,
    textToCopy = text
    toastMessage = "Copied!"
)
	
// or
	
mClipboard.Copy(
    context = ctx,
    textToCopy = text
    toastMessage = "Copied!"
    vibrate = true // VIBRATE permission needed!
)
```

String Generator:
```
val newUserUID = mStringGenerator.UID() // default length = 16
val newUserUID = mStringGenerator.UID(length = 8)
val newUserUID = mStringGenerator.UID(length = 8, allowedChars = "HELOWORLD1")
```

Time:
```
var currentTime: Long = mTime.currentTimeToLong()
var bannedTo: String = mTime.longToDate(currentTime + mTime.ONE_HOUR)
binding.banDetails.text = "You will be unbanned at $bannedTo"
```

Vibrator:
```
mVibrator.Vibrate(context = ctx)
mVibrator.Vibrate(context = ctx, durationInMillis = 350L // Works only in < Android 10 for now)
```
