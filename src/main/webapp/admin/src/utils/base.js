const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm1lm5q/",
            name: "ssm1lm5q",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm1lm5q/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园跑腿小程序"
        } 
    }
}
export default base
