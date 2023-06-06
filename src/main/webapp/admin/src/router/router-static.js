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
    import yijiedingdan from '@/views/modules/yijiedingdan/list'
    import dingdanpingjia from '@/views/modules/dingdanpingjia/list'
    import xitonggonggao from '@/views/modules/xitonggonggao/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import chat from '@/views/modules/chat/list'
    import paotuizhe from '@/views/modules/paotuizhe/list'
    import zaixianxiadan from '@/views/modules/zaixianxiadan/list'
    import yiwanchengdingdan from '@/views/modules/yiwanchengdingdan/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
	path: '/yijiedingdan',
        name: '已接订单',
        component: yijiedingdan
      }
      ,{
	path: '/dingdanpingjia',
        name: '订单评价',
        component: dingdanpingjia
      }
      ,{
	path: '/xitonggonggao',
        name: '系统公告',
        component: xitonggonggao
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/chat',
        name: '在线客服',
        component: chat
      }
      ,{
	path: '/paotuizhe',
        name: '跑腿者',
        component: paotuizhe
      }
      ,{
	path: '/zaixianxiadan',
        name: '在线下单',
        component: zaixianxiadan
      }
      ,{
	path: '/yiwanchengdingdan',
        name: '已完成订单',
        component: yiwanchengdingdan
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;
