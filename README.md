# WechatShop
用于微信网上商城的团队开发仓库

http://www.cnblogs.com/liuhongfeng/p/5099149.html   微信网页授权获取用户基本信息
springmvc默认拦截器会拦截静态资源   设置所有的springmvc请求后缀都为.action结尾

9天开发时间
要实现的功能：
	1.主页面	微信接口连接，认证登陆，主页面的各种链接，获取商品的前20种并显示
	2.商品的详细信息页面	 商品的图片,名称，价格
	3.购物车页面	查询购物车表 生成购物车 js计算总价，后台计算总额，提交后生成订单表
	4.用户页面		送货地址上传      个人信息查看

购物车session为WareGwc
订单表中商品存放json字符串    工具类为com.ssm.wechatshop.utils.JsonList，
模拟用户登录session为user
用户登录时同时存储address的session,名字为address