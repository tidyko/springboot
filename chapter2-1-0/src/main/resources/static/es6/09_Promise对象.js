
/**
 1. 理解:
 * Promise对象: 代表了未来某个将要发生的事件(通常是一个异步操作)
 * 有了promise对象, 可以将异步操作以同步的流程表达出来, 避免了层层嵌套的回调函数(俗称'回调地狱')
 * ES6的Promise是一个构造函数, 用来生成promise实例

 * 第一种：调用promise的then()
 promise.then(function(
 result => console.log(result),
 errorMsg => alert(errorMsg)
 ))

 * 第二种：调用promise的then()与.catch() --------用的不多
 promise.then(function(
 result => console.log(result),
 errorMsg => alert(errorMsg)
 ))

 3. promise实例对象的3个状态
 * pending: 初始化状态
 * fullfilled: 成功状态
 * rejected: 失败状态

 4. 应用:
 * 使用promise封装处理ajax请求

 */

//回调地狱
setTimeout(()=>{
    console.log('我是第1次请求回来的信息')
    setTimeout(()=>{
        console.log(`我是第2次请求回来的信息`)
        setTimeout(()=>{
            console.log(`我是第3次请求回来的信息`)
        },1000)
    },1000)
},1000)





 
 //模拟一个发送ajax请求的函数
 function senAjax(i) {
    let myPromise = new Promise((resolve,reject)=>{
      setTimeout(()=>{
        console.log(`第${i}次的请求成功了！`)
        resolve()
      },1000)
    })
   return myPromise
 }

 //第一次请求
  senAjax(1)
    .then(()=>{
      return senAjax(2)
      //then方法如果我们不手动返回Promise实例，程序会自动返回Promise实例，并且是成功状态
    })
    .then(()=>{
    return senAjax(3)
  })
