Mutiple top-level class in the same java file
* Only one top-level class can be declared `public` in a java file. The other have no access modifier (private, protected) nor static. Usually there are helper classes. The purpose of including multiple classes in one source file is to bundle related support functionality (internal data structures, support classes, etc) together with the main public class.

* Difference
    * A nested class has access to private members of the outer class but helper class does not.
    * You may want your helper class to help multiple classes in the same package.
    * A static nested class can be declared public but not for helper class.
    * By design: Nesting a class (statically in Java) sends a clear message of intent: the nested class. It is only relevant and usable to support the outer class. It has no meaning on its own. (coupling)