# Android PrefKot Library
Simplify usage of Android SharedPreferences in Kotlin by Delegates :)

## How to use
### Usage
```kotlin
/* if default is provided then there is no need to provide Type for function */
var pref by pref(
	pref = mySharedPreferences,
	key = "message", // key default value is Kotlin Property name's
	cache = true, // cache is true by default: if its off always get new values from SharedPreferences instance, else cache latest download
	default = "Hossain Khademian", // default can be a simple Value like "Hi" or Provider of its type like "Hossain Khademian"::toLower or { data.getSomthing() }, these providers use for lazy loading !!:)
)

// in class [Context | Activity | Application | View | Fragment]:
var pref1 by pref<String>()
var pref2 by pref(key= "State") { default: "Hello World!" }

// or use extensions
val pref3 by context.pref<Boolean>()


// use them as normal values
pref = "new Value"

val data = pref3
pref3 = false // Error
```
