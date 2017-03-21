<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0046)http://d.umq.me/allinpay/Tests/testMobile.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>优方外卖整合平台API接口测试程序</title>
  <style type="text/css">
    .style1{font-size:small}
    #webServiceUrl{width:462px}
    #input{width:730px;height:180px}
    #output{width:730px;height:180px}
    #status{font-size:small}
    .label{padding:2px;border:solid 1px grey}
  </style>
  <script type="text/javascript" src="assets/wmtest/js/jquery-1.7.1.min.js"></script>
  <script type="text/javascript" src="assets/wmtest/js/jquery.xmlext.js"></script>
  <script src="assets/wmtest/js/jquery.utility.js" type="text/javascript"></script>
  <script src="assets/wmtest/js/waimai.test.js?v=1702071506" type="text/javascript"></script>
  <script type="text/javascript">

    //外卖API测试接口
    var wmapi = [
      {n:'M001-客户端应用校验',v:'{"header":{"version":"1.0","transType":"T100","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.system.validateapp"},"body":{"appId":"182000899000001","appVersionNo":"1","appVersion":"1.0","deviceType":"clientz","deviceOS":"clientz","deviceOSVersion":"44","deviceModel":"clientz"}}'},
      {n:'M002-客户端应用版本查询',v:'{"header":{"version":"1.0","transType":"T100","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.system.queryappversion"},"body":{"appId":"182000899000001","appVersionNo":"1","appVersion":"1.0","deviceId":"","deviceType":"clientz","deviceOS":"clientz","deviceOSVersion":"44","deviceModel":"clientz","browserType":"","browserVersion":""}}'},
      {n:'M003-客户端错误报告',v:'{"header":{"version":"1.0","transType":"M003","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.system.reportexception"},"body":{"appId":"182000899000001","appVersionNo":"1","appVersion":"1.0","deviceType":"clientz","deviceOS":"clientz","deviceOSVersion":"44","deviceModel":"clientz","bugDesc":"APP出错了，记录到日志文件。"}}'},
      {n:'M004-客户端应用信息查询',v:'{"header":{"version":"1.0","transType":"M004","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.system.queryappinfo"},"body":{"appId":"182000899000001","htmlType":"1"}}'},

      {n:'T100-商户登录',v:'{"header":{"version":"1.0","transType":"T100","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.login"},"body":{"shopId":"182000899000001","shopOperId":"002","password":"123456"}}'},
      {n:'T101-店铺基本信息查询',v:'{"header":{"version":"1.0","transType":"T101","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.queryshopinfo"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb"}}'},
      {n:'T102-店铺营业情况查询',v:'{"header":{"version":"1.0","transType":"T102","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.shopbusinessinfo"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb"}}'},
      {n:'T103-商户营业状态修改接口',v:'{"header":{"version":"1.0","transType":"T103","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.shopbusinessstatus"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","channelId":"","status":"1"}}'},
      {n:'T104-客户端投诉建议接口',v:'{"header":{"version":"1.0","transType":"T105","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.shopcomplain"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","complainMsg":"投诉建议..."}}'},
      {n:'T105-商户名称查询',v:'{"header":{"version":"1.0","transType":"T105","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.queryshopname"},"body":{"shopId":"182000899000001"}}'},
      {n:'T106-商户外卖平台查询',v:'{"header":{"version":"1.0","transType":"T106","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.queryplatform"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb"}}'},
      {n:'T107-商户名称与LOGO查询',v:'{"header":{"version":"1.0","transType":"T107","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.querymerclogo"},"body":{"appId":"01806661"}}'},
      {n:'T108-商户退出登录',v:'{"header":{"version":"1.0","transType":"T108","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.exitlogin"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb"}}'},
      {n:'T109-外卖功能开启',v:'{"header":{"version":"1.0","transType":"T109","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.openwm","termSn":"LANDI50905703"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","clientId":"3990144733b2724776c8b832ab32b7d0","forcedLogin":"1","termType":"1"}}'},

      {n:'T201-订单查询',v:'{"header":{"version":"1.0","transType":"T201","submitTime":"20160725164113","sessionId":"","clientTraceNo":"","method":"unionlive.order.list"},"body":{"loginSessionId":"2cdd575a-ff7f-4be4-b038-012dec19e5a5","status":-1,"channelId":"189021000009002","pageSize":3,"pageIndex":0,"beginDate":"20160726","endDate":"20160726"}}'},
      {n:'T202-订单详情',v:'{"header":{"version":"1.0","transType":"T202","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.order.detail"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","orderId":"1467887261030"}}'},
      {n:'T204-订单数量查询',v:'{"header":{"version":"1.0","transType":"T204","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.order.process.number"},"body":{"loginSessionId":"2cdd575a-ff7f-4be4-b038-012dec19e5a5"}}'},

      {n:'T300-完成接单',v:'{"header":{"version":"1.0","transType":"T300","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.order.complete"},"body":{"loginSessionId":"2cdd575a-ff7f-4be4-b038-012dec19e5a5","orderId":"1467887261030"}}'},
      {n:'T301-确认订单',v:'{"header":{"version":"1.0","transType":"T301","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.order.confirm"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","orderId":"1467887261030"}}'},
      {n:'T302-取消订单',v:'{"header":{"version":"1.0","transType":"T302","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.order.cancel"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","orderId":"","cancelType":"2","cancelReason":"不开心，不接单"}}'},
      {n:'T303-商户开启自动接单接口',v:'{"header":{"version":"1.0","transType":"T303","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.openorderauto"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","channelId":"189021000009002","updateType":"all"}}'},
      {n:'T304-商户关闭自动接单接口',v:'{"header":{"version":"1.0","transType":"T304","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.closeorderauto"},"body":{"loginSessionId":"a393e99a-bc87-49e2-b99a-35318cff88eb","channelId":"189021000009002","updateType":"all"}}'},
      {n:'T305-同步更新百度门店信息',v:'{"header":{"version":"1.0","transType":"T305","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.shop.sync"},"body":{"channelId":"1001","shopId":"182000899000001","category1":"餐饮","category2":"糕点饮品","category3":"面包糕点"}}'},
      //{n:'T306-修改商户门店',v:'{"header":{"version":"1.0","transType":"T306","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.shopupdate"},"body":{"channelId":"1001","shopId":"182000899000001","name":"宜芝多外卖（延长路店Test）","shopLogo":"http://7mj4w3.com1.z0.glb.clouddn.com/wmthumbnails.png","address":"上海市闸北区延长路581号","bookAheadTime":"","brand":"宜芝多","businessTime":[{"end":"14:00","start":"10:00"},{"end":"21:00","start":"14:05"}],"categorys":[{"category1":"餐饮","category2":"糕点饮品","category3":"蛋糕"}],"coordType":"","city":"上海市","province":"上海市","county":"闸北区","deliveryRegion":[{"delivery_fee":"600","delivery_time":"60","name":"延长路配送区","region":[[{"latitude":"31.275522","longitude":"121.454737"},{"latitude":"31.276328","longitude":"121.458038"},{"latitude":"31.275094","longitude":"121.457539"},{"latitude":"31.276903","longitude":"121.455294"}]]}],"invoiceSupport":"2","latitude":"31.275277","longitude":"121.4559","minOrderPrice":"0","packageBoxPrice":"0","phone":"010-59929653","servicePhone":"4008527547"}}'},

      {n:'T320-更新餐厅接单模式-饿了么专用',v:'{"header":{"version":"1.0","transType":"T320","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.order.mode"},"body":{"channelId":"1003","shopId":"182000899000001","mode":2}}'},
      {n:'T321-与外卖平台商户ID绑定-饿了么专用',v:'{"header":{"version":"1.0","transType":"T321","submitTime":"20160706104851","sessionId":"","clientTraceNo":"","method":"unionlive.merchant.binding"},"body":{"channelId":"1003","shopId":"182000899000001","restaurantId":"1289545"}}'},

      //{n:'T401-新增菜品分类',v:'{"header":{"version":"1.0","transType":"T401","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.category.create"},"body":{"mercId":"182000899000001","cateName":"饮料","cateDesc":"分类描述","priority":1,"imgUrl":""}}'},
      //{n:'T402-更新菜品分类',v:'{"header":{"version":"1.0","transType":"T402","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.category.update"},"body":{"mercId":"182000899000001","cateId":"10125","cateName":"饮料套餐","cateDesc":"分类描述","priority":1,"imgUrl":""}}'},
      {n:'T403-菜品分类查询',v:'{"header":{"version":"1.0","transType":"T403","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.category.query"},"body":{"shopId":"182000899000001","cateName":""}}'},
      //{n:'T404-菜品分类同步',v:'{"header":{"version":"1.0","transType":"T404","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.category.sync"},"body":{"channelId":"1003","shopId":"182000899000001","cateId":"10125"}}'},

      //{n:'T410-新增菜品',v:'{"header":{"version":"1.0","transType":"T410","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.create"},"body":{"mercId":"182000899000001","foodName":"香蕉超茄子","cateId":"10125","priority":"11","upc":"","picUrl":"","minOrderNum":"1","packageNum":"1","desc":"自创黑暗料理","availDate":"1111111","availTimeStart":"0900","availTimeEnd":"2100","attrName":"","attrValue":"","isNew":"1","isFeatured":"1","isSpicy":"1","isGum":"1"}}'},
      //{n:'T411-更新菜品',v:'{"header":{"version":"1.0","transType":"T411","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.update"},"body":{"mercId":"182000899000001","foodId":"10126","foodName":"香蕉炒茄子","cateId":"10125","priority":"11","upc":"","picUrl":"","minOrderNum":"1","packageNum":"1","desc":"自创黑暗料理","availDate":"1111111","availTimeStart":"0900","availTimeEnd":"2100","attrName":"","attrValue":"","isNew":"1","isFeatured":"1","isSpicy":"1","isGum":"1"}}'},
      {n:'T412-菜品查询',v:'{"header":{"version":"1.0","transType":"T423","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.query"},"body":{"shopId":"182000899000001","cateId":""}}'},
      {n:'T413-菜品详情',v:'{"header":{"version":"1.0","transType":"T413","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.get"},"body":{"channelId":"189021000009002","shopId":"182000899000001","foodId":"10126"}}'},
      //{n:'T414-菜品同步',v:'{"header":{"version":"1.0","transType":"T414","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.sync"},"body":{"channelId":"1003","shopId":"182000899000001","foodId":"10126","price":"2124","stock":"1002","packingFee":"200","priority":"2"}}'},
      //{n:'T415-删除菜品',v:'{"header":{"version":"1.0","transType":"T415","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.delete"},"body":{"channelId":"1003","shopId":"182000899000001","foodId":"10126"}}'},
      {n:'T421-菜品库存修改',v:'{"header":{"version":"1.0","transType":"T421","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.update.stock"},"body":{"channelId":"189021000009002","shopId":"182000899000001","foodId":"10126","norms":[{"id":"1","stock":"191"}]}}'},
      {n:'T424-菜品上线下线',v:'{"header":{"version":"1.0","transType":"T424","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.dish.online"},"body":{"channelId":"189021000009002","shopId":"182000899000001","foodId":"10126","status":"0"}}'},

      {n:'',v:''},
      {n:'下线商户门店',v:'{"header":{"version":"1.0","transType":"","submitTime":"20160706104851","sessionId":"","clientTraceNo":"089f54c7-f013-4b51-8acc-2a1ae05e730a","method":"unionlive.shop.offline"},"body":{"loginSessionId": "d59eab01-6ca2-43db-93ff-cee1cbacb893","channelId":""}}'},
    ];
  </script>
</head>
<body>
<div style="width: 800px;margin: 0 auto;">
  <h1>
    优方外卖整合平台API接口测试程序</h1>
  <p class="style1">
    请求地址:
    <input id="webServiceUrl" type="text" value="gateway.test"></p>
  <p style="font-size: small">
    交易类型：
    <select id="transType">
      <option value="" selected="selected">请选择交易类型</option>
    </select>&nbsp;
    <input id="testTrans" type="button" value="测试交易">&nbsp;<span id="status">解析返回结果成功.</span>
  </p>
  <p style="font-size: small">
    外卖下单：
    商户ID <input type="text" id="mercId" value="189021000009001" style="width: 110px;">
    <input type="button" value="百度外卖下单" class="wmCreateOrder" data-url="baiduwmpush/{mercId}.do" data-params='{"body":{"shop":{"id":"2520","name":"百度外卖（测试店）"},"order":{"order_id":"14347012309352","send_immediately":1,"send_time":"1","send_fee":500,"package_fee":200,"discount_fee":0,"total_fee":3700,"shop_fee":3200,"user_fee":3700,"pay_type":1,"pay_status":1,"need_invoice":2,"invoice_title":"","remark":"请提供餐具","delivery_party":1,"create_time":"1469497574"},"user":{"name":"测试订单","phone":"18912345678","gender":1,"address":"北京海淀区奎科科技大厦 测试","coord":{"longitude":116.143145,"latitude":39.741426}},"products":[{"product_id":"12277320","product_name":"酱肉包（/份）","product_price":1200,"product_amount":1,"product_fee":1200,"package_price":100,"package_amount":1,"package_fee":100,"total_fee":1300,"upc":""}],"discount":[]},"cmd":"order.create","sign":"E362B8AACE4F7A77047A885C0C0D230D","source":"65400","ticket":"909C3B92-8CDD-AF2C-C887-5B660233E2B2","timestamp":1434701234,"version":"2.0"}'>
    <input type="button" value="美团外卖下单" class="wmCreateOrder" data-url="meituanwmpush.test" data-params='{"total":"52.5","delivery_time":"0","utime":"1476932363","wm_poi_name":"%E6%A1%82%E6%BA%90%E9%93%BA%E6%B5%8B%E8%AF%95%E5%BA%97","detail":"%5B%7B%22app_food_code%22%3A%22food_code01%22%2C%22box_num%22%3A0%2C%22box_price%22%3A0%2C%22food_discount%22%3A1%2C%22food_name%22%3A%22%E7%83%A4%E7%BF%85%22%2C%22price%22%3A43.5%2C%22quantity%22%3A1%2C%22sku_id%22%3A%22food_code01%22%2C%22unit%22%3A%22%22%7D%5D","caution":"","original_price":"52.5","order_id":"2358135573","recipient_name":"%E8%B5%B5+%28%E5%A5%B3%E5%A3%AB%29","wm_poi_phone":"4009208801","city_id":"999999","timestamp":"1476932363","pay_type":"1","wm_poi_id":"1406947","longitude":"97.175621","avg_send_time":"0.0","status":"2","invoice_title":"","app_poi_code":"test_poi_01","shipper_phone":"","is_third_shipping":"0","shipping_fee":"9.0","ctime":"1476932363","has_invoiced":"0","extras":"%5B%5D","recipient_phone":"15901751381","wm_poi_address":"%E5%8D%97%E6%9E%81%E6%B4%B24%E5%8F%B7%E7%AB%99","wm_order_id_view":"14069472706963755","app_id":"378","latitude":"31.143873","recipient_address":"%E6%98%8C%E9%83%BD%E6%B0%94%E8%B1%A1%E5%AE%BE%E9%A6%86+%28%E6%98%8C%E9%83%BD%E6%B0%94%E8%B1%A1%E5%AE%BE%E9%A6%86%29","sig":"832a281d97f395c65c2fd3764604f1dd"}'>
    <input type="button" value="饿了么外卖下单" class="wmCreateOrder" data-url="elemewmpush.test" data-params="consumer_key=9021958725&timestamp=1472106284&eleme_order_ids=101117914506897748&push_action=1&sig=004085ea2bfd542c2c9f8024519463cca218e221">
  </p>
  <div style="font-size: small">
    请求数据：</div>
  <p style="font-size: small">
    <textarea id="input"></textarea></p>
  <div style="font-size: small">
    交易返回：</div>
  <p style="font-size: small">
    <textarea id="output"></textarea></p>

</div>
</body>
</html>