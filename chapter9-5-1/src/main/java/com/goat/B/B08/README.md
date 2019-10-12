# 过滤器模式
    目的：使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来；
    实现：制定不同的规则来对一组对象进行过滤，然后对过滤结果进行分组。
    
    
    
    过滤器模式就是要吧集合中不需要的东西根据不同的的过滤规则，或者组合性质的过滤规则来进行过滤，
    留下最终想要的数据，而不会因为后来添加新的规则后，或者更换过滤要求而需要进行批量的修改代码，
    非常简便好用的设计模式。