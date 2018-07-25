**account** 

定位到的pattern
ReadWriteNode[987,account.Account@1bf,amount,READ,Thread-4,account/Account.java:28]
ReadWriteNode[993,account.Account@1bf,amount,WRITE,Thread-6,account/Account.java:16]
ReadWriteNode[1024,account.Account@1bf,amount,WRITE,Thread-4,account/Account.java:28]

结果：在Account.java的28行加了ac锁

**airline**

定位到的pattern定位到的pattern
ReadWriteNode[367,airline.Bug,Num_Of_Seats_Sold,READ,Thread-18,airline/Bug.java:61]
ReadWriteNode[376,airline.Bug,Num_Of_Seats_Sold,WRITE,Thread-20,airline/Bug.java:60]

检查：60和14行，60和51行

**AlarmClock**

定位到的pattern
ReadWriteNode[834,alarmclock.MyLinkedList@162,size,WRITE,Thread-1,alarmclock/AlarmClock.java:295]
ReadWriteNode[845,alarmclock.MyLinkedList@162,size,READ,Thread-8,alarmclock/AlarmClock.java:339]

结果：在AlarmClock.java的295和339行加锁

**HashCodeTest**

定位到的pattern
ReadWriteNode[308,hashcodetest.IntRange@166,hashCode,READ,Thread-10,hashcodetest/IntRange.java:355]
ReadWriteNode[346,hashcodetest.IntRange@166,hashCode,WRITE,Thread-7,hashcodetest/IntRange.java:357]

结果：在IntRange.java的355-360行加了this锁

**reorder** 

定位到的pattern
ReadWriteNode[26,reorder.SetCheck@167,a,WRITE,Thread-2,reorder/SetCheck.java:14]
ReadWriteNode[66,reorder.SetCheck@167,a,READ,Thread-3,reorder/SetCheck.java:19]

结果：19和14行加锁

**store**

定位到的pattern
ReadWriteNode[61,store.Store@15e,customerCost,READ,Thread-2,store/Store.java:12]
ReadWriteNode[65,store.Store@15e,customerCost,WRITE,Thread-1,store/Store.java:12]

对12行加锁

**WrongLock** 

定位到的pattern
ReadWriteNode[33,wrongLock.Data@15f,value,READ,Thread-1,wrongLock/WrongLock.java:18]
ReadWriteNode[42,wrongLock.Data@15f,value,WRITE,Thread-2,wrongLock/WrongLock.java:28]
ReadWriteNode[43,wrongLock.Data@15f,value,READ,Thread-1,wrongLock/WrongLock.java:19]

结果：WrongLock.java。18行加锁，28行加锁（这个应该是我们之前讨论的跨类修复）