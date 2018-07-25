Grail修复结果

| 程序名              | 修复时间     | lock count | 修复结果（Unicorn）               | 注释                                       | race | av   |
| ---------------- | -------- | ---------- | --------------------------- | ---------------------------------------- | ---- | ---- |
| Account          | 61min49s | 5          | success                     |                                          | 5    | 8    |
| AccountSubType   | 7min50   | 4          | success                     |                                          | 3    | 6    |
| Airline          | -        | -          | 失败                          | 无法修复，pecan检测不到我们的pattern的bug             | 6    | 0    |
| critical         | 2min17s  | 2          | 无法确认，不同反编译产生的结果不同，有的成功，有的失败 |                                          | 8    | 0    |
| even             | 2min35s  | 1          | 没有修复成功                      |                                          | 8    | 0    |
| hashcodetest     | 2min58s  | 2          | fail                        | 有死锁                                      | 4    | 0    |
| pingpong         |          | -          | fail                        | 无法修复，pecan检测不到我们的pattern的bug             | 2    | 0    |
| reorder          |          | -          | fail                        | unicorn也是长度为2 的pattern                   | 4    | 0    |
| store            |          | -          | fail                        | 无法修复，拼不出我们的pattern·                      | 1    | 0    |
| pool             |          |            | fail                        | pecan检测不到错误                              | 0    | 0    |
| wrongLock        | 2min36s  | 3          | success                     |                                          | 3    | 5    |
| consisitency     |          | -          | fail                        | pattern长度为4无法修复                          | 0    | 0    |
| wrongLock2       | 2min26s  | 1          | fail                        | 修复错误，在产生patch的过程中，加锁的代码被覆盖，原因未知，         | 1    | 0    |
| LinkedList       | -        | -          | fail                        | 涉及跨类无法修复                                 | 9    | 0    |
| datarace         |          | -          | fail                        | 修复失败，修复过程中产生exception                    | 3    | 0    |
| checkfield       |          | -          | fail                        | pecan无法构造unicorn给的pattern                | 5    | 0    |
| log4j            |          | -          | fail                        | pecan找不到错误,pecan无法构造unicorn给的pattern     | 0    | 0    |
| buggyprogram     | 2min23s  | 1          | fail                        | 修复错误，产生的patch无法修复bug，只有acquire，没有relase，死锁 | 9    | 1    |
| stringbuffer     | 2min52s  | -          | fail                        | 跨方法修复失败                                  | 0    | 1    |
| atmoerror        | 2min26s  | 1          | fail                        | 修复错误，在产生patch的过程中，加锁的代码被覆盖，原因未知，         | 3    | 0    |
| producerconsumer | 3min41s  |            | fail                        | 加锁不彻底                                    | 28   | 44   |
| alarmclock       | na       |            | fail                        | 修复过程中产生exception                         | 2    | 0    |
| mergesort        |          |            |                             | 无法检测到bug，原因未知                            | 0    | 0    |
|                  |          |            |                             |                                          |      |      |
|                  |          |            |                             |                                          |      |      |
|                  |          |            |                             |                                          |      |      |
|                  |          |            |                             |                                          |      |      |
|                  |          |            |                             |                                          |      |      |
|                  |          |            |                             |                                          |      |      |

