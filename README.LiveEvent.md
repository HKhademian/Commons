# Android LiveEvent Library
This is a simple library to handle UI events based on Android LiveData architecture library.

If `observer` is passed then: 
If `lifecycleOwner` is  not passed or `null` it use `observeForever(observer)` insteadof `observe(lifecycleOwner, observer)`.

## How to use
### Usage
```kotlin
// Simple create a SingleLiveEvent<String>
val event by liveEvent<String>

// Also register an default|first Observer
val event by liveEvent<String>(lifecycleOwner) { value ->
	Logger.e('test', value)
}

// lifecycleOwner parameter automaticly use in AppCompat activities !
// else if lifecycleOwner does not send then it observes for ever !!
val event by liveEvent { value: Boolean ->
	Logger.e('test', "check: $value")
}

// Use another LiveEvent types
val event by liveEvent<String>(clazz= OneShotLiveEvent::class)

// specify event class (default is SingleLiveEvent)
val event by liveEvent<String>(lifecycleOwner, OneShotLiveEvent::class) {
	// actions
}

// from google samples Handles only one observer
val event : LiveEvent<String> = SingleLiveEvent()
 
// from QAs Handles only one observer (not recommended)
val event : LiveEvent<String> = MutableLiveEvent()
 
// from QAs Handles many observers
val event : LiveEvent<String> = OneShotLiveEvent()
```

### Observe
```kotlin
event.observe(lifecycleOwner, Observer {
	// actions on event
})
```
