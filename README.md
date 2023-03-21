# JavaCourseWork_1

## Java类与对象基础练习

 

### 目的：

1. 复习并熟练基本编程控制语句（这方面尚缺的同学，自己参考C课本复习）；

2. 掌握Java基础语法，重点包括数组的使用、封装类及其方法的使用；

3. 创建类并实例化对象，通过对象调用类的成员方法。重点掌握构造方法，对象初始化，static数据成员及方法，this指针，访问权限（public->protected->packagae->private）的设置，toString()方法的使用，传值及传引用，String类、StringBuffer类重要方法的使用。

### 作业难度级别及分数比例：

同学们编程水平有差异，请根据自己的实际能力，一定独立完成，切不可抄袭！一旦发现有雷同的代码，一律都以零分处理！

*： 考查基础知识点，通过学习课件及例题可以仿照编写的程序。（60%）

**：需要经过稍长时间思考，查看Java doc，程序稍微复杂，进一步熟练编程技巧。（25%）

***: 比较灵活具有挑战性，需要花费较长的时间思考，有多种解决方案；或者课程中没有详细讲解，需要自己探索学习的课题。（15%）

**提交说明：**提交源代码，即src下的.java文件，而不是class文件！以下7题每一道题放在一个独立的package里面，第二章练习共6题放在同一个package里，如果全部完成，共8个package。然后附加写一个简短的readme，文字说明你每道题完成的程度，说明后面加上运行结果截图。最后把所有package文件和readme打包为一个压缩包上传，切不可依次上传多个文件，上传文件名格式例如：计算机张三作业1.rar(zip)

提交第二章练习！！！

 

### 作业：

#### 1

1. *（15%）（1）创建一个类Position包含两个int类型的数据成员x,y来表示一个点的位置，实现以下运算方法，并写一个PositionTest类测试Position对象功能。

l Position move(int dx, int dy): 将一个点x,y向X和Y轴移动dx和dy。

l double distance(Position p): 计算当前对象this和对象p的距离。

l Position scale(int f):此this对象的x,y值乘以一个系数f。

l main()里创建一个包含a,b,c三个点的数组，a点移动一定距离至b点，b点x,y乘以系数f至c点，分别计算三个点之间的距离。

别忘了写一个toString()方法以便打印出对象的字符串形式。

（2） 添加一个复制构造方法(copy constructor), 复制构造方法的功能是一个对象作为参数，此对象的数据全部复制给新对象。仿照如下模板：

class Foo{ 

int a; 

Foo(int a){ this.a = a; }

Foo(Foo that){ this.a = that.a;}  // copy constructor 

在PositionTest中验证此复制构造方法。

####  2

2. *（15%）工具类例如java.Lang.Math提供的都是static，不可实例化的方法。assertEquals()方法常用于单元测试中检查运行结果值是否与期望的测试值相等。

（1）  创建一个工具类TestUtils，实现以下的static方法：

l  static void assertEquals(String, String, String)——检查第一个参数值（正确的期望值）是否等于第二个参数值（真实的输出值），如果两个String不相等，throw一个错误提示信息AssertionError对象，该信息以第三个参数为前缀，后面是期待值和真实的输出值，如：*error:expecting expected but was actual*。

l  static void assertEquals(int,int,String) ——和以上方法类似，不同的是检查int类型。

在Main里验证示例如下：

```
assertEquals(1,2，“Err!”);
//Err!:expecting 1(class java.Lang.Integer)but got 2(class java.Lang.Integer)
assertEquals(“1”, “2”，“Err!”);
//Err!:expecting 1(class java.Lang.String)but got 2(class java.Lang.String)
```

####  3

3. *（20%） 编写一个Matrix类，包含两个数据成员：String inArr(输入的字符矩阵),int n(N*N矩阵的行数)。矩阵都是以一维形式保存的二维数组，比如输入String类型的"1,2,3,4,5,6,7,8,9"，实际上表示如下3*3的矩阵： 
    1,2,3,4,5,6,7,8,9。实现以下功能：

（1）  String add(String inArr,int n):实现两个N*N矩阵的相加，返回相加后的字符矩阵。

（2）  String subtraction(String inArr,int n): 实现两个N*N矩阵的相减，返回相加后的字符矩阵。

（3）  String multiply(String inArr,int n): 实现两个N*N矩阵的相乘，返回相乘后的字符矩阵。

（4）  String rotation ( ):将N*N矩阵的行列互换，返回转值后的字符矩阵，例如，输入InArr ="1,2,3,4,5,6,7,8,9"，n=3 返回："1,4,7,2,5,8,3,6,9"。

####  4

4. **（15%） String类的练习：在一个类StringOperator中，编写几个String的方法，实现对String的多种操作。

（1） String strAppend(String str，int n) 将str做n次复制，粘贴在原str后面，例如str为“java”，复制粘贴2次后结果为“javajavajava”。

（2） void strBufferAppend(StringBuffer a，int n)：改用StringBuffer或者StringBuilder实现复制粘贴string功能。比较两种方法有和不同。

（3） String strCompress(String str)：将给定的字符串，连续重复出现的字母用数字表示重复率，输出压缩后的字符串。例如”aaaa”压缩为”a4” 
 注：仅是单个字符连续才压缩，如babababa则不能压缩 输入：srcStr = "aaacccddef" 返回："a3c3d2ef"。

（4）String strEncryt(String str，int n)：将str进行字符串加密，返回加密后结果。加密算法是将每个字母依次向后偏移n位，例如字母A偏移3位后为D。

（5） boolean subText(String a, String b): 如果a中的所有字母都在b中出现（不要求相同次序），返回true, 否则返回false。

例如 subText(‘acer’, ‘racecar’) 返回true

​    	subText(‘babble’,‘probable’ ) 返回false

####  5

5. \*\*\*（8%）采用Junit写测试代码，assertEquals()方法对StringOperator类的方法完成单元测试，测试过程中如果出错，说明期待值、真实值和出错原因。

#### 6

6. \*\*某市开发一个电子借阅系统，服务于两个图书馆，可提供借阅、查询及返还图书功能。以下了提供两个类代码框架，Book和Library，要求你补充完整代码，实现功能。

* （10%）**第一步: 实现 Book** 

  	Book类定义了几个方法：获取书名、是否已借阅、借阅及返还功能，请把方法内功能补充完整。main()里测试方法，程序运行示例如下：

```bash
Title (should be The Da Vinci Code): The Da Vinci Code, 2002-01-19
Rented? (should be false): false, book entry time isv2002-01-19
Rented? (should be true): true, borrowed on 2020-12-20
Rented? (should be false): false, returned on 2021-01-20
```

- (10%）第二步: 实现 Library\*\* 

  Library类管理两个图书馆的书籍，每个图书馆开放时间均为9 AM 至5 PM，各自有不同的地点和收藏书籍，书籍可以用数组定义。请将Library类代码补充完整。

**注意：有些方法可能需要定义为static，不要更改main里的方法调用**

程序运行结果示例如下：

```bash
Library hours:
Libraries are open daily from 9am to 5pm.

Library addresses:
10 Main St.
228 Liberty St.

Borrowing The Lord of the Rings:
You successfully borrowed The Lord of the Rings
Sorry, this book is already borrowed.
Sorry, this book is not in our catalog.

Books available in the first library:
The Da Vinci Code
Le Petit Prince
```

####  7

7. \*\*\*（7%）实现Magic Squres,题目要求及代码架构请参看Magic Squares文件夹
