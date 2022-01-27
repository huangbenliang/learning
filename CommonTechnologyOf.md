# 字符串判空

- if(s == null || s.length() == 0);    //效率低

- if(s == null || s.equals("")); //效率较高

- 使用org.springframework.util.StringUtils ：为空、空字符串等都会返回false

  System.out.println(StringUtils.hasText(null));    // false
  System.out.println(StringUtils.hasText(""));      // false
  System.out.println(StringUtils.hasText(" "));     // false
  System.out.println(StringUtils.hasText(" \t"));   // false
  System.out.println(StringUtils.hasText(" \t \n"));// false

# 未登录csdn复制

document.designMode='on'



# BeanUtils.copyProperties：用于转换对象，属性名要相同。

a、 b中的属性要名字相同，才能被赋值，不然的话需要手动赋值

## 字符串符号常量：

com.baomidou.mybatisplus.core.toolkit.StringPool
