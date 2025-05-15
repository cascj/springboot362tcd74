const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot362tcd74/",
            name: "springboot362tcd74",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot362tcd74/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于协同过滤的个性化学习资源推荐系统设计与实现"
        } 
    }
}
export default base
