package ood;

public interface EmailProcessor {
    // 可以声明常量变量
    // 不能声明实例变量
    // 但将常量变量放在interface中违背了其作为接口的作用而存在的宗旨
    // 也混淆了interface与类的不同价值!!
    // 如果的确需要，可以将其放在相应的abstract class或Class中
    public int xx = 0; // Not recommended!!

    // 接口没有构造方法
    // public EmailProcessor() {} // WRONG!

    // interface中的每一个方法都是抽象方法
    // 都只是声明的 (declaration, 没有方法体)
    // 实现类必须要实现
    public String readEmail(String email);

    // 只能声明public的方法，不能声明private及protected的方法
    public void writeEmail();
}

