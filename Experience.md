# java基础

## 类初始化顺序

在涉及静态static块/静态对象,实例块/实例对象,构造函数，初始化调用顺序会混淆。

结论（参考《On java8》）：

1. 类的代码在首次使用时加载。这通常指创建类的第一个对象，或者是访问了类的static属性或方法。
2. 所有的static对象和static块在加载时`按书写顺序依次初始化`，static对象和块只初始化执行一次。首先初始化父类的static对象和static块，再初始化子类的static对象和块。（基本类型变量初始化有默认值，引用类型初始化为null）
3. 初始化父类的实例对象和实例块（按书写顺序），在初始化子类的实例对象和实例块。
4. 执行父类构造函数，最后执行子类构造函数。

以下面代码为例进行说明：

```java
package _08reuse;

class Insect {
	private static int staticBlock;
	private static final int x1 = printInit("static Insect.x1 initialized");

	//静态块
	static {
		System.out.println("Insert static block.staticBlock=" + staticBlock);
		staticBlock = 9;
		System.out.println("Insert static block.staticBlock=" + staticBlock);
		System.out.println(x1);
	}

	protected int j;
	private final int i = 9;
	private int instanceBlock;
	private final int k = printInit("Insect.k.initialized");

	{
		//System.out.println(k);  在这里写会报错，因为k还没有声明。
	}

	{
		System.out.println("Insert instance block.instanceBlock=" + instanceBlock);
		instanceBlock = 9;
		System.out.println("Insert instance block.instanceBlock=" + instanceBlock);
		System.out.println(k);

	}

	Insect() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}

public class Beetle extends Insect {
	private static final int x2 = printInit("static Beetle.x2 initialized");
	private final int k = printInit("Beetle.k.initialized");

	public Beetle() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}

	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		Beetle b = new Beetle();
	}
}

```
结果如下：

![](https://gitee.com/huangbenliang/picgo/raw/master/idea/2022-03-05-xMRv3a.png)

## 抽象类与接口
1. 接口的典型使用是代表一个类的类型或一个形容词，如 Runnable 或 Serializable，而抽象类通常是类层次结构
的一部分或一件事物的类型，如 String 或 ActionHero。
2. Java 通过默认方法具有了某种多继承的特性。结合带有默认方法 的接口意味着结合了多个基类中的行为。因为接口中仍然不允许存在属性（只有静态属性，不适用），所以属性仍然只会来自单个基类或抽象类，也就是说，不会存在状态的
   多继承。
![](https://gitee.com/huangbenliang/picgo/raw/master/idea/2022-03-06-I1SKDh.png)

## lambda与方法饮用
1. lambda传递的是函数，但是Java中一切皆对象，所以可以把lambda表达式当成是**对接口的匿名实现类**对待。
2. 当**引用类的静态方法或者引用实例对象的实例方法**时，**返回值和参数列表**需要完全相同。
3. 当**引用类的实例方法**时，要实现的接口方法中第一个参数是当前类的this对象。

如：
```java
package $11;

import java.util.function.Function;

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class MethodReference {
    public static void main(String[] args) {
// MakeString ms = X::f; // [1]
        TransformX sp = X::f;
        Function<X,String> function=X::f;
        X x = new X();

        System.out.println(sp.transform(x)); // [2]
        System.out.println(function.apply(x));
        System.out.println(x.f()); // 同等效果
    }
}
```
***
# spring开发常识
## 字符串判空

- if(s == null || s.length() == 0);    //效率低

- if(s == null || s.equals("")); //效率较高

- 使用org.springframework.util.StringUtils ：为空、空字符串等都会返回false

  System.out.println(StringUtils.hasText(null));    // false
  System.out.println(StringUtils.hasText(""));      // false
  System.out.println(StringUtils.hasText(" "));     // false
  System.out.println(StringUtils.hasText(" \t"));   // false
  System.out.println(StringUtils.hasText(" \t \n"));// false

## 未登录csdn复制

document.designMode='on'

## BeanUtils.copyProperties：用于转换对象，属性名要相同。

a、 b中的属性要名字相同，才能被赋值，不然的话需要手动赋值

## 字符串符号常量：
com.baomidou.mybatisplus.core.toolkit.StringPool
