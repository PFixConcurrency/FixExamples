# FixExamples

**Specification **

*account*:

There is a deadlock in the original program and JPF determines the fix failed.But this is the most reasonable fix we can generate.

use pattern 

ReadWriteNode[1569,account.Account@1bf,amount,READ,Thread-4,account/Account.java:28]
ReadWriteNode[1580,account.Account@1bf,amount,WRITE,Thread-6,account/Account.java:20]
ReadWriteNode[1601,account.Account@1bf,amount,WRITE,Thread-4,account/Account.java:28]

We know that we lock 28 lines of the account.java file,like this:

synchronized (ac) {ac.amount += mn;

}

*accountsubtype*,buggyprogram:

Sometimes you need to run multiple times to get the correct fix.

*pingpong*:

This program's bug is difficult to expose and requires multiple runs.

**dir**

examples:original program

exportExamples:fixed program

generateClass:generate class file

logFile:log runtime information

**program entry**

|                    program main                    |
| :------------------------------------------------: |
|                    account.Main                    |
|                accountsubtype.Main                 |
|                    airline.Main                    |
|               alarmclock.AlarmClock                |
|                   atmoerror.Main                   |
|             buggyprogram.BuggyProgram              |
|               checkfield.CheckField                |
|                 consisitency.Main                  |
|                 critical.Critical                  |
|                   datarace.Main                    |
|                     even.Main                      |
|             hashcodetest.HashCodeTest              |
|                linkedlist.BugTester                |
|                mergesort.MergeSort                 |
| org.apache.commons.pool.impl.TestGenericObjectPool |
|        org.apache.log4j.TestThrowableStrRep        |
|                 pingpong.PingPong                  |
|         producerConsumer.ProducerConsumer          |
|                reorder.ReorderTest2                |
|                  store.StoreTest                   |
|           stringbuffer.StringBufferTest            |
|                   wrongLock.Main                   |
|                  wronglock2.Main                   |
