import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import jiaoshiList from '../pages/jiaoshi/list'
import jiaoshiDetail from '../pages/jiaoshi/detail'
import jiaoshiAdd from '../pages/jiaoshi/add'
import biaoqianList from '../pages/biaoqian/list'
import biaoqianDetail from '../pages/biaoqian/detail'
import biaoqianAdd from '../pages/biaoqian/add'
import wenbenziyuanList from '../pages/wenbenziyuan/list'
import wenbenziyuanDetail from '../pages/wenbenziyuan/detail'
import wenbenziyuanAdd from '../pages/wenbenziyuan/add'
import shipinziyuanList from '../pages/shipinziyuan/list'
import shipinziyuanDetail from '../pages/shipinziyuan/detail'
import shipinziyuanAdd from '../pages/shipinziyuan/add'
import kechengziyuanList from '../pages/kechengziyuan/list'
import kechengziyuanDetail from '../pages/kechengziyuan/detail'
import kechengziyuanAdd from '../pages/kechengziyuan/add'
import kechengziyuanChapter from '../pages/kechengziyuan/chapter'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import discusswenbenziyuanList from '../pages/discusswenbenziyuan/list'
import discusswenbenziyuanDetail from '../pages/discusswenbenziyuan/detail'
import discusswenbenziyuanAdd from '../pages/discusswenbenziyuan/add'
import discussshipinziyuanList from '../pages/discussshipinziyuan/list'
import discussshipinziyuanDetail from '../pages/discussshipinziyuan/detail'
import discussshipinziyuanAdd from '../pages/discussshipinziyuan/add'
import discusskechengziyuanList from '../pages/discusskechengziyuan/list'
import discusskechengziyuanDetail from '../pages/discusskechengziyuan/detail'
import discusskechengziyuanAdd from '../pages/discusskechengziyuan/add'
import chapterkechengziyuanList from '../pages/chapterkechengziyuan/list'
import chapterkechengziyuanDetail from '../pages/chapterkechengziyuan/detail'
import chapterkechengziyuanAdd from '../pages/chapterkechengziyuan/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'jiaoshi',
					component: jiaoshiList
				},
				{
					path: 'jiaoshiDetail',
					component: jiaoshiDetail
				},
				{
					path: 'jiaoshiAdd',
					component: jiaoshiAdd
				},
				{
					path: 'biaoqian',
					component: biaoqianList
				},
				{
					path: 'biaoqianDetail',
					component: biaoqianDetail
				},
				{
					path: 'biaoqianAdd',
					component: biaoqianAdd
				},
				{
					path: 'wenbenziyuan',
					component: wenbenziyuanList
				},
				{
					path: 'wenbenziyuanDetail',
					component: wenbenziyuanDetail
				},
				{
					path: 'wenbenziyuanAdd',
					component: wenbenziyuanAdd
				},
				{
					path: 'shipinziyuan',
					component: shipinziyuanList
				},
				{
					path: 'shipinziyuanDetail',
					component: shipinziyuanDetail
				},
				{
					path: 'shipinziyuanAdd',
					component: shipinziyuanAdd
				},
				{
					path: 'kechengziyuan',
					component: kechengziyuanList
				},
				{
					path: 'kechengziyuanDetail',
					component: kechengziyuanDetail
				},
				{
					path: 'kechengziyuanAdd',
					component: kechengziyuanAdd
				},
				{
					path: 'kechengziyuanChapter',
					component: kechengziyuanChapter
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'discusswenbenziyuan',
					component: discusswenbenziyuanList
				},
				{
					path: 'discusswenbenziyuanDetail',
					component: discusswenbenziyuanDetail
				},
				{
					path: 'discusswenbenziyuanAdd',
					component: discusswenbenziyuanAdd
				},
				{
					path: 'discussshipinziyuan',
					component: discussshipinziyuanList
				},
				{
					path: 'discussshipinziyuanDetail',
					component: discussshipinziyuanDetail
				},
				{
					path: 'discussshipinziyuanAdd',
					component: discussshipinziyuanAdd
				},
				{
					path: 'discusskechengziyuan',
					component: discusskechengziyuanList
				},
				{
					path: 'discusskechengziyuanDetail',
					component: discusskechengziyuanDetail
				},
				{
					path: 'discusskechengziyuanAdd',
					component: discusskechengziyuanAdd
				},
				{
					path: 'chapterkechengziyuan',
					component: chapterkechengziyuanList
				},
				{
					path: 'chapterkechengziyuanDetail',
					component: chapterkechengziyuanDetail
				},
				{
					path: 'chapterkechengziyuanAdd',
					component: chapterkechengziyuanAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
