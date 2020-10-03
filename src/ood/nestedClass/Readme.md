# Nested class

## Definition
A `nested class` is any class whose declaration occurs within the body of another class or interface. A `top level class` is a class that is not a nested class.

* __It is a way of logically grouping classes that are only used in one place__ If a class is useful to only one class, then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined.

* __It increases encapsulation__ Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared `private`. By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.

* __It can lead to more readable and maintainable code__ Nesting small classes within top-level classes places the code closer to where it is used.

```java
public class Solution {
    public static class NestedStaticClass {
    }

    public class InnerClass {
    }
}

class HelperClass {

}
```

## Difference between `non-static nested class` and `static nested class`

* Inner class (or Non-static nested class) needs a reference of outer class.
* static nested class只能访问outer class的static member，不能访问non-static member. Inner class都可以访问
* inner class可以直接拿到outer class的这个instance的reference: `Outerclass.this`
* __prefer nested static class to inner classes__ Only use the inner class when you have to access instance info.

## Mutiple top-level class in the same java file
* Only one top-level class can be declared `public` in a java file. The other have no access modifier (private, protected) nor static. Usually there are helper classes. The purpose of including multiple classes in one source file is to bundle related support functionality (internal data structures, support classes, etc) together with the main public class.

* Difference
    * A nested class has access to private members of the outer class but helper class does not.
    * You may want your helper class to help multiple classes in the same package.
    * A static nested class can be declared public but not for helper class.
    * By design: Nesting a class (statically in Java) sends a clear message of intent: the nested class. It is only relevant and usable to support the outer class. It has no meaning on its own. (coupling)