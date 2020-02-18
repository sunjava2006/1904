//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
     studentID:'150201',
     passwd:'123456',
     msg:'请先登录'
  },
  
  onLoad: function () {
   
  },
  onSubmit: function(e){
      console.log(e.detail);
      var passwd = e.detail.value.passwd;
      var studentID = e.detail.value.studentID;
      var serverUrl = app.globalData.serverUrl;
      var that = this;
      // 发送请求
      wx.request({
          url: serverUrl + '/login?' + "studentID=" + studentID + "&passwd=" + passwd,
          method:"POST",
          success:function(data){
              console.log(data);
              if(data.data=='登录成功'){
                  wx.navigateTo({
                      url: '/pages/checkingin/checkingin',
                  });
              }else{
                  that.setData({
                      msg:'登录失败，请重试'
                  });
              }
          }
      })
  }

})
