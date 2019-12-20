//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   
  },
  
  onLoad: function (){
      var that=this;
      wx.getLocation({
         
          success: function(res) {
              var lat = res.latitude;
              var lon = res.longitude;
              var markers = [];
              var marker={
                  id:0,
                  latitude:lat,
                  longitude:lon,
                  iconPath:'/imgs/location_r.png',
                  width:50,
                  height:50
              };
              markers.push(marker);
              that.setData({
                  "latitude":lat,
                  "longitude":lon,
                  "markers":markers
              });

              //-------------请求周边wifi信息-------------- 
              wx.request({
                  url: 'http://apis.juhe.cn/wifi/local?key=743a48cdd71f773a6d7dee71c18d2964&lon='+lon+'&lat='+lat+'&r=3000&gtype=1',
                  success:function(result){
                      console.log(result);
                      if(result.data.result){
                          var list = result.data.result.data;
                          var markers = that.data.markers;
                          list.forEach((v,i, a)=>markers.push({
                              id: i+1,
                              latitude: v.baidu_lat,
                              longitude: v.baidu_lon,
                              iconPath: '/imgs/wifi.png',
                              width: 50,
                              height: 50,
                                title:v.name
                            }));
                          that.setData({
                              "markers":markers
                          });
                      }
                      
                  }
              })

          },
      })
  }
});
