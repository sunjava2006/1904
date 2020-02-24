// pages/newsInfo/newsInfo.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        img1:''
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        that = this;
        //访问服务器，取出指定新闻ID的新闻内容
        wx.request({
            url: '我们的地址',
            success:function(data){
                // 给页面中数据赋值
                that.setData({
                    img1: 'http://n.sinaimg.cn/default/1_img/upload/3933d981/33/w980h653/20200223/6eff-ipvnszf0100215.jpg'
                });
            }
        })
       
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})