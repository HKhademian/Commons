# RxBus2
This is a simple Rx2 Event Bus implementation using Kotlin. for RxJava2, RxKotlin2 and RxAndroid2 project

## How to use
### Registered
```kotlin
//subscribe to events (registered)
RxBus.observe<ExampleEvent>()
  .subscribe { doSomething() }
  .registerInBus(this) //registers your subscription to unsubscribe it properly later
 
//send events
RxBus.send(WhatEverEvent(someData))
 
// at the end
//unsubscribe from events
RxBus.unregister(this)
```
### UnRegistered
```kotlin
//subscribe to events (unregistered)
val disposable = RxBus.observe<ExampleEvent>()
  .subscribe { doSomething() }
  
// at the end for each disposable
disposable.dispose()
```    
### Bus Instance
```kotlin
val bus = RxBus // default instance
val bus = RxBus() // new Instance
```    
### Java usage
```java
final RxBus bus = RxBus.getInstance() // default instance
final RxBus bus = new RxBus() // new bus
```    
