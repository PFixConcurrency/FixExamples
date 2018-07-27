# FixExamples

examples是原来的程序

exportExamples是修复后的程序

generateClass是修复后的程序生成的class文件

logFile是将运行时的一些信息记录下来

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



|  id  |     program      | get pattern time(ms) | fix time(ms) | lock num |
| :--: | :--------------: | :------------------: | :----------: | :------: |
|  1   |     account      |        17684         |    297239    |    1     |
|  2   |  accountsubtype  |        26660         |    36790     |    1     |
|  3   |     airline      |         7205         |     5839     |    1     |
|  4   |    alarmclock    |         9086         |    77988     |   N/A    |
|  5   |    atmoerror     |        28411         |    24852     |    1     |
|  6   |   buggyprogram   |         7391         |     6197     |    2     |
|  7   |    checkfield    |         6553         |     5299     |    3     |
|  8   |   consisitency   |         5745         |     5042     |    1     |
|  9   |     critical     |        27123         |    114510    |    1     |
|  10  |     datarace     |         6979         |    37457     |    1     |
|  11  |       even       |         6333         |    85371     |    1     |
|  12  |   hashcodetest   |         6465         |     7093     |    1     |
|  13  |    linkedlist    |         6968         |    87626     |    1     |
|  14  |      log4j       |        68633         |    56707     |    1     |
|  15  |    mergesort     |        15503         |    292122    |   N/A    |
|  16  |     pingpong     |        29835         |    28491     |    1     |
|  17  |       pool       |        41531         |   1112062    |   N/A    |
|  18  | producerConsumer |        47483         |    440727    |   N/A    |
|  19  |     reorder      |         6516         |     5572     |    2     |
|  20  |      store       |         5136         |     6847     |    1     |
|  21  |   stringbuffer   |        27514         |    98194     |    1     |
|  22  |    wrongLock     |         6132         |     5009     |    1     |
|  23  |    wronglock2    |        27253         |    24670     |    1     |

