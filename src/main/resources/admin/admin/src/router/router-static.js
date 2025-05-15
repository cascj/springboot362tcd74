import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import discusswenbenziyuan from '@/views/modules/discusswenbenziyuan/list'
    import wenbenziyuan from '@/views/modules/wenbenziyuan/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import biaoqian from '@/views/modules/biaoqian/list'
    import kechengziyuan from '@/views/modules/kechengziyuan/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import discussshipinziyuan from '@/views/modules/discussshipinziyuan/list'
    import shipinziyuan from '@/views/modules/shipinziyuan/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import chapterkechengziyuan from '@/views/modules/chapterkechengziyuan/list'
    import discusskechengziyuan from '@/views/modules/discusskechengziyuan/list'
    import messages from '@/views/modules/messages/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/discusswenbenziyuan',
        name: '文本资源评论',
        component: discusswenbenziyuan
      }
      ,{
	path: '/wenbenziyuan',
        name: '文本资源',
        component: wenbenziyuan
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/biaoqian',
        name: '标签',
        component: biaoqian
      }
      ,{
	path: '/kechengziyuan',
        name: '课程资源',
        component: kechengziyuan
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/discussshipinziyuan',
        name: '视频资源评论',
        component: discussshipinziyuan
      }
      ,{
	path: '/shipinziyuan',
        name: '视频资源',
        component: shipinziyuan
      }
      ,{
	path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
      ,{
	path: '/chapterkechengziyuan',
        name: '课程资源章节',
        component: chapterkechengziyuan
      }
      ,{
	path: '/discusskechengziyuan',
        name: '课程资源评论',
        component: discusskechengziyuan
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '公告信息分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
